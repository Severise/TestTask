package main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class Controller {
    @FXML
    private TextField id;

    @FXML
    private TextField fName;

    @FXML
    private TextField mName;

    @FXML
    private TextField lName;

    @FXML
    private TextField day;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    private TextField group;


    @FXML
    void openAdd(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/addStudent.fxml"));
        stage.setTitle("Add student");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void openDelete(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/deleteStudent.fxml"));
        stage.setTitle("Delete student");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void add(ActionEvent event) {
        String fn = fName.getText();
        String mn = mName.getText();
        String ln = lName.getText();
        String g = group.getText();

        String Day = day.getText();
        String Month = month.getText();
        String Year = year.getText();

        Date date = Date.valueOf(String.format("%s-%s-%s", Year, Month, Day).trim());

        try {
            boolean res = Task2.addStudent(fn, mn, ln, date, g);
            Stage stage = (Stage) fName.getScene().getWindow();
            if (res) showInf("Row was added!");
            else
                showError("Row wasn't added");
            stage.close();
        } catch (SQLException throwables) {
            showError("Error has happened");
            throwables.printStackTrace();
        }
    }

    @FXML
    void delete(ActionEvent event) {
        int studId = Integer.parseInt(id.getText());
        try {
            boolean res = Task2.deleteStudent(studId);
            Stage stage = (Stage) id.getScene().getWindow();
            if (res)
                showInf("Row was deleted!");
            else showError("Row doesn't exist!");
            stage.close();
        } catch (SQLException throwables) {
            showError("Error has happened");
            throwables.printStackTrace();
        }
    }

    @FXML
    void display(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/students.fxml"));
        stage.setTitle("Students");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showInf(String msg) {
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setHeaderText("Info");
        errorAlert.setContentText(msg);
        errorAlert.showAndWait();
    }

    public void showError(String msg) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Error");
        errorAlert.setContentText(msg);
        errorAlert.showAndWait();
    }

}
