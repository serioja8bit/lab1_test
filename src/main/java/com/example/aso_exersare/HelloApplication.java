package com.example.aso_exersare;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import javafx.util.converter.LocalTimeStringConverter;

import java.io.FileNotFoundException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.Timer;
import static javafx.scene.paint.Color.BLACK;

public class HelloApplication extends Application {
    private TextField timeField;
    private Label currentTimeLabel;
    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message);
        alert.showAndWait();
    }
    @Override
        public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("DreamTeam.");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800);
        scene.setFill(Color.BLANCHEDALMOND);

        DropShadow shadow = new DropShadow();
        Button feli_button = new Button("Felicia ^-^");
        feli_button.setLayoutY(200);
        feli_button.setLayoutX(370);
        feli_button.setTextFill(BLACK);
        feli_button.setStyle("-fx-background-color: CRIMSON");
        feli_button.setEffect(shadow);

        Button sergiu_button = new Button("Sergiu  :0");
        sergiu_button.setLayoutY(400);
        sergiu_button.setLayoutX(375);
        sergiu_button.setTextFill(BLACK);
        sergiu_button.setStyle("-fx-background-color: GREENYELLOW");
        sergiu_button.setEffect(shadow);

        Button danu_button = new Button("Danu  =p");
        danu_button.setLayoutY(600);
        danu_button.setLayoutX(375);
        danu_button.setTextFill(BLACK);
        danu_button.setStyle("-fx-background-color: INDIANRED");
        danu_button.setEffect(shadow);

        Circle cerc = new Circle();
        cerc.setVisible(false);
        cerc.setFill(Color.LIGHTSALMON);
        cerc.setCenterX(400);
        cerc.setCenterY(400);
        cerc.setRadius(300);
        cerc.setEffect(shadow);

        Circle cerc2 = new Circle();
        cerc2.setVisible(false);
        cerc2.setFill(Color.VIOLET);
        cerc2.setCenterX(400);
        cerc2.setCenterY(400);
        cerc2.setRadius(350);
        cerc2.setEffect(shadow);

        Rectangle patrat1 = new Rectangle(100, 100);
        patrat1.setLayoutX(100);
        patrat1.setLayoutY(200);
        patrat1.setFill(BLACK);
        patrat1.setVisible(false);
        patrat1.setEffect(shadow);

        Rectangle patrat2 = new Rectangle(100, 100);
        patrat2.setLayoutX(100);
        patrat2.setLayoutY(500);
        patrat2.setFill(Color.BLACK);
        patrat2.setVisible(false);
        patrat2.setEffect(shadow);

        Rectangle patrat3 = new Rectangle(100, 100);
        patrat3.setLayoutX(600);
        patrat3.setLayoutY(200);
        patrat3.setFill(Color.BLACK);
        patrat3.setVisible(false);
        patrat3.setEffect(shadow);

        Rectangle patrat4 = new Rectangle(100, 100);
        patrat4.setLayoutX(600);
        patrat4.setLayoutY(500);
        patrat4.setFill(Color.BLACK);
        patrat4.setVisible(false);
        patrat4.setEffect(shadow);

        Rectangle patrat5 = new Rectangle(100, 100);
        patrat5.setLayoutX(350);
        patrat5.setLayoutY(350);
        patrat5.setFill(Color.BLACK);
        patrat5.setVisible(false);
        patrat5.setEffect(shadow);

        RotateTransition rotatie1 = new RotateTransition();
        rotatie1.setAxis(rotatie1.getAxis());
        rotatie1.setAxis(patrat1.getRotationAxis());
        rotatie1.setByAngle(360);
        rotatie1.setCycleCount(10);
        rotatie1.setDuration(Duration.millis(1000));
        rotatie1.setNode(patrat1);

        RotateTransition rotatie2 = new RotateTransition();
        rotatie2.setAxis(rotatie2.getAxis());
        rotatie2.setAxis(patrat2.getRotationAxis());
        rotatie2.setByAngle(360);
        rotatie2.setCycleCount(10);
        rotatie2.setDuration(Duration.millis(1000));
        rotatie2.setNode(patrat2);

        RotateTransition rotatie3 = new RotateTransition();
        rotatie3.setAxis(rotatie3.getAxis());
        rotatie3.setAxis(patrat2.getRotationAxis());
        rotatie3.setByAngle(-360);
        rotatie3.setCycleCount(10);
        rotatie3.setDuration(Duration.millis(1000));
        rotatie3.setNode(patrat3);

        RotateTransition rotatie4 = new RotateTransition();
        rotatie4.setAxis(rotatie4.getAxis());
        rotatie4.setAxis(patrat2.getRotationAxis());
        rotatie4.setByAngle(-360);
        rotatie4.setCycleCount(10);
        rotatie4.setDuration(Duration.millis(1000));
        rotatie4.setNode(patrat4);

        RotateTransition rotatie5 = new RotateTransition();
        rotatie5.setAxis(rotatie5.getAxis());
        rotatie5.setAxis(patrat2.getRotationAxis());
        rotatie5.setByAngle(360);
        rotatie5.setCycleCount(10);
        rotatie5.setDuration(Duration.millis(1000));
        rotatie5.setNode(patrat5);
        rotatie5.setAutoReverse(true);

        Label timeLabel = new Label("Enter time:");
        timeField = new TextField();
        timeField.setVisible(false);
        Button scheduleButton = new Button("Schedule exit");
        scheduleButton.setVisible(false);
        StringConverter<LocalTime> converter = new LocalTimeStringConverter(DateTimeFormatter.ofPattern("HH:mm:ss"), null);
        timeField.setTextFormatter(new TextFormatter<>(converter));
        Button cancelButton = new Button("Cancel");
        cancelButton.setVisible(false);
        cancelButton.setLayoutX(200);
        cancelButton.setLayoutY(100);
        Label statusLabel = new Label(" ");
        statusLabel.setLayoutX(0);
        statusLabel.setLayoutY(50);
        statusLabel.setVisible(false);
        Label currentTimePromptLabel = new Label("Current time:");
        currentTimePromptLabel.setVisible(false);
        currentTimePromptLabel.setLayoutY(150);
        currentTimeLabel = new Label();
        currentTimeLabel.setLayoutY(250);
        currentTimeLabel.setVisible(false);



        class Hopa extends TimerTask {
            public void run() {
                System.out.println("Timerul lucreaza!");
                patrat1.setVisible(true);
                patrat2.setVisible(true);
                patrat3.setVisible(true);
                patrat4.setVisible(true);
                rotatie1.play();
                rotatie2.play();
                rotatie3.play();
                rotatie4.play();
            }
        }

        class Hopa2 extends TimerTask {
            public void run() {
                System.out.println("Functie2!");
                patrat5.setVisible(true);
                rotatie5.play();
                cerc2.setVisible(true);
            }
        }

        class Hopa3 extends TimerTask {
            public void run() {
                System.out.println("Functia a treia 3!");
                cerc.setVisible(false);
            }
        }


       feli_button.setOnAction(event -> {
           final Timer timer3_feli = new Timer();
           timer3_feli.schedule( new Hopa3(), 13000);
           final Timer timer1_feli = new Timer();
           timer1_feli.schedule( new Hopa(), 1000);
           final Timer timer2_feli = new Timer();
           timer2_feli.schedule( new Hopa2(), 3000);
           feli_button.setVisible(false);
           sergiu_button.setVisible(false);
           danu_button.setVisible(false);
           cerc.setVisible(true);
        });

        sergiu_button.setOnAction(event -> {


        });

        danu_button.setOnAction(event -> {
            scheduleButton.setVisible(true);
            scheduleButton.setLayoutY(50);
            timeField.setVisible(true);
            feli_button.setVisible(false);
            sergiu_button.setVisible(false);
            danu_button.setVisible(false);
            cancelButton.setVisible(true);
            cancelButton.setLayoutY(50);
            cancelButton.setLayoutX(100);
            currentTimeLabel.setVisible(true);
            currentTimeLabel.setLayoutY(150);
            currentTimeLabel.setLayoutX(100);
            statusLabel.setVisible(true);
            statusLabel.setLayoutY(100);
            currentTimePromptLabel.setVisible(true);
    });

        scheduleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String inputTime = timeField.getText().trim();
                if (inputTime.isEmpty()) {
                    showErrorMessage("Please enter a time.");
                    return;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime localTime = LocalTime.parse(inputTime, formatter);
                ZoneId zoneId = ZoneId.systemDefault();
                ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDate.now(), localTime, zoneId);
                if (zonedDateTime.isBefore(ZonedDateTime.now())) {
                    showErrorMessage("Please enter a time in the future.");
                    return;
                }
                long delayMillis = java.time.Duration.between(ZonedDateTime.now(), zonedDateTime).toMillis();
                statusLabel.setText("System will shut down in " + formatDuration(delayMillis) + ".");
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        Platform.runLater(() -> {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "System is shutting down.");
                            alert.showAndWait();
                            System.exit(0);
                        });
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, delayMillis);
            }
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                statusLabel.setText(" ");
                timeField.setText("");
            }
        });

        Timeline currentTimeTimeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                currentTimeLabel.setText(now.format(formatter));
            }
        }));
        currentTimeTimeline.setCycleCount(Timeline.INDEFINITE);
        currentTimeTimeline.play();

        root.getChildren().addAll(feli_button, sergiu_button, danu_button, cerc2, cerc, patrat1, patrat2, patrat3, patrat4, patrat5, scheduleButton, timeField);
        root.getChildren().addAll(statusLabel, cancelButton, currentTimeLabel, currentTimePromptLabel);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String formatDuration(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        return String.format("%02d:%02d:%02d", hours, minutes % 60, seconds % 60);
    }

    public static void main(String[] args) {
        launch();
    }
}