package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class delFragment extends Fragment {

    private int content;

    /*public delFragment(int content) {
        this.content = content;
    }*/

    private ImageView tv_content;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.del_view, container, false);
       /* tv_content = view.findViewById(R.id.img);
        tv_content.setImageResource(content);*/
        return view;
    }

    public void setContent(int content) {
        this.content = content;
        tv_content.setImageResource(content);
    }
}
