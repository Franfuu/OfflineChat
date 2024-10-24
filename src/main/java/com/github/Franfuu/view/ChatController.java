package com.github.Franfuu.view;

import com.github.Franfuu.App;
import com.github.Franfuu.model.entity.Message;
import com.github.Franfuu.model.entity.MessageList;
import com.github.Franfuu.model.entity.User;
import com.github.Franfuu.model.utils.XMLManager;
import com.github.Franfuu.view.LoginController;
import com.github.Franfuu.view.WelcomeController;
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
import java.util.Objects;
import java.util.ResourceBundle;

import static com.github.Franfuu.App.scene;

public class ChatController extends Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField messageField;
    @FXML
    private VBox messageContainer;

    private static MessageList messageList = new MessageList();
    private User currentUser;
    private User selectedContact;

    @Override
    public void onOpen(Object input) throws Exception {
        // Initialize current user and selected contact
        this.currentUser = LoginController.Sender;
        this.selectedContact = (User) new User("Anadre", "Roldan", "ads@gmail.com", "asdasd");
        // Load messages from XML
        messageList = XMLManager.readXML(new MessageList(), WelcomeController.messageXML);
        displayMessages();
    }

    @Override
    public void onClose(Object output) {
        // Save messages to XML when closing
        XMLManager.writeXML(messageList, WelcomeController.messageXML);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization logic if needed
    }

    @FXML
    private void handleSendMessage() {
        String content = messageField.getText();
        if (!content.isEmpty()) {
            Message message = new Message(currentUser, selectedContact, content, 0);
            messageList.addMessage(message);
            addMessageToContainer(message);
            messageField.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Mensaje vacio", "Rellena el texto del mensaje.");
        }
    }

    private void displayMessages() {
        messageContainer.getChildren().clear();
        for (Message message : messageList.getMessages()) {
            if (message.getSender().equals(currentUser) && message.getRecipient().equals(selectedContact) ||
                    message.getSender().equals(selectedContact) && message.getRecipient().equals(currentUser)) {
                addMessageToContainer(message);
            }
        }
    }

    private void addMessageToContainer(Message message) {
        Label messageLabel = new Label(message.toString());
        VBox messageBox = new VBox(messageLabel);
        if (message.getSender().equals(currentUser)) {
            messageBox.getStyleClass().add("message-right");
        } else {
            messageBox.getStyleClass().add("message-left");
        }
        messageContainer.getChildren().add(messageBox);
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