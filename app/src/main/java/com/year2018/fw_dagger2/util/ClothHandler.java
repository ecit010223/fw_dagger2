package com.year2018.fw_dagger2.util;

import com.year2018.fw_dagger2.bean.Cloth;
import com.year2018.fw_dagger2.bean.Clothes;

public class ClothHandler {
    public Clothes handle(Cloth cloth){
        return new Clothes(cloth);
    }
}
