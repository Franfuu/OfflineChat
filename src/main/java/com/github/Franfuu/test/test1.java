package com.github.Franfuu.test;

import com.github.Franfuu.model.entity.User;
import com.github.Franfuu.model.entity.UserList;
import com.github.Franfuu.model.utils.XMLManager;

import java.util.ArrayList;
import java.util.List;



import static com.github.Franfuu.model.utils.XMLManager.writeXML;

public class test1 {


    public static void main(String[] args) {
        // Crear usuarios
        User pepito = new User("Pepito", "grillo", "pepillo@pepillo", "1234");
        User teresa = new User("Teresa", "Espadas", "pepillo@pepillo", "9481");

        // Crear una lista de usuarios
        List<User> userList = new ArrayList<>();
        userList.add(pepito);
        userList.add(teresa);

        // Crear un contenedor de usuarios y guardarlo en XML
        UserList users = new UserList(userList);
        boolean success = XMLManager.writeXML(users, "UserData.xml");
        if (success) {
            System.out.println("Archivo XML generado correctamente.");
        } else {
            System.out.println("Error al generar el archivo XML.");
        }
    }

}
