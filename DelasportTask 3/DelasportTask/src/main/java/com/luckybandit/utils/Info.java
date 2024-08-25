package com.luckybandit.utils;

import java.util.regex.Matcher;
import lombok.Data;
import org.apache.commons.lang3.StringEscapeUtils;

@Data
public class Info {
    private String creditType;
    private String key;
    private String amount;

    public String getAmount() {
        return StringEscapeUtils.unescapeJava(amount);
    }
}
