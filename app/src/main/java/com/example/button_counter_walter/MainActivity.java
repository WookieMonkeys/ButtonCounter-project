package com.example.button_counter_walter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button increment_button;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.displayId);

        increment_button = findViewById(R.id.button);
        increment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementCounter();
            }
        });


    }

    private void incrementCounter(){
        int currentValue = Integer.valueOf(display.getText().toString());
        currentValue++;
        display.setText(String.valueOf(currentValue));
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

