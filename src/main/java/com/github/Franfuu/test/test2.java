package com.github.Franfuu.test;

import com.github.Franfuu.model.entity.User;
import com.github.Franfuu.model.entity.UserList;
import com.github.Franfuu.model.utils.XMLManager;

import java.util.ArrayList;
import java.util.List;


/*
*  NO FUNCIONA
*/
public class test2 {
    public static void main(String[] args) {
        User andrea = new User("Anadre", "Roldan", "ads@gmail.com", "asdasd");
        List<User> userList = new ArrayList<>();
        userList.add(andrea);

        UserList users = new UserList(userList);
        boolean success = XMLManager.writeXML(users, "UserData.xml");

        if (success) {
            System.out.println("Archivo XML generado correctamente.");
        } else {
            System.out.println("Error al generar el archivo XML.");
        }
    }
}
