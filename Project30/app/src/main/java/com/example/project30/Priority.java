package com.example.project30;

import java.io.Serializable;

public enum Priority implements Serializable {
    High,
    Medium,
    Low;
    public static com.example.project30.Priority valueOf(int ordinal){
        for (com.example.project30.Priority item:values()){
            if(item.ordinal() == ordinal){
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}
