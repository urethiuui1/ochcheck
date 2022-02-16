package checker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root, Color.AZURE);
		primaryStage.setTitle("Checker");

		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
