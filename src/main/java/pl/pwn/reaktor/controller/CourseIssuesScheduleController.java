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
import pl.pwn.reaktor.model.Grupa;
import pl.pwn.reaktor.model.Kolejnosc;
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
    private ComboBox<Grupa> cmbKurs;

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
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
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
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
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
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
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
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
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
    	
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
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
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	Long id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
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
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	Long id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
    	Long id8 = cmbIssue08.getSelectionModel().getSelectedItem().getId();
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
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	Long id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
    	Long id8 = cmbIssue08.getSelectionModel().getSelectedItem().getId();
    	Long id9 = cmbIssue09.getSelectionModel().getSelectedItem().getId();
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
    	Long id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	Long id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	Long id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	Long id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	Long id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	Long id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	Long id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
    	Long id8 = cmbIssue08.getSelectionModel().getSelectedItem().getId();
    	Long id9 = cmbIssue09.getSelectionModel().getSelectedItem().getId();
    	Long id10 = cmbIssue10.getSelectionModel().getSelectedItem().getId();
    	Long id11 = cmbIssue11.getSelectionModel().getSelectedItem().getId();
    	
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
    	cmbKurs.setItems((ObservableList<Grupa>) groups);
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
		lblSumaDni.setText("0");
    }

    @FXML
    void zapisz(MouseEvent event) {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	Transaction trx = session.beginTransaction();
    	
    	//Long idGrupy = cmbKurs.getSelectionModel().getSelectedItem().getId();
    	Long idSzkolenia = cmbKurs.getSelectionModel().getSelectedItem().getIdSzkolenie();
    	
    	Long id1 = null;
    	Long id2 = null;
    	Long id3 = null;
    	Long id4 = null;
    	Long id5 = null;
    	Long id6 = null;
    	Long id7 = null;
    	Long id8 = null;
    	Long id9 = null;
    	Long id10 = null;
    	Long id11 = null;
    	Long id12 = null;
    	
    	Long liczbaDni01 = null;
    	Long liczbaDni02 = null;
    	Long liczbaDni03 = null;
    	Long liczbaDni04 = null;
    	Long liczbaDni05 = null;
    	Long liczbaDni06 = null;
    	Long liczbaDni07 = null;
    	Long liczbaDni08 = null;
    	Long liczbaDni09 = null;
    	Long liczbaDni10 = null;
    	Long liczbaDni11 = null;
    	Long liczbaDni12 = null;
    	
    	
    	
    	if (!Objects.isNull(cmbIssue01.getSelectionModel().getSelectedItem())) {
    		id1 = cmbIssue01.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue02.getSelectionModel().getSelectedItem())) {
    		id2 = cmbIssue02.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue03.getSelectionModel().getSelectedItem())) {
    		id3 = cmbIssue03.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue04.getSelectionModel().getSelectedItem())) {
    		id4 = cmbIssue04.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue05.getSelectionModel().getSelectedItem())) {
    		id5 = cmbIssue05.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue06.getSelectionModel().getSelectedItem())) {
    		id6 = cmbIssue06.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue07.getSelectionModel().getSelectedItem())) {
    		id7 = cmbIssue07.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue08.getSelectionModel().getSelectedItem())) {
    		id8 = cmbIssue08.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue09.getSelectionModel().getSelectedItem())) {
    		id9 = cmbIssue09.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue10.getSelectionModel().getSelectedItem())) {
    		id10 = cmbIssue10.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue11.getSelectionModel().getSelectedItem())) {
    		id11 = cmbIssue11.getSelectionModel().getSelectedItem().getId();
    	}
    	if (!Objects.isNull(cmbIssue12.getSelectionModel().getSelectedItem())) {
    		id12 = cmbIssue12.getSelectionModel().getSelectedItem().getId();
    	}
    	
    	if (!"".equals(txtLiczbaDniIssue01.getText())) {
    		liczbaDni01 = Long.valueOf(txtLiczbaDniIssue01.getText());
    	} else {
    		liczbaDni01 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue02.getText())) {
    		liczbaDni02 = Long.valueOf(txtLiczbaDniIssue02.getText());
    	} else {
    		liczbaDni02 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue03.getText())) {
    		liczbaDni03 = Long.valueOf(txtLiczbaDniIssue03.getText());
    	} else {
    		liczbaDni03 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue04.getText())) {
    		liczbaDni04 = Long.valueOf(txtLiczbaDniIssue04.getText());
    	} else {
    		liczbaDni04 = 0L;
    	}if (!"".equals(txtLiczbaDniIssue05.getText())) {
    		liczbaDni05 = Long.valueOf(txtLiczbaDniIssue05.getText());
    	} else {
    		liczbaDni05 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue06.getText())) {
    		liczbaDni06 = Long.valueOf(txtLiczbaDniIssue06.getText());
    	} else {
    		liczbaDni06 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue07.getText())) {
    		liczbaDni07 = Long.valueOf(txtLiczbaDniIssue07.getText());
    	} else {
    		liczbaDni07 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue08.getText())) {
    		liczbaDni08 = Long.valueOf(txtLiczbaDniIssue08.getText());
    	} else {
    		liczbaDni08 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue09.getText())) {
    		liczbaDni09 = Long.valueOf(txtLiczbaDniIssue09.getText());
    	} else {
    		liczbaDni09 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue10.getText())) {
    		liczbaDni10 = Long.valueOf(txtLiczbaDniIssue10.getText());
    	} else {
    		liczbaDni10 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue11.getText())) {
    		liczbaDni11 = Long.valueOf(txtLiczbaDniIssue11.getText());
    	} else {
    		liczbaDni11 = 0L;
    	}
    	if (!"".equals(txtLiczbaDniIssue12.getText())) {
    		liczbaDni12 = Long.valueOf(txtLiczbaDniIssue12.getText());
    	} else {
    		liczbaDni12 = 0L;
    	}
    	
    	String tempKolejnosc = "";
    	
    	if (!Objects.isNull(id1)) {
    		tempKolejnosc = id1.toString() + "," + liczbaDni01.toString();
    	}
    	if (!Objects.isNull(id2)) {
    		tempKolejnosc += ";" + id2.toString() + "," + liczbaDni02.toString();
    	}
    	if (!Objects.isNull(id3)) {
    		tempKolejnosc += ";" + id3.toString() + "," + liczbaDni03.toString();
    	}
    	if (!Objects.isNull(id4)) {
    		tempKolejnosc += ";" + id4.toString() + "," + liczbaDni04.toString();
    	}
    	if (!Objects.isNull(id5)) {
    		tempKolejnosc += ";" + id5.toString() + "," + liczbaDni05.toString();
    	}
    	if (!Objects.isNull(id6)) {
    		tempKolejnosc += ";" + id6.toString() + "," + liczbaDni06.toString();
    	}
    	if (!Objects.isNull(id7)) {
    		tempKolejnosc += ";" + id7.toString() + "," + liczbaDni07.toString();
    	}
    	if (!Objects.isNull(id8)) {
    		tempKolejnosc += ";" + id8.toString() + "," + liczbaDni08.toString();
    	}
    	if (!Objects.isNull(id9)) {
    		tempKolejnosc += ";" + id9.toString() + "," + liczbaDni09.toString();
    	}
    	if (!Objects.isNull(id10)) {
    		tempKolejnosc += ";" + id10.toString() + "," + liczbaDni10.toString();
    	}
    	if (!Objects.isNull(id11)) {
    		tempKolejnosc += ";" + id11.toString() + "," + liczbaDni11.toString();
    	}
    	if (!Objects.isNull(id12)) {
    		tempKolejnosc += ";" + id12.toString() + "," + liczbaDni12.toString();
    	}
    	System.out.println(tempKolejnosc);
    	Kolejnosc kolejnosc = new Kolejnosc(tempKolejnosc, idSzkolenia);
    	session.save(kolejnosc);
    	trx.commit();
    	session.close();
    }
    
    Session session = HibernateUtil.getSessionFactory().openSession();
    	
	Transaction trx = session.beginTransaction();
	
	Query query = session.createQuery("FROM TematySzkolen");
	
	List<TematySzkolen> listTematySzkolen = query.list();
	ObservableList<TematySzkolen> issues = FXCollections.observableArrayList(listTematySzkolen);
	
	Query query2 = session.createQuery("FROM Grupa");
	
	List<Grupa> listGrupy = query2.list();  
	ObservableList<Grupa> groups = FXCollections.observableArrayList(listGrupy);
	
	public void initialize() {

		cmbKurs.setItems((ObservableList<Grupa>) groups);
		cmbIssue01.setItems((ObservableList<TematySzkolen>) issues);

	}
}
