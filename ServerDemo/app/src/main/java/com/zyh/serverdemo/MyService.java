package com.zyh.serverdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.zyh.aidl.Person;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    private ArrayList<Person> mPersons;


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        mPersons = new ArrayList<Person>();
        return stub;
    }

    IMyAidl.Stub stub = new IMyAidl.Stub() { //具体实现
        @Override
        public void addPerson(Person p) throws RemoteException {
            p.setmName("改变后的名字");
            mPersons.add(p);
        }

        @Override
        public List<Person> getList() throws RemoteException {
            return mPersons;
        }

        @Override
        public int sum(int a, int b) throws RemoteException {
            return a+b;
        }
    };
}
