package com.year2018.fw_dagger2.component;

import com.year2018.fw_dagger2.module.BaseModule;
import com.year2018.fw_dagger2.module.MainModule;
import com.year2018.fw_dagger2.util.ClothHandler;

import javax.inject.Singleton;

import dagger.Component;

//BaseComponent都没有单例的话,外部依赖它的Component就更不可能单例了
@Singleton //对应Module中声明的单例
@Component(modules = BaseModule.class)
public interface BaseComponent {
    /**
     * 这个BaseComponent是给其他Component提供依赖的,所以我们就可以不用inject方法.
     * getClothHandler方法是告诉依赖于BaseComponent的Component,BaseComponent能为你们提供ClothHandler对象,
     * 如果没有这个方法,BaseComponent就不能提供ClothHandler对象。
     * 既然有了BaseComponent,那我们就可在其它Component中依赖它了.我们删除MainModule和SecondModule中的getClothHandler方法
     */
    ClothHandler getClothHandler();

    //@Subcomponent使用的声明方式,声明一个返回值为子组件的方法,子组件需要什么Module,就在方法参数中添加什么
    SubMainComponent getSubMainComponent(MainModule module);
}
