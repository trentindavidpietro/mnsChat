module mnsChat {
    requires javafx.fxml;
    requires javafx.controls;
    opens client to javafx.fxml;
    exports client;
}