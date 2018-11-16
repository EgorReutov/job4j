package ru.job4j.banktransfers;

import java.util.List;

public class Account  {
    private double value;
    private String requisites;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }
}
