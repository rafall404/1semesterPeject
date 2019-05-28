
package semesterProject;

import semesterProject.MatchSettings;
import semesterProject.PlayerSettings;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
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
	//Buttons for main.java;
	@FXML private Button AddMatch;
	@FXML private Button AddPlayer;
	//Fields for playerSettings;
	@FXML private TextField name;
	@FXML private TextField number;
	@FXML private ComboBox<String> position;
	@FXML private CheckBox isInjured;
	@FXML private CheckBox isSuspended;
     //ViewTable in the main.java;
	@FXML private TableView<Player> players;
	@FXML private TableColumn<Player, String> nameCol;
	@FXML private TableColumn<Player, Integer> numberCol;
	@FXML private TableColumn<Player, Character> positionCol;
	@FXML private TableColumn<Player, Boolean> injuredCol;
	@FXML private TableColumn<Player, Boolean> suspendedCol;

	private Stage addPlayerStage;
	private Stage addMatchStage;
	private  MatchSettings matchpage;
	private  PlayerSettings playerPage;

	private ProgramMediator mediator;




	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("VIA Club");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
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
		addMatchStage = new Stage();
		this.matchpage= new MatchSettings(this.mediator);
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
		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/fxml/MatchSettings.fxml"));
		fxmlLoader1.setController(this);
		Parent root = (Parent) fxmlLoader1.load();
		System.out.println("CREATE STAGE: " + addPlayerStage);
		addPlayerStage.setTitle("Add Player");
		addPlayerStage.setScene(new Scene(root));

		addPlayerStage.show();
	}

	public void handleClickMe1(ActionEvent e) throws IOException {

		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/fxml/playerSettings.fxml"));
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
	private void removeButtonAction(ActionEvent e) {
		List<Player> p = players.getSelectionModel().getSelectedItems();
		for (int i = 0; i < p.size(); i++) {
			mediator.removePlayer(p.get(i));

		}
		updatePlayers();
		players.refresh();


	}}

