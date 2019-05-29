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
    private Player playerEdit;

    public PlayerSettings(ProgramMediator mediator, Stage stage, Main main, Player player) {
        this(mediator, stage, main);
        this.playerEdit = player;
    }

    public PlayerSettings(ProgramMediator mediator, Stage stage, Main main) {
        this.mediator = mediator;
        this.stage = stage;
        this.main = main;

    }

    @FXML
    private void initialize() {
        name.setText(playerEdit.getName());
        number.setText(""+playerEdit.getNumber());
        position.setValue(String.valueOf(playerEdit.getPosition()));
        isInjured.setSelected(playerEdit.isInjured());
        isSuspended.setSelected(playerEdit.isInjured());
    }

    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/playerSettings.fxml"));
        loader.setController(this);
        return loader.load();
    }

    @FXML
    private void saveButtonAction(ActionEvent e) {


        if (name.getText().isEmpty() || number.getText().isEmpty() || position.getValue().equals("Pick Position")) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Input all your fields");
            alert.showAndWait();
        } else {

            String playerName = name.getText();
            String playerNumber = number.getText().trim();
            String playerPosition = position.getValue().toString();
            boolean isPlayerInjured = isInjured.isSelected();
            boolean isPlayerSuspended = isSuspended.isSelected();

            if (playerEdit == null) {
                Player player = new Player(playerName, (Integer.parseInt(playerNumber)), playerPosition.charAt(0),
                        isPlayerInjured, isPlayerSuspended);

                boolean duplicates = false;
                for (int i = 0; i < mediator.getAllPlayers().getNumberOfPlayers(); i++) {
                    if (mediator.getAllPlayers().getPlayer(i).getNumber() == (player.getNumber())) {

                        duplicates = true;

                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Fields have already been taken!");
                        alert.setHeaderText("Fields have already taken!");
                        alert.showAndWait();
                        break;
                    }
                }

                if (!duplicates) {
                    mediator.addPlayer(player);
                    stage.close();
                }
            } else {
                playerEdit.setName(playerName);
                playerEdit.setNumber(Integer.parseInt(playerNumber));
                playerEdit.setPosition(playerPosition.charAt(0));
                playerEdit.setIsInjured(isPlayerInjured);
                playerEdit.setIsSuspended(isPlayerSuspended);
                stage.close();
            }
        }
        mediator.editPlayer(playerEdit);
        main.updatePlayers();

    }

    public void closeButtonAction(ActionEvent e) {
        stage.hide();
    }

    public TextField getName() {
        return this.name;
    }

    public TextField getNumber() {
        return number;
    }

    public ComboBox<String> getPosition() {
        return position;
    }

    public CheckBox getIsInjured() {
        return isInjured;
    }

    public CheckBox getIsSuspended() {
        return isSuspended;
    }
}
