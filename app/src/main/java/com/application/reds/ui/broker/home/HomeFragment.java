package com.application.reds.ui.broker.home;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.application.reds.R;
import com.application.reds.ui.chat.ChatActivity;
import com.application.reds.ui.notification.NotificationActivity;
import com.application.reds.ui.transaction.TransactionProgressActivity;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView chat, transaction, notification;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_broker_home, container, false);

        bindViews();
        return view;
    }

    @Override
    public void onClick(View v){

    }

    public void seeAllMessage(View view){

    }

    private void bindViews( ){
        chat = view.findViewById(R.id.chat_all_home);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ChatActivity.class);
                startActivity(intent);
            }
        });

        transaction = view.findViewById(R.id.transaction_all_home);
        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TransactionProgressActivity.class);
                startActivity(intent);
            }
        });

        notification = view.findViewById(R.id.notification_all_home);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NotificationActivity.class);
                startActivity(intent);
            }
        });


    }

}
