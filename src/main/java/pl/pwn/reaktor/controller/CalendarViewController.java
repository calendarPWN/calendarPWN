package pl.pwn.reaktor.controller;

import java.util.List;
import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import pl.pwn.reaktor.model.Calendar;
import pl.pwn.reaktor.model.CalendarFilter;
import pl.pwn.reaktor.service.CalendarService;

public class CalendarViewController {

	@FXML
	private TableView<Calendar> table_calendar;
	 
    @FXML
    private TableColumn<Calendar, String> col_termin;

    @FXML
    private TableColumn<Calendar, String> col_tematyka;

    @FXML
    private TableColumn<Calendar, String> col_trener;

    @FXML
    private TableColumn<Calendar, String> col_dzien_szkolenia;
    
    @FXML
    private TableColumn<Calendar, String> col_grupa;

    @FXML
    private ComboBox<String> cb_dzien_szkolenia;

    @FXML
    private ComboBox<String> cb_trener;

    @FXML
    private ComboBox<String> cb_tematyka;

    @FXML
    private ComboBox<String> cb_grupa;
    
    @FXML
    private Button btn_wyloguj;

    @FXML
    private Button btn_filtruj;
    
    @FXML
    private Button btn_usun_wiersz;

    @FXML
    void wyloguj(MouseEvent event) {
    	System.exit(0);
    }

    private CalendarService calendarService;

	ObservableList<String> dzien_szkolenia = FXCollections.observableArrayList("1", "2", "3", "4","5");
	ObservableList<String> tematyka = FXCollections.observableArrayList("SQL", "Python", "Java");
	ObservableList<String> trener = FXCollections.observableArrayList("Micha³ Kruczkowski", "Robert Wasik", "Karol Lipiñski");
	ObservableList<String> grupa = FXCollections.observableArrayList("BE-1", "BE-2", "BE-3", "FE-1");

	public void initialize() {
		cb_tematyka.setItems(tematyka);
		cb_trener.setItems(trener);
		cb_dzien_szkolenia.setItems(dzien_szkolenia);
		cb_grupa.setItems(grupa);

		fillCalendarData();

		setCellValue();
		
		// w³¹czenie edytowania w tabeli
		table_calendar.setEditable(true);

		// metoda odpowiedzialna za obs³ugê edycji na poszczególnych polach
		editCells();
	}

	private void fillCalendarData() {
		calendarService = new CalendarService();
		List<Calendar> calendar = calendarService.getAll();

		ObservableList<Calendar> data = FXCollections.observableArrayList(calendar);
		table_calendar.setItems(null);
		table_calendar.setItems(data);
	}

	private void setCellValue() {

		col_termin.setCellValueFactory(new PropertyValueFactory<>("termin"));
		col_tematyka.setCellValueFactory(new PropertyValueFactory<>("tematyka"));
		col_trener.setCellValueFactory(new PropertyValueFactory<>("trener"));
		col_dzien_szkolenia.setCellValueFactory(new PropertyValueFactory<>("dzien_szkolenia"));
		}
	
	
	@FXML
    void usun(MouseEvent event) {

		if (Objects.isNull(table_calendar.getSelectionModel())
				|| Objects.isNull(table_calendar.getSelectionModel().getSelectedItem())) {

			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("ERROR");
			error.setContentText("Please select Item before clicked Delete");
			error.setTitle("No selected item!");
			error.show();
			return;
		}

		long id = table_calendar.getSelectionModel().getSelectedItem().getId();
		calendarService.delete(id);

		fillCalendarData();
	}

	 @FXML
	    void filtruj(MouseEvent event) {

	    String tematykaValue = cb_tematyka.getValue();
		String trenerValue = cb_trener.getValue();
		String dzienSzkoleniaValue = cb_dzien_szkolenia.getValue();
		String grupaValue = cb_grupa.getValue();

		CalendarFilter calendarFilter = new CalendarFilter(tematykaValue, trenerValue, dzienSzkoleniaValue, grupaValue);
		List<Calendar> list = calendarService.filter(calendarFilter);

		ObservableList<Calendar> data = FXCollections.observableArrayList(list);
		table_calendar.setItems(null);
		table_calendar.setItems(data);
	}

	private void editCells() {
		// edycja kolumny termin
		editTerminCell();

		// edycja kolumny tematyka
		editTematykaCell();

		// edycja kolumny trener
		editTrenerCell();

		// edycja kolumny grupa
		editGrupaCell();
		
		// edycja kolumny dzieñ szkolenia
		editDzienSzkoleniaCell();

		}

	private void editTerminCell() {
		col_termin.setCellFactory(TextFieldTableCell.forTableColumn());
		col_termin.setOnEditCommit(new EventHandler<CellEditEvent<Calendar, String>>() {
			@Override
			public void handle(CellEditEvent<Calendar, String> t) {
				((Calendar) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTermin(t.getNewValue());

				Calendar selectedItem = table_calendar.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}
	
	private void editTematykaCell() {
		col_tematyka.setCellFactory(TextFieldTableCell.forTableColumn());
		col_tematyka.setOnEditCommit(new EventHandler<CellEditEvent<Calendar, String>>() {
			@Override
			public void handle(CellEditEvent<Calendar, String> t) {
				((Calendar) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTematyka(t.getNewValue());

				Calendar selectedItem = table_calendar.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}
	
	private void editTrenerCell() {
		col_trener.setCellFactory(TextFieldTableCell.forTableColumn());
		col_trener.setOnEditCommit(new EventHandler<CellEditEvent<Calendar, String>>() {
			@Override
			public void handle(CellEditEvent<Calendar, String> t) {
				((Calendar) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTrener(t.getNewValue());

				Calendar selectedItem = table_calendar.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}
	
	private void editGrupaCell() {
		col_grupa.setCellFactory(TextFieldTableCell.forTableColumn());
		col_grupa.setOnEditCommit(new EventHandler<CellEditEvent<Calendar, String>>() {
			@Override
			public void handle(CellEditEvent<Calendar, String> t) {
				((Calendar) t.getTableView().getItems().get(t.getTablePosition().getRow())).setGrupa(t.getNewValue());

				Calendar selectedItem = table_calendar.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}
	
	private void editDzienSzkoleniaCell() {
		col_dzien_szkolenia.setCellFactory(TextFieldTableCell.forTableColumn());
		col_dzien_szkolenia.setOnEditCommit(new EventHandler<CellEditEvent<Calendar, String>>() {
			@Override
			public void handle(CellEditEvent<Calendar, String> t) {
				((Calendar) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDzienSzkolenia(t.getNewValue());

				Calendar selectedItem = table_calendar.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void updateCell(Calendar selectedItem) {
calendarService.update(selectedItem);
	}
}
