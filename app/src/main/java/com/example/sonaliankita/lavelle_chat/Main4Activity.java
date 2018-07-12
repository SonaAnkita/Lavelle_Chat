package com.example.sonaliankita.lavelle_chat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Main4Activity extends AppCompatActivity {

    Button button;
    ImageButton imageButton;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        button=(Button)findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main4Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        imageButton= (ImageButton)findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()== R.id.imageButton2){
                    resultText= (TextView)findViewById(R.id.Tv);
                    promptSpeechInput();
                }
            }

        });}

    public void promptSpeechInput(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"say something");
        try {
            startActivityForResult(intent,100);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(Main4Activity.this,"Sorry! Your Device does not support the language!",Toast.LENGTH_LONG).show();
        }
    }

    public  void  onActivityResult(int request_code, int result_code,Intent intent){
        super.onActivityResult(request_code,result_code,intent);
        switch (request_code){
            case 100: if(result_code==RESULT_OK && intent!=null){
                ArrayList<String> result = intent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                resultText.setText(result.get(0));
            }
                break;
        }

    }

}
