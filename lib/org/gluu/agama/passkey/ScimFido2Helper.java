package org.gluu.agama.passkey;

import com.nimbusds.oauth2.sdk.http.HTTPRequest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ScimFido2Helper extends ScimWSBase {

    private static final String SCOPE_FIDO2_READ = SCOPE_PREFIX + "/fido2.read";

    public ScimFido2Helper() throws IOException {
        super(false, null);
    }

    public ScimFido2Helper(ScimSetting scimSetting) throws IOException {
        super(true, scimSetting);
        setScope(SCOPE_FIDO2_READ);
    }

    public Map<String, Object> getFidoDeviceByUser(String userInum) throws IOException {
        try {
            URL url = new URL(apiBase + "/v2/Fido2Devices");
            log.debug("Scim Fido2Devices url: {}", url);
            HTTPRequest request = new HTTPRequest(HTTPRequest.Method.GET, url);
            request.setAccept("application/json");

            StringJoiner joiner = new StringJoiner("&");
            Map.of("userId", userInum).forEach((k, v) -> joiner.add(k + "=" + v));
            request.setQuery(joiner.toString());

            String response = sendRequest(request, true, true).getContentAsJSONObject().toJSONString();
            log.debug("Response scim fido2 devices: {}", response);
            JSONObject resObject = new JSONObject(response);
            int count = resObject.getInt("totalResults");
            List<Map<String, String>> mapList = new ArrayList<>();
            if (count > 0) {
                JSONArray jsonArray = resObject.getJSONArray("Resources");
                int i = 0;
                while (i < jsonArray.length()) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    Map<String, String> result = new HashMap<>();
                    result.put("displayName", item.getString("displayName"));
                    result.put("creationDate", item.getString("creationDate"));
                    mapList.add(result);
                    i++;
                }
            }
            return Map.of("count", count, "devices", mapList);

        } catch (Exception e) {
            throw new IOException("Could not obtain the user's list of fido devices: " + userInum, e);
        }
    }
}
