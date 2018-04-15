package pl.pwn.reaktor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

public class CalendarViewController {

    @FXML
    private TableColumn<?, ?> col_termin;

    @FXML
    private TableColumn<?, ?> col_tematyka;

    @FXML
    private TableColumn<?, ?> col_trener;

    @FXML
    private TableColumn<?, ?> col_weekend;

    @FXML
    private ComboBox<?> cb_weekend;

    @FXML
    private ComboBox<?> cb_trener;

    @FXML
    private ComboBox<?> cb_tematyka;

    @FXML
    private ComboBox<?> cb_termin;

    @FXML
    private Button btn_wyloguj;

    @FXML
    private ComboBox<?> cb_grupa;

    @FXML
    void wyloguj(MouseEvent event) {

    }

}
