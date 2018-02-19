package no.hiof.larseknu.hellojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application{

    private int teller = 0;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label etTekstFelt = new Label();
        etTekstFelt.setFont(Font.font("Calibri", 24));
        etTekstFelt.setText("Hællæ JavaFX");
        
        Button enKnapp = new Button();
        enKnapp.setText("En fin liten knapp! Klikk meg gjerne!");
        enKnapp.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mus over knapp!");
                enKnapp.setFont(new Font("Comic Sans MS", 24));
            }
        });
        enKnapp.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mus over knapp!");
                enKnapp.setFont(new Font("Calibri", 14));
            }
        });
        enKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                teller++;

                if (teller == 10) {
                    visAlert();
                    teller = 0;
                }

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
        primaryStage.setTitle("Min første JavaFX applikasjon");
        primaryStage.show();
    }

    private void visAlert() {
        Alert minAlert = new Alert(Alert.AlertType.INFORMATION);
        minAlert.setTitle("Du vant!");
        minAlert.setHeaderText(null);
        minAlert.setContentText("Gratulerer! Du klarte å trykke " + teller + " ganger.");

        minAlert.showAndWait();
    }
}
