package com.example.lab5_slominski_march25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView tvName, tvNewName;
    EditText etInputName;
    String process;

    public static final String SHARED_PREFS = "sharePres";
    public static final String TEXT = "text";

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        tvName = findViewById(R.id.tvName);
        tvNewName = findViewById(R.id.tvNewName);
        etInputName = findViewById(R.id.etInputName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName();
            }
        });

        loadName();
        updateViews();
    }

    public void saveName() {
        process = etInputName.getText().toString();
        tvNewName.setText(process);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, tvNewName.getText().toString());

        editor.apply();
    }

    public void loadName() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"Name");
    }

    public  void updateViews(){
        tvName.setText(text);
    }


}
