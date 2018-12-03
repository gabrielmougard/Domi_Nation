package application;



import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Game extends Application{
	
	public Game(Stage primaryStage) throws Exception {
		//build a new Window !
		
		start(primaryStage);
	}

	@Override
	public void start(Stage gameStage) throws Exception {
		// TODO Auto-generated method stub
		Group gameRoot = new Group();
		Scene gameScene = new Scene(gameRoot);
		
		//new Window
		Stage gameWindow = new Stage();
		gameWindow.setTitle("Domi'Nation");
		gameWindow.setScene(gameScene);
		gameWindow.setMaximized(true);
		
		setup(gameRoot); //set the user interface
		//String[] config = recoverConfig("config.txt"); // load config file
		
		
		
		gameWindow.show();
	}
	
	private void setup(Group root) {
		//String musicFile = "ambience.wav";
		//Media sound = new Media(new File(musicFile).toURI().toString());
		//MediaPlayer ambiencePlayer = new MediaPlayer(sound);
		//ambiencePlayer.play();
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		double xBound = primaryScreenBounds.getWidth()/5;
		double height = primaryScreenBounds.getHeight();
		double width = primaryScreenBounds.getWidth();
		double yBound = 4*height/5; 
	
		//we build the user interface here
		Polygon incomingArea = new Polygon();
		Polygon actionBar = new Polygon();
		Polygon board = new Polygon();
		
		incomingArea.getPoints().addAll(new Double[] {
			0.0,0.0,
			xBound,0.0,
			xBound,height,
			0.0,height
		});
		incomingArea.setFill(Color.CADETBLUE);
		root.getChildren().add(incomingArea);
		
		actionBar.getPoints().addAll(new Double[] {
			xBound, 0.0,
			xBound*5, 0.0,
			xBound*5, yBound,
			xBound, yBound
		});
		actionBar.setFill(Color.BISQUE);
		root.getChildren().add(actionBar);
		
		board.getPoints().addAll(new Double[] {
			xBound, 0.0,
			xBound*5, 0.0,
			xBound*5, yBound,
			xBound, yBound
		});
		board.setFill(Color.AQUAMARINE);
		root.getChildren().add(board);
		
		ArrayList<Line> lines = drawGrid(width,height);
		root.getChildren().addAll(lines);
		
	}
	
	//private String[] recoverConfig(String fileName) {
		
	//}
	
	//(4/5)*height/21 + i*(4/5)*height/21
	
	private ArrayList<Line> drawGrid(double width, double height) {
		double padY = (0.8)*height/19;
		double padX = (0.8)*width/19;
		ArrayList<Line> lines = new ArrayList<Line>();
		
		for ( int i = 0; i < 20; i++) {
			lines.add(new Line(width/5,padY*i, 5*width/5, padY*i)); //horiz
			lines.add(new Line((0.2)*width + padX*i,0,(0.2)*width + padX*i,(0.8)*height)); //vert
			
		}
		
		for (Line line : lines) {
			line.setStroke(Color.WHITE);
			System.out.println(line);
		}
		
		return lines;
	}



}
