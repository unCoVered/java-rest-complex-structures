package com.returnly.assessment.utils;

import com.returnly.assessment.model.Item;
import com.returnly.assessment.model.MyEntry;
import com.returnly.assessment.model.Order;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

final public class ArrayUtils {

    private ArrayUtils() {}

    public static int calculateNumberOfOrders(List<Order> orderList) { return orderList.size(); }

    public static int calculateNumberOfUniqueCustomer(List<Order> orderList) {
        return orderList
                .stream()
                .map(Order::getCustomer)
                .collect(Collectors.toSet())
                .size();
    }

    public static MyEntry<Entry<String,Long>, Entry<String,Long>> calculateLeastAndMostOrderedItems(List<Order> orderList) {
        Map<String, Long> itemsOrdersMap = orderList
                .stream()
                .flatMap(order -> order.getItemList().stream())
                .map(Item::getId)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Entry<String, Long> leastOrderedItem = itemsOrdersMap.entrySet().stream().min(Comparator.comparing(Entry::getValue)).get();
        Entry<String, Long> mostOrderedItem = itemsOrdersMap.entrySet().stream().max(Comparator.comparing(Entry::getValue)).get();

        return new MyEntry<>(leastOrderedItem, mostOrderedItem);
    }

    public static double calculateMedianOrderValue(List<Order> orderList) {
        return (double) ArrayUtils.computeMedian(orderList.stream().map(Order::getValue).sorted().toArray());
    }

    public static List<MyEntry<String, Long>> calculateShortestIntervalPerCustomer(List<Order> orderList) {
        List<MyEntry<String, Long>> daysBetweenOrders = new ArrayList<>();

        Map<String, List<Calendar>> ordersDatePerCustomer = orderList
                .stream()
                .map(x -> new MyEntry<>(x.getCustomer(), x.getDate()))
                .collect(Collectors.groupingBy(MyEntry::getFirstElement,
                        Collectors.mapping(MyEntry::getSecondElement, Collectors.toList())));

        ordersDatePerCustomer.keySet().forEach(keyset -> {
            List<Long> intervalBetweenOrders = new ArrayList<>();
            List<Calendar> orderDates = ordersDatePerCustomer.get(keyset);
            if (orderDates.size() > 1) {
                orderDates.stream().reduce((a,b) -> {
                    intervalBetweenOrders.add(ChronoUnit.DAYS.between(b.toInstant(), a.toInstant()));
                    return b;
                });

                daysBetweenOrders.add(new MyEntry<>(keyset, intervalBetweenOrders.stream().min(Comparator.naturalOrder()).orElse(-1L)));
            }
        });


        return daysBetweenOrders;
    }

    public static <E> E computeMedian(final E[] array) {
        return array[array.length / 2];
    }
}
