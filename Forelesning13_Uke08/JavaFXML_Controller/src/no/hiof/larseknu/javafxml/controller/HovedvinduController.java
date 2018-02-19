package no.hiof.larseknu.javafxml.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class HovedvinduController {
    @FXML
    private Button velgFargeButton;

    @FXML
    private ColorPicker fargeVelger;

    @FXML
    private Ellipse enElipse;
    @FXML
    private Rectangle enRektangel;

    @FXML
    private void initialize() {

        velgFargeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Paint valgtFarge = fargeVelger.getValue();
                enElipse.setFill(valgtFarge);
            }
        });

    }

    @FXML
    private void fargeleggRektangel(ActionEvent actionEvent) {
        Paint valgtFarge = fargeVelger.getValue();
        enRektangel.setFill(valgtFarge);
    }
}
