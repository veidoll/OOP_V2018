package no.hiof.larseknu.javafxdyrepark.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import no.hiof.larseknu.javafxdyrepark.MainJavaFX;
import no.hiof.larseknu.javafxdyrepark.model.Dyr;


public class DyrelisteController {

    // Listevisninen vår definert i fxml'en
    @FXML
    private ListView<Dyr> dyreListe;

    private Stage stage;
    private Dyr valgtDyr;

    @FXML
    public void initialize() {
        // Setter listen til å inneholde observablelisten vi henter fra Main
        dyreListe.setItems(MainJavaFX.mainJavaFXApplikasjon.getAlleDyrene());

        // Setter opp at vi vil ha beskjed hver gang et dyr endres/blir valgt
        dyreListe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Dyr>() {
            @Override
            public void changed(ObservableValue<? extends Dyr> observable, Dyr gammeltDyr, Dyr nyttDyr) {
                // Printer ut dyret som er valgt
                System.out.println(nyttDyr);

                // Sjekker om dyret er et dovendyr
                if(nyttDyr.getArt().equals("Dovendyr"))
                    // Er det det, endrer vi det til et våkendyr, endringen blir vist i grensesnittet med en gang
                    nyttDyr.setArt("Våkendyr");
            }
        });
    }

    // Metode for å si i fra at vi har valgt et dyr, det er MainJavaFX klassen som kontrollerer hva den gjør med dettedette
    // EventHandleren er "satt" i fxml'en
    @FXML
    public void setValgtDyrOgAvslutt(ActionEvent actionEvent) {
        valgtDyr = dyreListe.getSelectionModel().getSelectedItem();

        // Lukker stagen/vinduet
        stage.close();
    }

    public Dyr getValgtDyr() {
        return valgtDyr;
    }

    // Metode for å sette stagen/vinduet, slik at vi har mulighet til å lukke det "manuelt" (når vi velger et dyr)
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
