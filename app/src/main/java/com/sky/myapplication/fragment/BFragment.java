package com.sky.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sky.myapplication.androidword1.R;

/**
 * @author 施 凯 沅
 * @version 0.0.1
 */
public class BFragment extends Fragment {
    private TextView layout_fragment_b_text;
    private Button layout_fragment_b_button;
    private AFragment aFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //声明布局文件
        View view = inflater.inflate(R.layout.layout_fragment_b, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layout_fragment_b_text = view.findViewById(R.id.layout_fragment_b_text);
        layout_fragment_b_button = view.findViewById(R.id.layout_fragment_b_button);
        layout_fragment_b_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aFragment == null) {
                    aFragment = new AFragment();
                }
                getFragmentManager().beginTransaction().replace(R.id.activity_container_fragment, aFragment).commit();
            }
        });
    }
}
