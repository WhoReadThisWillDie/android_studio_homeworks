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

    private TextView textViewX1;
    private TextView textViewX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        editTextC = findViewById(R.id.edit_text_c);

        textViewX1 = findViewById(R.id.text_view_x1);
        textViewX2 = findViewById(R.id.text_view_x2);

    }

    public void click(View view) {
        textViewX1.setText("");
        textViewX2.setText("");
        String textA = editTextA.getText().toString();
        String textB = editTextB.getText().toString();
        String textC = editTextC.getText().toString();

        double x1;
        double x2;

        if (textA.isEmpty() || textB.isEmpty() || textC.isEmpty() || textA.equals("-") || textB.equals("-"))
            Toast.makeText(this, "Некорректный ввод", Toast.LENGTH_SHORT).show();
        else {
            double a = Double.parseDouble(textA);
            double b = Double.parseDouble(textB);
            double c = Double.parseDouble(textC);

            if (a == 0) {
                if (b == 0)
                    textViewX1.setText("Нет корней");
                else {
                    x1 = -c / b;
                    textViewX1.setText("x = " + x1);
                }
            }
            else {
                double discriminant = b * b - 4 * a * c;
                if (discriminant > 0) {
                    x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
                    x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
                    textViewX1.setText("x1 = " + x1);
                    textViewX2.setText("x2 = " + x2);
                } else if (discriminant == 0) {
                    x1 = -b / (2 * a);
                    textViewX1.setText("x = " + x1);
                } else
                    textViewX1.setText("Нет корней");
            }
        }
    }
}