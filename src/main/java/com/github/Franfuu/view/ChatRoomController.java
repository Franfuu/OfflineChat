package com.github.Franfuu.view;

import com.github.Franfuu.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatRoomController extends Controller implements Initializable {

    @Override
    public void onOpen(Object input) throws Exception {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void goToChat(ActionEvent actionEvent) {
        try {
            App.currentController.changeScene(Scenes.CHAT, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
