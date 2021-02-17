package com.returnly.assessment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order implements Serializable {
    @JsonProperty("id") private String id;
    @JsonProperty("email") private String customer;
    @JsonProperty("line_items") private List<Item> itemList;
    @JsonProperty("total_price_usd") private double value;
    @JsonProperty("created_at") @JsonFormat private Calendar date;

    public String getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public double getValue() {
        return value;
    }

    public Calendar getDate() {
        return date;
    }
}
