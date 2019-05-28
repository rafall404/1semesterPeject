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

public class PlayerSettings {

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
    private Button saveButton;
    @FXML
    private Button close;

    private ProgramMediator mediator;
    private Stage stage;
    private Main main;


    public PlayerSettings(ProgramMediator mediator, Stage stage,Main main) {
        this.mediator = mediator;
        this.stage = stage;
        this.main = main;

    }

    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/playerSettings.fxml"));
        loader.setController(this);
        return loader.load();
    }



    @FXML
    private void saveButtonAction(ActionEvent e) {
        Alert alert = new Alert(AlertType.WARNING);

        if (name.getText().isEmpty() || number.getText().isEmpty() || position.getValue().equals("Pick Position")) {
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


            boolean duplicates = false;
            for (int i = 0; i < mediator.getAllPlayers().getNumberOfPlayers(); i++) {
                if (mediator.getAllPlayers().getPlayer(i).getNumber() == (player.getNumber())) {

                    duplicates = true;

                    Alert alert1 = new Alert(AlertType.WARNING);
                    alert1.setTitle("Fields have already been taken!");
                    alert1.setHeaderText("Fields have already taken!");
                    alert.showAndWait();
                    System.out.println("fm;kjjn");
                    break;
                }
            }

            if(!duplicates) {
                mediator.addPlayer(player);
                stage.close();

            }
        }
        main.updatePlayers();

    }

    public void closeButtonAction(ActionEvent e) {
        stage.hide();
    }







}
