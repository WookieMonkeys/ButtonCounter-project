package com.example.button_counter_walter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button increment_button;
    private Button decrement_button;
    private Button clear_button;

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.displayId);

        increment_button = findViewById(R.id.incrementButton);
        increment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementCounter();
            }
        });

        decrement_button = findViewById(R.id.decrementButton);
        decrement_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementCounter();
            }
        });

        clear_button = findViewById(R.id.clearButton);
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCounter();
            }
        });

    }

    private void incrementCounter(){
        int currentValue = Integer.valueOf(display.getText().toString());
        currentValue++;
        display.setText(String.valueOf(currentValue));
    }

    private void decrementCounter(){
        int currentValue = Integer.valueOf(display.getText().toString());
        currentValue--;
        display.setText(String.valueOf(currentValue));
    }

    private void clearCounter(){
        display.setText(String.valueOf(0));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String counterValue = display.getText().toString();

        outState.putString("display", counterValue);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

       String counterValue = savedInstanceState.getString("display");
       display.setText(counterValue);
    }
}

