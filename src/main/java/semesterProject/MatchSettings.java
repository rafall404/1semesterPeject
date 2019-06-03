package semesterProject;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    @FXML private DatePicker date;
    @FXML private TextField opponent;
    @FXML private ComboBox place;
    @FXML private ComboBox type;
    @FXML private Button add;
    @FXML private Button cancel;
    @FXML private Button save;
    @FXML private Button remove;
    @FXML private TableColumn<Player, Integer> listNumberCol;
    @FXML private TableColumn<Player, String> listNameCol;
    @FXML private TableColumn<Player, Character> listPositionCol;
    @FXML private TableColumn<Player, Integer> teamNumberCol;
    @FXML private TableColumn<Player, String> teamNameCol;
    @FXML private TableColumn<Player, Character> teamPositionCol;
    @FXML private TableView<Player> listView;
    @FXML private TableView<Player> teamView;
    @FXML private TextField timeH;
    @FXML private TextField timeM;

    private Stage stage;
    private ProgramMediator mediator;
    private Match matchEdit;
    private MainView mainView;

    public MatchSettings(ProgramMediator mediator, Stage stage, MainView mainView) {
        this.mediator = mediator;
        this.stage = stage;
        this.mainView = mainView;

    }

    public MatchSettings(ProgramMediator mediator, Stage stage, MainView mainView, Match match) {
        this(mediator, stage, mainView);
        this.matchEdit = match;
    }

    @FXML
    private void initialize() {
        teamNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        teamNumberCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
        teamPositionCol.setCellValueFactory(new PropertyValueFactory<Player, Character>("position"));
        listView.setItems(FXCollections.observableList(mediator.getAllPlayers().convertToAList()));
        listNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        listNumberCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
        listPositionCol.setCellValueFactory(new PropertyValueFactory<Player, Character>("position"));

        if (matchEdit != null) {
            date.setValue(matchEdit.getLocalDateTime().toLocalDate());
            opponent.setText(matchEdit.getOpponent());
            timeH.setText("" + matchEdit.getLocalDateTime().getHour());
            timeM.setText("" + matchEdit.getLocalDateTime().getMinute());
            place.setValue(matchEdit.getPlace());
            type.setValue(matchEdit.getType());
            teamView.setItems(FXCollections.observableList(matchEdit.getPlayerList().convertToAList()));
        }
    }

    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MatchSettings.fxml"));
        loader.setController(this);
        return loader.load();
    }

    public void AddButtonAction(ActionEvent e) {

        teamView.getItems().add(listView.getSelectionModel().getSelectedItem());

    }

    public void typeMatchAction(ActionEvent e) {

        if (type.getValue().equals("Premier league") || type.getValue().equals("Champions league")) {

            listView.setItems(FXCollections.observableList(mediator.getAllPlayers().getAllAvailablePlayers().convertToAList()));

        } else if (type.getValue().equals("Friendly")) {

            listView.setItems(FXCollections.observableList(mediator.getAllPlayers().convertToAList()));
        }
    }


    public void removeButtonAction(ActionEvent e) {
        for (int i = 0; i < teamView.getItems().size(); i++) {
            teamView.getSelectionModel().getSelectedItems().remove(i);
            //REMOVE BUTTON IS NOT WORKING, IT NEEDS TO BE FIXED, HOWEVER I GOT SO WASTED THAT I DONT REMEMBER WHAT HAPPENED.
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
            alert.setTitle(null);
            alert.setContentText("Please input all fields");
            alert.showAndWait();
        } else {

            LocalDateTime localDateTime = LocalDateTime.of(date.getValue(), LocalTime.of(Integer.parseInt(timeH.getText()), Integer.parseInt(timeM.getText())));
            String matchtype = type.getValue().toString();
            String matchPlace = place.getValue().toString();
            String matchOpponent = opponent.getText();

            List<Player> p = teamView.getItems();

            ArrayList<Player> teamplayers = new ArrayList<Player>(p);
            PlayerList tp = new PlayerList();
            tp.setPlayerList(teamplayers);

            if (matchEdit == null) {
                Match match = new Match(localDateTime, matchOpponent, matchPlace, matchtype, tp);
                match.setPlayerList(tp);

                boolean duplicates = false;

                for (int i = 0; i < mediator.getAllMatches().getNumberOfMatches(); i++) {
                    if (mediator.getAllMatches().getMatchByIndex(i).getLocalDateTime().equals(match.getLocalDateTime())) {

                        duplicates = true;

                        Alert alert3 = new Alert(AlertType.WARNING);
                        alert3.setTitle(null);
                        alert3.setHeaderText("Fields have already taken!");
                        alert3.showAndWait();
                        break;
                    }
                }

                if (!duplicates) {

                    mediator.addMatch(match);
                    stage.close();
                }
            } else {
                matchEdit.setLocalDateTime(localDateTime);
                matchEdit.setOpponent(opponent.toString());
                matchEdit.setPlace(matchPlace);
                matchEdit.setType(matchtype);
                matchEdit.setPlayerList(tp);
                stage.close();
            }

        }
        mainView.updateMatches();

    }
}





