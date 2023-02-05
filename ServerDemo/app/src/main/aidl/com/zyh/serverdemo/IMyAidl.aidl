// IMyAidl.aidl
package com.zyh.serverdemo;

// Declare any non-default types here with import statements
import com.zyh.aidl.Person;
interface IMyAidl {
    void addPerson(inout Person p);
    List<Person> getList();
    int sum(int a,int b);
}
