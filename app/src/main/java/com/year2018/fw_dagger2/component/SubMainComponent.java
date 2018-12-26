package com.year2018.fw_dagger2.component;

import com.year2018.fw_dagger2.MainActivity;
import com.year2018.fw_dagger2.annotation.PerActivity;
import com.year2018.fw_dagger2.module.MainModule;

import dagger.Subcomponent;

/**
 * 这里总结一下@Subcomponent的使用:
 * 1.子组件的声明方式由@Component改为@Subcomponent.
 * 2.在父组件中要声明一个返回值为子组件的方法,当子组件需要什么Module时,就在该方法中添加该类型的参数.
 * 注意:用@Subcomponent注解声明的Component是无法单独使用的,想要获取该Component实例必须经过其父组件.
 */
@PerActivity
@Subcomponent(modules = MainModule.class)
public interface SubMainComponent {
    void inject(MainActivity activity);
}
