package com.year2018.fw_dagger2;

import android.app.Application;

import com.year2018.fw_dagger2.component.BaseComponent;
import com.year2018.fw_dagger2.component.DaggerBaseComponent;
import com.year2018.fw_dagger2.module.BaseModule;

public class MyApplication extends Application {
    private BaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        baseComponent = DaggerBaseComponent.builder().baseModule(new BaseModule()).build();
    }

    public BaseComponent getBaseComponent() {
        return baseComponent;
    }
}
