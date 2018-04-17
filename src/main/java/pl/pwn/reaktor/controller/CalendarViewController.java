package pl.pwn.reaktor.controller;

import java.util.List;
import java.util.Objects;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
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

		fillAnkietaData();

		setCallValue();
		
		// w³¹czenie edytowania w tabeli
		table_calendar.setEditable(true);

		// metoda odpowiedzialna za obs³ugê edycji na poszczególnych polach
		editCalls();
	}

	private void fillCalendarData() {
		calendarService = new CalendarService();
		List<Calendar> calendar = calendarService.getAll();

		ObservableList<Calendar> data = FXCollections.observableArrayList(calendar);
		table_calendar.setItems(null);
		table_calendar.setItems(data);
	}

	private void setCallValue() {

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
/*
	private void editCalls() {
		// edycja kolumny name
		editNameCell();

		// edycja kolumny last name
		editLastNameCell();

		// edycja kolumny mail
		editMailCell();

		// edycja kolumny phone
		editPhoneCell();

		// edycja kolumny java
		editJavaCell();

		// edycja kolumny python
		editPythonCell();

		// edycja kolumny other
		editOtherCell();
		
		// edycja kolumny otherDesc
		editOtherDescCell();

		// edycja kolumny Language
		editLanguageCell();

		// edycja kolumny course
		editCourseCell();
	}

	private void editNameCell() {
		col_name.setCellFactory(TextFieldTableCell.forTableColumn());
		col_name.setOnEditCommit(new EventHandler<CellEditEvent<Ankieta, String>>() {
			@Override
			public void handle(CellEditEvent<Ankieta, String> t) {
				((Ankieta) t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());

				Ankieta selectedItem = table_ankieta.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void editLastNameCell() {
		col_lastname.setCellFactory(TextFieldTableCell.forTableColumn());
		col_lastname.setOnEditCommit(new EventHandler<CellEditEvent<Ankieta, String>>() {
			@Override
			public void handle(CellEditEvent<Ankieta, String> t) {
				((Ankieta) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());
				Ankieta selectedItem = table_ankieta.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void editMailCell() {
		col_mail.setCellFactory(TextFieldTableCell.forTableColumn());
		col_mail.setOnEditCommit(new EventHandler<CellEditEvent<Ankieta, String>>() {
			@Override
			public void handle(CellEditEvent<Ankieta, String> t) {
				((Ankieta) t.getTableView().getItems().get(t.getTablePosition().getRow())).setMail(t.getNewValue());
				Ankieta selectedItem = table_ankieta.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void editPhoneCell() {
		col_phone.setCellFactory(TextFieldTableCell.forTableColumn());
		col_phone.setOnEditCommit(new EventHandler<CellEditEvent<Ankieta, String>>() {
			@Override
			public void handle(CellEditEvent<Ankieta, String> t) {
				((Ankieta) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPhone(t.getNewValue());
				Ankieta selectedItem = table_ankieta.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void editJavaCell() {
		col_java.setCellValueFactory(new Callback<CellDataFeatures<Ankieta, Boolean>, ObservableValue<Boolean>>() {

			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Ankieta, Boolean> param) {
				Ankieta ankieta = param.getValue();

				SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(ankieta.getJava());
				// When "Java?" column change.
				booleanProp.addListener(new ChangeListener<Boolean>() {

					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
							Boolean newValue) {
						ankieta.setJava(newValue);

						// update wiersza po edycji pola
						updateCell(ankieta);
					}
				});
				return booleanProp;
			}
		});

		col_java.setCellFactory(new Callback<TableColumn<Ankieta, Boolean>, TableCell<Ankieta, Boolean>>() {
			@Override
			public TableCell<Ankieta, Boolean> call(TableColumn<Ankieta, Boolean> p) {
				CheckBoxTableCell<Ankieta, Boolean> cell = new CheckBoxTableCell<Ankieta, Boolean>();
				cell.setAlignment(Pos.CENTER);
				return cell;
			}
		});
	}

	private void editPythonCell() {
		col_python.setCellValueFactory(new Callback<CellDataFeatures<Ankieta, Boolean>, ObservableValue<Boolean>>() {

			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Ankieta, Boolean> param) {
				Ankieta ankieta = param.getValue();

				SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(ankieta.getPython());
				// When "Python?" column change.
				booleanProp.addListener(new ChangeListener<Boolean>() {

					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
							Boolean newValue) {
						ankieta.setPython(newValue);

						// update wiersza po edycji pola
						updateCell(ankieta);
					}
				});
				return booleanProp;
			}
		});

		col_python.setCellFactory(new Callback<TableColumn<Ankieta, Boolean>, TableCell<Ankieta, Boolean>>() {
			@Override
			public TableCell<Ankieta, Boolean> call(TableColumn<Ankieta, Boolean> p) {
				CheckBoxTableCell<Ankieta, Boolean> cell = new CheckBoxTableCell<Ankieta, Boolean>();
				cell.setAlignment(Pos.CENTER);
				return cell;
			}
		});
	}
	
	private void editOtherCell() {
		col_other.setCellValueFactory(new Callback<CellDataFeatures<Ankieta, Boolean>, ObservableValue<Boolean>>() {

			@Override
			public ObservableValue<Boolean> call(CellDataFeatures<Ankieta, Boolean> param) {
				Ankieta ankieta = param.getValue();

				SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(ankieta.getOther());
				// When "Other?" column change.
				booleanProp.addListener(new ChangeListener<Boolean>() {

					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
							Boolean newValue) {
						ankieta.setOther(newValue);

						// update wiersza po edycji pola
						updateCell(ankieta);
					}
				});
				return booleanProp;
			}
		});

		col_other.setCellFactory(new Callback<TableColumn<Ankieta, Boolean>, TableCell<Ankieta, Boolean>>() {
			@Override
			public TableCell<Ankieta, Boolean> call(TableColumn<Ankieta, Boolean> p) {
				CheckBoxTableCell<Ankieta, Boolean> cell = new CheckBoxTableCell<Ankieta, Boolean>();
				cell.setAlignment(Pos.CENTER);
				return cell;
			}
		});
	}

	private void editOtherDescCell() {
		col_otherdesc.setCellFactory(TextFieldTableCell.forTableColumn());
		col_otherdesc.setOnEditCommit(new EventHandler<CellEditEvent<Ankieta, String>>() {
			@Override
			public void handle(CellEditEvent<Ankieta, String> t) {
				((Ankieta) t.getTableView().getItems().get(t.getTablePosition().getRow()))
						.setOtherDesc(t.getNewValue());
				Ankieta selectedItem = table_ankieta.getSelectionModel().getSelectedItem();
				// update wiersza po edycji pola
				updateCell(selectedItem);
			}
		});
	}

	private void editCourseCell() {
		ObservableList<String> courses = FXCollections.observableArrayList("Back-end", "Front-end", "Web developere",
				"Tester");
		
		col_course.setCellValueFactory(new Callback<CellDataFeatures<Ankieta, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Ankieta, String> param) {
				Ankieta ankieta = param.getValue();

				String course = ankieta.getCourse();
				return new SimpleObjectProperty<String>(course);
			}
		});
		col_course.setCellFactory(ComboBoxTableCell.forTableColumn(courses));
		col_course.setOnEditCommit((CellEditEvent<Ankieta, String> event) -> {
			TablePosition<Ankieta, String> pos = event.getTablePosition();

			String newCourse = event.getNewValue();
			int row = pos.getRow();
			Ankieta ankieta = event.getTableView().getItems().get(row);
			ankieta.setCourse(newCourse);

			// update wiersza po edycji pola
			updateCell(ankieta);
		});
	}

	private void editLanguageCell() {
		ObservableList<String> langueages = FXCollections.observableArrayList("Basic", "Intermediate", "Advanced");

		col_language.setCellValueFactory(new Callback<CellDataFeatures<Ankieta, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Ankieta, String> param) {
				Ankieta ankieta = param.getValue();

				String course = ankieta.getLanguage();
				return new SimpleObjectProperty<String>(course);
			}
		});
		col_language.setCellFactory(ComboBoxTableCell.forTableColumn(langueages));
		col_language.setOnEditCommit((CellEditEvent<Ankieta, String> event) -> {
			TablePosition<Ankieta, String> pos = event.getTablePosition();

			String newLanguage = event.getNewValue();
			int row = pos.getRow();
			Ankieta ankieta = event.getTableView().getItems().get(row);
			ankieta.setLanguage(newLanguage);
			// update wiersza po edycji pola
			updateCell(ankieta);
		});
	}

	private void updateCell(Ankieta selectedItem) {
ankietaService.update(selectedItem);
	}*/
}
