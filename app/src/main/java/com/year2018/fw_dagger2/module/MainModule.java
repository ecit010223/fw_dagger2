package com.year2018.fw_dagger2.module;

import com.year2018.fw_dagger2.annotation.YellowCloth;
import com.year2018.fw_dagger2.bean.Cloth;
import com.year2018.fw_dagger2.bean.Clothes;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * 相当于工厂类，为他人提供Cloth
 * @Module表明该类是Module类
 */
@Module
public class MainModule {

    /**
     * @Provides 声明Module类中哪些方法是用来提供依赖对象的。
     *           当Component类需要依赖对象时,他就会根据返回值的类型来在有@Provides注解的方法中选择调用哪个方法。
     *           在一个方法上声明@Provides注解,就相当于创建了一条生产线,这条生产线的产物就是方法的返回值类型。
     * @return Dagger2是通过返回值类型来确定调用哪个方法
     * @Singleton 声明无论调用该方法多少次只会产生一个Cloth，而还需要在MainComponent添加@Singleton.
     *            单例是在同一个Component实例提供依赖的前提下才有效的,不同的Component实例只能通过Component
     *            依赖才能实现单例.也就是说,你虽然在两个Component接口上都添加了PerActivity注解,但是这两个
     *            Component提供依赖时是没有联系的,他们只能在各自的范围内实现单例.
     */
//    @Singleton
    @Provides
    public Cloth getCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("紫色");
        return cloth;
    }

    /**
     * 当我们将@PerActivity注解使用在Module类中的Provide方法上时,就是声明这个Provide方法是在PerActivity作用范围内的,
     * 并且当一个Component要引用这个Module时,必须也要声明这个Component是PerActivity作用范围内的,否则就会报错,
     * 声明方法也很简单,就是在Component接口上使用这个注解.但是我们声明这个作用范围又有什么用呢?原来Dagger2有这样一个机制:
     * 在同一个作用范围内,Provide方法提供的依赖对象就会变成单例,也就是说依赖需求方不管依赖几次Provide方法提供的依赖对象,
     * Dagger2都只会调用一次这个方法
     */
//    @PerActivity
//    @Provides
//    public ClothHandler getClothHandler(){
//        return new ClothHandler();
//    }

    /**
     * 新的需求：假设我们现在又有了新的需求,MainActivity中需要两种布料,分别是红布料和蓝布料。
     * Dagger2是通过返回值类型来确定的,当你需要红布料时,它又怎么知道哪个是红布料呢?所以Dagger2为我们提供@Named注解。
     */
    @Provides
    @Named("red")
    public Cloth getRedCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }

    @Provides
    @Named("blue")
    public Cloth getBlueCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("蓝色");
        return cloth;
    }

    /**
     * 有了如上@Qualifier的注解，就可以替换Named("yellow")
     */
    @Provides
    @YellowCloth
    public Cloth getYellowCloth(){
        Cloth cloth = new Cloth();
        cloth.setColor("黄色");
        return cloth;
    }

    /**
     * 还可以将@Name注解与@Qualifier自定的注解用在参数上
     */
    @Provides
    @YellowCloth
    public Clothes getYellowClothes(@YellowCloth Cloth cloth){
        return new Clothes(cloth);
    }

    /**
     * 只要在getClothes方法中添加Cloth参数,Dagger2就会像帮依赖需求方找依赖对象一样帮你找到该方法依赖的Cloth实例。
     */
    @Provides
    public Clothes getClothes(Cloth cloth){
        return new Clothes(cloth);
    }
}
