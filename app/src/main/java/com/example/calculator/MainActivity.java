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
    Button buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonDot, buttonEquals, buttonMod, buttonPlus, buttonMinus, buttonX, buttonAC, buttonC, buttonDivide, buttonLog, buttonFact, buttonSqrt, buttonSquare, buttonCube;

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("topResult", resultTextTop.getText().toString());
        outState.putString("bottomResult", resultTextBottom.getText().toString());
        outState.putInt("operation", Operation);
        outState.putInt("operationTemp", OperationTemp);
        outState.putDouble("topNumber", TopNumber);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        resultTextTop.setText(savedInstanceState.getString("topResult"));
        resultTextBottom.setText(savedInstanceState.getString("bottomResult"));
        Operation = savedInstanceState.getInt("operation");
        OperationTemp = savedInstanceState.getInt("operationTemp");
        TopNumber = savedInstanceState.getDouble("topNumber");
    }

    public void getAndSetNumberInput(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        resultTextBottom.setText(resultTextBottom.getText() + buttonText);
    }

    public int getBottomResultLength() {
        int length = resultTextBottom.getText().length(); //dlugosc aktualnie wpisanego tekstu w oknie wyniku
        return length;
    }

    void calculate(int x) {
        switch (x) {//dzialania po kliknieciu =
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
                    resultTextBottom.setText("0");  //dzielenie przez zero!!!
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

            case 10://fact
                double result = 1;
                TopNumber = Math.round(TopNumber);
                if (TopNumber < 0) {//tylko na dodatnich
                    TopNumber = TopNumber * (-1);
                }
                while (TopNumber > 0) {
                    result = result * TopNumber;
                    TopNumber--;
                }
                resultTextBottom.setText(Double.toString(result));
                break;
        }
    }

    void bottomToTop() {
        TopNumber = Double.parseDouble((String) resultTextBottom.getText());
        resultTextBottom.setText("");
    }

    @Override // ladowanie przyciskow
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
        resultTextBottom = findViewById(R.id.textViewResultBottom);
        resultTextTop = findViewById(R.id.textViewResultTop);
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
                if (getBottomResultLength() > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "+");
                    bottomToTop();
                }
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation = 2;
                if (getBottomResultLength() > 0 && resultTextBottom.getText() != "-") {
                    resultTextTop.setText(resultTextBottom.getText() + "-");
                    bottomToTop();
                } else {
                    resultTextBottom.setText("-");
                }
            }
        });

        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 3;
                if (getBottomResultLength() > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "x");
                    bottomToTop();
                }
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 4;
                if (getBottomResultLength() > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "/");
                    bottomToTop();
                }
            }
        });

        buttonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operation = 5;
                if (getBottomResultLength() > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "%");
                    bottomToTop();
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int indexNumberToDelete = getBottomResultLength() - 1; //z ktorego miejsca stringa usunac (numeracja od 0)
                if (getBottomResultLength() > 0) {
                    StringBuilder deleter = new StringBuilder(resultTextBottom.getText());
                    deleter.deleteCharAt(indexNumberToDelete);//usun znak na ostatnim miejscu
                    resultTextBottom.setText(deleter.toString());
                } else {
                    OperationTemp = 0;
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
                BottomNumber = 0;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDot = false;
                if (getBottomResultLength() > 0) {
                    String inputToCheck = (String) resultTextBottom.getText();
                    for (int i = 0; i < inputToCheck.length(); i++) {
                        if (inputToCheck.contains(".")) {
                            isDot = true;
                            break;
                        }
                    }
                    if (isDot == false) {
                        resultTextBottom.setText(resultTextBottom.getText() + ".");
                    }
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getBottomResultLength() > 0 && resultTextTop.length() > 0) {
                    if (OperationTemp != 0) {//jesli dzia??anie na ujemnych
                        Operation = OperationTemp;
                    }
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
                if (getBottomResultLength() > 0) {
                    resultTextTop.setText("log10(" + resultTextBottom.getText() + ")");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    calculate(OperationTemp);
                }
            }
        });

        buttonFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 10;
                if (getBottomResultLength() > 0) {

                    int tempTop = (int) Math.floor(Double.parseDouble((String) resultTextBottom.getText()));
                    resultTextTop.setText(tempTop + "!");
                    TopNumber = tempTop;
                    calculate(OperationTemp);
                }
            }
        });

        buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 8;
                if (getBottomResultLength() > 0) {
                    resultTextTop.setText("sqrt(" + resultTextBottom.getText() + ")");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    calculate(OperationTemp);
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
                if (getBottomResultLength() > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "^2");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    calculate(OperationTemp);
                }
            }
        });

        buttonCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationTemp = 7;
                if (getBottomResultLength() > 0) {
                    resultTextTop.setText(resultTextBottom.getText() + "^3");
                    TopNumber = Double.parseDouble((String) resultTextBottom.getText());
                    calculate(OperationTemp);
                }
            }
        });
    }
}