package com.year2018.fw_dagger2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.year2018.fw_dagger2.bean.Cloth;
import com.year2018.fw_dagger2.component.DaggerSecondComponent;
import com.year2018.fw_dagger2.component.SecondComponent;
import com.year2018.fw_dagger2.module.SecondModule;
import com.year2018.fw_dagger2.util.ClothHandler;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {
    private StringBuilder stringBuilder = new StringBuilder();
    private TextView tvSecond;

    @Inject
    Cloth blueCloth;

    @Inject
    ClothHandler clothHandler;

    public static void entry(Context from){
        Intent intent = new Intent(from,SecondActivity.class);
        from.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvSecond = (TextView)findViewById(R.id.tv_second);
//        SecondComponent secondComponent = DaggerSecondComponent.builder().secondModule(new SecondModule()).build();
        SecondComponent secondComponent = DaggerSecondComponent
                .builder()
                .baseComponent(((MyApplication)getApplication()).getBaseComponent())
                .secondModule(new SecondModule())
                .build();
        secondComponent.inject(this);
        stringBuilder.append("蓝布料加工后变成了" + clothHandler.handle(blueCloth) + "\nclothHandler地址:" + clothHandler);
        tvSecond.setText(stringBuilder.toString());
    }
}
