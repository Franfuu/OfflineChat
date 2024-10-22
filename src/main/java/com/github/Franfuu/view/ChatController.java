package com.github.Franfuu.view;

import com.github.Franfuu.App;
import com.github.Franfuu.model.entity.Message;
import com.github.Franfuu.model.entity.MessageList;
import com.github.Franfuu.model.entity.User;
import com.github.Franfuu.model.utils.XMLManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ChatController extends Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField messageField;
    @FXML
    private VBox messageContainer;

    private static MessageList messageList = new MessageList();
    private User currentUser;

    @Override
    public void onOpen(Object input) throws Exception {
        // Initialize current user
        this.currentUser = new User("aaaa", "aaa", "aa@example.com", "aaaaa");
    }

    @Override
    public void onClose(Object output) {
        // Save messages to XML when closing
        XMLManager.writeXML(messageList, "Messages.xml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization logic if needed
    }

    @FXML
    private void handleSendMessage() {
        String content = messageField.getText();
        if (!content.isEmpty()) {
            Message message = new Message(currentUser, null, content, 0, LocalDate.now(), LocalTime.now());
            messageList.addMessage(message);
            messageContainer.getChildren().add(new Label(message.toString()));
            messageField.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Mensaje vacio", "Rellena el texto del mensaje, pedazo subnormal");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void goToChatRoom(ActionEvent actionEvent) {
        try {
            App.currentController.changeScene(Scenes.CHATROOM, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}