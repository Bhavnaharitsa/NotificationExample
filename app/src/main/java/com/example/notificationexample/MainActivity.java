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
        CreateNotificationChannel();
       
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
    
    public void CreateNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    // Create the NotificationChannel
    val name = getString(R.string.channel_name)
    val descriptionText = getString(R.string.channel_description)
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
    mChannel.description = descriptionText
    // Register the channel with the system; you can't change the importance
    // or other notification behaviors after this
    val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(mChannel)
}

    }

}
