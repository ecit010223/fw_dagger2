package com.year2018.fw_dagger2.bean;

public class Clothes {
    private Cloth cloth;

    public Clothes(Cloth cloth) {
        this.cloth = cloth;
    }

    public Cloth getCloth() {
        return cloth;
    }

    @Override
    public String toString() {
        return "很多"+cloth.getColor() + "衣服";
    }
}
