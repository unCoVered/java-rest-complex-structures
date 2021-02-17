package com.returnly.assessment.model;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ReturnlyAssessmentResult aggregates all the results that are required for this project,
 * for example, there should be a field representing Total number of orders, a field
 * representing Number of unique customers, etc.
 */
public class ReturnlyAssessmentResult {

    private int totalOrders;
    private int uniqueCustomers;
    private Entry<String, Long> leastOrderedItem;
    private Entry<String, Long> mostOrderedItem;
    private double medianOrderValue;
    private List<MyEntry<String, Long>> shortestIntervalPerCustomer;

    public ReturnlyAssessmentResult(int totalOrders, int uniqueCustomers, Entry<String, Long> leastOrderedItem,
                                    Entry<String, Long> mostOrderedItem, double medianOrderValue,
                                    List<MyEntry<String, Long>> shortestIntervalPerCustomer) {
        this.totalOrders = totalOrders;
        this.uniqueCustomers = uniqueCustomers;
        this.leastOrderedItem = leastOrderedItem;
        this.mostOrderedItem = mostOrderedItem;
        this.medianOrderValue = medianOrderValue;
        this.shortestIntervalPerCustomer = shortestIntervalPerCustomer;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getUniqueCustomers() {
        return uniqueCustomers;
    }

    public void setUniqueCustomers(int uniqueCustomers) {
        this.uniqueCustomers = uniqueCustomers;
    }

    public Entry<String, Long> getMostOrderedItem() {
        return mostOrderedItem;
    }

    public void setMostOrderedItem(Entry<String, Long> mostOrderedItem) {
        this.mostOrderedItem = mostOrderedItem;
    }

    public Entry<String, Long> getLeastOrderedItem() {
        return leastOrderedItem;
    }

    public void setLeastOrderedItem(Entry<String, Long> leastOrderedItem) {
        this.leastOrderedItem = leastOrderedItem;
    }

    public double getMedianOrderValue() {
        return medianOrderValue;
    }

    public void setMedianOrderValue(double medianOrderValue) {
        this.medianOrderValue = medianOrderValue;
    }

    public List<MyEntry<String, Long>> getShortestIntervalPerCustomer() {
        return shortestIntervalPerCustomer;
    }

    public void setShortestIntervalPerCustomer(List<MyEntry<String, Long>> shortestIntervalPerCustomer) {
        this.shortestIntervalPerCustomer = shortestIntervalPerCustomer;
    }

    @Override
    public String toString() {
        return "ReturnlyAssessmentResult{" +
                "totalOrders=" + totalOrders +
                ", uniqueCustomers=" + uniqueCustomers +
                ", leastOrderedItem=" + leastOrderedItem +
                ", mostOrderedItem=" + mostOrderedItem +
                ", medianOrderValue=" + medianOrderValue +
                ", shortestIntervalPerCustomer=" + shortestIntervalPerCustomer +
                '}';
    }
}
