package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView tv;
private String input, answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
    }
    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data){
            case "AC":
                input = "";
                break;
            case "C":
                if (input.length()>0){
                    String newText = input.substring(0,input.length()-1);
                    input = newText;
                }
                break;
            case "=":
                Solve();
                answer = input;
                break;
            case "x":
                Solve();
                input+="*";
                break;
            default:
                if (input == null){
                    input="";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                    //in ket qua
                }
               input+=data;
        }
        tv.setText(input);
    }
    public void Solve(){
        if (input.split("\\*").length==2){
            String number[] = input.split("\\*");
            try {
                double tich = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input = tich+"";
            }catch (Exception e){

            }
        }
        if (input.split("\\/").length==2){
            String number[] = input.split("\\/");
            try {
                double thuong = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input = thuong+"";
            }catch (Exception e){

            }
        }
        if (input.split("\\+").length==2){
            String number[] = input.split("\\+");
            try {
                double tong = Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input = tong+"";
            }catch (Exception e){

            }
        }
        if (input.split("\\-").length==2){
            String number[] = input.split("\\-");
            try {
                double hieu = Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input = hieu+"";
            }catch (Exception e){

            }
        }
        String n[] = input.split("\\.");
        if (n.length>1){
            if (n[1].equals("0")){
                input = n[0];
            }
        }
    }
}