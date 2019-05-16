package com.sky.myapplication.shared;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sky.myapplication.androidword1.R;

public class SharedActivity extends AppCompatActivity {
    private Button shared_button_sharedpreferences, shared_button_file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        shared_button_sharedpreferences = findViewById(R.id.shared_button_sharedpreferences);
        shared_button_file = findViewById(R.id.shared_button_file);

        myOnclick();

    }

    private void myOnclick() {
        MyOnclickListener myOnclickListener = new MyOnclickListener();
        shared_button_sharedpreferences.setOnClickListener(myOnclickListener);
        shared_button_file.setOnClickListener(myOnclickListener);
    }

    class MyOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.shared_button_sharedpreferences:
                    intent = new Intent(SharedActivity.this, SharedPreferencesActivity.class);
                    break;
                case R.id.shared_button_file:
                    intent = new Intent(SharedActivity.this,FileActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}
