package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvResult = (TextView) findViewById(R.id.tvR);
        show();

    }

    private  void show(){

        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int programming = bundle.getInt("programming");
        int dataStruct = bundle.getInt("dataStruct");
        int algorithm = bundle.getInt("algorithm");
        int sum = programming + dataStruct + algorithm;
        double average = sum / 3.0;
        String text = "programming =" + programming + "\ndataStruct =" + dataStruct + "algorithm ="
                + algorithm + "\nsum = " + sum +"\naverage" + nf.format(average);

        tvResult.setText(text);
        alert(average);

    }

    public void alert(double average){

        String message = new String();
        String title = new String();
        int pic = 0;

        if (average == 100){
            message = "100";
            title = "Pass";
            pic = R.drawable.circle;
        }

        else if (average >= 60){
            message = "Congratulation";
            title = "Pass";
            pic = R.drawable.circle;

        }

        else{
            message = "0.0";
            title = "88";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setIcon(pic);
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel",null);
        builder.setNeutralButton("Nothing",null);
        builder.show();

    }

    public void Back(View view){
        Intent intent = new Intent();
        intent.setClass(Main2Activity.this , MainActivity.class);
        startActivity(intent);
    }

}
