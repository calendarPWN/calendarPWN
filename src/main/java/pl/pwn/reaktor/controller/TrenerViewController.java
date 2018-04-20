package pl.pwn.reaktor.controller;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.Main;
import pl.pwn.reaktor.model.Trener;
import pl.pwn.reaktor.util.HibernateUtil;

public class TrenerViewController {

    @FXML
    private TextField tfImie;

    @FXML
    private TextField tfNazwisko;

    @FXML
    private TextField tfInicjaly;

    @FXML
    private ComboBox<String> cmbMentor;

    @FXML
    private Button btnZapiszTrenera;

    @FXML
    void zapiszTrenera(MouseEvent event) throws IOException {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction trx = session.beginTransaction();
    	Boolean mentor = null;
    	
    	if ("Tak".equals(cmbMentor.getSelectionModel().getSelectedItem().toString())) {
    		mentor = true;
    	} else {
    		mentor = false;
    	}
    	
    	Trener trener = new Trener(tfImie.getText(), tfNazwisko.getText(), tfInicjaly.getText(), mentor);
    	session.save(trener);
    	trx.commit();
    	session.close();
    	
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/MainAppView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }
    
    public void initialize() {

    	ObservableList<String> mentor = FXCollections.observableArrayList("Tak", "Nie");
		cmbMentor.setItems((ObservableList<String>) mentor);

	}
}
