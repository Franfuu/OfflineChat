package com.github.Franfuu.test;

import com.github.Franfuu.model.entity.UserList_Singleton;

public class testSingleTon {
    public static void main(String[] args) {
        UserList_Singleton usrLS = UserList_Singleton.getInstance();
        System.out.println(usrLS);
    }
}
