package com.example.testexam1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {
    private static final String KEY_DATA = "SOME_KEY";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView fragment_textview = view.findViewById(R.id.fragment_textview);
        fragment_textview.setText(getArguments().getString(KEY_DATA));
    }

    public static FragmentA newInstance(String data) {

        Bundle args = new Bundle();
        args.putString(KEY_DATA,data);
        FragmentA fragment = new FragmentA();
        fragment.setArguments(args);
        return fragment;
    }
}
