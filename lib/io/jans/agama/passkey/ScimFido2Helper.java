package io.jans.agama.passkey;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;
import io.jans.agama.passkey.dto.ScimFidoDeviceDTO;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.StringJoiner;

public class ScimFido2Helper extends ScimWSBase {

    private static final String SCOPE_FIDO2_READ = SCOPE_PREFIX + "/fido2.read";

    public ScimFido2Helper(ScimSetting scimSetting) throws IOException {
        super(true, scimSetting);
        setScope(SCOPE_FIDO2_READ);
    }

    public ScimFidoDeviceDTO getFidoDeviceByUser(String userId) throws IOException {
        try {
            HTTPRequest request = new HTTPRequest(HTTPRequest.Method.GET, new URL(apiBase + "/v2/Fido2Devices"));
            StringJoiner joiner = new StringJoiner("&");
            Map.of("userId", userId).forEach((k, v) -> joiner.add(k + "=" + v));
            request.setQuery(joiner.toString());

            Map<String, Object> response = sendRequest(request, true, true).getContentAsJSONObject();
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(response, ScimFidoDeviceDTO.class);

        } catch (Exception e) {
            throw new IOException("Could not obtain the user's list of fido devices: " + userId, e);
        }
    }
}
