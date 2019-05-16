package com.sky.myapplication.shared;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sky.myapplication.androidword1.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
    private static final String FILE_NAME = "text.txt";
    private TextView file_preferences_text_write, file_preferences_text_show;
    private Button file_preferences_button_save, file_preferences_button_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        file_preferences_text_write = findViewById(R.id.file_preferences_text_write);
        file_preferences_text_show = findViewById(R.id.file_preferences_text_show);
        file_preferences_button_save = findViewById(R.id.file_preferences_button_save);
        file_preferences_button_show = findViewById(R.id.file_preferences_button_show);

        file_preferences_button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                save(file_preferences_text_write.getText().toString());
                saveOut(file_preferences_text_write.getText().toString());
            }
        });
        file_preferences_button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String text = read();
                String text = readOut();
                file_preferences_text_show.setText(text);
            }
        });
    }

    /**
     * 保存数据
     *
     * @param content 需要保存的内容
     */
    private void save(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            //打开文件输出流
            fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            //写入数据
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输出流 fileOutputStream.close();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 外部存储数据
     *
     * @param content 需要保存的内容
     */
    private void saveOut(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            File dir = null;
            //指定文件目录
            dir = new File(Environment.getExternalStorageDirectory(), "skypan");
            //不存在需要新建文件夹
            if (!dir.exists()) {
                //只新建一个文件夹 mkdirs 会解析名称 skypan/a/b 则会生成多个文件夹
                dir.mkdir();
            }
            //指定文件
            File file = new File(dir, FILE_NAME);
            //不存在需要新建该文件
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取数据
     *
     * @return 读取到的数据
     */
    private String read() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int len = 0;
            while ((len = fileInputStream.read(buff)) > 0) {
                sb.append(new String(buff, 0, len));
            }

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 外部读取
     *
     * @return 读取到的内容
     */
    private String readOut() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "skypan", FILE_NAME);
            fileInputStream = new FileInputStream(file);
            byte[] buff = new byte[1024];
            int len = 0;
            StringBuilder sb = new StringBuilder();
            while ((len = fileInputStream.read(buff)) > 0) {
                sb.append(new String(buff, 0, len));
            }
            return sb.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (fileInputStream != null) {
                        try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
