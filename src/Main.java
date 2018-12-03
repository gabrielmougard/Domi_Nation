package application;
	
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main extends Application {
	
	Group root = new Group();
	
	
	private double xOffset = 0;
	private double yOffset = 0;
	public static MediaPlayer mediaPlayer;
	
	@Override
	public void start(Stage primaryStage) {
		try {

			primaryStage.setTitle("Domi'Nations");
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			
			
			
			root.setOnMousePressed(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                xOffset = event.getSceneX();
	                yOffset = event.getSceneY();
	            }
			});
			
			 //move around here
	        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	                primaryStage.setX(event.getScreenX() - xOffset);
	                primaryStage.setY(event.getScreenY() - yOffset);
	            }
	        });
			////////write the title into gothic font
			
			
			FileInputStream streamtitle = new FileInputStream("dominationsfinal.png");
			Image title = new Image(streamtitle);
			ImageView theTitle = new ImageView(title);
			//position
			theTitle.setFitHeight(100);
			theTitle.setFitWidth(600);
			theTitle.setX(110);
			theTitle.setY(100);
				
			//buttons 
			Button singlePlayer = new Button("Single Player");
			Button multiPlayer = new Button("Multi Player");
			Button quit = new Button("Quit");
			
			singlePlayer.setLayoutX(350);
			singlePlayer.setLayoutY(400);
			singlePlayer.setScaleX(2);
			singlePlayer.setScaleY(2);
			
			multiPlayer.setLayoutX(355);
			multiPlayer.setLayoutY(500);
			multiPlayer.setScaleX(2);
			multiPlayer.setScaleY(2);
			
			quit.setLayoutX(375);
			quit.setLayoutY(600);
			quit.setScaleX(2);
			quit.setScaleY(2);
			
			
			///////background gif
			FileInputStream stream = new FileInputStream("castle.gif");
			Image image = new Image(stream);
			ImageView mv = new ImageView(image);
			
			
			///////////////:action button
			
			
			///single Player button
			
			//animation
			 ScaleTransition scaleTransitionSingle = new ScaleTransition(Duration.millis(1000),mv);
			 scaleTransitionSingle.setByX(1.0f);
			 scaleTransitionSingle.setByY(1.0f);
			 scaleTransitionSingle.setAutoReverse(false);
			 FadeTransition ft = new FadeTransition(Duration.millis(500),singlePlayer);
			 ft.setFromValue(1.0);
			 ft.setToValue(0.0);
			 
			 
			 singlePlayer.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		                //when clicked on Single Player
		            	scaleTransitionSingle.play();
		            	ft.play();
		            	moveAndFade(multiPlayer,200,500,500);
		            	moveAndFade(quit,-200,600,500);
		            	
		            	root.getChildren().remove(singlePlayer);
		            	try {
		            		root.getChildren().remove(theTitle);
							SingleMode singleMode = new SingleMode(root,primaryStage);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} //launch the single player menu knowing the root architecture
		            	
		            }
		            
		            private void moveAndFade(Button but, int x,int y, int time) {
		            	//todo : the button translate of x pixels(WIDTH) and y pixels(HEIGHT) and fade at the same time
		            	// also , remove them at the end of the animation
		            	PathTransition transition = new PathTransition();
		            	transition.setNode(but);
		            	transition.setDuration(Duration.millis(time));
		            	transition.stop();
		            	
		            	//Fadding
		            	FadeTransition ft = new FadeTransition(Duration.millis(time));
		            	ft.setFromValue(1.0);
		            	ft.setToValue(0.0);
		            	
		            	Path path = new Path();
		            	path.getElements().add(new MoveToAbs(but));
		            	path.getElements().add(new LineToAbs(but,x,y));
		            	
		            	transition.setPath(path);
		            	transition.play();
		            	//ft.play();
		            	
		            	//destroy after anim
		            	root.getChildren().remove(but);
		            }
		     });
			 
			 ///Multi Player Button
			 multiPlayer.setOnAction(new EventHandler<ActionEvent>() {
				 
				 @Override
				 public void handle(ActionEvent event) {
					 //When Clicked on Multi Player
				 }
			 });
			 
			 ///quit button
			 	quit.setOnAction(new EventHandler<ActionEvent>() {
				 
				 @Override
				 public void handle(ActionEvent event) {
					 //When Clicked on quit
					 primaryStage.close();
				 }
			 });
			 
			
			///////////
			
			
			
			//music background
			//String musicFile = "middleAge.wav";
			//Media sound = new Media(new File(musicFile).toURI().toString());
			//mediaPlayer = new MediaPlayer(sound);
			//mediaPlayer.play();
			
			
			
			root.getChildren().add(mv);
			
			root.getChildren().add(theTitle);
			root.getChildren().addAll(singlePlayer,multiPlayer,quit);
			
			
			
			///scene
			Scene scene = new Scene(root,800,800);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
