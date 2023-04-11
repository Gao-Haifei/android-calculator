package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView input, btn_ac, btn_clear, btn_backward, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9,
            btn_plus, btn_minus, btn_times, btn_divide, btn_dot, btn_equal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


        btn_ac.setOnClickListener(new SetOnClickListen());
        btn_clear.setOnClickListener(new SetOnClickListen());
        btn_backward.setOnClickListener(new SetOnClickListen());

        btn_0.setOnClickListener(new SetOnClick());
        btn_1.setOnClickListener(new SetOnClick());
        btn_2.setOnClickListener(new SetOnClick());
        btn_3.setOnClickListener(new SetOnClick());
        btn_4.setOnClickListener(new SetOnClick());
        btn_5.setOnClickListener(new SetOnClick());
        btn_6.setOnClickListener(new SetOnClick());
        btn_7.setOnClickListener(new SetOnClick());
        btn_8.setOnClickListener(new SetOnClick());
        btn_9.setOnClickListener(new SetOnClick());

        btn_plus.setOnClickListener(new SetOnClick());
        btn_minus.setOnClickListener(new SetOnClick());
        btn_times.setOnClickListener(new SetOnClick());
        btn_divide.setOnClickListener(new SetOnClick());
        btn_dot.setOnClickListener(new SetOnClick());
        btn_equal.setOnClickListener(new SetOnClick());
    }

    char op = ' ';
    Double a=0d, b=0d;

    private class SetOnClick implements View.OnClickListener {

        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {
            String res = input.getText().toString();


            switch (view.getId()) {
                case R.id.btn_0:
                    if (!input.getText().toString().equals("") && !input.getText().toString().equals("0")) {
                        int i = input.getText().length();
                        if (input.getText().charAt(i - 1) != op) {
                            input.setText(res + "0");
                        }
                    }
                    break;
                case R.id.btn_1:
                    if (input.getText().equals("0")) {
                        input.setText("1");
                    } else {
                        input.setText(res + "1");
                    }

                    break;
                case R.id.btn_2:
                    if (input.getText().equals("0")) {
                        input.setText("2");
                    } else {
                        input.setText(res + "2");
                    }

                    break;
                case R.id.btn_3:
                    if (input.getText().equals("0")) {
                        input.setText("3");
                    } else {
                        input.setText(res + "3");
                    }
                    break;
                case R.id.btn_4:
                    if (input.getText().equals("0")) {
                        input.setText("4");
                    } else {
                        input.setText(res + "4");
                    }
                    break;
                case R.id.btn_5:
                    if (input.getText().equals("0")) {
                        input.setText("5");
                    } else {
                        input.setText(res + "5");
                    }
                    break;
                case R.id.btn_6:
                    if (input.getText().equals("0")) {
                        input.setText("2");
                    } else {
                        input.setText(res + "6");
                    }
                    break;
                case R.id.btn_7:
                    if (input.getText().equals("0")) {
                        input.setText("7");
                    } else {
                        input.setText(res + "7");
                    }
                    break;
                case R.id.btn_8:
                    if (input.getText().equals("0")) {
                        input.setText("8");
                    } else {
                        input.setText(res + "8");
                    }
                    break;
                case R.id.btn_9:
                    if (input.getText().equals("0")) {
                        input.setText("9");
                    } else {
                        input.setText(res + "9");
                    }
                    break;
                case R.id.btn_dot:
                    int i = res.length();
                    if (i != 0) {
                        if (res.charAt(i - 1) != '.' && res.charAt(i - 1) != op ) {
                            if (a == 0d){
                                int ii = res.length()-1;
                                String s = res.substring(0,ii);
                                if (!s.contains(String.valueOf('.'))){
                                    input.setText(res + ".");
                                }
                            }
                            else {
                                int ii = res.indexOf(op);
                                String s = res.substring(ii);
                                if (!s.contains(String.valueOf('.'))){
                                    input.setText(res+".");
                                }
                            }

                        }
                    }
                    break;


                case R.id.btn_plus:

                    if (!res.equals("")) {
                        if (op == ' ') {
                            a = Double.parseDouble(res);
                            op = '+';
                            input.setText(res + op);
                        }
                        else {
                            String s;
                            int size = input.getText().length();
                            if (res.charAt(size-1) != op){
                                if (op == '÷' || op == '-') {
                                    s = res.split(String.valueOf(op))[1];
                                } else {
                                    s = res.split("\\" + op)[1];
                                }
                                if (!s.equals("")) {
                                    b = Double.parseDouble(s);
                                    String ss = String.valueOf(Calculator.calculate(a, b, op));
                                    input.setText(ss+'+');
                                    a = Double.parseDouble(ss);
                                    b = 0d;
                                    op = '+';
                                }
                            }


                        }
                    }

                    break;
                case R.id.btn_minus:
                    if (!res.equals("")) {

                        if (op == ' ') {
                            a = Double.parseDouble(res);
                            op = '-';
                            input.setText(res + op);
                        }else {
                            String s;
                            int size = input.getText().length();
                            if (res.charAt(size-1) != op){
                                if (op == '÷' || op == '-') {
                                    s = res.split(String.valueOf(op))[1];
                                } else {
                                    s = res.split(String.valueOf("\\" + op))[1];
                                }
                                if (!s.equals("")) {
                                    b = Double.parseDouble(s);
                                    String ss = String.valueOf(Calculator.calculate(a, b, op));
                                    input.setText(ss+'-');
                                    a = Double.parseDouble(ss);
                                    b = 0d;
                                    op = '-';
                                }
                            }

                        }
                    }

                    break;
                case R.id.btn_times:
                    if (!res.equals("")) {
                        if (op == ' ') {
                            a = Double.parseDouble(res);
                            op = '*';
                            input.setText(res + op);
                        }else {
                            String s;
                            int size = input.getText().length();
                            if (res.charAt(size-1) != op){
                                if (op == '÷' || op == '-') {
                                    s = res.split(String.valueOf(op))[1];
                                } else {
                                    s = res.split(String.valueOf("\\" + op))[1];
                                }
                                if (!s.equals("")) {
                                    b = Double.parseDouble(s);
                                    String ss = String.valueOf(Calculator.calculate(a, b, op));
                                    input.setText(ss+'*');
                                    a = Double.parseDouble(ss);
                                    b = 0d;
                                    op = '*';
                                }
                            }

                        }
                    }

                    break;
                case R.id.btn_divide:
                    if (!res.equals("")) {
                        if (op == ' ') {
                            a = Double.parseDouble(res);
                            op = '÷';
                            input.setText(res + op);
                        }
                        else {
                            String s;
                            int size = input.getText().length();
                            if (res.charAt(size-1) != op){
                                if (op == '÷' || op == '-') {
                                    s = res.split(String.valueOf(op))[1];
                                } else {
                                    s = res.split("\\" + op)[1];
                                }
                                if (!s.equals("")) {
                                    b = Double.parseDouble(s);
                                    String ss = String.valueOf(Calculator.calculate(a, b, op));
                                    input.setText(ss+'÷');
                                    a = Double.parseDouble(ss);
                                    b = 0d;
                                    op = '÷';
                                }
                            }

                        }
                    }
                    break;

                case R.id.btn_equal:
                    int size = res.length();
                    if (size == 0) {
                        return;
                    }
                    if (res.charAt(size - 1) != op) {
                        if (!res.equals("") && op != ' ' && a != 0d) {
                            System.out.println(res);
                            String s;
                            if (op == '÷' || op == '-') {
                                s = res.split(String.valueOf(op))[1];
                            } else {
                                s = res.split("\\" + op)[1];
                            }

                            if (!s.equals("")) {
                                b = Double.parseDouble(s);
                                String ss = String.valueOf(Calculator.calculate(a, b, op));
                                input.setText(ss);
                                a = 0d;
                                b = 0d;
                                op = ' ';
                            }


                        }


                    }
            }
        }
    }


    private class SetOnClickListen implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String res = input.getText().toString();
            switch (view.getId()) {
                case R.id.btn_ac:
                    input.setText("");
                    op = ' ';
                    a = 0d;
                    b = 0d;
                    Toast.makeText(MainActivity.this, "清空完成", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_backward:
                    if (!res.equals("")) {
                        res = res.substring(0, res.length() - 1);

                        for (int i = 0; i < res.length(); i++) {
                            if (res.charAt(i) == '+' || res.charAt(i) == '-' || res.charAt(i) == '*' ||  res.charAt(i) == '÷'){
                                op = res.charAt(i);
                            }
                        }
                        input.setText(res);
                    }

                    break;
                case R.id.btn_clear:
                    input.setText("0");
                    op = ' ';
                    a = 0d;
                    b = 0d;
                    break;
            }
        }
    }


    private void initView() {
        input = findViewById(R.id.input);
        btn_ac = findViewById(R.id.btn_ac);
        btn_clear = findViewById(R.id.btn_clear);
        btn_backward = findViewById(R.id.btn_backward);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_times = findViewById(R.id.btn_times);
        btn_divide = findViewById(R.id.btn_divide);
        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
    }


}