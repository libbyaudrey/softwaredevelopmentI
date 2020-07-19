package application;
	
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * @author libbysnedaker
 *July 19, 2020
 *add javadoc to word occurrences app
 */
public class Snedaker_mod10 extends Application {

	/**
	 * JavaFX GUI method
	 */
	@Override
	public void start(Stage primaryStage) {
		
		//label object for chart title in top region of BorderPane
		Label titleLabel = new Label("Word Occurrences in Macbeth");
		
		//label for GUI functions
		Label actionLabel = new Label("To display the word occurrences in Macbeth, press the Show Words button.");
		actionLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 16));

		
		//Defining the Comment text field
		final TextArea allWords = new TextArea();
		allWords.setMinSize(300,300);

		
		//Defining the Submit button
		Button submit = new Button("Show Words");
		//button action to call the Working_TextAnalyzer class
		EventHandler<ActionEvent> submitAction = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Working_TextAnalyzer workingClass = new Working_TextAnalyzer();
				try {
					allWords.setText(workingClass.getWords());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		};
		
		//button action
		submit.setOnAction(submitAction);
		submit.setFont(Font.font("Georgia", FontWeight.BOLD, 24));
		
		//the BorderPane
		BorderPane thePane = new BorderPane();
		thePane.setTop(actionLabel);
		BorderPane.setAlignment(actionLabel, Pos.TOP_CENTER);
		thePane.setCenter(allWords);
		BorderPane.setAlignment(allWords, Pos.CENTER);
		thePane.setBottom(submit);
		BorderPane.setAlignment(submit, Pos.BOTTOM_CENTER);
		
		//the scene
		Scene scene1 = new Scene(thePane, 700, 800);	
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Word Occurernces in Macbeth");
		primaryStage.show();
	}

/**
 * 
 * @param args launches the javafx GUI
 */
	public static void main(String[] args) {
		launch(args);
	}

}
