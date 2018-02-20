package no.hiof.larseknu.javafxdyrepark.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import no.hiof.larseknu.javafxdyrepark.Main;
import no.hiof.larseknu.javafxdyrepark.model.Dyr;

public class DyreDetaljController {
    // Label definert i fxml
    @FXML
    private Label navnTekstLabel;

    // TextField definert i fxml
    @FXML
    private TextField idTextField, fodselsdatoTextField;

    // Referanse til objekt av Main-klassen, slik at vi får tilgang til felles lister og mulighet til "navigering"
    private Main mainApp;
    // Index for hvilket dyr i listen som er valgt
    private int valgtDyr = 0;

    public void setMain(Main mainApp) {
        // Setter referansen til objektet av Main-klassen
        this.mainApp = mainApp;

        // Sjekker om vi har noe dyr i listen
        if (valgtDyr < mainApp.getAlleDyrene().size()) {
            // Har vi oppretter vi et dyrobjekt med referanse til dyret
            Dyr etDyr = mainApp.getAlleDyrene().get(valgtDyr);
            // Sender dyret til fyllUtDyreInfo-metoden
            fyllUtDyreInfo(etDyr);
        }
    }

    // Fyller ut grensesnittet med info om et dyr
    private void fyllUtDyreInfo(Dyr etDyr) {
        // Sjekker om dyret ikke er "null"
        if (etDyr != null) {
            // Er det ikke det, fyller vi inn den forskjellige infoen fra dyrobjektet
            navnTekstLabel.setText(etDyr.getArt() + " - " + etDyr.getNavn());
            idTextField.setText(String.valueOf(etDyr.getID()));
            fodselsdatoTextField.setText(etDyr.getFodselsDato().toString());
        }
    }

    // Metode for å hente og vise neste dyr
    // EventHandleren er "satt" i fxml'en
    @FXML
    public void gaaTilNesteDyr(ActionEvent actionEvent) {
        // Undersøker om vi har noen flere dyr i listen
        if(valgtDyr+1 < mainApp.getAlleDyrene().size()) {
            // Har vi det, henter vi ut dyret og sender det til fyllUtDyreInfo metoden
            fyllUtDyreInfo(mainApp.getAlleDyrene().get(valgtDyr+1));
            // Øker indexen til valgtDyr med 1
            valgtDyr++;
        }
    }

    // Metode for å hente og vise forrige dyr
    // EventHandleren er "satt" i fxml'en
    @FXML
    public void gaaTilForrigeDyr(ActionEvent actionEvent) {
        // Undersøker om vi har noen dyr "tilbake" i lista
        if(valgtDyr-1 >= 0) {
            // Har vi det, henter vi ut dyret og sender det til fyllUtDyreInfo metoden
            fyllUtDyreInfo(mainApp.getAlleDyrene().get(valgtDyr-1));
            // Senker indexen til valgtDyr med 1
            valgtDyr--;
        }
    }
}
