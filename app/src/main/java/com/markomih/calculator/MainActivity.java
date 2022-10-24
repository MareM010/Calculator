package com.markomih.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


import org.mariuszgromada.math.mxparser.*;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot, btnEquals, btnDivide, btnMultiple, btnSubstract, btnAddition, btnClear, btnOpenParenthesis, btnClosedParenthesis, btnExponent, btnPercentage, btnFactoriel, btnModuo, btnSquareRoot;
    ImageButton btnDelete;
    TextView displayText;
    ScrollView mScrollView;
    boolean dotPlaced, equalsPressedStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mScrollView = (ScrollView) findViewById(R.id.scroll_view);

        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        btnDot = findViewById(R.id.btn_dot);
        btnEquals = findViewById(R.id.btn_equals);
        btnDivide = findViewById(R.id.btn_divide);
        btnMultiple = findViewById(R.id.btn_multiplicate);
        btnSubstract = findViewById(R.id.btn_substract);
        btnAddition = findViewById(R.id.btn_addition);
        displayText = findViewById(R.id.txt_window);
        btnClear = findViewById(R.id.btn_clear);
        btnDelete = (ImageButton) findViewById(R.id.btn_delete);
        btnClosedParenthesis = findViewById(R.id.btn_closed_parenthesis);
        btnOpenParenthesis = findViewById(R.id.btn_open_parenthesis);
        btnExponent = findViewById(R.id.btn_exponent);
        btnFactoriel = findViewById(R.id.btn_factorial);
        btnModuo = findViewById(R.id.btn_modulo);
        btnPercentage = findViewById(R.id.btn_percentage);
        btnSquareRoot = findViewById(R.id.btn_square_root);
        dotPlaced = false;
        equalsPressedStatus = false;

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        mXparser.enableAlmostIntRounding();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                displayText.setText(displayText.getText() + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                displayText.setText(displayText.getText() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                displayText.setText(displayText.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText(""); }
                displayText.setText(displayText.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText(""); }
                displayText.setText(displayText.getText() + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText(""); }
                displayText.setText(displayText.getText() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText(""); }
                displayText.setText(displayText.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText(""); }
                displayText.setText(displayText.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    infinityDetection();
                    displayText.setText(""); }
                displayText.setText(displayText.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText(""); }
                displayText.setText(displayText.getText() + "9");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText(""); }
                int length = displayText.length();
                if (length <= 0 || displayText.getText().charAt(length - 1) != '/' || displayText.getText().charAt(length - 1) != '*' || displayText.getText().charAt(length - 1) != '-' || displayText.getText().charAt(length - 1) != '+' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '#') {
                    if (dotPlaced == false) {
                        displayText.setText(displayText.getText() + ".");
                        dotPlaced = true;
                    }
                }
            }
        });
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(60);
                equalsCalculation(); }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                int length = displayText.length();
                if (length != 0)
                    if (displayText.getText().charAt(length - 1) != '.') {
                        dotPlaced = true;
                        if (displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '#') {
                            String temp = displayText.getText().toString().substring(0, length - 1);
                            displayText.setText(temp);
                            displayText.setText(displayText.getText() + "/");
                        } else {
                            displayText.setText(displayText.getText() + "/");
                            dotPlaced = false; }
                    }

                equalsPressedStatus = false;
            }
        });
        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                int length = displayText.length();
                if (length != 0)
                    if (displayText.getText().charAt(length - 1) != '.')
                        if (displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '#') {
                            String temp = displayText.getText().toString().substring(0, length - 1);
                            displayText.setText(temp);
                            displayText.setText(displayText.getText() + "*");
                        } else {
                            displayText.setText(displayText.getText() + "*");
                            dotPlaced = false;
                        }
                equalsPressedStatus = false;
            }
        });
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                int length = displayText.length();
                if (length != 0)
                    if (displayText.getText().charAt(length - 1) != '.')
                        if (displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '#') {
                            String temp = displayText.getText().toString().substring(0, length - 1);
                            displayText.setText(temp);
                            displayText.setText(displayText.getText() + "-");
                        } else {
                            displayText.setText(displayText.getText() + "-");
                            dotPlaced = false;
                        }
                equalsPressedStatus = false;
            }
        });
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                int length = displayText.length();
                if (length != 0)
                    if (displayText.getText().charAt(length - 1) != '.')
                        if (displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '#') {
                            String temp = displayText.getText().toString().substring(0, length - 1);
                            displayText.setText(temp);
                            displayText.setText(displayText.getText() + "+");
                        } else {
                            displayText.setText(displayText.getText() + "+");
                            dotPlaced = false;
                        }
                equalsPressedStatus = false;
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(60);
                displayText.setText("");
                dotPlaced = false;
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(30);
                try {
                    int length = displayText.length();
                    if (displayText.length() == 0 || displayText.getText().charAt(length - 1) == '.') {
                        String temp = displayText.getText().toString().substring(0, length - 1);
                        displayText.setText(temp);
                        dotPlaced = false;
                    } else if (length > 0 && displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '0' || displayText.getText().charAt(length - 1) == '1' || displayText.getText().charAt(length - 1) == '2' || displayText.getText().charAt(length - 1) == '3' || displayText.getText().charAt(length - 1) == '4' || displayText.getText().charAt(length - 1) == '5' || displayText.getText().charAt(length - 1) == '6' || displayText.getText().charAt(length - 1) == '7' || displayText.getText().charAt(length - 1) == '8' || displayText.getText().charAt(length - 1) == '9' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '!' || displayText.getText().charAt(length - 1) == '#' || displayText.getText().charAt(length - 1) == '√' || displayText.getText().charAt(length - 1) == 'E' || displayText.getText().charAt(length - 1) == '(' || displayText.getText().charAt(length - 1) == ')') {
                        String temp = displayText.getText().toString().substring(0, length - 1);
                        displayText.setText(temp);
                    } else {
                        displayText.setText("");
                        dotPlaced = false;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        btnDelete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                vibrator.vibrate(60);
                displayText.setText("");
                dotPlaced = false;
                return false;
            }
        });

        btnOpenParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                displayText.setText(displayText.getText() + "(");
                equalsPressedStatus = false; }
        });

        btnClosedParenthesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                displayText.setText(displayText.getText() + ")");
                equalsPressedStatus = false; }
        });

        btnExponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                int length = displayText.length();
                if (length != 0)
                    if (displayText.getText().charAt(length - 1) != '.')
                        if (displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '#') {
                            String temp = displayText.getText().toString().substring(0, length - 1);
                            displayText.setText(temp);
                            displayText.setText(displayText.getText() + "^");
                        } else {
                            displayText.setText(displayText.getText() + "^");
                            dotPlaced = false;
                        }
                equalsPressedStatus = false; }
        });

        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                int length = displayText.length();
                if (length != 0)
                    if (displayText.getText().charAt(length - 1) != '.')
                        if (displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '#') {
                            String temp = displayText.getText().toString().substring(0, length - 1);
                            displayText.setText(temp);
                            displayText.setText(displayText.getText() + "%");
                        } else {
                            displayText.setText(displayText.getText() + "%");
                            dotPlaced = false;
                        }
                equalsPressedStatus = false;
            }
        });

        btnFactoriel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                int length = displayText.length();
                if (length != 0)
                    if (displayText.getText().charAt(length - 1) != '.')
                        if (displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '!' || displayText.getText().charAt(length - 1) == '#') {
                            String temp = displayText.getText().toString().substring(0, length - 1);
                            displayText.setText(temp);
                            displayText.setText(displayText.getText() + "!");
                        } else {
                            displayText.setText(displayText.getText() + "!");
                            dotPlaced = false;
                        }
                equalsPressedStatus = false;
            }
        });

        btnModuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                int length = displayText.length();
                if (length != 0)
                    if (displayText.getText().charAt(length - 1) != '.')
                        if (displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '!' || displayText.getText().charAt(length - 1) == '#') {
                            String temp = displayText.getText().toString().substring(0, length - 1);
                            displayText.setText(temp);
                            displayText.setText(displayText.getText() + "#");
                        } else {
                            displayText.setText(displayText.getText() + "#");
                            dotPlaced = false;
                        }
                equalsPressedStatus = false;
            }
        });

        btnSquareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infinityDetection();
                vibrator.vibrate(30);
                if (isInputInvalid()) {
                    displayText.setText("");
                }
                int length = displayText.length();
                try {
                    if (displayText.getText().charAt(length - 1) != '.')
                        if (displayText.getText().charAt(length - 1) == '-' || displayText.getText().charAt(length - 1) == '+' || displayText.getText().charAt(length - 1) == '*' || displayText.getText().charAt(length - 1) == '/' || displayText.getText().charAt(length - 1) == '^' || displayText.getText().charAt(length - 1) == '%' || displayText.getText().charAt(length - 1) == '!' || displayText.getText().charAt(length - 1) == '#') {
                            String temp = displayText.getText().toString().substring(0, length - 1);
                            displayText.setText(temp);
                            displayText.setText(displayText.getText() + "√");
                        } else {
                            displayText.setText(displayText.getText() + "√");
                            dotPlaced = false;
                        }
                } catch (Exception e) {
                    displayText.setText(displayText.getText() + "√");
                    dotPlaced = false;
                }
                equalsPressedStatus = false;
            }
        });
        displayText.setMovementMethod(new ScrollingMovementMethod());
    }

    void equalsCalculation() {
        equalsPressedStatus = true;
        String displayString = displayText.getText().toString();
        if (displayString.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter numbers", Toast.LENGTH_SHORT).show();
            displayText.setText("");
        }
        if(displayString.contains("+") || displayString.contains("-") || displayString.contains("*") || displayString.contains("/") || displayString.contains("#") || displayString.contains("!") || displayString.contains("%") || displayString.contains("√") || displayString.contains("^") == true) {

            {
                try {
                    Double expressionCalculation = new Expression(displayString).calculate();
                    if (expressionCalculation.isNaN()) {
                        displayText.setText(displayString);
                        Toast.makeText(getApplicationContext(), "Invalid input values", Toast.LENGTH_SHORT).show();

                    } else {
                        displayText.setText(String.valueOf(round(expressionCalculation, 2)));
                    }
                } catch (ArithmeticException e) {
                    Toast.makeText(getApplicationContext(), "Values too large", Toast.LENGTH_SHORT).show();
                }

                // if a decimal result has zero and dot preceding it at the end, deletes last two characters
                // ako na kraju rezultata postoje tacka i nula, brise ih
                if (displayText.getText().charAt(displayText.length() - 1) == '0') {
                    String temp = displayText.getText().toString().substring(0, displayText.length() - 1);
                    displayText.setText(temp);
                    if (displayText.getText().charAt(displayText.length() - 1) == '.') {
                        String temp1 = displayText.getText().toString().substring(0, displayText.length() - 1);
                        displayText.setText(temp1);
                    }
                }

                // checks if output number has decimal point already, if it has, user is forbidden to enter it until operator is placed and second number comes,
                if (displayText.getText().toString().contains("."))
                    dotPlaced = true;
            }
        }
    }

    boolean isInputInvalid() {
        if (displayText.getText().equals("Invalid input values") || displayText.getText().equals("Infinity"))
            return true;
        else {
            return false; }
    }


    // rounding decimal numbers to specific number of decimal places(passed down as a places argument)
    public static double round(double value, int places) {
        try {
            if (places < 0) throw new IllegalArgumentException();

            BigDecimal bd = BigDecimal.valueOf(value);
            bd = bd.setScale(places, RoundingMode.HALF_UP);
            return bd.doubleValue();
        } catch (NumberFormatException e) {
            return value; }
    }

    public void infinityDetection(){
       boolean detected = displayText.getText().toString().contains("Infinity");
        if(detected == true){
            displayText.setText("");
        }
    }



}
