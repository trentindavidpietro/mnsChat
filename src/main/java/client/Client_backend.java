package client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Client_backend extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Label namelbl=new Label("Inserisci nome");
        TextField nameFld=new TextField();

        Label msg=new Label();
        msg.setStyle("-fx-text-fill: blue;");

        //creo i bottoni
        Button sayHelloBtn=new Button("Dì ciao");
        Button exitBtn=new Button("Exit");
        exitBtn.setOnAction(e-> Platform.exit());

        sayHelloBtn.setOnAction(e->
                {
                    String name=nameFld.getText();
                    if(name.trim().length()>0)
                    {
                        msg.setText("Ciao "+name);
                    }
                    else {
                        msg.setText("ciao");
                    }
                }

        );




        // Create a VBox node
        VBox root=new VBox();
        root.setSpacing(5);


        // Add the Text node to the VBox as a child node
        root.getChildren().addAll(namelbl,nameFld,msg,sayHelloBtn,exitBtn);

        // Create a scene
        //The following statement creates a scene with the VBox as the root node, with 300px
        //width and 50px height:
        Scene scene=new Scene(root,500,500);

        stage.setScene(scene);

        //titolo dello stage
        stage.setTitle("ciao");

        //mostro lo stage
        stage.show();
    }

}
