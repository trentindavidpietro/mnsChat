package client;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            // Esempio: aggiungere il messaggio alla finestra di chat
            Label newMessage = new Label(message);
            chatBox.getChildren().add(newMessage);
            messageField.clear(); // Cancella il campo di testo dopo l'invio del messaggio
        }
    }
    // Potresti aggiungere altri metodi per gestire ulteriori azioni nella chat
}