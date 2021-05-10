package main.java;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.sql.*;
import java.text.ParseException;

public class Main extends Application {

    public static void main(String[] args) throws IOException, SQLException {
        Task1.mergeFiles("src\\main\\resources\\test");

        Task2 db = new Task2();
        db.createStudentTable();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view\\menu.fxml"));
        primaryStage.setTitle("Task2");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
