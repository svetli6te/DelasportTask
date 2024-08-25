package com.luckybandit.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
public class ActionInfo {
    private String action;
    private Info info;

    public ActionInfo(@JsonProperty(value = "action") String action, @JsonProperty(value = "info") Info info) {
        this.action = action;
        this.info = info;
    }
}
