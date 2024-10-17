package com.github.Franfuu.model.entity;



public class User {
private String Name;
private String Surname;
private String Email;
private int ID;
private String Password;

    public User(String name, String surname, String email, int ID, String password) {
        Name = name;
        Surname = surname;
        Email = email;
        this.ID = ID;
        Password = password;
    }

    public User() {
    }

    // GETTERS
    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getEmail() {
        return Email;
    }

    public int getID() {
        return ID;
    }

    public String getPassword() {
        return Password;
    }

    // SETTERS
    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Email='" + Email + '\'' +
                ", ID=" + ID +
                ", Password='" + Password + '\'' +
                '}';
    }
}
