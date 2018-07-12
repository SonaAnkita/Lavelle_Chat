package com.example.sonaliankita.lavelle_chat;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class Main3Activity extends AppCompatActivity {

    TextToSpeech t1;
    EditText editText;
    Button button;
    Button getButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
            button = (Button)findViewById(R.id.button3);

            editText = (EditText) findViewById(R.id.editText);
            t1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i != TextToSpeech.ERROR) {
                        t1.setLanguage(Locale.ENGLISH);


                    }

                }
            });

            getButton= (Button)findViewById(R.id.button4);
            getButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                    startActivity(intent);
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String string= editText.getText().toString();
                    t1.speak(string,TextToSpeech.QUEUE_FLUSH,null);



                }
            });

        }
    public  void  onParse(){
        if(t1!= null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }

}

