package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

     EditText edtNumber1 ;
     EditText edtNumber2 ;
     TextView txtResult1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber1 = findViewById(R.id.number1);
        edtNumber2 = findViewById(R.id.number2);
        txtResult1 = findViewById(R.id.txtResult);

    }
    public void compute(View v){
        String firstInputAsText =edtNumber1.getText().toString();
        String secondInputAsText =edtNumber2.getText().toString();
        double firstNumber=0;
        double secondNumber=0;
        double resultAsNumber=0;

        //validate input
        if(!firstInputAsText.isEmpty() && !secondInputAsText.isEmpty())
        {
            firstNumber = Double.parseDouble(firstInputAsText);
            secondNumber = Double.parseDouble(secondInputAsText);
        }


        //get tag
        String operation= v.getTag().toString();

        if(operation.equals("add"))
        {
            resultAsNumber=firstNumber+secondNumber;
        }
        else if (operation.equals("mul"))
        {
            resultAsNumber=firstNumber*secondNumber;
        }
        else if (operation.equals("div"))
        {
            resultAsNumber=firstNumber/secondNumber;
        }
        else if (operation.equals("mod"))
        {
            resultAsNumber=firstNumber%secondNumber;
        }
        else if (operation.equals("expo"))
        {
            resultAsNumber=Math.pow(firstNumber,secondNumber) ;
        }
        else if (operation.equals("sub"))
        {
            resultAsNumber=firstNumber-secondNumber;
        }


        //decimal format
        DecimalFormat formatter=new DecimalFormat("#,###.##");


        //return result
        String resultAsText=formatter.format(resultAsNumber);
        txtResult1.setText(resultAsText);

    }
}