package com.github.Franfuu.view;

public enum Scenes {
    WELCOME("view/Welcome.fxml"), //ELEGIR ROL
    MAINPAGE("view/mainPage.fxml"), //PAGINA PRINCIPAL
    ROOT("view/layout.fxml"); //PAGINA PRINCIPAL


    private final String url;

    Scenes(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}