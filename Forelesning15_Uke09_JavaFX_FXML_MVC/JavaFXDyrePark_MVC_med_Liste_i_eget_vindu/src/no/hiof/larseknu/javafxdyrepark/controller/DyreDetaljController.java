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
    private int valgtDyrIndex = 0;
    private MainJavaFX mainJavaFX;

    @FXML
    public void initialize() {
        // Legger referansen til MainJavaFX til i en lokal variabel, så den er "lettere" tilgjengelig (mindre tekst å skrive)
        mainJavaFX = MainJavaFX.mainJavaFXApplikasjon;

        // Henter en referanse til dyrelisten
        ObservableList<Dyr> dyreListe = mainJavaFX.getAlleDyrene();

        // Sjekker om vi har noe dyr i listen
        if (valgtDyrIndex < dyreListe.size()) {
            // Har vi oppretter vi et dyrobjekt med referanse til dyret
            Dyr etDyr = dyreListe.get(valgtDyrIndex);
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
        if(valgtDyrIndex +1 < dyreListe.size()) {
            // Øker indexen til valgtDyrIndex med 1
            valgtDyrIndex++;
            // Har vi det, henter vi ut dyret og sender det til fyllUtDyreInfo metoden
            fyllUtDyreInfo(dyreListe.get(valgtDyrIndex));
        }
    }

    // Metode for å hente og vise forrige dyr
    // EventHandleren er "satt" i fxml'en
    @FXML
    public void gaaTilForrigeDyr(ActionEvent actionEvent) {
        // Undersøker om vi har noen dyr "tilbake" i lista
        if(valgtDyrIndex -1 >= 0) {
            // Senker indexen til valgtDyrIndex med 1
            valgtDyrIndex--;
            // Har vi det, henter vi ut dyret og sender det til fyllUtDyreInfo metoden
            fyllUtDyreInfo(mainJavaFX.getAlleDyrene().get(valgtDyrIndex));
        }
    }

    // Metode for å gå til listescenen, det er MainJavaFX klassen som kontrollerer dette
    // EventHandleren er "satt" i fxml'en
    @FXML
    public void velgDyrFraListe(ActionEvent actionEvent) {
        // Sier til applikasjonen at vi vil velge et dyr fra en liste, får et valgt dyr tilbake
        Dyr valgtDyr = mainJavaFX.velgDyrFraListe();

        // Fyller ut data om valgt dyr
        fyllUtDyreInfo(valgtDyr);

        // Setter indexen "valgtDyrIndex" til indexen i listen for dyret
        this.valgtDyrIndex = mainJavaFX.getAlleDyrene().indexOf(valgtDyr);
    }
}
