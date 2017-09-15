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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
