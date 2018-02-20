package no.hiof.larseknu.javafxdyrepark.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import no.hiof.larseknu.javafxdyrepark.Main;
import no.hiof.larseknu.javafxdyrepark.model.Dyr;

public class HovedlayoutController {
    @FXML
    private Label navnTekstLabel;

    @FXML
    private TextField idTextField, fodselsdatoTextField;

    private Main mainApp;
    private int valgtDyr = 0;

    private void fyllUtDyreInfo(Dyr etDyr) {
        if (etDyr != null) {
            navnTekstLabel.setText(etDyr.getArt() + " - " + etDyr.getNavn());
            idTextField.setText(String.valueOf(etDyr.getID()));
            fodselsdatoTextField.setText(etDyr.getFodselsDato().toString());
        }
    }

    public void setMain(Main mainApp) {
        this.mainApp = mainApp;

        if (valgtDyr < mainApp.getAlleDyrene().size()) {
            Dyr etDyr = mainApp.getAlleDyrene().get(valgtDyr);
            fyllUtDyreInfo(etDyr);
        }
    }

    public void gaaTilNesteDyr(ActionEvent actionEvent) {
        if(valgtDyr+1 < mainApp.getAlleDyrene().size()) {
            fyllUtDyreInfo(mainApp.getAlleDyrene().get(valgtDyr+1));
            valgtDyr++;
        }
    }

    public void gaaTilForrigeDyr(ActionEvent actionEvent) {
        if(valgtDyr-1 >= 0) {
            fyllUtDyreInfo(mainApp.getAlleDyrene().get(valgtDyr-1));
            valgtDyr--;
        }
    }
}
