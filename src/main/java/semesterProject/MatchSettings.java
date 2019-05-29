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
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


public class MatchSettings{
    @FXML private DatePicker date;
    @FXML private TextField opponent;
    @FXML private ComboBox place;
    @FXML private ComboBox type;
    @FXML private Button add;
    @FXML private Button cancel;
    @FXML private Button save;
    @FXML private Button remove;
    @FXML private TableColumn <Player, Integer>listNumberCol;
    @FXML private TableColumn <Player, String>listNameCol;
    @FXML private TableColumn <Player, Character>listPositionCol;
    @FXML private TableColumn <Player, Integer> teamNumberCol;
    @FXML private TableColumn <Player, String> teamNameCol;
    @FXML private TableColumn <Player, Character> teamPositionCol;
    @FXML private TableView<Player> listView;
    @FXML private TableView<Player> teamView;

    private Stage stage;
    private ProgramMediator mediator;

    public TableColumn <Player, Integer> getListNumberCol(){
        return listNumberCol;
    }

    public TableColumn <Player, String> getListNameCol(){
        return listNameCol;
    }

    public TableColumn <Player, Character> getListPositionCol(){
        return listPositionCol;
    }


    public MatchSettings(ProgramMediator mediator,Stage stage){
        this.mediator=mediator;
        this.stage= stage;

    }

    public void AddButtonAction (ActionEvent e){

        for(int n = 0;  n<listView.getSelectionModel().getSelectedItems().size(); n++){
            teamView.getItems().add(listView.getSelectionModel().getSelectedItems().get(n));
            teamNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
            teamNumberCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
            teamPositionCol.setCellValueFactory(new PropertyValueFactory<Player, Character>("position"));
        }

    }

    public void typeMatchAction(ActionEvent e)
    {

        if(type.getValue().equals("Premier league") || type.getValue().equals("Champions league")) {
            listView.getItems().clear();

            for (int n = 0; n < mediator.getAllPlayers().getAllAvailablePlayers().getNumberOfPlayers(); n++) {


                listView.getItems().add(new Player(mediator.getAllPlayers().getAllAvailablePlayers().getPlayer(n).getNumber(), mediator.getAllPlayers().getAllAvailablePlayers().getPlayer(n).getName(), mediator.getAllPlayers().getAllAvailablePlayers().getPlayer(n).getPosition()));
                listNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
                listNumberCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
                listPositionCol.setCellValueFactory(new PropertyValueFactory<Player, Character>("position"));
            }
        }else if(type.getValue().equals("Friendly")){
            listView.getItems().clear();

            for (int n = 0; n < mediator.getNumberOfPlayers(); n++) {


                listView.getItems().add(new Player(mediator.getPlayer(n).getNumber(), mediator.getPlayer(n).getName(), mediator.getPlayer(n).getPosition()));
                listNameCol.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
                listNumberCol.setCellValueFactory(new PropertyValueFactory<Player, Integer>("number"));
                listPositionCol.setCellValueFactory(new PropertyValueFactory<Player, Character>("position"));
            }
        }

    }


    public void removeButtonAction(ActionEvent e)
    {
        teamView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
       for(int i=0; i<teamView.getItems().size();i++)
       {
           teamView.getSelectionModel().getSelectedItems().remove(i);

       }
    }

    public void closeButtonAction(ActionEvent e) {
        stage.hide();
    }

    public TableView<Player> getListView()
    {
        return listView;
    }

    @FXML
    private void saveButtonAction(ActionEvent e)
    {
        Alert alert= new Alert(AlertType.WARNING);
        if( type.getValue().equals("Choose match type") || place.getValue().equals("Choose match place") ||
        opponent.getText().isEmpty()){
            alert.setTitle("Warning");
            alert.setContentText("Please input all fields");
            alert.showAndWait();
        }else {

            String day = date.getPromptText().substring(0, 2);
            String month = date.getPromptText().substring(4, 5);
            String year = date.getPromptText().substring(date.getPromptText().length() - 4);

            int matchday = Integer.parseInt(day);
            int matchmonth = Integer.parseInt(month);
            int matchyear = Integer.parseInt(year);

            String matchtype = type.getPromptText();
            String matchPlace = place.getPromptText();
            String matchOpponent = opponent.getPromptText();

            List<Player> l = teamView.getItems();

            Match match = new Match(new MyDate(matchday, matchmonth, matchyear), matchOpponent, matchPlace, matchtype);
            if (mediator.getAllMatches().getNumberOfMatches() == 0) {
                mediator.getAllMatches().addMatch(match);
            } else {
                boolean duplicates = false;
                for (int i = 0; i < mediator.getAllMatches().getNumberOfMatches(); i++) {
                    if (mediator.getAllMatches().getMatchByIndex(i).getDate().equals(match.getDate())) {

                        duplicates = true;

                        break;

                    }
                }

                if (!duplicates) {
                    mediator.addMatch(match);
                    Alert allen = new Alert(AlertType.CONFIRMATION);
                    allen.setTitle("You have successfully added a match!");
                    allen.setContentText("You have successfully added a match!");
                } else {
                    Alert alert1 = new Alert(AlertType.WARNING);
                    alert1.setTitle("Fields have already been taken!");
                    alert1.setContentText("Fields have already been taken!");
                    alert.showAndWait();

                }

            }

        }
    }



}
