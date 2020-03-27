package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Operation = 0;
    int OperationTemp = 0;
    double result = 0;
    double TopNumber = 0;
    double BottomNumber = 0;
    TextView resultTextBottom, resultTextTop;
    Button buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive,
            buttonSix, buttonSeven, buttonEight, buttonNine, buttonDot, buttonEquals,
            buttonMod, buttonPlus, buttonMinus, buttonX, buttonAC, buttonC, buttonDivide,
            buttonLog, buttonFact, buttonSqrt, buttonSquare, buttonCube;


    public void getAndSetNumberInput(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        resultTextBottom.setText(resultTextBottom.getText() + buttonText);
    }

    void calculate(int x) {
        switch (x) {
            case 1://add
                result = TopNumber + BottomNumber;
                resultTextBottom.setText(Double.toString(result));
                break;

            case 2://substract
                if (OperationTemp == 0) {
                    result = TopNumber - BottomNumber;
                    resultTextBottom.setText(Double.toString(result));
                    break;
                } else {
                    Operation = OperationTemp;
                    break;
                }
            case 3://multiply
                result = TopNumber * BottomNumber;
                resultTextBottom.setText(Double.toString(result));
                break;

            case 4://divide
                result = TopNumber / BottomNumber;
                if (BottomNumber == 0) {
                    resultTextBottom.setText("Err!");  //dzielenie przez zero!!!
                } else {
                    resultTextBottom.setText(Double.toString(result));
                }
                break;

            case 5://mod
                result = TopNumber % BottomNumber;
                resultTextBottom.setText(Double.toString(result));
                break;

            case 6://square
                result = Math.pow(TopNumber, 2);
                resultTextBottom.setText(Double.toString(result));
                break;

            case 7://cube
                result = Math.pow(TopNumber, 3);
                resultTextBottom.setText(Double.toString(result));
                break;

            case 8://sqrt
                result = Math.sqrt(TopNumber);
                resultTextBottom.setText(Double.toString(result));
                break;

            case 9://log
                result = Math.log10(TopNumber);
                resultTextBottom.setText(Double.toString(result));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonZero = findViewById(R.id.buttonZero);
        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonDot = findViewById(R.id.buttonDot);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonMod = findViewById(R.id.buttonMod);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonX = findViewById(R.id.buttonX);
        buttonAC = findViewById(R.id.buttonAC);
        buttonC = findViewById(R.id.buttonC);
        buttonDivide = findViewById(R.id.buttonDivide);
        resultTextBottom = findViewById(R.id.textViewResult);
        resultTextTop = findViewById(R.id.textViewResult2);
        buttonLog = findViewById(R.id.buttonLog);
        buttonFact = findViewById(R.id.buttonFact);
        buttonSqrt = findViewById(R.id.buttonSqrt);
        buttonCube = findViewById(R.id.buttonCube);
        buttonSquare = findViewById(R.id.buttonSquare);
        portraitButtons();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            landscapeButtons();// jesli landscape to doladuj przyciski landscape
        }
    }

    private void portraitButtons() {

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAndSetNumberInput(v);
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation = 1;
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "+");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    resultTextBottom.setText("");
                }
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation = 2;
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0 && resultTextBottom.getText() != "-") {
                    resultTextTop.setText(resultTextBottom.getText() + "-");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    resultTextBottom.setText("");
                } else {
                    resultTextBottom.setText("-");
                }
            }
        });

        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 3;
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "x");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    resultTextBottom.setText("");
                } else {
                    //pusty string
                }
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 4;
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "/");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    resultTextBottom.setText("");
                } else {
                    //pusty string
                }
            }
        });

        buttonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation = 5;
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "%");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    resultTextBottom.setText("");
                } else {
                    //pusty string
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                int number = length - 1; //z ktorego miejsca stringa usunac (numeracja od 0)
                String temp;
                if (length > 0) {
                    StringBuilder del = new StringBuilder(resultTextBottom.getText());
                    del.deleteCharAt(number);//usun znak na ostatnim miejscu
                    temp = del.toString();//zmiana stringbuilder na string
                    resultTextBottom.setText(temp);
                } else {
                    OperationTemp = 0;
                    Operation = 0;
                }
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTextBottom.setText("");
                resultTextTop.setText("");
                Operation = 0;
                OperationTemp = 0;
                TopNumber = 0;
                result = 0;
                BottomNumber = 0;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                boolean isDot = false;
                if (length > 0) {
                    String inputToCheck = (String) resultTextBottom.getText();
                    for (int i = 0; i < inputToCheck.length(); i++) {
                        if (inputToCheck.contains(".")) {
                            isDot = true;
                            break;
                        }
                    }
                    if (isDot == false) {
                        resultTextBottom.setText(resultTextBottom.getText() + ".");// TODO append nie działa :(
                    }
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku

                if (OperationTemp == 0) {//jesli działanie na dodatnich
                    if (length > 0) {
                        resultTextTop.setText("");
                        BottomNumber = Double.parseDouble((String) resultTextBottom.getText());
                        calculate(Operation);
                    } else {
                        ///ousty string
                    }
                } else {//jesli działanie na ujemnych
                    Operation = OperationTemp;
                    resultTextTop.setText("");
                    BottomNumber = Double.parseDouble((String) resultTextBottom.getText());
                    calculate(Operation);
                    OperationTemp = 0;
                }
            }
        });

    }

    private void landscapeButtons() {
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 9;
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    resultTextTop.setText("log10(" + resultTextBottom.getText() + ")");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    calculate(OperationTemp);
                } else {
                    //pusty string
                }
            }
        });

        buttonFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 8;
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    resultTextTop.setText("sqrt(" + resultTextBottom.getText() + ")");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    calculate(OperationTemp);
                } else {
                    //pusty string
                }
            }
        });

        buttonCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 6;
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "^2");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    calculate(OperationTemp);
                } else {
                    //pusty string
                }
            }
        });

        buttonCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 7;
                int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
                if (length > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "^3");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    calculate(OperationTemp);
                } else {
                    //pusty string
                }
            }
        });

    }
}

