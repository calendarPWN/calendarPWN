package pl.pwn.reaktor.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import pl.pwn.reaktor.Main;
import pl.pwn.reaktor.model.Grupa;
import pl.pwn.reaktor.model.Szkolenia;
import pl.pwn.reaktor.util.HibernateUtil;

public class GroupViewController {

    @FXML
    private TextField tfAcronim;

    @FXML
    private TextField tfDataStart;

    @FXML
    private ComboBox<Szkolenia> cmbSzkolenie;

    @FXML
    void zapiszGroup(MouseEvent event) throws IOException {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction trx = session.beginTransaction();
    	
    	Grupa grupa = new Grupa(tfAcronim.getText(), tfDataStart.getText(), cmbSzkolenie.getSelectionModel().getSelectedItem().getId());
    	session.save(grupa);
    	trx.commit();
    	session.close();
    	
    	Parent parent = FXMLLoader.load(getClass().getResource("/view/MainAppView.fxml"));
		Scene scene = new Scene(parent);
		Main.getPrimaryStage().setScene(scene);
    }

    Session session = HibernateUtil.getSessionFactory().openSession();
	
   	Transaction trx = session.beginTransaction();
   	
   	Query query = session.createQuery("FROM Szkolenia");
   	
   	List<Szkolenia> listSzkolenie = query.list();
	ObservableList<Szkolenia> szkolenia = FXCollections.observableArrayList(listSzkolenie);
	
	public void initialize() {

		cmbSzkolenie.setItems((ObservableList<Szkolenia>) szkolenia);

	}
}
