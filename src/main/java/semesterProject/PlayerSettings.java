package semesterProject;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerSettings {

    @FXML private TextField name;
    @FXML private TextField number;
    @FXML private ComboBox<String> position;
    @FXML private CheckBox isInjured;
    @FXML private CheckBox isSuspended;
    @FXML private Button saveButton;
    @FXML private Button close;

    private Stage stage;
    private ProgramMediator mediator;
    private Player playerEdit;
    private MainView mainView;

    public PlayerSettings(ProgramMediator mediator, Stage stage,MainView mainView) {
        this.mediator = mediator;
        this.stage = stage;
        this.mainView = mainView;
    }

    public PlayerSettings(ProgramMediator mediator, Stage stage,MainView mainView ,Player player) {
        this(mediator, stage,mainView);
        this.playerEdit = player;
    }



    @FXML
    private void initialize() {
        if(playerEdit != null) {
            name.setText(playerEdit.getName());
            number.setText("" + playerEdit.getNumber());
            position.setValue(String.valueOf(playerEdit.getPosition()));
            isInjured.setSelected(playerEdit.isInjured());
            isSuspended.setSelected(playerEdit.isInjured());
        }
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
        mainView.updateListAvailablePlayers();

    }

}

