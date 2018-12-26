package com.year2018.fw_dagger2.component;

import com.year2018.fw_dagger2.MainActivity;
import com.year2018.fw_dagger2.annotation.PerActivity;
import com.year2018.fw_dagger2.module.MainModule;

import dagger.Component;

/**
 * @Component：有modules和dependencies两个属性,这两个属性的类型都是Class数组。
 * modules属性：的作用就是声明该Component含有哪几个Module,当Component需要某个依赖对象时,
 *             就会通过这些Module类中对应的方法获取依赖对象。
 * dependencies属性：则是声明Component类的依赖关系。
 */
@PerActivity
@Component(modules=MainModule.class,dependencies = BaseComponent.class)
public interface MainComponent {
    /**
     * 通过inject方法将MainActivity实例传入到MainComponent中,MainComponent就会从MainModule中的getCloth方
     * 法获取Cloth实例,并将该实例赋值给MainActivity中的cloth字段。
     * inject方法的参数不能用父类来接收,例如本Demo中,如果inject的参数是AppCompatActivity,那么Dagger2就会报错。
     */
    void inject(MainActivity mainActivity);
}
