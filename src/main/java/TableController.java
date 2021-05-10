package main.java;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class TableController {
    @FXML
    private TableView<Student> table;
    private List<Student> students;
    @FXML
    private TableColumn<Student, Integer> idCol;

    @FXML
    private TableColumn<Student, String> fNameCol;

    @FXML
    private TableColumn<Student, String> mNameCol;

    @FXML
    private TableColumn<Student, String> lNameCol;

    @FXML
    private TableColumn<Student, Date> bdCol;

    @FXML
    private TableColumn<Student, String> groupCol;

    @FXML
    public void initialize() {
        try {
            students = Task2.getStudents();
        } catch (SQLException throwables) {

            throwables.printStackTrace();
            return;
        }

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        mNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        bdCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        groupCol.setCellValueFactory(new PropertyValueFactory<>("group"));

        table.getItems().setAll(students);
    }
}
