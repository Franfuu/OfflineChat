package com.github.Franfuu.test;

import com.github.Franfuu.model.entity.Message;
import com.github.Franfuu.model.entity.MessageList_Singleton;
import com.github.Franfuu.model.entity.User;
import com.github.Franfuu.model.utils.XMLManager;
import com.github.Franfuu.view.WelcomeController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class testMessage {
    public static void main(String[] args) {
        User fran = new User("fran", "puto", "fran@gmail.com", "12345678");
        User andrea = new User("Anadre", "Roldan", "ads@gmail.com", "asdasd");
        String content = "Buenos dias";

        Message mensaje1 = new Message(fran, andrea, content, 1);
        XMLManager.writeXML(mensaje1, WelcomeController.messageXML);

        System.out.println(mensaje1);
        String content2 = "Cago en dios";

        Message mensaje2 = new Message(fran, andrea, content2, 2);
        //XMLManager.writeXML(mensaje2, WelcomeController.messageXML);

        ArrayList<Message> msgLS = new ArrayList<>();
        msgLS.add(mensaje1);
        msgLS.add(mensaje2);

        LocalTime time = LocalTime.now();
        System.out.println(time.format(DateTimeFormatter.ofPattern("HH-mm")));

        LocalDate date = LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        /*
        MessageList_Singleton msgST = MessageList_Singleton.getInstance();

        List<Message> LS = msgST.getMessages();
        System.out.println(LS);

        */
    }
}