package com.year2018.fw_dagger2.module;

import com.year2018.fw_dagger2.annotation.PerActivity;
import com.year2018.fw_dagger2.bean.Cloth;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondModule {

    @PerActivity
    @Provides
    public Cloth getBlueCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("蓝色");
        return cloth;
    }

//    @PerActivity
//    @Provides
//    public ClothHandler getClothHandler(){
//        return new ClothHandler();
//    }
}
