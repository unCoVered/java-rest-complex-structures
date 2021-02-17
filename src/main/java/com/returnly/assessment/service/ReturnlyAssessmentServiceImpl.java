package com.returnly.assessment.service;

import com.returnly.assessment.model.MyEntry;
import com.returnly.assessment.model.Order;
import com.returnly.assessment.utils.ArrayUtils;
import com.returnly.assessment.utils.ServiceUtils;
import com.returnly.assessment.model.ReturnlyAssessmentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

@Service
public class ReturnlyAssessmentServiceImpl implements ReturnlyAssessmentService{
    static final String ORDERS = "/admin/api/2021-01/orders.json?status=any";

    @Value("${shopify.auth.token}")
    private String shopifyToken;

    @Override
    public ReturnlyAssessmentResult calculateAssessmentResult() throws IOException {
        String orderJson = ServiceUtils.downloadJson(shopifyToken, ORDERS);
        List<Order> orderList = ServiceUtils.transformOrderJson(orderJson);

        int ordersNumber = ArrayUtils.calculateNumberOfOrders(orderList);
        int uniqueCustomer = ArrayUtils.calculateNumberOfUniqueCustomer(orderList);

        MyEntry<Entry<String,Long>, Entry<String,Long>> entryTuple = ArrayUtils.calculateLeastAndMostOrderedItems(orderList);
        Entry<String, Long> leastOrderedItem = entryTuple.getFirstElement();
        Entry<String, Long> mostOrderedItem = entryTuple.getSecondElement();

        double medianOrderValue = ArrayUtils.calculateMedianOrderValue(orderList);

        List<MyEntry<String, Long>> shortestIntervalPerCustomer = ArrayUtils.calculateShortestIntervalPerCustomer(orderList);


        return new ReturnlyAssessmentResult(ordersNumber,
                uniqueCustomer,
                leastOrderedItem,
                mostOrderedItem,
                medianOrderValue,
                shortestIntervalPerCustomer);
    }
}
