package com.sky.myapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class AFragment extends Fragment {
    private TextView layout_fragment_a_text;
    private Activity mActivity;
    private Button layout_fragment_a_button, layout_fragment_a_textchange,layout_fragment_a_button_message;
    private BFragment bFragment;
    private IOnMessageClick iOnMessageClick;
    public interface  IOnMessageClick{
        void onClick(String text);
    }
    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //声明布局文件
        View view = inflater.inflate(R.layout.layout_fragment_a, container, false);
        Log.d("fragment","----oncreate----");
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layout_fragment_a_text = view.findViewById(R.id.layout_fragment_a_text);
        layout_fragment_a_button = view.findViewById(R.id.layout_fragment_a_button);
        layout_fragment_a_textchange = view.findViewById(R.id.layout_fragment_a_button_textchange);
        if (getArguments() != null) {
            layout_fragment_a_text.setText(getArguments().getString("title"));
        }
        layout_fragment_a_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null) {
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if (fragment != null) {
                    getFragmentManager().beginTransaction().hide(fragment)
                            .add(R.id.activity_container_fragment, bFragment).addToBackStack(null).commit();
                } else {
                    getFragmentManager().beginTransaction().replace(R.id.activity_container_fragment, bFragment)
                            .addToBackStack(null).commit();
                }
            }
        });
        layout_fragment_a_textchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_fragment_a_text.setText("我是新文字");
            }
        });
        layout_fragment_a_button_message = view.findViewById(R.id.layout_fragment_a_button_message);
        layout_fragment_a_button_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               iOnMessageClick.onClick("你好222");
            }
        });
    }

    //fragment 和activity绑定,在getActivity为null时也必然执行
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            iOnMessageClick = (IOnMessageClick) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity 必须实现 IOnMessageClick 这个接口");
        }
    }

    //运行该方法后与宿主Activity脱离了联系
    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消异步
    }
}
