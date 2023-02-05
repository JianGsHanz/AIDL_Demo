# AIDL_Demo
首先AIDL传对象<br>

1.创建bean，实现Parcelable<br>
2.app/main/aidl相同目录下创建同名aidl文件<br>
例如：<br>
package com.zyh.aidl;<br>
//下面这段很重要<br>
parcelable Person;<br>
//interface Person {<br>
//<br>
//}<br>
<br>

interface IMyAidl {<br>
    void addPerson(inout Person p);<br>
    List<Person> getList();<br>
    int sum(int a,int b);<br>
}<br>

3.定向TAG

- inout：服务端修改数据，会同步到客户端，因此可以说数据是双向流动的
- in：数据只从客户端流向服务端，服务端修改数据不会影响客户端
- out：数据只能由服务端传向客户端，及时客户端传入一个对象，这个对象也是空的，即没有数据，服务端获取该对象后，对该对象任何操作都会同步到客户端这里

**Exception**


- serverdemo\IMyAidl.java:146: ����: �Ҳ�������
            p.readFromParcel(_reply);

    bean默认并不会实现readFromParcel(Parcel in)方法，本身也不会有问题，但是当用到 out inout 时，aidl服务端会调用readFromParcel(Parcel in)方法，这时候就需要实现readFromParcel(Parcel in)方法了。


- Process 'command 'D:\Studio\SDK\build-tools\27.0.3\aidl.exe'' finished with non-zero exit value 1<br>
    出现此错误是由于AIDL自定义方法参数是（序列化）对象。<br>
    检查<br>
     1.（序列化）对象的包是否相同（app/main/aidl下与app/main/自定义目录）<br>
     2.aidl文件导包路径是否正确
