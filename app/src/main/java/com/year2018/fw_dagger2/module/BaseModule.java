package com.year2018.fw_dagger2.module;

import com.year2018.fw_dagger2.util.ClothHandler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseModule {
    @Singleton //单例
    @Provides
    public ClothHandler getClothHandler(){
        return new ClothHandler();
    }
}
