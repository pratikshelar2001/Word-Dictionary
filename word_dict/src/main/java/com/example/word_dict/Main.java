package com.example.word_dict;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Group root; //Group contains all the panes / fxml we want to add
    @Override
    public void start(Stage stage) throws IOException {
        root = new Group();
        stage.setTitle("Word Dictionary");
        DictionaryPage page = new DictionaryPage();
        root.getChildren().add(page.root); // Add FXML file stored in DP.java/root
        stage.setScene(new Scene(root,500,500));

        stage.getScene().setFill(new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,new Stop(0, Color.web("#81c483")),new Stop(1, Color.web("#fcc200"))));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}