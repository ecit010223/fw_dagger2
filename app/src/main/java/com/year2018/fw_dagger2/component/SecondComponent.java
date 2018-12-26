package com.year2018.fw_dagger2.component;

import com.year2018.fw_dagger2.SecondActivity;
import com.year2018.fw_dagger2.annotation.PerActivity;
import com.year2018.fw_dagger2.module.SecondModule;

import dagger.Component;

@PerActivity
@Component(modules = SecondModule.class,dependencies = BaseComponent.class)
public interface SecondComponent {
    void inject(SecondActivity secondActivity);
}
