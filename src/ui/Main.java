package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GUIController controller = new GUIController(true);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPane.fxml"));
		
		loader.setController(controller);
		
		Parent parent = loader.load();
		
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

}
