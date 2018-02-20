package no.hiof.larseknu.javafxdyrepark;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.hiof.larseknu.javafxdyrepark.controller.HovedlayoutController;
import no.hiof.larseknu.javafxdyrepark.model.Dyr;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main extends Application {

    private ObservableList<Dyr> alleDyrene = FXCollections.observableArrayList();

    public Main() {
        alleDyrene.add(new Dyr("Nils", "HonningGrevling", LocalDate.of(2015, 5, 5)));
        alleDyrene.add(new Dyr("Trine", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Guro", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Petter", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Gunnar", "Panda",  LocalDate.of(1995, 2 ,1)));
        alleDyrene.add(new Dyr("Tom Heine", "Dovendyr",  LocalDate.of(1995, 2 ,1)));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlInnlaster = new FXMLLoader();

        fxmlInnlaster.setLocation(getClass().getResource("view/Hovedlayout.fxml"));
        Parent hovedLayout = fxmlInnlaster.load();

        HovedlayoutController hovedlayoutController = fxmlInnlaster.getController();
        hovedlayoutController.setMain(this);

        Scene hovedScene = new Scene(hovedLayout, 400, 200);

        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Dyrene i Dyreparken");
        primaryStage.show();
    }

    public ObservableList<Dyr> getAlleDyrene() {
        return alleDyrene;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
