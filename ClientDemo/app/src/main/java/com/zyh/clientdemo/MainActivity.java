package com.zyh.clientdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zyh.aidl.Person;
import com.zyh.serverdemo.IMyAidl;

public class MainActivity extends AppCompatActivity {

    private IMyAidl myAidl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = findViewById(R.id.tv);
        Button bt = findViewById(R.id.bt);

        Intent intent = new Intent("com.zyh.MyService");
        bindService(intent,conn,BIND_AUTO_CREATE);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person("AIDL");
                try {
                    myAidl.addPerson(person);
                    tv.setText(myAidl.getList().toString()+"\n sum = " +myAidl.sum(3,5));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


            }
        });



    }
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            myAidl = IMyAidl.Stub.asInterface(iBinder);

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            myAidl = null;
        }
    };
}
