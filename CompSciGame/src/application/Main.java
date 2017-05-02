package application;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	public static int windowX = 200; 
	public static int windowY = 200; 
	public static int bx =  0, by = 0;
	public static Circle ball;
	public static Pane main = new Pane();
	public static Pane game = new Pane();
	public static Scene gameScreen;
	public static boolean up = false;
	public static Rectangle pad;

	@Override
	public void start(Stage Main) {
			Scene MainWindow = new Scene(main,windowX,windowY);
			MainWindow.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.setScene(MainWindow);
			ball = new Circle(windowX/8, Color.RED);
	        game.getChildren().add(ball);
	        pad = new Rectangle(windowX, 10, Color.GRAY);
	        game.getChildren().add(pad);
			Main.show();
			
			Button largeWindow = new Button ("large");
			largeWindow.setMinSize(windowX/2, windowY/4);
			largeWindow.setLayoutX((windowX/2) - (windowX/4));
			largeWindow.setLayoutY((windowY/2)- (windowY/8) + (windowY/3));
			main.getChildren().add(largeWindow);
			largeWindow.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			    	windowX = 1200;
			    	windowY = 850;
			    	Main.close();
			    	
			    	gameScreen = new Scene(game,windowX,windowY);
					gameScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					Main.setScene(gameScreen);
					ball.setTranslateX(windowX/2);
					ball.setTranslateY(windowY/2);
			        pad.setTranslateX(windowX/2);
					pad.setTranslateY(windowY-20);
					bx = windowX/2; by = windowY/2;
					Main.show();

					
					gameScreen.setOnKeyPressed((key) -> {
					      if(key.getCode()==KeyCode.LEFT) {
					          ball.setCenterX(ball.getCenterX()-10);
					      }
					      if(key.getCode()==KeyCode.RIGHT) {
					          ball.setCenterX(ball.getCenterX()+10);
					      }
					      
					});
					
					
			    }
			});

			new AnimationTimer(){
				 public void handle (long currentTimeNano){
					 play();
				 }
			}.start();
			
			
			
	}
	
	private static void play(){
		if (up == false){
			if (ball.getCenterY() < windowY/2 - 40){
				ball.setCenterY(ball.getCenterY()+5);
			}else{
				up = true;
			}
		}else{
			if (ball.getCenterY() > -100){
				ball.setCenterY(ball.getCenterY()-5);
			}else{
				up = false;
			}
		}
		
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
