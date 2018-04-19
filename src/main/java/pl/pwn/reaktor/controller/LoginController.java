package pl.pwn.reaktor.controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.Main;
import pl.pwn.reaktor.service.LoginService;

public class LoginController {

    @FXML
    private Button btn_login;

    @FXML
    private TextField tf_login;

    @FXML
    private TextField tf_password;

    @FXML
    void login_action(MouseEvent event) throws IOException, SQLException {
    	String login = tf_login.getText();
		String password = tf_password.getText();
		boolean isLogin = loginService.login(login, password);
		if (isLogin) {
			//Parent parent = FXMLLoader.load(getClass().getResource("/view/CalendarViewTrener.fxml"));
			Parent parent = FXMLLoader.load(getClass().getResource("/view/CourseIssuesSchedule.fxml"));
			Scene scene = new Scene(parent);
			Main.getPrimaryStage().setScene(scene);
		} else {
			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("Error");
			error.setContentText("Enter valid login/password");
			error.setTitle("Wrong login or password");
			error.show();
		}
    }
    private LoginService loginService;

	public void initialize() {
		loginService = new LoginService();
	}

}
