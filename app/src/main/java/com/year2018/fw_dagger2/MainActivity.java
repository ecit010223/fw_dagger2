package com.year2018.fw_dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.year2018.fw_dagger2.bean.Cloth;
import com.year2018.fw_dagger2.bean.Clothes;
import com.year2018.fw_dagger2.module.MainModule;
import com.year2018.fw_dagger2.util.ClothHandler;

import javax.inject.Inject;

/**
 * 参考：https://www.jianshu.com/p/1d84ba23f4d2
 * Dagger2主要分为三个模块:
 * 1.依赖提供方Module,负责提供依赖中所需要的对象,实际编码中类似于工厂类.
 * 2.依赖需求方实例,它声明依赖对象,它在实际编码中对应业务类,例如Activity,当你在Activity中需要某个对象时,你只要在其中声明就行.
 * 3.依赖注入组件Component,负责将对象注入到依赖需求方,它在实际编码中是一个接口,编译时Dagger2会自动为它生成一个实现类.
 *
 * Dagger2的主要工作流程分为以下几步:
 * 1.将依赖需求方实例传入给Component实现类.
 * 2.Component实现类根据依赖需求方实例中依赖声明,来确定该实例需要依赖哪些对象.
 * 3.确定依赖对象后,Component会在与自己关联的Module类中查找有没有提供这些依赖对象的方法,
 *   有的话就将Module类中提供的对象设置到依赖需求方实例中.
 *
 * 通俗上来讲就好比你现在需要一件衣服,自己做太麻烦了,你就去商店买,你跟商店老板说明你想要购买的类型后,
 * 商店老板就会在自己的衣服供应商中查找有没有你所说的类型,有就将它卖给你.其中你就对应上面所说的依赖需求方实例,
 * 你只要说明你需要什么,商店老板则对应Component实现类,负责满足别人的需求,而衣服供应商则对应Module类,他负责生产衣服.
 *
 * 有两种方式可以提供依赖，一个是注解了@Inject的构造方法，一个是在Module里提供的依赖，那么Dagger2是怎么选择依赖提供的呢，规则是这样的：
 * 步骤1：查找Module中是否存在创建该类的方法；
 * 步骤2：若存在创建类方法，查看该方法是否存在参数；
 * 步骤2.1：若存在参数，则按从步骤1开始依次初始化每个参数；
 * 步骤2.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束；
 * 步骤3：若不存在创建类方法，则查找Inject注解的构造函数，看构造函数是否存在参数；
 * 步骤3.1：若存在参数，则从步骤1开始依次初始化每个参数；
 * 步骤3.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束。
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private StringBuilder stringBuilder = new StringBuilder();
    private TextView tvMain;

    // 方式一：Cloth的构造方法没有添加@Inject注解，@Inject注解的字段不能是private和protected的
    @Inject
    Cloth cloth;

    // 方式二：在Shoe的构造方法中添加@Inject注解，当Component在所拥有的Module类中找不到依赖需求方需要类型的
    // 提供方法时,Dagger2就会检查该需要类型的有没有用@Inject声明的构造方法,有则用该构造方法创建一个。
    // 为什么不都用这种方法来声明呢?为什么要用Module类?因为项目中我们会用到别人的jar包,我们无法修改别人的源码,
    // 就更别说在人家的类上添加注解了,所以我们只能通过Module类来提供.
//    @Inject
//    Shoe shoe;

    // 当创建的这些依赖类需要依赖于其它依赖类时。
    // 同理,在带有@Inject注解的构造函数要是依赖于其它对象,Dagger2也会帮你自动注入。
    @Inject
    Clothes clothes;

//    @Inject
//    @Named("red")
//    Cloth redCloth;
//
//    @Inject
//    @Named("blue")
//    Cloth blueCloth;
//
//    @Inject
//    @YellowCloth
//    Cloth yellowCloth;
//
//    @Inject
//    @YellowCloth
//    Clothes yellowClothes;

    @Inject
    ClothHandler clothHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMain = (TextView) findViewById(R.id.tv_main);
        findViewById(R.id.btn_to_second).setOnClickListener(this);

        /**
         * 通过Dagger2自动生成的类来创建Component的实现类,创建时需要传入该Component实现类所需要的Module类实例,
         * 传入方法就是调用Module类类名首字母小写对应的方法。
         * 注意：编写完Component接口后Dagger2并不会自动创建对应的类,需要我们点击Android Studio中bulid菜单下的Rebulid Poject选项,
         * 或者直接书写代码,编译时Dagger2就会帮你自动生成。
         * error：出现无法自动生成Component类的情况，修改如下：
         * （1）dependencies下的dagger-compiler修改为：annotationProcessor 'com.google.dagger:dagger-compiler:2.0.2'
         * （2）支持1.8：在File->Project Structure->Modules中的Properties选项卡，把SourceCompatibility和
         *     TargetCompatibility都改成 1.8,现在默认是使用Java 1.8编译了。
         */
//        MainComponent build = DaggerMainComponent.builder().mainModule(new MainModule()).build();
//        MainComponent build = DaggerMainComponent
//                .builder()
//                .baseComponent(((MyApplication)getApplication()).getBaseComponent())
//                .mainModule(new MainModule())
//                .build();
//        build.inject(this);

//        stringBuilder.append("我现在有:\n");
//        stringBuilder.append(cloth+"\n");
//        stringBuilder.append(shoe+"\n");
//        stringBuilder.append(clothes+"\n");
//        stringBuilder.append(redCloth+"\n");
//        stringBuilder.append(blueCloth+"\n");
//        stringBuilder.append(yellowCloth+"\n");
//        stringBuilder.append(yellowClothes+"\n");
//        stringBuilder.append("clothes=clothes中的cloth吗?:" + (cloth == clothes.getCloth()));
//        stringBuilder.append("布料加工后变成了" + clothHandler.handle(cloth) + "clothHandler地址:" + clothHandler);
//        tvMain.setText(stringBuilder.toString());

        MyApplication application = (MyApplication) getApplication();
        application.getBaseComponent()
                .getSubMainComponent(new MainModule())
                .inject(this);
        tvMain.setText("红布料加工后变成了" + clothHandler.handle(cloth) + "\nclothHandler地址:" + clothHandler);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_to_second:
                SecondActivity.entry(this);
                break;
        }
    }
}
