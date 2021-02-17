package com.returnly.assessment.model;

import java.util.Map;

public class MyEntry<K, V> {

    private K firstElement;
    private V secondElement;

    public MyEntry(K firstElement, V secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public K getFirstElement() {
        return firstElement;
    }

    public V getSecondElement() {
        return secondElement;
    }
}
