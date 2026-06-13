package com.example.testexam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;
    private boolean lastStatus = false;
    private TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtStatus = findViewById(R.id.txtStatus);
        lastStatus = getInternetStatus(this);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                boolean currentStatus = getInternetStatus(context);

                if (currentStatus != lastStatus) {
                    String time = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss", Locale.getDefault())
                            .format(new Date());

                    String statusText;
                    if (currentStatus) {
                        statusText = "✅ اینترنت وصل شد";
                    } else {
                        statusText = "❌ اینترنت قطع شد";
                    }

                    txtStatus.setText(statusText + "\n" + time);

                    lastStatus = currentStatus;
                }
            }
        };

        registerReceiver(broadcastReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    public boolean getInternetStatus(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) return false;

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }
}
