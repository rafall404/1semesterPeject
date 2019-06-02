package semesterProject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainView {

    @FXML private TextField textField;
    @FXML private Button addMatch;
    @FXML private Button addPlayer;
    @FXML private TextField name;
    @FXML private TextField number;
    @FXML private ComboBox<String> position;
    @FXML private CheckBox isInjured;
    @FXML private CheckBox isSuspended;
    @FXML private TableView<Player> players;
    @FXML private TableColumn<Player,String> playerName;
    @FXML private TableColumn<Player,Integer> playerNumber;
    @FXML private TableColumn<Player,Character> playerPosition;
    @FXML private TableColumn<Player,Boolean> playerInjured;
    @FXML private TableColumn<Player,Boolean> playerSuspended;
    @FXML private TableColumn<Match,MyDate> matchDate;
    @FXML private TableColumn<Match,String> matchOpponent;
    @FXML private TableColumn<Match,String> matchPlace;
    @FXML private TableColumn<Match,String> matchType;
    @FXML private TableView<Match> matches;



    private ProgramMediator mediator;
    private Stage addPlayerStage;
    private Stage addMatchStage;
    private Stage mainView;
    //CONSTRUCTOR
    public MainView(ProgramMediator mediator,Stage mainView) {
        this.mediator = mediator;
        this.mainView = mainView;
    }
    //INIT DATA
    @FXML
    private void initialize() {

        playerName.setCellValueFactory(new PropertyValueFactory<Player, String>("Name"));
        playerNumber.setCellValueFactory(new PropertyValueFactory<Player, Integer>("Number"));
        playerPosition.setCellValueFactory(new PropertyValueFactory<Player, Character>("Position"));
        playerInjured.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("Injured"));
        playerSuspended.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("Suspended"));

        matchDate.setCellValueFactory(new PropertyValueFactory<Match, MyDate>("Date"));
        matchOpponent.setCellValueFactory(new PropertyValueFactory<Match, String>("Opponent"));
        matchPlace.setCellValueFactory(new PropertyValueFactory<Match, String>("Place"));
        matchType.setCellValueFactory(new PropertyValueFactory<Match, String>("Type"));

        players.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        matches.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        updateListAvailablePlayers();
        updateMatches();
    }
    //CREATE MATCH
    public void createMatch(ActionEvent e) throws IOException {
        addMatchStage = new Stage();
        MatchSettings match = new MatchSettings(mediator,addMatchStage,this,matches.getSelectionModel().getSelectedItem());
        Parent root = match.load();
        System.out.println("CREATE STAGE: " + addPlayerStage);
        addMatchStage.setTitle("Add Match");
        addMatchStage.setScene(new Scene(root));
        addMatchStage.show();

    }
    //EDIT MATCH
    public void editMatch(ActionEvent e) throws IOException {
        addMatchStage = new Stage();
        MatchSettings match = new MatchSettings(mediator,addMatchStage,this,matches.getSelectionModel().getSelectedItem());
        Parent root = match.load();
        System.out.println("CREATE STAGE: " + addPlayerStage);
        addMatchStage.setTitle("Add Player");
        addMatchStage.setScene(new Scene(root));

        addMatchStage.show();
    }
    //CREATE PLAYER
    public void createPlayer(ActionEvent e) throws IOException {
        addPlayerStage = new Stage();
        PlayerSettings player = new PlayerSettings(mediator,addPlayerStage,this);
        Parent root = player.load();
        System.out.println("CREATE STAGE: " + addPlayerStage);
        addPlayerStage.setTitle("Add Player");
        addPlayerStage.setScene(new Scene(root));
        addPlayerStage.show();
    }
    //EDIT PLAYER
    public void editPlayer(ActionEvent e) throws IOException {

        addPlayerStage = new Stage();
        PlayerSettings player = new PlayerSettings(mediator,addPlayerStage,this,players.getSelectionModel().getSelectedItem());
        Parent root = player.load();
        System.out.println("CREATE STAGE: " + addPlayerStage);
        addPlayerStage.setTitle("Add Player");
        addPlayerStage.setScene(new Scene(root));
        addPlayerStage.show();
    }
    //REMOVE BUTTON FOR PLAYERS
    public void removePlayerButtonAction(ActionEvent e) {
        List<Player> AllAvailablePlayers = players.getSelectionModel().getSelectedItems();
        for (int i = 0; i < AllAvailablePlayers.size(); i++) {
            mediator.removePlayer(AllAvailablePlayers.get(i));
        }
        updateListAvailablePlayers();

    }
    //REMOVE BUTTON FOR MATCHES
    public void removeMatchButtonAction(ActionEvent e) {
        List<Match> AllMatches = matches.getSelectionModel().getSelectedItems();
        for (int i = 0; i < AllMatches.size(); i++) {
            mediator.removeMatch(AllMatches.get(i));
        }
        updateMatches();
    }
    //ALL MATCHES
    public void allMatchesAction(ActionEvent e) {
        matches.setItems(FXCollections.observableList(mediator.getAllMatches().convertToAList()));
    }
    //HISTORY OF MATCHES
    public void historyOfMatchesAction(ActionEvent e) {
        matches.setItems(FXCollections.observableList(mediator.getAllPastMatches().convertToAList()));
    }
    //UPCOMING MATCHES
    public void upcomingMatchesAction(ActionEvent e) {
        matches.setItems(FXCollections.observableList(mediator.getAllUpcomingMatches().convertToAList()));
    }
    public void updateMatches() {
        matches.setItems(FXCollections.observableList(mediator.getAllMatches().convertToAList()));
    }
    public void updateListAvailablePlayers() {

        players.setItems(FXCollections.observableList(mediator.getAllPlayers().convertToAList()));
    }




}
