package semesterProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class MatchSettings {
    @FXML
    private DatePicker date;
    @FXML
    private TextField opponent;
    @FXML
    private ComboBox place;
    @FXML
    private ComboBox type;
    @FXML
    private Button add;
    @FXML
    private Button cancel;
    @FXML
    private Button save;
    @FXML
    private Button remove;
    @FXML
    private TableColumn<Player, Integer> listNumberCol;
    @FXML
    private TableColumn<Player, String> listNameCol;
    @FXML
    private TableColumn<Player, Character> listPositionCol;
    @FXML
    private TableColumn<Player, Integer> teamNumberCol;
    @FXML
    private TableColumn<Player, String> teamNameCol;
    @FXML
    private TableColumn<Player, Character> teamPositionCol;
    @FXML
    private TableView<Player> listView;
    @FXML
    private TableView<Player> teamView;

    private Stage stage;
    private ProgramMediator mediator;
    private Main main;

    public TableColumn<Player, Integer> getListNumberCol() {
        return listNumberCol;
    }

    public TableColumn<Player, String> getListNameCol() {
        return listNameCol;
    }

    public TableColumn<Player, Character> getListPositionCol() {
        return listPositionCol;
    }


    public MatchSettings(ProgramMediator mediator, Stage stage,Main main) {
        this.main= main;
        this.mediator = mediator;
        this.stage = stage;

    }

    public void AddButtonAction(ActionEvent e) {

        for (int n = 0; n < listView.getSelectionModel().getSelectedItems().size(); n++) {
            teamView.getItems().add(listView.getSelectionModel().getSelectedItems().get(n));
            teamNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
            teamNumberCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
            teamPositionCol.setCellValueFactory(new PropertyValueFactory<Player, Character>("position"));
        }

    }

    public void typeMatchAction(ActionEvent e) {

        if (type.getValue().equals("Premier league") || type.getValue().equals("Champions league")) {
            listView.getItems().clear();

            for (int n = 0; n < mediator.getAllPlayers().getAllAvailablePlayers().getNumberOfPlayers(); n++) {


                listView.getItems().add(new Player(mediator.getAllPlayers().getAllAvailablePlayers().getPlayer(n).getNumber(), mediator.getAllPlayers().getAllAvailablePlayers().getPlayer(n).getName(), mediator.getAllPlayers().getAllAvailablePlayers().getPlayer(n).getPosition()));
                listNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
                listNumberCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
                listPositionCol.setCellValueFactory(new PropertyValueFactory<Player, Character>("position"));
            }
        } else if (type.getValue().equals("Friendly")) {
            listView.getItems().clear();

            for (int n = 0; n < mediator.getNumberOfPlayers(); n++) {


                listView.getItems().add(new Player(mediator.getPlayer(n).getNumber(), mediator.getPlayer(n).getName(), mediator.getPlayer(n).getPosition()));
                listNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
                listNumberCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
                listPositionCol.setCellValueFactory(new PropertyValueFactory<Player, Character>("position"));
            }
        }

    }


    public void removeButtonAction(ActionEvent e) {
        teamView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (int i = 0; i < teamView.getItems().size(); i++) {
            teamView.getSelectionModel().getSelectedItems().remove(i);
        }
    }

    public void closeButtonAction(ActionEvent e) {
        stage.hide();
    }

    public TableView<Player> getListView() {
        return listView;
    }

    @FXML
    private void saveButtonAction(ActionEvent e) {
        Alert alert = new Alert(AlertType.WARNING);
        if (type.getValue().equals("Choose match type") || place.getValue().equals("Choose match place") ||
                opponent.getText().isEmpty()) {
            alert.setTitle("Warning");
            alert.setContentText("Please input all fields");
            alert.showAndWait();
        } else {

            int matchDay = date.getValue().getDayOfMonth();
            int matchMonth = date.getValue().getMonthValue();
            int matchYear = date.getValue().getYear();


            String matchtype = type.getValue().toString();
            String matchPlace = place.getValue().toString();
            String matchOpponent = opponent.getText();
             List<Player> p= teamView.getItems();

             ArrayList<Player> teamplayers=new ArrayList<Player>(p);
            PlayerList tp= new PlayerList();
             tp.setPlayerList(teamplayers);


            Match match = new Match(new MyDate(matchDay, matchMonth, matchYear), matchOpponent, matchPlace, matchtype);
            match.setPlayerList(tp);
            boolean duplicates = false;
            System.out.println(match.toString());
            for (int i = 0; i < mediator.getAllMatches().getNumberOfMatches(); i++) {
                if (mediator.getAllMatches().getMatchByIndex(i).getDate().equals(match.getDate())) {

                    duplicates = true;

                    Alert alert3 = new Alert(AlertType.WARNING);
                    alert3.setTitle("Fields have already been taken!");
                    alert3.setHeaderText("Fields have already taken!");
                    alert3.showAndWait();
                    break;
                }
            }

            if (!duplicates) {

                mediator.addMatch(match);
                stage.close();
            }

        }
        main.updateMatches();
        main.getMatchesTable().refresh();

    }
}




