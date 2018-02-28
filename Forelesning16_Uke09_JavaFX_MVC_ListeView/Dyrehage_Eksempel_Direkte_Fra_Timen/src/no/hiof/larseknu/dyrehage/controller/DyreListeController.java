package no.hiof.larseknu.dyrehage.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import no.hiof.larseknu.dyrehage.MainJavaFX;
import no.hiof.larseknu.dyrehage.model.Dyr;

import java.io.IOException;
import java.time.LocalDate;

public class DyreListeController {
    @FXML
    private ListView<Dyr> dyreListeView;
    @FXML
    private Button gaaTilDetaljerKnapp;

    private MainJavaFX mainJavaFX;

    @FXML
    public void initialize() {
        mainJavaFX = MainJavaFX.javaFXApplikasjonen;

        dyreListeView.getItems().addAll(Dyr.dyrArrayList);

        dyreListeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Dyr>() {
            @Override
            public void changed(ObservableValue<? extends Dyr> observable, Dyr gammelDyr, Dyr valgtDyr) {
                System.out.println("Gammelt dyr: " + gammelDyr + " Valgt dyr: " + valgtDyr);

                if (valgtDyr.getArt().equals("Dovendyr")) {
                    valgtDyr.setArt("Våkendyr");
                }
            }
        });


        gaaTilDetaljerKnapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dyr dyr = new Dyr("Lars Emil", "Løve",9001, LocalDate.now());
                dyreListeView.getItems().add(dyr);


                //mainJavaFX.getListeMedDyr().add(dyr);
            }
        });
    }

}
