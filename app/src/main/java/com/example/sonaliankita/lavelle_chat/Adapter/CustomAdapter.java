package com.example.sonaliankita.lavelle_chat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.sonaliankita.lavelle_chat.ChatMode;
import com.example.sonaliankita.lavelle_chat.R;
import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

/**
 * Created by Sonali Ankita on 11-07-2018.
 */

public class CustomAdapter extends BaseAdapter {


    private List<ChatMode> chatModeList;
    private Context context;
    private LayoutInflater layoutInflater;


    public CustomAdapter(List<ChatMode> chatModeList, Context context) {
        this.chatModeList = chatModeList;
        this.context = context;
        layoutInflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return chatModeList.size();
    }

    @Override
    public Object getItem(int position) {
        return chatModeList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null){
            if(chatModeList.get(position).isSend){
                view = layoutInflater.inflate(R.layout.list_item_message_send,null);
            }
            else {
                view= layoutInflater.inflate(R.layout.list_item_message_recv,null);
                BubbleTextView text_message= (BubbleTextView)view.findViewById(R.id.text_message);
                text_message.setText(chatModeList.get(position).message);
            }
            return view;
        }

        return null;
    }
}
