package application;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

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


	@Override
	public void start(Stage Main) {
		Scene MainWindow = new Scene(main, windowX, windowY); // Starting Window
		MainWindow.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Main.setScene(MainWindow);
		ball = new Circle(windowX / 8, Color.RED); // Ball
		game.getChildren().add(ball);
		pad = new Rectangle(windowX, 10, Color.GRAY); // Pad
		game.getChildren().add(pad);
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
				pad.setTranslateY(windowY - 20);
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
				pad.setTranslateY(windowY - 20);
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
				pad.setTranslateY(windowY - 20);
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
		points.textProperty().bind(score);

		new AnimationTimer() {
			public void handle(long currentTimeNano) {
				play();
			}
		}.start();

	}

	private static void play() {
		// Ball movement
		if (left)
			ball.setCenterX(ball.getCenterX() - 5);
		else if (right)
			ball.setCenterX(ball.getCenterX() + 5);

		// When the ball hits the pad
		if (ball.getBoundsInParent().intersects(pad.getBoundsInParent())) {
			// boolean y = false;
			int randomMove = randomNum.nextInt(800);
			// int randomMoveY = randomNum.nextInt(800);
			// while (y == false){
			// if (randomMoveY < 400){
			// randomMoveY = randomNum.nextInt(800);
			// }else{
			// y = true;
			// }
			// }
			pad.setTranslateX(randomMove);
			// pad.setTranslateY(randomMoveY);

			Score += 10;
			score.set("Score: " + Score);
		} else if (ball.getCenterY() + (200 / 8) == pad.getY()) {
			Score -= 10;
			score.set("Score: " + Score);
		}

		if (up == false) {
			if (ball.getCenterY() < windowY / 2 - 40) {

				if (level == 1) {
					ball.setCenterY(ball.getCenterY() + 8);
				} else if (level == 2) {
					ball.setCenterY(ball.getCenterY() + 12);
				} else if (level == 3) {
					ball.setCenterY(ball.getCenterY() + 15);
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
					ball.setCenterY(ball.getCenterY() - 5);
				} else if (level == 2) {
					ball.setCenterY(ball.getCenterY() - 12);
				} else if (level == 3) {
					ball.setCenterY(ball.getCenterY() - 15);
				}

			} else {
				up = false;
			}
			if (ball.getCenterY()-(200/8) == pad.getY() && intersect == false){
				up = false;
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
