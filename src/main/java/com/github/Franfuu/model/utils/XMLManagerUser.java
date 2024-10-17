package com.github.Franfuu.model.utils;
import com.github.Franfuu.model.entity.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLManagerUser {

    public static boolean writeXML(User u, String fileName) {
        boolean result = false;
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(u.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            m.marshal(u, new File(fileName));
            result = true;
        } catch (JAXBException e) {
            e.printStackTrace(); //mode development
        }
        return result;
    }

    public static User readXML(User u, String filename) {
        User result = u;
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(u.getClass());
            Unmarshaller um = context.createUnmarshaller();
            result = (User) um.unmarshal(new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }

}