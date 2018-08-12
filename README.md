# AIDL_Demo
首先AIDL传对象
1.创建bean，实现Parcelable
2.app/main/aidl相同目录下创建同名aidl文件
例如：
package com.zyh.aidl;

parcelable Person;
//interface Person {
//
//}

Process 'command 'D:\Studio\SDK\build-tools\27.0.3\aidl.exe'' finished with non-zero exit value 1
出现此错误是由于AIDL自定义方法参数是（序列化）对象。
检查
1.（序列化）对象的包是否相同（app/main/aidl下与app/main/自定义目录）
2.aidl文件导包路径是否正确
