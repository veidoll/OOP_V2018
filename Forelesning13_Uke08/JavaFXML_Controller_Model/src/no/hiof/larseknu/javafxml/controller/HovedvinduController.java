package no.hiof.larseknu.javafxml.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

public class HovedvinduController {
    @FXML
    private ColorPicker fargeVelger;
    @FXML
    private Button velgFargeButton;
    @FXML
    private Ellipse elipse;

    @FXML
    public void initialize() {

        velgFargeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Paint valgtFarge = fargeVelger.getValue();
                elipse.setFill(valgtFarge);
            }
        });

    }

}
