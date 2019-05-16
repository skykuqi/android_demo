package com.sky.myapplication.androidword1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    CheckBox checkbox_check_hobby_1, checkbox_check_hobby_2, checkbox_check_hobby_3, checkbox_check_hobby_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        checkbox_check_hobby_1 = findViewById(R.id.checkbox_check_hobby_1);
        checkbox_check_hobby_2 = findViewById(R.id.checkbox_check_hobby_2);
        checkbox_check_hobby_3 = findViewById(R.id.checkbox_check_hobby_3);
        checkbox_check_hobby_4 = findViewById(R.id.checkbox_check_hobby_4);
        setLinsters();
    }

    private void setLinsters() {
        Onclick onclick = new Onclick();
        checkbox_check_hobby_1.setOnClickListener(onclick);
        checkbox_check_hobby_2.setOnClickListener(onclick);
        checkbox_check_hobby_3.setOnClickListener(onclick);
        checkbox_check_hobby_4.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.checkbox_check_hobby_1:
                    Toast.makeText(CheckBoxActivity.this, checkbox_check_hobby_1.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_check_hobby_2:
                    Toast.makeText(CheckBoxActivity.this, checkbox_check_hobby_2.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_check_hobby_3:
                    Toast.makeText(CheckBoxActivity.this, checkbox_check_hobby_3.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_check_hobby_4:
                    Toast.makeText(CheckBoxActivity.this, checkbox_check_hobby_4.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
