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


        FXMLLoader fxmlInnlaster = new FXMLLoader();

        fxmlInnlaster.setLocation(getClass().getResource("view/Hovedvindu.fxml"));
        Parent hovedLayout = fxmlInnlaster.load();

        Scene hovedScene = new Scene(hovedLayout, 400, 300);

        primaryStage.setScene(hovedScene);
        primaryStage.setTitle("Applikasjon med FXML grensesnitt");
        primaryStage.show();
    }
}
