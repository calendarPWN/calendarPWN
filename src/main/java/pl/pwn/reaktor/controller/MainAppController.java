package pl.pwn.reaktor.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.Main;

public class MainAppController {

    @FXML
    private Button btnInsertGroup;

    @FXML
    private Button btnInsertIssuesSchedule;

    @FXML
    private Button btnShowPlan;

    @FXML
    private Button btnInsertTrener;

    @FXML
    void insertGroup(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/GroupView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void insertIssuesSchedule(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/CourseIssuesSchedule.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void insertTrener(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/TrenerView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void showPlan(MouseEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/CalendarViewTrener.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    @FXML
    void quitApp(MouseEvent event) {
    	System.exit(0);
    }
}
