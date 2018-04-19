package pl.pwn.reaktor.controller;

import java.util.List;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import pl.pwn.reaktor.util.HibernateUtil;
import pl.pwn.reaktor.model.TematySzkolen;
import pl.pwn.reaktor.model.Szkolenia;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class CourseIssuesScheduleController {

    @FXML
    private ComboBox<Szkolenia> cmbKurs;

    @FXML
    private Label lblKurs;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue01;

    @FXML
    private TextField txtLiczbaDniIssue01;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue02;

    @FXML
    private TextField txtLiczbaDniIssue02;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue03;

    @FXML
    private TextField txtLiczbaDniIssue03;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue04;

    @FXML
    private TextField txtLiczbaDniIssue04;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue05;

    @FXML
    private TextField txtLiczbaDniIssue05;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue06;

    @FXML
    private TextField txtLiczbaDniIssue06;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue07;

    @FXML
    private TextField txtLiczbaDniIssue07;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue08;

    @FXML
    private TextField txtLiczbaDniIssue08;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue09;

    @FXML
    private TextField txtLiczbaDniIssue09;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue10;

    @FXML
    private TextField txtLiczbaDniIssue10;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue11;

    @FXML
    private TextField txtLiczbaDniIssue11;

    @FXML
    private ComboBox<TematySzkolen> cmbIssue12;

    @FXML
    private TextField txtLiczbaDniIssue12;

    @FXML
    private Label lblSumaDni;

    @FXML
    private Button btnZapisz;

    @FXML
    private Button btnClearForm;
    
    @FXML
    void addLDI01(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue01.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI02(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue02.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI03(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue03.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI04(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue04.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI05(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue05.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI06(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue06.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI07(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue07.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI08(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue08.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI09(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue09.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI10(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue10.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI11(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue11.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }

    @FXML
    void addLDI12(ActionEvent event) {
    	String sumaDniString = lblSumaDni.getText();
    	
    	Long sumaDni = Long.valueOf(sumaDniString);
    	
    	if (Objects.isNull(sumaDni)) {
    		sumaDni = 0L;
    	}
    	sumaDni += Long.valueOf(txtLiczbaDniIssue12.getText());
    	lblSumaDni.setText(sumaDni.toString());
    }
    
    @FXML
    void updateCMB02(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Query query = session.createQuery("FROM TematySzkolen WHERE id!=:id1");
    	query.setLong("id1", id1);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue02.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB03(ActionEvent event) {
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue03.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB04(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	cmbIssue02.getSelectionModel();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	cmbIssue03.getSelectionModel();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2 AND id != :id3");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	query.setLong("id3", id3);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue04.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB05(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	cmbIssue02.getSelectionModel();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	cmbIssue03.getSelectionModel();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	cmbIssue04.getSelectionModel();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2 AND id != :id3 AND id != :id4");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	query.setLong("id3", id3);
    	query.setLong("id4", id4);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue05.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB06(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	cmbIssue02.getSelectionModel();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	cmbIssue03.getSelectionModel();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	cmbIssue04.getSelectionModel();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	cmbIssue05.getSelectionModel();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2 AND id != :id3 AND id != :id4 AND id != :id5");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	query.setLong("id3", id3);
    	query.setLong("id4", id4);
    	query.setLong("id5", id5);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue06.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB07(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	cmbIssue02.getSelectionModel();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	cmbIssue03.getSelectionModel();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	cmbIssue04.getSelectionModel();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	cmbIssue05.getSelectionModel();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	cmbIssue06.getSelectionModel();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2 AND id != :id3 AND id != :id4 AND id != :id5 AND id !=:id6");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	query.setLong("id3", id3);
    	query.setLong("id4", id4);
    	query.setLong("id5", id5);
    	query.setLong("id6", id6);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue07.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB08(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	cmbIssue02.getSelectionModel();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	cmbIssue03.getSelectionModel();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	cmbIssue04.getSelectionModel();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	cmbIssue05.getSelectionModel();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	cmbIssue06.getSelectionModel();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	cmbIssue07.getSelectionModel();
    	Long id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2 AND id != :id3 AND id != :id4 AND id != :id5 AND id != :id6 AND id != :id7");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	query.setLong("id3", id3);
    	query.setLong("id4", id4);
    	query.setLong("id5", id5);
    	query.setLong("id6", id6);
    	query.setLong("id7", id7);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue08.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB09(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	cmbIssue02.getSelectionModel();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	cmbIssue03.getSelectionModel();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	cmbIssue04.getSelectionModel();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	cmbIssue05.getSelectionModel();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	cmbIssue06.getSelectionModel();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	cmbIssue07.getSelectionModel();
    	Long id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
    	cmbIssue08.getSelectionModel();
    	Long id8 = cmbIssue08.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2 AND id != :id3 AND id != :id4 AND id != :id5 AND id != :id6 AND id != :id7 AND id != :id8");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	query.setLong("id3", id3);
    	query.setLong("id4", id4);
    	query.setLong("id5", id5);
    	query.setLong("id6", id6);
    	query.setLong("id7", id7);
    	query.setLong("id8", id8);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue09.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB10(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	cmbIssue02.getSelectionModel();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	cmbIssue03.getSelectionModel();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	cmbIssue04.getSelectionModel();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	cmbIssue05.getSelectionModel();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	cmbIssue06.getSelectionModel();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	cmbIssue07.getSelectionModel();
    	Long id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
    	cmbIssue08.getSelectionModel();
    	Long id8 = cmbIssue08.getSelectionModel().getSelectedItem().getId();
    	cmbIssue09.getSelectionModel();
    	Long id9 = cmbIssue09.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2 AND id != :id3 AND id != :id4 AND id != :id5 AND id != :id6 AND id != :id7 AND id != :id8 AND id != :id9");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	query.setLong("id3", id3);
    	query.setLong("id4", id4);
    	query.setLong("id5", id5);
    	query.setLong("id6", id6);
    	query.setLong("id7", id7);
    	query.setLong("id8", id8);
    	query.setLong("id9", id9);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue10.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB11(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	cmbIssue02.getSelectionModel();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	cmbIssue03.getSelectionModel();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	cmbIssue04.getSelectionModel();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	cmbIssue05.getSelectionModel();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	cmbIssue06.getSelectionModel();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	cmbIssue07.getSelectionModel();
    	Long id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
    	cmbIssue08.getSelectionModel();
    	Long id8 = cmbIssue08.getSelectionModel().getSelectedItem().getId();
    	cmbIssue09.getSelectionModel();
    	Long id9 = cmbIssue09.getSelectionModel().getSelectedItem().getId();
    	cmbIssue10.getSelectionModel();
    	Long id10 = cmbIssue10.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2 AND id != :id3 AND id != :id4 AND id != :id5 AND id != :id6 AND id != :id7 AND id != :id8 AND id != :id9 AND id != :id10");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	query.setLong("id3", id3);
    	query.setLong("id4", id4);
    	query.setLong("id5", id5);
    	query.setLong("id6", id6);
    	query.setLong("id7", id7);
    	query.setLong("id8", id8);
    	query.setLong("id9", id9);
    	query.setLong("id10", id10);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue11.setItems((ObservableList<TematySzkolen>) issues);
    }

    @FXML
    void updateCMB12(ActionEvent event) {
    	cmbIssue01.getSelectionModel();
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	cmbIssue02.getSelectionModel();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	cmbIssue03.getSelectionModel();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	cmbIssue04.getSelectionModel();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	cmbIssue05.getSelectionModel();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	cmbIssue06.getSelectionModel();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	cmbIssue07.getSelectionModel();
    	Long id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
    	cmbIssue08.getSelectionModel();
    	Long id8 = cmbIssue08.getSelectionModel().getSelectedItem().getId();
    	cmbIssue09.getSelectionModel();
    	Long id9 = cmbIssue09.getSelectionModel().getSelectedItem().getId();
    	cmbIssue10.getSelectionModel();
    	Long id10 = cmbIssue10.getSelectionModel().getSelectedItem().getId();
    	cmbIssue11.getSelectionModel();
    	Long id11 = cmbIssue10.getSelectionModel().getSelectedItem().getId();
    	
    	Query query = session.createQuery("FROM TematySzkolen WHERE id != :id1 AND id != :id2 AND id != :id3 AND id != :id4 AND id != :id5 AND id != :id6 AND id != :id7 AND id != :id8 AND id != :id9 AND id != :id10 AND id != :id11");
    	query.setLong("id1", id1);
    	query.setLong("id2", id2);
    	query.setLong("id3", id3);
    	query.setLong("id4", id4);
    	query.setLong("id5", id5);
    	query.setLong("id6", id6);
    	query.setLong("id7", id7);
    	query.setLong("id8", id8);
    	query.setLong("id9", id9);
    	query.setLong("id10", id10);
    	query.setLong("id11", id11);
    	List<TematySzkolen> listTematySzkolen = query.list();
    	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
    	cmbIssue11.setItems((ObservableList<TematySzkolen>) issues);
    }
    @FXML
    void clearForm(MouseEvent event) {
    	txtLiczbaDniIssue01.setText("");
    	txtLiczbaDniIssue02.setText("");
    	txtLiczbaDniIssue03.setText("");
    	txtLiczbaDniIssue04.setText("");
    	txtLiczbaDniIssue05.setText("");
    	txtLiczbaDniIssue06.setText("");
    	txtLiczbaDniIssue07.setText("");
    	txtLiczbaDniIssue08.setText("");
    	txtLiczbaDniIssue09.setText("");
    	txtLiczbaDniIssue10.setText("");
    	txtLiczbaDniIssue11.setText("");
    	txtLiczbaDniIssue12.setText("");
    	cmbKurs.setItems((ObservableList<Szkolenia>) courses);
		cmbIssue01.setItems((ObservableList<TematySzkolen>) issues);
		cmbIssue02.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue03.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue04.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue05.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue06.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue07.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue08.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue09.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue10.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue11.setItems((ObservableList<TematySzkolen>) null);
		cmbIssue12.setItems((ObservableList<TematySzkolen>) null);
    }

    Session session = HibernateUtil.getSessionFactory().openSession();
    	
	Transaction trx = session.beginTransaction();
	
	Query query = session.createQuery("FROM TematySzkolen");
	
	List<TematySzkolen> listTematySzkolen = query.list();
	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
	
	Query query2 = session.createQuery("FROM Szkolenia");
	
	List<Szkolenia> listSzkolenia = query2.list();  
	ObservableList<Szkolenia> courses = FXCollections.observableArrayList(listSzkolenia);
	
	public void initialize() {

		cmbKurs.setItems((ObservableList<Szkolenia>) courses);
		cmbIssue01.setItems((ObservableList<TematySzkolen>) issues);

	}
}
