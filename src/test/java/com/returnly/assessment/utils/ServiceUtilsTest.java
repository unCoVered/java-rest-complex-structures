package com.returnly.assessment.utils;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.returnly.assessment.model.Item;
import com.returnly.assessment.model.Order;
import com.returnly.assessment.model.OrderResponseJson;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ServiceUtilsTest {

    @Test
    public void testComposeStoreAdminUrl() {
        final String correct_url = "https://100pure-demo.myshopify.com/admin/api/2021-01/orders.json?status=any";
        final String ORDERS = "/admin/api/2021-01/orders.json?status=any";

        assertThat(ServiceUtils.composeStoreAdminUrl(ORDERS)).isEqualTo(correct_url);
    }

    @Test
    public void testTransformOrderJson() {
        String path = "./src/test/resources/order.json";
        ObjectMapper mapper = new ObjectMapper();

        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            String orderJson = new String(encoded, StandardCharsets.UTF_8);

            OrderResponseJson orderResponseJson = mapper.readValue(orderJson, OrderResponseJson.class);
            List<Order> orderList = orderResponseJson.getOrderList();

            assertThat(orderList.size()).isEqualTo(1);

            Order order = orderList.get(0);

            assertThat(order).isNotNull();

            String orderId = order.getId();
            List<Item> itemList = order.getItemList();

            assertThat(orderId).isEqualTo("5056830858");
            assertThat(itemList.size()).isEqualTo(3);

            Item item = itemList.get(0);

            assertThat(item).isNotNull();

            String itemId = item.getId();

            assertThat(itemId).isEqualTo("4078472967");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
