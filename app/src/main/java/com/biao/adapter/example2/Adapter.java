package com.biao.adapter.example2;

public class Adapter implements Target {
    Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public float getMoney() {
        return adaptee.getRMB() * 6.7f;
    }
}
