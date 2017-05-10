package application;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Main extends Application {
	public static int windowX = 200;
	public static int windowY = 200;
	public static int bx = 0, by = 0;
	public static Circle ball;
	public static Pane main = new Pane();
	public static Pane game = new Pane();
	public static Scene gameScreen;
	public static boolean up = false;
	public static Rectangle pad;
	public static boolean left = false, right = false;
	static Random randomNum = new Random();
	public static int level;
	public static int Score = 0;
	static SimpleStringProperty score;
	public static boolean intersect;
	public static ImageView  iv = new ImageView();
	public static Image image;
	public static ImageView  blood1 = new ImageView();
	public static ImageView  blood2 = new ImageView();
	public static ImageView  blood3 = new ImageView();
	public static ImageView  blood4 = new ImageView();
	public static ImageView  blood5 = new ImageView();
	public static ImageView  blood6 = new ImageView();
	public static ImageView  blood7 = new ImageView();
	public static ImageView  blood8 = new ImageView();
	public static ImageView  blood9 = new ImageView();
	public static ImageView  blood10 = new ImageView();
	public static Image spike;
	public static Image blood;


	@Override
	public void start(Stage Main) {
		Scene MainWindow = new Scene(main, windowX, windowY); // Starting Window
		MainWindow.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Main.setScene(MainWindow);
		ball = new Circle(windowX / 8, Color.RED); // Ball
		game.getChildren().add(ball);
		pad = new Rectangle(windowX, 10, Color.GRAY); // Pad
		game.getChildren().add(pad);game.getChildren().add(iv);game.getChildren().add(blood1);game.getChildren().add(blood2);game.getChildren().add(blood3);game.getChildren().add(blood4);game.getChildren().add(blood5);game.getChildren().add(blood6);game.getChildren().add(blood7);game.getChildren().add(blood8);game.getChildren().add(blood9);game.getChildren().add(blood10);
		image = new Image ("file:Background.jpg");
		iv.setImage(image);
		image = new Image ("file:spikes-hi.png");
		blood = new Image ("file:blood_PNG6119.png");
		blood1.setImage(image);blood2.setImage(image);blood3.setImage(image);
		Main.show();

		// Easy Button
		Button Easy = new Button("Easy");
		level = 1;
		Easy.setMinSize(windowX / 2, windowY / 4); // Sizing
		Easy.setLayoutX((windowX / 2) - (windowX / 4)); // X layout
		Easy.setLayoutY((windowY / 2) - (windowY) + (windowY / 3) + 45); // Y
																			// layout
		main.getChildren().add(Easy);
		Easy.setOnAction(new EventHandler<ActionEvent>() { // When Clicked
			@Override
			public void handle(ActionEvent e) {
				windowX = 1000;
				windowY = 850;
				Main.close();
				gameScreen = new Scene(game, windowX, windowY);
				gameScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.setScene(gameScreen);
				ball.setTranslateX(windowX / 2);
				ball.setTranslateY(windowY / 2);
				pad.setTranslateX(windowX / 2);
				pad.setTranslateY(windowY - 50);
				bx = windowX / 2;
				by = windowY / 2;
				Main.show();

				// While the buttons are being pressed a var is set to true
				// When they are released the var is set back to false
				gameScreen.setOnKeyPressed((key) -> {
					if (key.getCode() == KeyCode.LEFT) {
						left = true;
					}
					if (key.getCode() == KeyCode.RIGHT) {
						right = true;
					}

				});
				gameScreen.setOnKeyReleased((key) -> {
					if (key.getCode() == KeyCode.LEFT) {
						left = false;
					}
					if (key.getCode() == KeyCode.RIGHT) {
						right = false;
					}
				});
			}
		});

		// Medium
		Button Medium = new Button("Medium");
		level = 2;
		Medium.setMinSize(windowX / 2, windowY / 4);
		Medium.setLayoutX((windowX / 2) - (windowX / 4));
		Medium.setLayoutY((windowY / 2) - (windowY / 2) + (windowY / 3) + 10);
		main.getChildren().add(Medium);
		Medium.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				windowX = 1000;
				windowY = 850;
				Main.close();

				gameScreen = new Scene(game, windowX, windowY);
				gameScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.setScene(gameScreen);
				ball.setTranslateX(windowX / 2);
				ball.setTranslateY(windowY / 2);
				pad.setTranslateX(windowX / 2);
				pad.setTranslateY(windowY - 50);
				bx = windowX / 2;
				by = windowY / 2;
				Main.show();

				gameScreen.setOnKeyPressed((key) -> {
					if (key.getCode() == KeyCode.LEFT) {
						left = true;
					}
					if (key.getCode() == KeyCode.RIGHT) {
						right = true;
					}
				});
				gameScreen.setOnKeyReleased((key) -> {
					if (key.getCode() == KeyCode.LEFT) {
						left = false;
					}
					if (key.getCode() == KeyCode.RIGHT) {
						right = false;
					}
				});
			}
		});

		// Hard
		Button Hard = new Button("Hard");
		level = 3;
		Hard.setMinSize(windowX / 2, windowY / 4);
		Hard.setLayoutX((windowX / 2) - (windowX / 4));
		Hard.setLayoutY((windowY / 2) - (windowY / 8) + (windowY / 3));
		main.getChildren().add(Hard);
		Hard.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				windowX = 1000;
				windowY = 850;
				Main.close();
				gameScreen = new Scene(game, windowX, windowY);
				gameScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Main.setScene(gameScreen);
				ball.setTranslateX(windowX / 2);
				ball.setTranslateY(windowY / 2);
				pad.setTranslateX(windowX / 2);
				pad.setTranslateY(windowY - 50);
				bx = windowX / 2;
				by = windowY / 2;
				Main.show();
				
				gameScreen.setOnKeyPressed((key) -> {
					if (key.getCode() == KeyCode.LEFT) {
						left = true;
					}
					if (key.getCode() == KeyCode.RIGHT) {
						right = true;
					}

				});
				gameScreen.setOnKeyReleased((key) -> {
					if (key.getCode() == KeyCode.LEFT) {
						left = false;
					}
					if (key.getCode() == KeyCode.RIGHT) {
						right = false;
					}
				});
			}
		});

		Label points = new Label("");
		game.getChildren().add(points);
		score = new SimpleStringProperty("Score: 0");
		points.setTextFill(Color.RED);
		points.setFont(Font.font ("Verdana", 40));
		points.textProperty().bind(score);

		new AnimationTimer() {
			public void handle(long currentTimeNano) {
				play();
			}
		}.start();
	}

	private static void play() {
		if(ball.getCenterX() >= 475){
			right = false;
		}else if (ball.getCenterX() <= -475){
			left = false;
		}
		
		iv.setFitHeight(850);iv.setFitWidth(1000);
		blood1.toBack();blood2.toBack();blood3.toBack();blood4.toBack();blood5.toBack();blood6.toBack();blood7.toBack();blood8.toBack();blood9.toBack();blood10.toBack();
		iv.toBack();
		blood1.setX(0);blood1.setY(800);blood1.setFitHeight(100);blood1.setFitWidth(100);
		blood2.setX(100);blood2.setY(800);blood2.setFitHeight(100);blood2.setFitWidth(100);
		blood3.setX(200);blood3.setY(800);blood3.setFitHeight(100);blood3.setFitWidth(100);
		blood4.setX(300);blood4.setY(800);blood4.setFitHeight(100);blood4.setFitWidth(100);
		blood5.setX(400);blood5.setY(800);blood5.setFitHeight(100);blood5.setFitWidth(100);
		blood6.setX(500);blood6.setY(800);blood6.setFitHeight(100);blood6.setFitWidth(100);
		blood7.setX(600);blood7.setY(800);blood7.setFitHeight(100);blood7.setFitWidth(100);
		blood8.setX(700);blood8.setY(800);blood8.setFitHeight(100);blood8.setFitWidth(100);
		blood9.setX(800);blood9.setY(800);blood9.setFitHeight(100);blood9.setFitWidth(100);
		blood10.setX(-900);blood10.setY(800);blood10.setFitHeight(100);blood10.setFitWidth(100);
		// Ball movement
		if (left)
			ball.setCenterX(ball.getCenterX() - 10);
		else if (right)
			ball.setCenterX(ball.getCenterX() + 10);
		// When the ball hits the pad

		if (ball.getBoundsInParent().intersects(pad.getBoundsInParent())) {
			int randomMove = randomNum.nextInt(800);
			pad.setTranslateX(randomMove);
			Score += 10;
			score.set("Score: " + Score);
		}
		
		if (up == false) {
			if (ball.getCenterY() - 200/8 < 319) {

				if (level == 1) {
					ball.setCenterY(ball.getCenterY() + 10);
				} else if (level == 2) {
					ball.setCenterY(ball.getCenterY() + 12);
				} else if (level == 3) {
					ball.setCenterY(ball.getCenterY() + 25);
					if (left)
						ball.setCenterX(ball.getCenterX() - 5);
					else if (right)
						ball.setCenterX(ball.getCenterX() + 5);
				}
			} else {
				up = true;
			}
		} else {
			if (ball.getBoundsInParent().intersects(pad.getBoundsInParent())){
				intersect = true;
			}
			int y = 0;
			if (level == 1) {
				y = 0;
			} else if (level == 2) {
				y = -100;
			} else if (level == 3) {
				y = -250;
			}
			
			if (ball.getBoundsInParent().intersects(pad.getBoundsInParent())) {
			} else if (ball.getCenterY() > y) {
				if (level == 1) {
					ball.setCenterY(ball.getCenterY() - 10);
				} else if (level == 2) {
					ball.setCenterY(ball.getCenterY() - 12);
				} else if (level == 3) {
					ball.setCenterY(ball.getCenterY() - 25);
				}

			} else {
				up = false;
			}
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
