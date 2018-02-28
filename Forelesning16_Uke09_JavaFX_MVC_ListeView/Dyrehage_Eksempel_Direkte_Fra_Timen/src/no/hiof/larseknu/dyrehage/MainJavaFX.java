package no.hiof.larseknu.dyrehage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import no.hiof.larseknu.dyrehage.model.Dyr;

import java.io.IOException;
import java.time.LocalDate;

public class MainJavaFX extends Application {
    private ObservableList<Dyr> listeMedDyr = FXCollections.observableArrayList();
    public static MainJavaFX javaFXApplikasjonen;

    private Stage primaryStage;

    public MainJavaFX() {
        listeMedDyr.add(new Dyr("Trine", "Panda", 100, LocalDate.of(2014, 4, 5)));
        listeMedDyr.add(new Dyr("Petter", "Panda", 101, LocalDate.of(2014, 4, 5)));
        listeMedDyr.add(new Dyr("Anders", "Panda", 102, LocalDate.of(2014, 4, 5)));
        listeMedDyr.add(new Dyr("Karl", "Panda", 103, LocalDate.of(2014, 4, 5)));
        listeMedDyr.add(new Dyr("Nils", "HonningGrevling", 105, LocalDate.of(2014, 4, 5)));
        listeMedDyr.add(new Dyr("Tom Heine", "Dovendyr", 106, LocalDate.of(2014, 4, 5)));
    }

    @Override
    public void start(Stage primaryStage) {
        MainJavaFX.javaFXApplikasjonen = this;

        this.primaryStage = primaryStage;

        gaaTilDyreDetaljScene();
    }

    public void gaaTilDyreDetaljScene() {
        try {
            FXMLLoader fxmlInnlaster = new FXMLLoader();

            fxmlInnlaster.setLocation(getClass().getResource("view/DyreDetalj.fxml"));
            Parent rootNode = fxmlInnlaster.load();

            Scene hovedScene = new Scene(rootNode);

            primaryStage.setTitle("Dyrepark");
            primaryStage.setScene(hovedScene);
            primaryStage.show();
        }
        catch (IOException | IllegalStateException ioexc) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);

            errorAlert.setTitle("Noe feil skjedde");
            errorAlert.setHeaderText("ERROR!");
            errorAlert.setContentText("Feil med innlasting av fxml" + ioexc.getMessage());
            errorAlert.showAndWait();
        }
    }

    public void gaaTilDyreListeScene() throws IOException {
        FXMLLoader fxmlInnlaster = new FXMLLoader();

        fxmlInnlaster.setLocation(getClass().getResource("view/DyreListe.fxml"));
        Parent rootNode = fxmlInnlaster.load();

        Scene listeScene = new Scene(rootNode);

        Stage listeStage = new Stage();
        listeStage.initModality(Modality.WINDOW_MODAL);
        listeStage.initOwner(primaryStage);

        listeStage.setTitle("Liste med dyr");
        listeStage.setScene(listeScene);
        listeStage.showAndWait();
    }

    public ObservableList<Dyr> getListeMedDyr() {
        return listeMedDyr;
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
