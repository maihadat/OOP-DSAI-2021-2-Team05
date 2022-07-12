package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import javafx.event.ActionEvent;

public class MainSceneController {
	private FXMLLoader loader;
	private Stage stage;
	private Parent root;
	private Scene scene;
	protected String algochoice = new String();
	@FXML

	protected Button Quit;
	@FXML
	private AnchorPane scenePane;
	@FXML
	protected Button helpButton ;
	
    @FXML
    private ToggleGroup AlgoChoice;
	
	@FXML
	private Button Start;
	@FXML
	void Start(ActionEvent event) throws IOException {
		
		RadioButton selectedAlgoChoice = (RadioButton) AlgoChoice.getSelectedToggle();
		algochoice = selectedAlgoChoice.getText();
		loader = new FXMLLoader(getClass().getResource("/View/SortVisualized.fxml"));
		loader.setController(new SortController(algochoice));

		root = loader.load();
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setTitle("Sorting Visualization");
		stage.setScene(scene);
		
		stage.show();


	 }
	@FXML
	void Help(ActionEvent event) throws IOException{
		loader = new FXMLLoader(getClass().getResource("/View/HelpMenu.fxml"));
		//loader.setController(new SortController());
		root = loader.load();
		stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setTitle("Sorting Visualization");
		stage.setScene(scene);
		
		stage.show();
	}

	public void logout(ActionEvent event) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quit");
		alert.setHeaderText("You're about to exit!");
		alert.setContentText("Are you sure to exit?");
		
		if(alert.showAndWait().get() == ButtonType.OK){
			Stage stage = (Stage) scenePane.getScene().getWindow();
			System.out.println("You successfully exited!");
			stage.close();
		}
		
	}
}