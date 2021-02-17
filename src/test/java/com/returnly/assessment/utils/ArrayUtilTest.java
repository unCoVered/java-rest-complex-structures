package com.returnly.assessment.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.returnly.assessment.model.MyEntry;
import com.returnly.assessment.model.Order;
import com.returnly.assessment.model.OrderResponseJson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map.Entry;

import static org.assertj.core.api.Assertions.assertThat;


public class ArrayUtilTest {
    List<Order> orderList;

    @Before
    public void readOrderListJson() {
        String path = "./src/test/resources/orderList.json";
        ObjectMapper mapper = new ObjectMapper();

        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            String orderListJson = new String(encoded, StandardCharsets.UTF_8);

            OrderResponseJson orderResponseJson = mapper.readValue(orderListJson, OrderResponseJson.class);
            this.orderList = orderResponseJson.getOrderList();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNumberOfOrders() {
        int ordersNumber = ArrayUtils.calculateNumberOfOrders(this.orderList);
        assertThat(ordersNumber).isEqualTo(10);
    }

    @Test
    public void testCalculateNumberOfUniqueCustomers() {
        int customersNumber = ArrayUtils.calculateNumberOfUniqueCustomer(this.orderList);
        assertThat(customersNumber).isEqualTo(8);
    }

    @Test
    public void testCalculateLeastAndMostOrderedItems() {
        MyEntry<Entry<String,Long>, Entry<String,Long>> entryTuple = ArrayUtils.calculateLeastAndMostOrderedItems(orderList);

        assertThat(entryTuple).isNotNull();

        Entry<String, Long> leastOrderedItem = entryTuple.getFirstElement();
        Entry<String, Long> mostOrderedItem = entryTuple.getSecondElement();

        assertThat(leastOrderedItem).isNotNull();
        assertThat(leastOrderedItem.getKey()).isEqualTo("4078502983");
        assertThat(leastOrderedItem.getValue()).isEqualTo(7L);

        assertThat(mostOrderedItem).isNotNull();
        assertThat(mostOrderedItem.getKey()).isEqualTo("4078472967");
        assertThat(mostOrderedItem.getValue()).isEqualTo(9L);
    }

    @Test
    public void testCalculateMedianOrderValue() {
        Double median = ArrayUtils.calculateMedianOrderValue(orderList);

        assertThat(median).isNotNull();
        assertThat(median).isEqualTo(142.0);
    }

    @Test
    public void testCalculateShortestIntervalPerCustomer() {
        List<MyEntry<String, Long>> shortestIntervalPerCustomer = ArrayUtils.calculateShortestIntervalPerCustomer(orderList);

        assertThat(shortestIntervalPerCustomer).isNotNull();
        assertThat(shortestIntervalPerCustomer.size()).isNotEqualTo(0);
    }

    @Test
    public void testComputeMedian() {
        final Integer[] testInt = new Integer[] {1,2,3,4,5};
        assertThat(ArrayUtils.computeMedian(testInt)).isEqualTo(3);

        final Long[] testLong = new Long[] {10L, 20L, 30L, 40L, 60L};
        assertThat(ArrayUtils.computeMedian(testLong)).isEqualTo(30L);

        final String[] testString = new String[] {"A", "B", "C", "M", "X", "Y", "Z"};
        assertThat(ArrayUtils.computeMedian(testString)).isEqualTo("M");
    }
}
