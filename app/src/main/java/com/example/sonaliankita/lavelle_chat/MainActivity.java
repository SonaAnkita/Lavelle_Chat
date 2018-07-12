package com.example.sonaliankita.lavelle_chat;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sonaliankita.lavelle_chat.Adapter.CustomAdapter;
import com.example.sonaliankita.lavelle_chat.Helper.HttpDataHandler;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    List<ChatMode> list_chat= new ArrayList<>();
    FloatingActionButton btn_send_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_of_message);
        editText= (EditText)findViewById(R.id.user_message);
        btn_send_message= (FloatingActionButton)findViewById(R.id.fab);

        btn_send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text= editText.getText().toString();
                ChatMode mode = new ChatMode(text,true); //user_send_message
                list_chat.add(mode);
                new SimsimiAPI().execute(list_chat);

                //remove user message

                editText.setText("");
            }
        });

    }

    private class SimsimiAPI extends AsyncTask<List<ChatMode>,Void,String> {
        String stream = null;
        List<ChatMode> modes;
        String text = editText.getText().toString();

        @Override
        protected String doInBackground(List<ChatMode>[] lists) {
            String url = String.format("http://sandbox.api.simsimi.com/request.p?key=%s&lc=en&ft=l.0&text=%s","9ccfb3bb-9e19-4139-a8e9-e29105fe06f9",getString(R.string.simsimi_api),text);
            List<ChatMode>[] params = new List[0];
            modes= params[0];
            HttpDataHandler httpDataHandler= new HttpDataHandler();
            stream= httpDataHandler.GetHttpDataHandler(url);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            Simsimimode response = gson.fromJson(s,Simsimimode.class);
            ChatMode chatMode = new ChatMode(response.getResponse(),false);
            modes.add(chatMode);
            CustomAdapter adapter = new CustomAdapter(modes,getApplicationContext());
            listView.setAdapter(adapter);
        }
    }
}
