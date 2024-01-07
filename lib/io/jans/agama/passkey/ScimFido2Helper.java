package io.jans.agama.passkey;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;
import io.jans.agama.passkey.dto.ScimFidoDeviceResponseDTO;
import net.minidev.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.StringJoiner;

public class ScimFido2Helper extends ScimWSBase {

    private static final String SCOPE_FIDO2_READ = SCOPE_PREFIX + "/fido2.read";

    public ScimFido2Helper() throws IOException {
        super(false, null);
    }

    public ScimFido2Helper(ScimSetting scimSetting) throws IOException {
        super(true, scimSetting);
        setScope(SCOPE_FIDO2_READ);
    }

    public ScimFidoDeviceResponseDTO getFidoDeviceByUser(String userInum) throws IOException {
        try {
            URL url = new URL(apiBase + "/v2/Fido2Devices");
            log.debug("Scim Fido2Devices url: {}", url);
            HTTPRequest request = new HTTPRequest(HTTPRequest.Method.GET, url);
            request.setAccept("application/json");

            StringJoiner joiner = new StringJoiner("&");
            Map.of("userId", userInum).forEach((k, v) -> joiner.add(k + "=" + v));
            request.setQuery(joiner.toString());

            JSONObject response = sendRequest(request, true, true).getContentAsJSONObject();
            log.debug("Response scim fido2 devices: {}", response);
            ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.convertValue(response, ScimFidoDeviceResponseDTO.class);

        } catch (Exception e) {
            throw new IOException("Could not obtain the user's list of fido devices: " + userInum, e);
        }
    }
}
