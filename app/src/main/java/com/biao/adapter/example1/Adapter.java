package com.biao.adapter.example1;

public class Adapter extends Adaptee implements Target{

    @Override
    public float getMoney() {
        return getRMB() * 6.7f;
    }
}
