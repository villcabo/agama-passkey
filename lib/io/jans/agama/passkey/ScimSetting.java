package io.jans.agama.passkey;

public class ScimSetting {

    private String scimClientId;

    private String scimClientSecret;

    public String getScimClientId() {
        return scimClientId;
    }

    public void setScimClientId(String scimClientId) {
        this.scimClientId = scimClientId;
    }

    public String getScimClientSecret() {
        return scimClientSecret;
    }

    public void setScimClientSecret(String scimClientSecret) {
        this.scimClientSecret = scimClientSecret;
    }
}
