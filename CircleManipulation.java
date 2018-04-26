/*
 * Code by: William Colachicco
 * This is a simple GUI exercise which manipulates a circle.
 * A button moves the circle incrementally across the screen.
 * There is a button to resize the circle.
 * Radio buttons change the color of the circle.
 * 
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
	
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	boolean flag = false;
	
	public void start(Stage stage) {
		
		Stage stage1 = new Stage();
		
		Circle circle = new Circle();
		circle.setCenterX(250);
		circle.setCenterY(100);
		circle.setRadius(80);
		circle.setStroke(Color.GREEN);
		circle.setFill(Color.AQUAMARINE);
		
		Button okBtn = new Button("Resize");
		Button moveBtn = new Button("Move");
		moveBtn.setOnAction(e -> {
			
			double len = circle.getCenterX();
			len += 50;
			if (len > 550)
			{
				len = 100;
			}
			circle.setCenterX(len);
		});
		
		okBtn.setOnAction(e -> {
			if (flag == false) 
			{
			circle.setFill(Color.GOLDENROD);
			circle.setRadius(100);
			flag = true; 
			}
			
			else 
			{
				circle.setFill(Color.FUCHSIA);
				circle.setRadius(30);
				flag = false;
			}
		});
		
		ToggleGroup group = new ToggleGroup();
		RadioButton radioBtn1 = new RadioButton("red");
		RadioButton radioBtn2 = new RadioButton("green");
		RadioButton radioBtn3 = new RadioButton("blue");
		
		radioBtn1.setToggleGroup(group);
		radioBtn2.setToggleGroup(group);
		radioBtn3.setToggleGroup(group);
		
		radioBtn1.setOnAction(e -> { 
			circle.setFill(Color.RED);
			radioBtn1.setTextFill(Color.RED);
			radioBtn2.setTextFill(Color.BLACK);
			radioBtn3.setTextFill(Color.BLACK);
		});
		
		radioBtn2.setOnAction(e -> { 
			circle.setFill(Color.GREEN);
			radioBtn1.setTextFill(Color.BLACK);
			radioBtn2.setTextFill(Color.GREEN);
			radioBtn3.setTextFill(Color.BLACK);
		});
		
		radioBtn3.setOnAction(e -> { 
			circle.setFill(Color.BLUE);
			radioBtn1.setTextFill(Color.BLACK);
			radioBtn2.setTextFill(Color.BLACK);
			radioBtn3.setTextFill(Color.BLUE);
		});
		
		Pane pane2 = new Pane();
		pane2.getChildren().addAll(circle);
		
		okBtn.setTranslateX(220);
		moveBtn.setTranslateX(220);
		
		VBox vPane = new VBox();
		vPane.setPadding(new Insets(10,10,10,10));
		vPane.setSpacing(5);
		
		vPane.getChildren().addAll(pane2, okBtn, moveBtn, radioBtn1, radioBtn2, radioBtn3);
		Scene scene2 = new Scene(vPane, 700, 700);
		
		stage1.setScene(scene2);
		stage1.setTitle("Circle Action");
		stage1.show();
		
	}

}
