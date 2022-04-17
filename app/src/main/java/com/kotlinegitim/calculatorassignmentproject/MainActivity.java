package com.kotlinegitim.calculatorassignmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.kotlinegitim.calculatorassignmentproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private TextView userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.kotlinegitim.calculatorassignmentproject.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userInput = binding.userInput;
        userInput.setOnClickListener(view -> {
            if (getString(R.string.user_input).equals(userInput.getText().toString())) {
                userInput.setText("");
            }
        });

        binding.buttonZero.setOnClickListener(view -> changeUserInput("0"));

        binding.buttonOne.setOnClickListener(view -> changeUserInput("1"));

        binding.buttonTwo.setOnClickListener(view -> changeUserInput("2"));

        binding.buttonThree.setOnClickListener(view -> changeUserInput("3"));

        binding.buttonFour.setOnClickListener(view -> changeUserInput("4"));

        binding.buttonFive.setOnClickListener(view -> changeUserInput("5"));

        binding.buttonSix.setOnClickListener(view -> changeUserInput("6"));

        binding.buttonSeven.setOnClickListener(view -> changeUserInput("7"));

        binding.buttonEight.setOnClickListener(view -> changeUserInput("8"));

        binding.buttonNine.setOnClickListener(view -> changeUserInput("9"));

        binding.buttonSum.setOnClickListener(view -> {
            String input = userInput.getText().toString();
            String lastInput = input.substring(input.length() - 1);
            if (!lastInput.equals("+")) {
                changeUserInput("+");
            }
        });

        binding.buttonDot.setOnClickListener(view -> changeUserInput("."));

        binding.buttonClear.setOnClickListener(view -> userInput.setText(""));

        binding.buttonDelete.setOnClickListener(view -> {
            int userInputLength = userInput.length();
            if (userInputLength > 0) {
                userInput.setText(userInput.getText().toString().substring(0, userInputLength - 1));
            }
        });

        binding.buttonEquals.setOnClickListener(view -> {
            String[] userInputArray = userInput.getText().toString().split("\\+");

            double size = userInputArray.length;
            double[] intArray = new double[(int) size];
            for (int i = 0; i < size; i++) {
                intArray[i] = Double.parseDouble(userInputArray[i]);
            }
            double sum = 0;
            for (double i : intArray) {
                sum += i;
            }
            userInput.setText(String.valueOf(sum));
        });
    }

    private void changeUserInput(String addNumber) {
        if (getString(R.string.user_input).equals(userInput.getText().toString())) {
            userInput.setText("");
        }
        userInput.setText(userInput.getText().toString() + addNumber);
    }
}