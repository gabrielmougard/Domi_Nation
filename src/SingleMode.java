package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SingleMode {
	
	private FileInputStream streamtitle = new FileInputStream("dominationsfinal.png");
	
	
	private String[] config = new String[6]; //will contain the configuration for the game : Game Mode(0), nbPlayer(1), player1(2), player2(3), player3(4), player4(5)
	private String errorLog;
	public static int count;

		
	public SingleMode(Group root, Stage primaryStage) throws FileNotFoundException {
		//TODO : menu of the single mode here
		
		

		//slider to choose the number of player
		Slider nbPlayer = new Slider(2,4,1);
		nbPlayer.setMajorTickUnit(1);
		nbPlayer.setMinorTickCount(0);
		nbPlayer.setShowTickLabels(true);
		nbPlayer.setBlockIncrement(1);
		nbPlayer.setSnapToTicks(true);
		nbPlayer.setLayoutX(110);
		nbPlayer.setLayoutY(250);
		root.getChildren().add(nbPlayer);
		
		//recover Menu Title
		Node title = root.getChildren().get(1); //we recover the title
		FadeTransition ft = new FadeTransition(Duration.millis(500),title);
			
		
		//
		
		//Game Mode (We'll use menuButton)
		MenuItem normal = new MenuItem("Normal");
		MenuItem dynastie = new MenuItem("Dynastie");
		MenuItem empire_du_milieu = new MenuItem("Empire Du Milieu");
		MenuItem harmonie = new MenuItem("Harmonie");
		MenuItem grand_duel = new MenuItem("Le Grand Duel");
		
			//image of the menuButton
		FileInputStream fire = new FileInputStream("fire.png");
		Image menuImage = new Image(fire);
		ImageView imageMenuButton = new ImageView(menuImage);
			//
		MenuButton menuButton = new MenuButton("Game Mode", imageMenuButton, 
												normal,
												dynastie,
												empire_du_milieu,
												harmonie,
												grand_duel);
		
		normal.setOnAction(event -> {
			config[0] = "normal";
			menuButton.setText("Normal Mode");
			printDescription(root,0);
		});
		dynastie.setOnAction(event -> {
			config[0] = "dynastie";
			menuButton.setText("Dynastie Mode");
			printDescription(root,1);
		});
		empire_du_milieu.setOnAction(event -> {
			config[0] = "middleEmpire";
			menuButton.setText("Middle Empire Mode");
			printDescription(root,2);
		});
		harmonie.setOnAction(event -> {
			config[0] = "harmonie";
			menuButton.setText("Harmony Mode");
			printDescription(root,3);
		});
		grand_duel.setOnAction(event -> {
			config[0] = "grandDuel";
			menuButton.setText("Great Duel Mode");
			printDescription(root,4);
		});
		
		
		HBox hbox = new HBox(menuButton);
		hbox.setLayoutX(130);
		hbox.setLayoutY(100);
		hbox.setScaleX(1.5);
		hbox.setScaleY(1.5);
		root.getChildren().add(hbox);
		//
		
		//Launch button
		Button launch = new Button("Launch game !");
		launch.setLayoutX(350);
		launch.setLayoutY(700);
		launch.setScaleX(2);
		launch.setScaleY(2);
		root.getChildren().add(launch);
		//
		
		//Line
		Line line = new Line();
		line.setStartX(400);
		line.setStartY(50);
		line.setEndX(400);
		line.setEndY(650);
		line.setStroke(Color.WHITE);
		line.setStrokeWidth(5);
		root.getChildren().add(line);
		//
		
		//error message
		
		//
		
		//info message (describing game mode)
		
		//
		
		//back arrow
		FileInputStream backArr = new FileInputStream("back_arrow.png");
		Image backArrowLogo = new Image(backArr);
		ImageView returnLogo = new ImageView(backArrowLogo);
		
		returnLogo.setRotate(180);
		returnLogo.setLayoutX(30);
		returnLogo.setLayoutY(30);
		root.getChildren().add(returnLogo);
		
		//
		
		//button for the type of players
		FileInputStream playerIc = new FileInputStream("playerIcon2.png");
		Image playerImage = new Image(playerIc);
		ImageView playerIconButton1 = new ImageView(playerImage); //because of javafx internal structure one node has to be unique
		ImageView playerIconButton2 = new ImageView(playerImage); // thus we create 4 times a different variable with the same content
		ImageView playerIconButton3 = new ImageView(playerImage);
		ImageView playerIconButton4 = new ImageView(playerImage);
		
		
		
		
		MenuItem realPlayer1 = new MenuItem("Real Player");
		MenuItem bot1 = new MenuItem("Domin'AI");
		MenuItem noPlayer1 = new MenuItem("No Player");
		
		MenuItem realPlayer2 = new MenuItem("Real Player");
		MenuItem bot2 = new MenuItem("Domin'AI");
		MenuItem noPlayer2 = new MenuItem("No Player");
		
		MenuItem realPlayer3 = new MenuItem("Real Player");
		MenuItem bot3 = new MenuItem("Domin'AI");
		MenuItem noPlayer3 = new MenuItem("No Player");
		
		MenuItem realPlayer4 = new MenuItem("Real Player");
		MenuItem bot4 = new MenuItem("Domin'AI");
		MenuItem noPlayer4 = new MenuItem("No Player");
			
		
		MenuButton buttonPlayer1 = new MenuButton("Player 1",playerIconButton1,realPlayer1,bot1,noPlayer1);
		MenuButton buttonPlayer2 = new MenuButton("Player 2",playerIconButton2,realPlayer2,bot2,noPlayer2);
		MenuButton buttonPlayer3 = new MenuButton("Player 3",playerIconButton3,realPlayer3,bot3,noPlayer3);
		MenuButton buttonPlayer4 = new MenuButton("Player 4",playerIconButton4,realPlayer4,bot4,noPlayer4);
		
		buttonPlayer1.setLayoutX(130);
		buttonPlayer1.setLayoutY(350);
		
		buttonPlayer2.setLayoutX(130);
		buttonPlayer2.setLayoutY(450);
		
		buttonPlayer3.setLayoutX(130);
		buttonPlayer3.setLayoutY(550);
		
		buttonPlayer4.setLayoutX(130);
		buttonPlayer4.setLayoutY(650);
		
		root.getChildren().addAll(buttonPlayer1,buttonPlayer2,buttonPlayer3,buttonPlayer4);
		
		//
		
		//action handler and animations
		//TODO : add handler to each MenuButton, add bouncing button (the launch one)
		//       + fading(and removal) of the specified MenuButton according to the intValue in the slider
		//       + create a saver to save game configuration.
		// 		 + implement textView where we describe the specificity of each game mode (see Constants class)
		//		 + implement return button to return to the welcome screen (with the inverse animation)
		//		 + implement keypad compatibility for chosing buttons (i.e : "esc" -> return to welcome screen
		//			"arrows" (right, up, down, left) for moving around.
		returnLogo.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				root.getChildren().removeAll(nbPlayer,hbox,launch,line,returnLogo,buttonPlayer1,buttonPlayer2,buttonPlayer3,buttonPlayer4);
				
				//create the nodes of the start page
				
				//title
			
				Image title = new Image(streamtitle);
				ImageView theTitle = new ImageView(title);
					//position
				theTitle.setFitHeight(100);
				theTitle.setFitWidth(600);
				theTitle.setX(110);
				theTitle.setY(100);
				root.getChildren().add(theTitle);
				//
				
				//single Player button
				Button singlePlayer = new Button("Single Player");
				singlePlayer.setLayoutX(350);
				singlePlayer.setLayoutY(400);
				singlePlayer.setScaleX(2);
				singlePlayer.setScaleY(2);
				root.getChildren().add(singlePlayer);
				//
				
				//mutliPlayer button
				Button multiPlayer = new Button("Multi Player");
				multiPlayer.setLayoutX(355);
				multiPlayer.setLayoutY(500);
				multiPlayer.setScaleX(2);
				multiPlayer.setScaleY(2);
				root.getChildren().add(multiPlayer);
				//
				
				//quit button
				Button quit = new Button("Quit");
				quit.setLayoutX(375);
				quit.setLayoutY(600);
				quit.setScaleX(2);
				quit.setScaleY(2);
				root.getChildren().add(quit);
				
				quit.setOnAction(new EventHandler<ActionEvent>() {
					 
					 @Override
					 public void handle(ActionEvent event) {
						 //When Clicked on quit
						 primaryStage.close();
					 }
				 });
				
				//
				
				//
				
				FadeTransition ft1 = new FadeTransition(Duration.millis(1000),root.getChildren().get(1)); //title
				FadeTransition ft2 = new FadeTransition(Duration.millis(1000),root.getChildren().get(2)); //singlePlayer
				FadeTransition ft3 = new FadeTransition(Duration.millis(1000),root.getChildren().get(3)); //MultiPlayer
				FadeTransition ft4 = new FadeTransition(Duration.millis(1000),root.getChildren().get(4)); //Quit
				
				
				ScaleTransition scaleTransitionSingle = new ScaleTransition(Duration.millis(1000), root.getChildren().get(0));
				
				if (count % 2 == 0) { //simple trick to avoid that the background image unzoom forever 
					scaleTransitionSingle.setByX(-1.0f);
					scaleTransitionSingle.setByY(-1.0f);
					count++;
				}
				else {
					scaleTransitionSingle.setByX(1.0f);
					scaleTransitionSingle.setByY(1.0f);
					count++;
				}
				
				scaleTransitionSingle.play();
				
			
				ft1.setFromValue(0.0);
				ft1.setToValue(1.0);
				ft1.play();
				
				ft2.setFromValue(0.0);
				ft2.setToValue(1.0);
				ft2.play();
				
				ft3.setFromValue(0.0);
				ft3.setToValue(1.0);
				ft3.play();
				
				ft.setFromValue(0.0);
				ft.setToValue(1.0);
				ft4.play();
				
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
			 	
				
			}
		});
		
		//handler for player config
		realPlayer1.setOnAction(event -> {
			config[2] = "real";
			buttonPlayer1.setText("Real");
		});
		bot1.setOnAction(event -> {
			config[2] = "bot";
			buttonPlayer1.setText("Domin'AI");
		});
		noPlayer1.setOnAction(event -> {
			config[2] = "no";
			buttonPlayer1.setText("No Player");
		});
		
		realPlayer2.setOnAction(event -> {
			config[3] = "real";
			buttonPlayer2.setText("Real");
		});
		bot2.setOnAction(event -> {
			config[3] = "bot";
			buttonPlayer2.setText("Domin'AI");
		});
		noPlayer2.setOnAction(event -> {
			config[3] = "no";
			buttonPlayer2.setText("No Player");
		});
		
		realPlayer3.setOnAction(event -> {
			config[4] = "real";
			buttonPlayer3.setText("Real");
		});
		bot3.setOnAction(event -> {
			config[4] = "bot";
			buttonPlayer3.setText("Domin'AI");
		});
		noPlayer3.setOnAction(event -> {
			config[4] = "no";
			buttonPlayer3.setText("No Player");
		});
		
		realPlayer4.setOnAction(event -> {
			config[5] = "real";
			buttonPlayer4.setText("Real");
		});
		bot4.setOnAction(event -> {
			config[5] = "bot";
			buttonPlayer4.setText("Domin'AI");
		});
		noPlayer4.setOnAction(event -> {
			config[5] = "no";
			buttonPlayer4.setText("No Player");
		});
		
		//slider handler
		
		nbPlayer.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				int val = (int)nbPlayer.getValue();
				config[1] = String.valueOf(val);
			}
		});

				
		//lauch handler
		
		launch.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (isGameConfigCorrect(config)) {
					//launch the game
					//TODO : implement this method
					//open a new window in fullscreen
					//System.out.println(Arrays.toString(config));
					Main.mediaPlayer.stop();
					try {
						writeConfigFile(config);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						Game game = new Game(primaryStage);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
				
				else {
					printErrorConfig(root); // print the error in the right section of the screen
				}
			}
		});
	}
	
	private boolean isGameConfigCorrect(String[] config) {
		//TODO : implement this method
		
		if (config[0] == null) {
			errorLog = "*0 == null*";
			return false;
		}
			
		else {
				int c = 0;
				for (int i = 2; i< config.length;i++) {
					if (config[i] != "no") {
						c ++;
					}
				}
				
				if (c != Integer.parseInt(config[1])) {
					errorLog = "*wrong nbPlayer";
					return false;
				}
		
		
		if (config[0] == "grandDuel" && Integer.parseInt(config[1]) != 2) {
			errorLog = "*wrong grandDuel";
			return false;
		}
		
		return true;
	}
	}

	
	private void printErrorConfig(Group root) {
		//TODO : implement this method
		Text log = new Text();
		String erreur = new String();
		if (errorLog == "*0 == null*") {
			erreur = " Il faut choisir "
					+ "\n un mode de jeu !";
		}
		
		else if (errorLog == "*wrong nbPlayer") {
			erreur = " Vous n'avez pas"
					+ "\n selectionné le"
					+ "\n bon nombre de joueurs !";
		}
		
		else if (errorLog == "*wrong grandDuel") {
			erreur = "Ce mode de jeu ne"
					+ "\n se joue qu'à deux !";
		}
		else {
			erreur = "";
		}
		log.setText(erreur);
		log.setFill(Color.RED);
		log.setFont(Font.font(30));
		log.setLayoutX(440);
		log.setLayoutY(500);
		root.getChildren().add(log);
		
	}
	
	private void printDescription(Group root, int mode) {
		//create the textView on the upper-right area describing the game mode.
	
		Text description = new Text();
		switch (mode) {
			case 0:
				description.setText(Constants.getNormalModeDescription());
				break;
			case 1:
				description.setText(Constants.getDynastieModeDescription());
				break;
			case 2:
				description.setText(Constants.getMiddleEmpireModeDescription());
				break;
			case 3:
				description.setText(Constants.getHarmonyModeDescription());
				break;
			case 4:
				description.setText(Constants.getGreatDuelModeDescription());
			
		}
		description.setFill(Color.ANTIQUEWHITE);
		description.setLayoutX(450);
		description.setLayoutY(100);
		description.setFont(Font.font(30));
		
		if (root.getChildren().contains(description)) {
			root.getChildren().remove(description); //remove the old one
			//root.getChildren().add(description);
		}
		else {
			root.getChildren().add(description);
		}
	}
	
	private void writeConfigFile(String[] config) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("config.txt", true));
		for (int i = 0; i < config.length; i ++) {
			writer.append(config[i] + "\n");
		}
		writer.close();
	}
	
}	

