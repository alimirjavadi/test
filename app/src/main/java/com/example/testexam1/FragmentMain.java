package com.example.testexam1;

import static com.example.testexam1.FragmentB.KEY_NAME;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentMain extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main , container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button sendDataToFragment = view.findViewById(R.id.btn_send_data);
        EditText editText = view.findViewById(R.id.edit_text_id);
        sendDataToFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fragmentTransaction2 = getParentFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.fragmentContainerView, FragmentB.newInstance(editText.getText().toString()));
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
            }
        });
    }

}
