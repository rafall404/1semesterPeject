
package semesterProject;

import java.io.IOException;
import java.util.ArrayList;
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
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void updatePlayers() {
		players.getItems().clear();
		PlayerList allPlayers = mediator.getAllPlayers();
		for (int i = 0; i < allPlayers.getNumberOfPlayers(); i++) {
			players.getItems().add(allPlayers.getPlayer(i));
		}
	}

	public void openMatchEdit(ActionEvent e) throws IOException {
		addMatchStage = new Stage();

		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/fxml/matchSettings.fxml"));
		fxmlLoader1.setController(new MatchSettings(mediator, addMatchStage));
		Parent root = fxmlLoader1.load();

		System.out.println("CREATE STAGE: " + addPlayerStage);
		addMatchStage.setTitle("Add Match");
		addMatchStage.setScene(new Scene(root));

		for( int n= 0; n<mediator.getNumberOfPlayers(); n++){
			String listName= mediator.getAllPlayers().getPlayer(n).getName();
			int number= mediator.getAllPlayers().getPlayer(n).getNumber();
			char position = mediator.getAllPlayers().getPlayer(n).getPosition();

			Player player = new Player(number, listName, position);

                   matchpage.getListView().getItems().add(player);


		}

		addMatchStage.show();
	}

	public void openPlayerEdit(ActionEvent e) throws IOException {
		addPlayerStage = new Stage();
		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/fxml/playerSettings.fxml"));
		fxmlLoader1.setController(new PlayerSettings(mediator,addPlayerStage,this));
		Parent root = fxmlLoader1.load();
		System.out.println("CREATE STAGE: " + addPlayerStage);
		addPlayerStage.setTitle("Add Player");
		addPlayerStage.setScene(new Scene(root));

		addPlayerStage.show();

	}

	public void removeButtonAction(ActionEvent e) {

		List<Player> p = players.getSelectionModel().getSelectedItems();
		System.out.println("gdhi");
		for (int i = 0; i < p.size(); i++) {
			mediator.removePlayer(p.get(i));

		}
		System.out.println("dgjvoudv");
		updatePlayers();
	}







}



