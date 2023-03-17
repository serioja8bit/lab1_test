package com.example.aso_exersare;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;

import static javafx.scene.paint.Color.AQUA;
import static javafx.scene.paint.Color.BLACK;

class Hopa extends TimerTask {
    public void run() {

        System.out.println("Timerul lucreaza!");
    }

     public void scheduleAtFixedRate(Hopa hopa, int i, int i1) {
     }
 }
public class HelloApplication extends Application {
    @Override
        public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("dREAMTEAM.");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800);
        Button feli_button = new Button("Faceți click!  ");
        feli_button.setLayoutY(200);
        feli_button.setLayoutX(400);
        feli_button.setTextFill(BLACK);
        feli_button.setStyle("-fx-background-color: RED");

        Button sergiu_button = new Button("Faceți click!");
        sergiu_button.setLayoutY(400);
        sergiu_button.setLayoutX(400);
        sergiu_button.setTextFill(BLACK);
        sergiu_button.setStyle("-fx-background-color: RED");

        Button danu_button = new Button("Faceți click!");
        danu_button.setLayoutY(600);
        danu_button.setLayoutX(400);
        danu_button.setTextFill(BLACK);
        danu_button.setStyle("-fx-background-color: RED");

       feli_button.setOnAction(event -> {


        });

        sergiu_button.setOnAction(event -> {


        });

        danu_button.setOnAction(event -> {


        });


        root.getChildren().addAll(feli_button, sergiu_button, danu_button);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        final Timer timer1 = new Timer();
        timer1.scheduleAtFixedRate( new Hopa(), 3000, 10*1000);
        launch();
    }
}