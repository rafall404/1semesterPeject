
package semesterProject;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


	private MainView mainView;


	public void start(Stage Main) throws IOException {
		ProgramMediator mediator = new ProgramMediator();
		this.mainView = new MainView(mediator,Main);
		Main.setTitle("VIA Club");
		FXMLLoader mainWindow = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
		mainWindow.setController(mainView);
		Scene scene = new Scene(mainWindow.load());
		Main.setScene(scene);
		Main.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}



