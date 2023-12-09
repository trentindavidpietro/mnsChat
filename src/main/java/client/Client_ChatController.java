package client;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Client_ChatController {
    @FXML
    private VBox chatBox;

    @FXML
    private MFXTextField messageField;

    @FXML
    private MFXButton sendButton;

    @FXML
    public void initialize() {
        // Puoi inizializzare qui il controller, ad esempio aggiungere un'azione al pulsante "Send"
        sendButton.setOnAction(event -> sendMessage());
    }
private void receiveMessage(){
    String message = messageField.getText();
    if (!message.isEmpty()) {
        HBox messageContainer = new HBox();
        Label newMessage = new Label(message);

        newMessage.setWrapText(true);
        messageContainer.setStyle("-fx-pref-width: 100%");
        messageContainer.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        newMessage.getStyleClass().add("received-message");

        messageContainer.getChildren().add(newMessage);

        chatBox.getChildren().add(messageContainer);
        messageField.clear();
    }
}

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            Label newMessage = new Label(message);
            HBox messageContainer = new HBox();

            newMessage.setWrapText(true);
            newMessage.setMaxWidth(Double.MAX_VALUE);
            newMessage.getStyleClass().add("sent-message");

            messageContainer.setStyle("-fx-pref-width: 100%; "); // Adjust padding as needed
            messageContainer.setAlignment(javafx.geometry.Pos.CENTER_RIGHT); // Align to the right

            // Add a listener to the label's width property to dynamically adjust the container's height
            newMessage.widthProperty().addListener((observable, oldValue, newValue) -> {
                messageContainer.setMinHeight(computeTextHeight(new Text(message)));
                messageContainer.setPrefHeight(computeTextHeight(new Text(message)));
            });

            messageContainer.getChildren().add(newMessage);
            chatBox.getChildren().add(messageContainer);
            messageField.clear();
        }
    }

    // Method to compute the height of the text content in the label
    private double computeTextHeight(Text text) {
        double width = text.getWrappingWidth();
        double textHeight = text.getLayoutBounds().getHeight();
        double lines = Math.ceil(textHeight / (width == 0 ? 1 : width)); // Calculate number of lines
        double lineHeight = text.getFont().getSize(); // Get line height
        return lines * lineHeight; // Return total height
    }

    // Potresti aggiungere altri metodi per gestire ulteriori azioni nella chat
}