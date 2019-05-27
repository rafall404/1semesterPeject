
package semesterProject;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Main extends Application {
	ObservableList<String> positionList = FXCollections.observableArrayList("D", "M", "F", "Gk");
	@FXML
	private TextField text;
	@FXML
	private Button AddMatch;

	@FXML
	private Button AddPlayer;
	@FXML
	private TextField name;
	@FXML
	private TextField number;

	@FXML
	private ComboBox<String> position;
	@FXML
	private CheckBox isInjured;
	@FXML
	private CheckBox isSuspended;

	@FXML
	private TableView<Player> players;

	@FXML
	private TableColumn<Player, String> nameCol;
	@FXML
	private TableColumn<Player, Integer> numberCol;
	@FXML
	private TableColumn<Player, Character> positionCol;
	@FXML
	private TableColumn<Player, Boolean> injuredCol;
	@FXML
	private TableColumn<Player, Boolean> suspendedCol;

	private Stage addPlayerStage;

	private ProgramMediator mediator;

	public void start(Stage primaryStage) throws IOException {
<<<<<<< HEAD
		primaryStage.setTitle("VIA Club");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/main.fxml"));
=======
		primaryStage.setTitle("CALCULATOR");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
>>>>>>> 708780acc5184c125e52b2169eea1bf5fc11b6af
		loader.setController(this);
		Scene scene = new Scene(loader.load());

		nameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		numberCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
		positionCol.setCellValueFactory(new PropertyValueFactory<Player, Character>("position"));
		injuredCol.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("injured"));
		suspendedCol.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("suspended"));

		updatePlayers();

		primaryStage.setScene(scene);
		primaryStage.show();
		
		players.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	public Main() {
		this.mediator = new ProgramMediator();
		addPlayerStage = new Stage();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void updatePlayers() {
		players.getItems().clear();
		PlayerList allPlayers = mediator.getAllPlayers();
		for (int i = 0; i < allPlayers.getNumberOfPlayers(); i++) {
			players.getItems().add(allPlayers.getPlayer(i));
		}
	}

	public void handleClickMe(ActionEvent e) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddMatch.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Add Match");
		stage.setScene(new Scene(root1));
		stage.show();

	}

	public void handleClickMe1(ActionEvent e) throws IOException {

		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("addPlayer.fxml"));
		fxmlLoader1.setController(this);
		Parent root = (Parent) fxmlLoader1.load();
		System.out.println("CREATE STAGE: " + addPlayerStage);
		addPlayerStage.setTitle("Add Player");
		addPlayerStage.setScene(new Scene(root));

		addPlayerStage.show();

	}

	public void closeButtonAction(ActionEvent e) {
		addPlayerStage.hide();
	}

	@FXML
	private void saveButtonAction(ActionEvent e) throws IOException {
		Alert alert = new Alert(AlertType.WARNING);
		if (name.getText().isEmpty() || number.getText().isEmpty()) {
			alert.setTitle("Warning");
			alert.setContentText("Input all your fields");
			alert.showAndWait();
		} else {

			String playerName = name.getText();
			String playerNumber = number.getText().trim();
			String PlayerPosition = position.getValue().toString();
			boolean isPlayerInjured = isInjured.isSelected();
			boolean isPlayerSuspended = isSuspended.isSelected();

			Player player = new Player(playerName, (Integer.parseInt(playerNumber)), PlayerPosition.charAt(0),
					isPlayerInjured, isPlayerSuspended);
			
			for(int i=0; i<players.getItems().size(); i++)
			{
				if(players.getItems().get(i).equals(player))
			{
				Alert alert1 = new Alert(AlertType.WARNING);
				alert1.setTitle("Warning");
				alert1.setContentText("Fields have already been taken!");
				addPlayerStage.close();
			}
				
			}
			

			mediator.addPlayer(player);
			addPlayerStage.close();

			System.out.println(playerName + Integer.parseInt(playerNumber) + PlayerPosition.charAt(0) + isPlayerInjured
					+ isPlayerSuspended);

			System.out.println(this.addPlayerStage);
			addPlayerStage.close();

			updatePlayers();
			players.refresh();

		}

	}

	@FXML
	private void removeButtonAction(ActionEvent e)
	{
      List<Player> p = players.getSelectionModel().getSelectedItems();
      for(int i= 0; i<p.size(); i++) {
    	  mediator.removePlayer(p.get(i));
    	  
      }
      updatePlayers();
      players.refresh();
      
      
      
     
	}
}
