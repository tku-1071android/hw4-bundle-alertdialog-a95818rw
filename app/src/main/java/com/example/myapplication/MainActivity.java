package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etP, etDS, etA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etP = (EditText) findViewById(R.id.programming);
        etDS = (EditText) findViewById(R.id.dataStructure);
        etA = (EditText) findViewById(R.id.Algorithm);

    }

    private boolean isValid(EditText editText){

        String pattern = "1[0]{1}|[0-9]{1,2}";
        String text =editText.getText().toString();
        if(!text.matches(pattern)){
            editText.setError("0~100");
            return false;
        }
        else
            return true;

    }

    public void Submit(View view){

        boolean isValid = isValid(etP) & isValid(etDS) & isValid(etA);

        if(!isValid)
            return;

        int programming = Integer.parseInt(etP.getText().toString());
        int dataStructure = Integer.parseInt(etDS.getText().toString());
        int algorithm = Integer.parseInt(etA.getText().toString());

        Intent intent = new Intent();

        Bundle bundle = new Bundle();
        bundle.putInt("programming", programming);
        bundle.putInt("dataStructure", dataStructure);
        bundle.putInt("algorithm", algorithm);

        intent.putExtras(bundle);

        intent.setClass(MainActivity.this , Main2Activity.class);

        startActivity(intent);
    }

}
