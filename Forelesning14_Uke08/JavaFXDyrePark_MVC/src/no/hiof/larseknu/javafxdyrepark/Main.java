package no.hiof.larseknu.javafxdyrepark;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.hiof.larseknu.javafxdyrepark.controller.DyreDetaljController;
import no.hiof.larseknu.javafxdyrepark.model.Dyr;

import java.time.LocalDate;

public class Main extends Application {

    // Lager en observablelist, denne har støtte for å oppdatere elementer i listen i grensesnittet automagisk
    private ObservableList<Dyr> alleDyrene = FXCollections.observableArrayList();

    public Main() {
        // Oppretter og fyller listen med en rekke dyr
        alleDyrene.add(new Dyr("Nils", "HonningGrevling", LocalDate.of(2015, 5, 5)));
        alleDyrene.add(new Dyr("Trine", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Guro", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Petter", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Gunnar", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Tom Heine", "Dovendyr",  LocalDate.of(1995, 2 ,1)));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Oppretter og instansierer et objekt av klassen FXMLLoader. Som vi benytter til å laste inn UI fra en .fxml fil.
        FXMLLoader fxmlInnlaster = new FXMLLoader();
        // Setter lokasjonen vi skal laste inn .fxml filen fra (hvilken fil vi skal hente fra)
        fxmlInnlaster.setLocation(getClass().getResource("view/DyreDetalj.fxml"));
        // Laster inn hovedLayoutet/rotnoden fra Hovedlayout.fxml
        Parent hovedLayout = fxmlInnlaster.load();

        // Henter ut controlleren som hører til hovedlayoutet
        DyreDetaljController hovedlayoutController = fxmlInnlaster.getController();
        // Gir en referanse til denne klassen, slik at HovedlayoutController får tilgang til å hente lister med data og kalle metode for å bytte scene
        hovedlayoutController.setMain(this);

        // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
        Scene hovedScene = new Scene(hovedLayout, 400, 200);

        // Legger scenen vi har laget til primaryStage (vinduet)
        primaryStage.setScene(hovedScene);
        // Lager en tittel
        primaryStage.setTitle("Dyrene i Dyreparken");
        // Viser primaryStage (vinduet). Uten denne vil vi ikke få frem noe på skjermen
        primaryStage.show();
    }

    // Returnerer vår ObservableList med dyr
    public ObservableList<Dyr> getAlleDyrene() {
        return alleDyrene;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
