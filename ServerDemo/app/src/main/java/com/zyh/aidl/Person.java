package com.zyh.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable{
    private String mName;

    public Person(String mName) {
        this.mName = mName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
    }

    public void readFromParcel(Parcel in) {
        this.mName = in.readString();
    }

    protected Person(Parcel in) {
        this.mName = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
