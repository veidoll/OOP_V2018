package no.hiof.larseknu.javafxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Oppretter og instansierer et objekt av klassen FXMLLoader. Som vi benytter til å laste inn UI fra en .fxml fil.
        FXMLLoader fxmlInnlaster = new FXMLLoader();

        // Setter lokasjonen vi skal laste inn .fxml filen fra (hvilken fil vi skal hente fra)
        fxmlInnlaster.setLocation(getClass().getResource("view/Hovedvindu.fxml"));
        // Laster inn hovedLayoutet/rotnoden fra Hovedvindu.fxml
        Parent hovedLayout = fxmlInnlaster.load();

        // Oppretter og instansierer scenen vi skal benytte, og setter hovedLayout(rotnoden), samt høyde og bredde
        Scene hovedScene = new Scene(hovedLayout, 600, 300);

        // Legger scenen vi har laget til primaryStage (vinduet)
        primaryStage.setScene(hovedScene);
        // Lager en tittel
        primaryStage.setTitle("Applikasjon med FXML grensesnitt og kontroller");
        // Viser primaryStage (vinduet). Uten denne vil vi ikke få frem noe på skjermen
        primaryStage.show();
    }
}
