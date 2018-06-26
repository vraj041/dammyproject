package com.everest.amcu.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.everest.amcu.config.SpringBoot;
import com.everest.amcu.model.User;
import com.everest.amcu.service.Services;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
//import com.lowagie.text.pdf.TextField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Viewcontroller implements Initializable {

	@FXML
	private TextField txt_id;

	@FXML
	private TextField txt_firstname;

	@FXML
	private TextField txt_lastname;

	@FXML
	private TextField txt_num;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnDelete;

	@FXML
	private AnchorPane gridviewAnchor;

	@FXML
	private VBox vbox;

	@FXML
	private TableView<User> tableData;

	@FXML
	private TableColumn<User, Number> colid;

	@FXML
	private TableColumn<User, String> colFirstName;

	@FXML
	private TableColumn<User, String> colLastName;

	@FXML
	private TableColumn<User, String> colMobileNum;

	@FXML
	private TableColumn<User, String> colState;

	@FXML
	private TableColumn<User, String> colDistrict;

	@FXML
	private ComboBox<String> cboxstate;

	@FXML
	private ComboBox<String> cboxdistric;

	private ObservableList<User> listdata;

	private Services service;

	private User user, user1;

	private ObjectProperty<User> objectPro;

	public Viewcontroller() {
		objectPro = new SimpleObjectProperty<>();
		listdata = FXCollections.observableArrayList();

		service = SpringBoot.getContext().getBean(Services.class);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println("intiallize method");
		vbox.getChildren().remove(gridviewAnchor);

		btnEdit.setOnAction(e -> {
			user1 = objectPro.get();
			if (user1 != null) {
				if (btnEdit.getText().equals("Edit")) {
					if (vbox.getChildren().size() != 4) {
						vbox.getChildren().add(3, gridviewAnchor);

						btnDelete.setText("Cancel");
						btnEdit.setText("Update");
						txt_id.setDisable(true);
						loadControls(user1);

					}
				} else {
					System.out.println("update method call");
					Update(user1);
				}
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Information");
				alert.setContentText("first Select Value");
				alert.showAndWait();
			}

		});

		System.out.println("load call.....");
		loadData();
		setupTable();

		btnDelete.setOnAction(e -> {
			user = objectPro.get();
			if (user != null) {
				if (btnDelete.getText().equals("Delete")) {
					delete(user);
				} else {
					btnDelete.setOnAction(ee -> Platform.exit());
				}

			} else if (btnDelete.getText().equals("Cancel")) {
				btnDelete.setOnAction(ee -> Platform.exit());
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Information");
				alert.setContentText("first Select Value");
				alert.showAndWait();
			}

		});
	}

	private void loadControls(User user12) {
		txt_id.setText(String.valueOf(user12.getId()));
		txt_firstname.setText(user12.getFirstname());
		txt_lastname.setText(user12.getLastname());
		txt_num.setText(String.valueOf(user12.getMobile()));

	}

	private void Update(User user1) {
		user1.setFirstname(txt_firstname.getText());
		user1.setLastname(txt_lastname.getText());
		user1.setMobile(txt_num.getText());
		if (service.update(user1)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setContentText("Record Updated Successfully..");
			alert.showAndWait();
			vbox.getChildren().remove(3);
			btnEdit.setText("Edit");

			loadData();
		}

	}

	private void delete(User user) {

		if (service.delete(user)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setContentText("Record Deleted Successfully..");
			alert.showAndWait();
			loadData();
		}

	}

	private void setupTable() {

		System.out.println("setup table");
		// colStateCode.setCellValueFactory(data -> new
		// SimpleStringProperty(data.getValue().getStateCode()));
		colid.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getId()));

		// colFirstName.setCellValueFactory(new PropertyValueFactory<User,
		// String>("firstName"));
		colFirstName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFirstname()));
		colLastName.setCellValueFactory(new PropertyValueFactory<User, String>("Lastname"));
		colMobileNum.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMobile()));

		// colState.setCellValueFactory(data -> new
		// SimpleStringProperty(data.getValue().getState()));

		// colDistrict.setCellValueFactory(new PropertyValueFactory<User,
		// String>("district"));

		objectPro.bind(tableData.getSelectionModel().selectedItemProperty());

	}

	private void loadData() {
		System.out.println("load call");

		listdata = FXCollections.observableArrayList(service.fetchAll());
		System.out.println("listdata complete");
		tableData.setItems(listdata);

	}

}