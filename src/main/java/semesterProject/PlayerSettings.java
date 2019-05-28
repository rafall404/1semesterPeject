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

    @FXML private TextField name;
    @FXML private TextField number;
    @FXML private ComboBox<String> position;
    @FXML private CheckBox isInjured;
    @FXML private CheckBox isSuspended;
    @FXML private Button saveButton;
    @FXML private Button close;

    private ProgramMediator mediator;

    public PlayerSettings(ProgramMediator mediator) {
        this.mediator = mediator;
    }

    public Parent load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/playerSettings.fxml"));
        loader.setController(this);
        return loader.load();
    }

    @FXML void closeButtonAction(ActionEvent event) {

    }

    @FXML void saveButtonAction(ActionEvent event) {

    }

}

