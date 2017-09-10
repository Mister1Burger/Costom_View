package com.example.kapusta.elements;

/**
 * Created by Kapusta on 10.09.2017.
 */

public class Element {
    String name;
    int number;
    int symbol;
    String info;

    Element(String name, String info, int number, int symbol) {
        this.name = name;
        this.number = number;
        this.symbol = symbol;
        this.info = info;
    }
}
