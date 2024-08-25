package com.luckybandit.utils;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;
import java.util.Map;
import lombok.Data;

@JsonTypeName("data")
@Data
public class ResponseData {

    Map<Integer, List<ActionInfo>> response;
}
