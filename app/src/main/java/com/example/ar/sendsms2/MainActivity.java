package com.example.ar.sendsms2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int PERMISSIONS = 0;
    String phone, textmessage;
    RadioButton r1, r2, r3;
    Button send;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        send = (Button) findViewById(R.id.bt1);
        ed1 = (EditText) findViewById(R.id.ed1);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean rdi1 = r1.isChecked();
                boolean rdi2 = r2.isChecked();
                boolean rdi3 = r3.isChecked();
                textmessage = ed1.getText().toString();
                if (rdi1 == true && rdi2 == false && rdi3 == false) {
                    sendmessage1();
                } else if (rdi2 == true && rdi1 == false && rdi3 == false) {
                    sendmessage2();
                } else if (rdi3 == true && rdi1 == false && rdi2 == false) {
                    sendmessage3();
                } else {
                    Toast.makeText(getApplicationContext(), "Not Number ", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void sendmessage1() {

        phone = r1.getText().toString();
        textmessage = ed1.getText().toString();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSIONS);
            }
        }
    }

    public void sendmessage2() {
        textmessage = ed1.getText().toString();
        phone = r2.getText().toString();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSIONS);
            }
        }
    }

    public void sendmessage3() {
        textmessage = ed1.getText().toString();
        phone = r3.getText().toString();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSIONS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCodem, String permissions[], int[] grantResults) {
        switch (requestCodem) {
            case PERMISSIONS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManger = SmsManager.getDefault();
                    smsManger.sendTextMessage(phone, null, textmessage, null, null);
                    Toast.makeText(getApplicationContext(), "Sms sent", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sms faild,Plese try agin", Toast.LENGTH_LONG).show();
                    return;
                }
        }
    }
}
