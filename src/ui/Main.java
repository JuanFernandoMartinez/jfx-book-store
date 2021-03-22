package ui;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Library;

public class Main extends Application {
	
	private Library library;

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		library = new Library();
		GUIController controller = new GUIController(library);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPane.fxml"));
		
		loader.setController(controller);
		
		Parent parent = loader.load();
		
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}
	
	
	

}
