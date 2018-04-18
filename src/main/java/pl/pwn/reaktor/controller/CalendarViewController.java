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
    private TableColumn<Calendar, String> col_weekend;

    @FXML
    private ComboBox<String> cb_weekend;

    @FXML
    private ComboBox<String> cb_trener;

    @FXML
    private ComboBox<String> cb_tematyka;

    @FXML
    private ComboBox<String> cb_termin;

    @FXML
    private ComboBox<String> cb_grupa;
    
    @FXML
    private Button btn_wyloguj;

    @FXML
    private Button btn_filtruj;

    @FXML
    void wyloguj(MouseEvent event) {
    	System.exit(0);
    }

    private CalendarService calendarService;

	ObservableList<String> termin = FXCollections.observableArrayList("1", "2", "3", "4");
	ObservableList<String> tematyka = FXCollections.observableArrayList("SQL", "Python", "Java");
	ObservableList<String> trener = FXCollections.observableArrayList("Micha³ Kruczkowski", "Robert Wasik", "Karol Lipiñski");
	ObservableList<String> weekend = FXCollections.observableArrayList("1", "2", "3");
	ObservableList<String> grupa = FXCollections.observableArrayList("Backend", "Frontend");

	public void initialize() {
		cb_termin.setItems(termin);
		cb_tematyka.setItems(tematyka);
		cb_trener.setItems(trener);
		cb_weekend.setItems(weekend);
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
		col_weekend.setCellValueFactory(new PropertyValueFactory<>("weekend"));
		}
	//usuwanie chyba te¿ trzeba bêdzie jakieœ zrobiæ, zostawiam w tym miejscu wzorzec z ankiety - Wojtek
	/*@FXML
	void delete(MouseEvent event) {

		if (Objects.isNull(table_ankieta.getSelectionModel())
				|| Objects.isNull(table_ankieta.getSelectionModel().getSelectedItem())) {

			Alert error = new Alert(AlertType.ERROR);
			error.setHeaderText("ERROR");
			error.setContentText("Please select Item before clicked Delete");
			error.setTitle("No selected item!");
			error.show();
			return;
		}

		long id = table_ankieta.getSelectionModel().getSelectedItem().getId();
		ankietaService.delete(id);

		fillAnkietaData();
	}*/

	 @FXML
	    void filtruj(MouseEvent event) {

	    String terminValue = cb_termin.getValue();
		String tematykaValue = cb_tematyka.getValue();
		String trenerValue = cb_trener.getValue();
		String weekendValue = cb_weekend.getValue();
		String grupaValue = cb_grupa.getValue();

		CalendarFilter calendarFilter = new CalendarFilter(terminValue, tematykaValue, trenerValue, weekendValue, grupaValue);
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

		// edycja kolumny weekend
		editWeekendCell();

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
	
	private void editWeekendCell() {
		col_weekend.setCellFactory(TextFieldTableCell.forTableColumn());
		col_weekend.setOnEditCommit(new EventHandler<CellEditEvent<Calendar, String>>() {
			@Override
			public void handle(CellEditEvent<Calendar, String> t) {
				((Calendar) t.getTableView().getItems().get(t.getTablePosition().getRow())).setWeekend(t.getNewValue());

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
