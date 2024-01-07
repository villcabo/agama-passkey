package io.jans.agama.passkey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScimFidoDeviceResponseDTO {

    @JsonProperty("totalResults")
    private Integer count;

    @JsonProperty("Resources")
    private List<ScimFidoDeviceDTO> devices;

    public ScimFidoDeviceResponseDTO() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ScimFidoDeviceDTO> getDevices() {
        return devices;
    }

    public void setDevices(List<ScimFidoDeviceDTO> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "ScimFidoDeviceDTO{" +
                "count=" + count +
                ", devices=" + devices +
                '}';
    }
}
