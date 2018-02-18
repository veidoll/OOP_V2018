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
    private ColorPicker fargeVelger;
    @FXML
    private Button velgFargeElipseButton;
    @FXML
    private Ellipse enElipse;
    @FXML
    private Rectangle enRektangel;

    @FXML
    public void initialize() {

        velgFargeElipseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Paint valgtFarge = fargeVelger.getValue();
                enElipse.setFill(valgtFarge);
            }
        });

    }

    public void fargeleggRektangel(ActionEvent actionEvent) {
        Paint valgtFarge = fargeVelger.getValue();
        enRektangel.setFill(valgtFarge);
    }
}
