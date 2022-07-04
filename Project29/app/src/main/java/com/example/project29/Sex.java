package com.example.project29;

public enum Sex {
    Male,
    Female;
    public static Sex valueOf(int ordinal){
        for(Sex item:values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}
