module mnsChat {
    requires javafx.fxml;
    requires javafx.controls;
    requires MaterialFX;
    opens client to javafx.fxml;
    exports client;
}