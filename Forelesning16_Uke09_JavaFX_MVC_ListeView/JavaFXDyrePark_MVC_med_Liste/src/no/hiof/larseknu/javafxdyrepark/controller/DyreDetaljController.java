package no.hiof.larseknu.javafxdyrepark.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import no.hiof.larseknu.javafxdyrepark.MainJavaFX;
import no.hiof.larseknu.javafxdyrepark.model.Dyr;

public class DyreDetaljController {
    // Label definert i fxml
    @FXML
    private Label navnTekstLabel;

    // TextField definert i fxml
    @FXML
    private TextField idTextField, fodselsdatoTextField;

    // Index for hvilket dyr i listen som er valgt
    private int valgtDyr = 0;

    @FXML
    public void initialize() {
        // Henter en referanse til dyrelisten
        ObservableList<Dyr> dyreListe = MainJavaFX.mainJavaFXApplikasjon.getAlleDyrene();

        // Sjekker om vi har noe dyr i listen
        if (valgtDyr < dyreListe.size()) {
            // Har vi oppretter vi et dyrobjekt med referanse til dyret
            Dyr etDyr = dyreListe.get(valgtDyr);
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
        // Henter en referanse til dyrelisten
        ObservableList<Dyr> dyreListe = MainJavaFX.mainJavaFXApplikasjon.getAlleDyrene();

        // Undersøker om vi har noen flere dyr i listen
        if(valgtDyr+1 < dyreListe.size()) {
            // Har vi det, henter vi ut dyret og sender det til fyllUtDyreInfo metoden
            fyllUtDyreInfo(dyreListe.get(valgtDyr+1));
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
            fyllUtDyreInfo(MainJavaFX.mainJavaFXApplikasjon.getAlleDyrene().get(valgtDyr-1));
            // Senker indexen til valgtDyr med 1
            valgtDyr--;
        }
    }

    // Metode for å gå til listescenen, det er MainJavaFX klassen som kontrollerer dette
    // EventHandleren er "satt" i fxml'en
    @FXML
    public void gaaTilListe(ActionEvent actionEvent) {
        MainJavaFX.mainJavaFXApplikasjon.gaaTilListeVisning();
    }
}
