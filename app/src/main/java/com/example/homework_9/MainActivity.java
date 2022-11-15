package com.example.homework_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;

    private TextView textViewX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        editTextC = findViewById(R.id.edit_text_c);

        textViewX = findViewById(R.id.text_view_x);

    }

    private double getDoubleValue(EditText editText) {
        if (editText.getText().toString().isEmpty() || editText.getText().toString().equals("-")) {
            Toast.makeText(this, "Некорректный ввод",Toast.LENGTH_SHORT).show();
            return 0;
        }
        return Double.parseDouble(editText.getText().toString());
    }

    public void click(View view) {
        double a = getDoubleValue(editTextA);
        double b = getDoubleValue(editTextB);
        double c = getDoubleValue(editTextC);

        double x = (c - b) / (double) a;
        textViewX.setText(String.format("%.2f", x));

        Toast.makeText(this, x + "", Toast.LENGTH_SHORT).show();
    }
}