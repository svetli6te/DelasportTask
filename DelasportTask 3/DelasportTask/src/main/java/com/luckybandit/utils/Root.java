package com.luckybandit.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Root {
    private String status;
    private String data;

    public Root(@JsonProperty(value = "status") String status, @JsonProperty(value = "data") String data) {
        this.status = status;
        this.data = data;
    }
}
