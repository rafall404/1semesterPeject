package semesterProject;

import com.google.common.collect.Table;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    @FXML private TableView<Match> matches;
    @FXML private TableColumn<Match,MyDate> matchDate;
    @FXML private TableColumn<Match,String> matchOpponent;
    @FXML private TableColumn<Match,String> matchPlace;
    @FXML private TableColumn<Match,String> matchType;
    @FXML private TableColumn<Player,String> playerName;
    @FXML private TableColumn<Player,Integer> playerNumber;
    @FXML private TableColumn<Player,Character> playerPosition;
    @FXML private TableColumn<Player,Boolean> playerInjured;
    @FXML private TableColumn<Player,Boolean> playerSuspended;

    private ProgramMediator mediator;
    private MatchSettings matchPage;
    private PlayerSettings playerPage;

    public MainView(ProgramMediator mediator,MatchSettings matchPage,PlayerSettings playerPage) {
        this.mediator = mediator;
        this.matchPage = matchPage;
        this.playerPage = playerPage;
    }
    @FXML
    private void initialize() {
        //don't know how to make init.
        playerName.setCellValueFactory(new PropertyValueFactory<Player, String>("Name"));
        playerNumber.setCellValueFactory(new PropertyValueFactory<Player, Integer>("Number"));
        playerPosition.setCellValueFactory(new PropertyValueFactory<Player, Character>("Position"));
        playerInjured.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("Injured"));
        playerSuspended.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("Suspended"));

        matchDate.setCellValueFactory(new PropertyValueFactory<Match,MyDate>("Date"));
        matchOpponent.setCellValueFactory(new PropertyValueFactory<Match,String>("Opponent"));
        matchPlace.setCellValueFactory(new PropertyValueFactory<Match,String>("Place"));
        matchType.setCellValueFactory(new PropertyValueFactory<Match,String>("Type"));

        players.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }





}
