package no.hiof.larseknu.javafxdyrepark;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.hiof.larseknu.javafxdyrepark.controller.DyreDetaljController;
import no.hiof.larseknu.javafxdyrepark.controller.DyrelisteController;
import no.hiof.larseknu.javafxdyrepark.model.Dyr;

import java.io.IOException;
import java.time.LocalDate;


public class MainJavaFX extends Application {

    // Lager en observablelist, denne har støtte for å oppdatere elementer i listen i grensesnittet automagisk
    private ObservableList<Dyr> alleDyrene = FXCollections.observableArrayList();
    // Legger stagen/vinduet i en lokal feltvariabel
    private Stage primaryStage;
    // Lager en statisk referanse til oss selv. (dette er ikke heelt vanlig, men gjør det litt "lettere" å få tilgang til listen vår, samt metoder for å bytte vindu/scene)
    // Setter den også til public slik at den alltid er tilgjengelig der vi har behov for den (hovedsakelig i våre controllere)
    public static MainJavaFX mainJavaFXApplikasjon;

    public MainJavaFX() {
        // Oppretter og fyller listen med en rekke dyr
        alleDyrene.add(new Dyr("Nils", "HonningGrevling", LocalDate.of(2015, 5, 5)));
        alleDyrene.add(new Dyr("Trine", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Guro", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Petter", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Gunnar", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Tom Heine", "Dovendyr",  LocalDate.of(1995, 2 ,1)));

        // Setter den statiske variabelen til å referere til oss selv, altså instansen av MainJavaFX
        mainJavaFXApplikasjon = this;
    }

    @Override
    public void start(Stage primaryStage) {
        // Setter den lokale feltvariabelen
        this.primaryStage = primaryStage;

        // Setter hvilken scene som skal lastes inn
        gaaTilHovedVisning();
    }

    // Laster inn
    public void gaaTilHovedVisning(){
        try {
            // Oppretter og instansierer et objekt av klassen FXMLLoader. Som vi benytter til å laste inn UI fra en .fxml fil.
            FXMLLoader fxmlInnlaster = new FXMLLoader();
            // Setter lokasjonen vi skal laste inn .fxml filen fra (hvilken fil vi skal hente fra)
            fxmlInnlaster.setLocation(getClass().getResource("view/DyreDetalj.fxml"));
            // Laster inn hovedLayoutet/rotnoden fra Hovedlayout.fxml
            Parent hovedLayout = fxmlInnlaster.load();

            // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
            Scene hovedScene = new Scene(hovedLayout, 400, 200);

            // Legger scenen vi har laget til primaryStage (vinduet)
            primaryStage.setScene(hovedScene);
            // Lager en tittel
            primaryStage.setTitle("Dyrene i Dyreparken");
            // Viser primaryStage (vinduet). Uten denne vil vi ikke få frem noe på skjermen
            primaryStage.show();
        }
        catch (IOException ioe) {
            // Viser en alertboks med feilmelding
            visFilmeldingsBoks("I/O feil: " + ioe.getMessage());
        }
        catch (IllegalStateException exc) {
            // Viser en alertboks med feilmelding
            visFilmeldingsBoks("Feil 41!\nKlarte ikke finne grensesnittdefinisjon.\n" + exc.getMessage());
            System.err.println(exc);
        }
    }

    public Dyr velgDyrFraListe() {
        try {
            Stage nyListeStage = new Stage();

            // Oppretter og instansierer et objekt av klassen FXMLLoader. Som vi benytter til å laste inn UI fra en .fxml fil.
            FXMLLoader fxmlInnlaster = new FXMLLoader();

            // Setter lokasjonen vi skal laste inn .fxml filen fra (hvilken fil vi skal hente fra)
            fxmlInnlaster.setLocation(getClass().getResource("view/Dyreliste.fxml"));
            // Laster inn hovedLayoutet/rotnoden fra Dyreliste.fxml
            Parent hovedLayout = fxmlInnlaster.load();

            DyrelisteController dyrelisteController = fxmlInnlaster.getController();
            dyrelisteController.setStage(nyListeStage);

            // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
            Scene hovedScene = new Scene(hovedLayout, 400, 200);



            nyListeStage.initModality(Modality.APPLICATION_MODAL);
            nyListeStage.initOwner(primaryStage);

            nyListeStage.setScene(hovedScene);
            nyListeStage.setTitle("Dyreliste");
            nyListeStage.showAndWait();

            return dyrelisteController.getValgtDyr();
        }
        catch (IOException ioe) {
            // Viser en alertboks med feilmelding
            visFilmeldingsBoks("I/O feil: " + ioe.getMessage());
            return null;
        }
        catch (IllegalStateException exc) {
            // Viser en alertboks med feilmelding
            visFilmeldingsBoks("Feil 42!\nKlarte ikke finne grensesnittdefinisjon.\n" + exc.getMessage());
            System.err.println(exc);
            return null;
        }
    }

    private void visFilmeldingsBoks(String message) {
        // Oppretter og instansierer et Alert objekt, og setter typen til Informasjon (vi får da en OK knapp, samt et ikon med "i" i boksen
        Alert errorAlert = new Alert(AlertType.ERROR);
        // Setter tittelen til alertboksen
        errorAlert.setTitle("Feil med innlasting av grensesnitt");
        // Setter denne til null for å gjøre alertboksen litt ryddigere, hadde vi hatt behov for en header kunne vi satt en tekst her
        errorAlert.setHeaderText(null);
        // Setter innholdet i alertboksen, altså teksten som skal vises
        errorAlert.setContentText(message);

        // Setter at alertboksen skal vises, og at vi venter med å kjøre videre i programmet til det er trykket OK eller den er lukket
        errorAlert.show();
    }

    // Returnerer vår ObservableList med dyr
    public ObservableList<Dyr> getAlleDyrene() {
        return alleDyrene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
