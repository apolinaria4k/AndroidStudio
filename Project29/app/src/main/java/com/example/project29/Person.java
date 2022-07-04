package com.example.project29;

public class Person {
    String name;
    int age;
    Sex sex;
    Status status;
    public Person(String _name, int _age, Sex _sex, Status _status){
        name = _name;
        age = _age;
        sex = _sex;
        status = _status;
    }
    public String toString(){
        return name +
                " | " + age+
                " | " + sex +
                " | " + status;
    }
}
