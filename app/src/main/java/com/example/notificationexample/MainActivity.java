package com.example.notificationexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String channel_id="Notification Channel";
    public static final String channel_name="Notification Channel";
    public static final String channel_desc="Simple Notification";
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel nc=new NotificationChannel(channel_id,channel_name, NotificationManager.IMPORTANCE_DEFAULT);
            nc.setDescription(channel_id);
            NotificationManager nm=getSystemService(NotificationManager.class);
            nm.createNotificationChannel(nc);
        }
        findViewById(R.id.NotifyButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displaynotifs();
                    }
                }
        );

        notificationManager = NotificationManagerCompat.from(this);


    }
    public void displaynotifs(){

        Notification notifbuilder= new NotificationCompat.Builder(this,channel_id)
                .setSmallIcon(R.drawable.ic_mms_black_24dp)
                .setContentTitle("Sample")
                .setContentText("Hello")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(3,notifbuilder);
    }


}
