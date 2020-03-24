package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Operation = 0;
    int OperationTemp = 0;
    double result = 0;
    double LiczbaA = 0;
    double LiczbaB = 0;
    TextView resultText, result2Text;

    void calculate(int x) {
        switch (x) {
            case 1://add
                result = LiczbaA + LiczbaB;
                LiczbaA = result;
                resultText.setText(Double.toString(result));
                break;

            case 2://substract
                if (OperationTemp == 0) {
                    result = LiczbaA - LiczbaB;
                    LiczbaA = result;
                    resultText.setText(Double.toString(result));
                    break;
                } else {
                    Operation = OperationTemp;
                    break;
                }
            case 3://multiply
                result = LiczbaA * LiczbaB;
                LiczbaA = result;
                resultText.setText(Double.toString(result));
                break;

            case 4://divide
                result = LiczbaA / LiczbaB;
                if (LiczbaB == 0) {
                    resultText.setText("Err!");
                    //dzielenie przez zero!!!
                } else {
                    LiczbaA = result;
                    resultText.setText(Double.toString(result));
                }
                break;

            case 5://mod
                result = LiczbaA % LiczbaB;
                LiczbaA = result;
                resultText.setText(Double.toString(result));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonZero = findViewById(R.id.buttonZero);
        final Button buttonOne = findViewById(R.id.buttonOne);
        final Button buttonTwo = findViewById(R.id.buttonTwo);
        final Button buttonThree = findViewById(R.id.buttonThree);
        final Button buttonFour = findViewById(R.id.buttonFour);
        final Button buttonFive = findViewById(R.id.buttonFive);
        final Button buttonSix = findViewById(R.id.buttonSix);
        final Button buttonSeven = findViewById(R.id.buttonSeven);
        final Button buttonEight = findViewById(R.id.buttonEight);
        final Button buttonNine = findViewById(R.id.buttonNine);
        final Button buttonFact = findViewById(R.id.buttonFact);
        final Button buttonDot = findViewById(R.id.buttonDot);
        final Button buttonEquals = findViewById(R.id.buttonEquals);
        final Button buttonMod = findViewById(R.id.buttonMod);
        final Button buttonSquare = findViewById(R.id.buttonSquare);
        final Button buttonSqrt = findViewById(R.id.buttonSqrt);
        final Button buttonPlus = findViewById(R.id.buttonPlus);
        final Button buttonMinus = findViewById(R.id.buttonMinus);
        final Button buttonX = findViewById(R.id.buttonX);
        final Button buttonAC = findViewById(R.id.buttonAC);
        final Button buttonC = findViewById(R.id.buttonC);
        final Button buttonDivide = findViewById(R.id.buttonDivide);
        resultText = findViewById(R.id.textViewResult);
        result2Text = findViewById(R.id.textViewResult2);


        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonZero.getText());
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonOne.getText());
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonTwo.getText());
            }
        });


        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonThree.getText());
            }
        });


        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonFour.getText());
            }
        });


        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonFive.getText());
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonSix.getText());
            }
        });


        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonSeven.getText());
            }
        });


        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonEight.getText());
            }
        });


        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonNine.getText());
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPlus.setEnabled(false);
                result2Text.setText(resultText.getText() + (String) buttonPlus.getText());
                buttonDot.setEnabled(true);
                Operation = 1;
                int length = resultText.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    result2Text.setText(resultText.getText() + "+");
                    LiczbaA = Double.parseDouble((String) resultText.getText());
                    resultText.setText("");
                }
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDot.setEnabled(true);
                Operation = 2;
                int length = resultText.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0 && resultText.getText() != "-") {
                    result2Text.setText(resultText.getText() + "-");
                    LiczbaA = Double.parseDouble((String) resultText.getText());
                    resultText.setText("");
                    buttonMinus.setEnabled(true);
                } else {
                    resultText.setText("-");
                }
            }
        });

        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDot.setEnabled(true);
                OperationTemp = 3;
                int length = resultText.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    result2Text.setText(resultText.getText() + "x");
                    LiczbaA = Double.parseDouble((String) resultText.getText());
                    resultText.setText("");
                } else {
                    //pusty string
                }
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDot.setEnabled(true);
                OperationTemp = 4;
                int length = resultText.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    result2Text.setText(resultText.getText() + "/");
                    LiczbaA = Double.parseDouble((String) resultText.getText());
                    resultText.setText("");
                } else {
                    //pusty string
                }
            }
        });

        buttonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDot.setEnabled(true);
                Operation = 5;
                int length = resultText.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    result2Text.setText(resultText.getText() + "%");
                    LiczbaA = Double.parseDouble((String) resultText.getText());
                    resultText.setText("");
                    buttonMinus.setEnabled(true);
                } else {
                    //pusty string
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = resultText.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                int number = length - 1; //z ktorego miejsca stringa usunac (numeracja od 0)
                String temp;
                if (length > 0) {
                    StringBuilder del = new StringBuilder(resultText.getText());
                    del.deleteCharAt(number);//usun znak na ostatnim miejscu
                    temp = del.toString();//zmiana stringbuilder na string
                    resultText.setText(temp);
                } else {
                    OperationTemp=0;
                    Operation=0;
                    buttonDot.setEnabled(true);
                }
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText("");
                result2Text.setText("");
                Operation = 0;
                OperationTemp = 0;
                LiczbaA = 0;
                result = 0;
                LiczbaB = 0;
                buttonDot.setEnabled(true);
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(resultText.getText() + (String) buttonDot.getText());
                buttonDot.setEnabled(false);
                int length = resultText.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    String temp1;
                    String del = (String) resultText.getText();
                    for (int i = 0; i < del.length(); i++) {
                        if (del.charAt(i) == '.') {
                            //juz jest kropka
                            return;
                        }
                    }
                    temp1 = del;//zmiana stringbuilder na string
                    resultText.setText(temp1 + ".");
                } else {
                    buttonDot.setEnabled(true);
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPlus.setEnabled(true);
                int length = resultText.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (OperationTemp == 0) {//jesli odejmowanie lub dodawanie dodatniej
                    if (length > 0) {
                        result2Text.setText("");
                        LiczbaB = Double.parseDouble((String) resultText.getText());
                        calculate(Operation);
                    } else {
                        ///ousty string
                    }
                } else {//jesli dzielenie lub mnozenie ujemnej
                    Operation = OperationTemp;
                    result2Text.setText("");
                    LiczbaB = Double.parseDouble((String) resultText.getText());
                    calculate(Operation);
                    OperationTemp = 0;
                }
            }
        });
    }
}
