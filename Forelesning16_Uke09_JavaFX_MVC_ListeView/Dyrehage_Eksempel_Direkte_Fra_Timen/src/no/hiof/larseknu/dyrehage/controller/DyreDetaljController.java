package no.hiof.larseknu.dyrehage.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import no.hiof.larseknu.dyrehage.MainJavaFX;
import no.hiof.larseknu.dyrehage.model.Dyr;

import java.io.IOException;

public class DyreDetaljController {
    @FXML
    private TextField idFodselsdato;
    @FXML
    private TextField idTextField;
    @FXML
    private Label tittelLabel;

    private int valgtDyrIndex = 0;

    private MainJavaFX mainJavaFX;

    @FXML
    private void initialize() {
        tittelLabel.setText("Testdyr");

        mainJavaFX = MainJavaFX.javaFXApplikasjonen;

        Dyr etDyr = mainJavaFX.getListeMedDyr().get(valgtDyrIndex);

        fyllUtDyreData(etDyr);
    }

    @FXML
    public void gaaTilForrige() {
        valgtDyrIndex--;

        Dyr etDyr = mainJavaFX.getListeMedDyr().get(valgtDyrIndex);

        fyllUtDyreData(etDyr);
    }

    @FXML
    public void gaaTilNeste() {
        valgtDyrIndex++;

        Dyr etDyr = mainJavaFX.getListeMedDyr().get(valgtDyrIndex);

        fyllUtDyreData(etDyr);
    }

    @FXML
    public void gaaTilListeScene() throws IOException {
        mainJavaFX.gaaTilDyreListeScene();
    }

    private void fyllUtDyreData(Dyr etDyr) {
        if (etDyr != null) {
            tittelLabel.setText(etDyr.getNavn() + " - " + etDyr.getArt());

            idTextField.setText(String.valueOf(etDyr.getId()));

            idFodselsdato.setText(etDyr.getFodselsdato().toString());
        }
    }

}
