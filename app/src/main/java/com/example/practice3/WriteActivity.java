package com.example.practice3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;

public class WriteActivity extends AppCompatActivity {

    int noteID;
    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        editText = (EditText) findViewById(R.id.write);
        textView = (TextView) findViewById(R.id.count);
        button = (Button) findViewById(R.id.button);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @SuppressLint("SetTextI18n")
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = editText.getText().toString();
                textView.setText(input.length() + " ");
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        button.setOnClickListener(view -> {
            MainActivity.adapter.addData(editText.getText().toString());

            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.tanay.thunderbird.deathnote", Context.MODE_PRIVATE);
            HashSet<String> set = new HashSet<>(MainActivity.notes);
            sharedPreferences.edit().putStringSet("notes", set).apply();

            finish();
        });
    }
}