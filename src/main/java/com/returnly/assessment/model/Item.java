package com.returnly.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable {
    @JsonProperty("product_id") private String id;
    @JsonProperty("name") private String name;
    @JsonProperty("quantity") private int quantity;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
