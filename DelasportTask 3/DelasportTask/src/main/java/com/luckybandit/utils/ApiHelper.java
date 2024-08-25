package com.luckybandit.utils;

import com.google.gson.GsonBuilder;
import com.luckybandit.utils.Root;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.LinkedHashMap;
import java.util.Locale;
import org.apache.commons.lang3.StringEscapeUtils;


public class ApiHelper {

    public static String getMemberBalance() {
        Response response0 = RestAssured.given()
                .header(new Header("x-requested-with", "XMLHttpRequest"))
                .when()
                .get("https://luckybandit.club.test-delasport.com/en/auth/logout") // Update with actual API
                .then()
                .statusCode(200)
                .extract()
                .response();

        Response response1 = RestAssured.given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("system_data[current_url]", "https://luckybandit.club.test-delasport.com/en")
                .formParam("login_form[username]", "tu_svetla")
                .formParam("login_form[password]", "Pass112#")
                .formParam("scope", "openid email")
                .formParam("method", "login")
                .when()
                .post("https://luckybandit.club.test-delasport.com/en/index/operation/login") // Update with actual API
                .then()
                .statusCode(200)
                .extract()
                .response();
        String token =
                response1.getHeaders().asList().stream().filter(e -> e.getName().equals("set-cookie")).filter(e -> e.getValue().contains("SESS")).findFirst().get().getValue();

        Response response = RestAssured.given()
                .auth().preemptive().basic("tu_svetla", "Pass112#")
                .header(new Header("x-requested-with", "XMLHttpRequest"))
                .header(new Header("cookie", token))
                .when()
                .get("https://luckybandit.club.test-delasport.com/en/euro/operation/getMemberBalance") // Update with actual API endpoint
                .then()
                .statusCode(200)
                .extract()
                .response();
        LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap>> responseMap = response.jsonPath().get();
        LinkedHashMap<String, LinkedHashMap> data = responseMap.get("data");
        LinkedHashMap<String, LinkedHashMap> balanceData = data.get("1");
        LinkedHashMap<String, LinkedHashMap> info = balanceData.get("info");
        String apiBalance = StringEscapeUtils.unescapeJava(info.get("raw_amount") + "");

        Currency eur = Currency.getInstance("EUR");
        NumberFormat eurFormatter
                = NumberFormat.getCurrencyInstance(Locale.UK);
        eurFormatter.setCurrency(eur);
        BigDecimal amt = new BigDecimal(apiBalance);
        return eurFormatter.format(amt);
    }
}

