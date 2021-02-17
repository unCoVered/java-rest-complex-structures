package com.returnly.assessment.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.returnly.assessment.model.Order;
import com.returnly.assessment.model.OrderResponseJson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class ServiceUtils {

    static final String STORE_HOST = "100pure-demo.myshopify.com";
    static final String HTTPS = "https://";
    static final String CONTENT_TYPE = "Content-Type";
    static final String CONTENT_JSON = "application/json";
    static final String SHOPIFY_ACCESS = "X-Shopify-Access-Token";

    public static String composeStoreAdminUrl(String uri) { return HTTPS + STORE_HOST + uri; }

    public static HttpEntity<String> composeHttpEntity(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, CONTENT_JSON);
        headers.set(SHOPIFY_ACCESS, token);

        return new HttpEntity<String>(headers);
    }

    public static String downloadJson(String token, String uri) {
        HttpEntity<String> entity = ServiceUtils.composeHttpEntity(token);
        String url = ServiceUtils.composeStoreAdminUrl(uri);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public static List<Order> transformOrderJson(String orderJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        OrderResponseJson orderResponseJson = mapper.readValue(orderJson, OrderResponseJson.class);
        return orderResponseJson.getOrderList();
    }
}
