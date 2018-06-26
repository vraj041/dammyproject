package com.everest.amcu.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.everest.amcu.config.SpringBoot;
import com.everest.amcu.model.District;
import com.everest.amcu.model.State;
import com.everest.amcu.model.User;
import com.everest.amcu.service.Services;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Maincontroller implements Initializable {

	@FXML
	private CheckBox chkConform;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtFirstname;

	@FXML
	private TextField txtLastname;

	@FXML
	private TextField txtMobile;

	@FXML
	private ComboBox<String> cboxState;

	@FXML
	private ComboBox<District> cboxDistrict;

	@FXML
	private Button btnOk;

	@FXML
	private Button btnView;
	@FXML
	private TableColumn<User, State> colState;

	@FXML
	private TableColumn<User, District> colDistrict;

	private Services service;

	public Maincontroller() {

		service = SpringBoot.getContext().getBean(Services.class);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cboxState.getItems().addAll("A","B","C","D","E");
		btnOk.setOnAction(e -> {
			if (chkConform.isSelected() == true) {
				System.out.println("save method call.......");
				savepersondata();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Warning");
				alert.setContentText("Please Conform your data");
				alert.showAndWait();
			}

		});

		btnView.setOnAction(e -> {
			Stage stage = new Stage();

			AnchorPane pane = null;
			try {
				pane = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/Viewandedit.fxml"));
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();

		});
	}

	private void savepersondata() {
		System.out.println("save method call");
		User insertobj = new User();
		setValue(insertobj);
		if (validate(insertobj)) {
			/*if (personService.checkCode(person.getCode())) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Look at the Error");
				alert.setContentText("Person code is Duplicate.");
				alert.showAndWait();
			} else {
				insert(person, personLocal);
			}*/
			insert(insertobj);
		}

		clearControls();

	}

	private boolean validate(User insertobj) {
		return true;
	}

	//// if (cboxState.getSelectionModel().getSelectedItem() == null) {
	// message += ("Plz,select State") + "\n";
	// }
	// if (cboxDistrict.getSelectionModel().getSelectedItem() == null) {
	// message += ("Plz,select District") + "\n";
	// }
	// return false;
	// }

	public void clearControls() {
		txtId.setText("");
		txtFirstname.setText("");
		txtLastname.setText("");
		txtMobile.setText("");

	}

	private void insert(User insertobj) {
		if (service.insert(insertobj)) {
			System.out.println("insert method done");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setContentText("Record Saved Successfully..");
			alert.showAndWait();
		} else {
			System.out.println("not run");
		}

	}

	private void setValue(User insertobj) {

		System.out.println("set value call");
		insertobj.setId(Integer.parseInt(txtId.getText()));
		System.out.println(insertobj.getId());
		insertobj.setFirstname(txtFirstname.getText());
		System.out.println(insertobj.getFirstname());
		insertobj.setLastname(txtLastname.getText());
		insertobj.setMobile(txtMobile.getText());
		// insertobj.setState(cboxState.getAccessibleText());
		System.out.println(insertobj.getMobile());
		// insertobj.setState(cboxState.getAccessibleText());
		// insertobj.setDistrict(cboxDistrict.getAccessibleText());
	}

}
