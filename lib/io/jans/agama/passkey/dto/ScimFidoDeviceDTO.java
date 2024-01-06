package io.jans.agama.passkey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScimFidoDeviceDTO {

    @JsonProperty("totalResults")
    private Integer totalResults;

    @JsonProperty("Resources")
    private List<FidoDevice> items;

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<FidoDevice> getItems() {
        return items;
    }

    public void setItems(List<FidoDevice> items) {
        this.items = items;
    }

    public static class FidoDevice {

        @JsonProperty("id")
        private String id;

        @JsonProperty("userId")
        private String userId;

        @JsonProperty("creationDate")
        private String creationDate;

        @JsonProperty("counter")
        private Integer counter;

        @JsonProperty("status")
        private String status;

        @JsonProperty("displayName")
        private String displayName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(String creationDate) {
            this.creationDate = creationDate;
        }

        public Integer getCounter() {
            return counter;
        }

        public void setCounter(Integer counter) {
            this.counter = counter;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }
}
