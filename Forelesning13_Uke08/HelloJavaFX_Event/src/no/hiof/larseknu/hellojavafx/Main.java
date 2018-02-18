package no.hiof.larseknu.hellojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{

    private int teller = 0;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Min første JavaFX applikasjon");

        Label etTekstFelt = new Label();
        etTekstFelt.setFont(Font.font("Calibri", 24));
        etTekstFelt.setText("Hællæ JavaFX");

        Button enKnapp = new Button();
        enKnapp.setText("En fin liten knapp! Klikk meg gjerne!");
        enKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                teller++;
                etTekstFelt.setText("Knapp klikket " + teller + " ganger");
            }
        });

        VBox hovedLayout = new VBox();
        hovedLayout.setFillWidth(true);
        hovedLayout.getChildren().add(enKnapp);
        hovedLayout.getChildren().add(etTekstFelt);
        hovedLayout.setAlignment(Pos.CENTER);

        Scene hovedScenen = new Scene(hovedLayout, 300, 300);
        primaryStage.setScene(hovedScenen);

        primaryStage.show();
    }
}
