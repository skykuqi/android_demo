package com.sky.myapplication.androidword1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {
    private RadioGroup radio_group_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radio_group_city = findViewById(R.id.radio_group_city);
        radio_group_city.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                String radioText = radioButton.getText().toString();
                Toast.makeText(RadioButtonActivity.this,radioText,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
