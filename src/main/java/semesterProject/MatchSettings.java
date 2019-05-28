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
    @FXML private TableColumn listNumberCol;
    @FXML private TableColumn listNameCol;
    @FXML private TableColumn listPositionCol;
    @FXML private TableColumn teamNumberCol;
    @FXML private TableColumn teamNameCol;
    @FXML private TableColumn teamPoisitionCol;
    @FXML private TableView<Player> listView;
    @FXML private TableView<Player> teamView;



    private ProgramMediator mediator;

    public static void main(String[] args) {
        launch(args);
    }

    public MatchSettings(ProgramMediator mediator){
        this.mediator=mediator;
    }

    public void AddButtonAction (ActionEvent e){
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for(int n = 0;  n<listView.getSelectionModel().getSelectedItems().size(); n++){
            teamView.getItems().add(listView.getSelectionModel().getSelectedItems().get(n));
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

    @FXML
    private void saveButtonAction(ActionEvent e)
    {
        Alert alert= new Alert(AlertType.WARNING);
        if(date.getPromptText().isEmpty() || type.getPromptText().equals("Choose match type") || place.getPromptText().equals("Choose match place") ||
        opponent.getText().isEmpty()){
            alert.setTitle("Warning");
            alert.setContentText("Please input all fields");
            alert.showAndWait();
        }

        String day =  date.getPromptText().substring(0,2);
        String month = date.getPromptText().substring(4,5);
        String year = date.getPromptText().substring(date.getPromptText().length()-4);

        int matchday= Integer.parseInt(day);
        int matchmonth= Integer.parseInt(month);
        int matchyear= Integer.parseInt(year);

        String matchtype= type.getPromptText();
        String matchPlace= place.getPromptText();
        String matchOpponent = opponent.getPromptText();

        List<Player> l = teamView.getItems();

        Match match = new Match(new MyDate(matchday,matchmonth,matchyear),matchOpponent,matchPlace,matchtype);
        if (mediator.getAllMatches().getNumberOfMatches() == 0) {
            mediator.getAllMatches().addMatch(match);
        } else {
            boolean duplicates = false;
            for (int i = 0; i < mediator.getAllMatches().getNumberOfMatches(); i++) {
                if (mediator.getAllMatches().getAllMatches().get(i).getDate().equals(match.getDate())) {

                    duplicates = true;

                    break;

                }
            }

            if (!duplicates) {
                mediator.getAllMatches().getAllMatches().add(match);
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
