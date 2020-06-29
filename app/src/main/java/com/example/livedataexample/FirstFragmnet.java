package com.example.livedataexample;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

public class FirstFragmnet extends Fragment {

    EditText editText;
    TextView textView;

    private MutableLiveData<String> stringMLiveData;

    public MutableLiveData<String> getStringMLiveData() {
        if (stringMLiveData == null) {
            stringMLiveData = new MutableLiveData<String>();
        }
        return stringMLiveData;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstfrag, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.txt);
        editText = view.findViewById(R.id.edittxt);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stringMLiveData.setValue(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
