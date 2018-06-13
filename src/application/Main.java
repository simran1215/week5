package application;

import java.awt.Rectangle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Drawing Operations Test");
		Group root = new Group();
		Canvas canvas = new Canvas(300, 300);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawShapes(gc);
		root.getChildren().add(canvas);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	private void drawShapes(GraphicsContext gc) {
		bigSquare(gc, 0, 0);
		bigSquare(gc, 215, 0);
		bigSquare(gc, 0, 215);

		double qrFreq = 0.4; // percent chance of having a QR spot

		// TopBox
		for (int i = 0; i <= 7; i++) {
			for (int j = 8; j <= 16; j++) {
				if (Math.random() < qrFreq)
					smallSquare(gc, j * 12, i * 12);
			}
		}

		// MiddleBox
		for (int i = 8; i <= 16; i++) {
			for (int j = 0; j <= 24; j++) {
				if (Math.random() < qrFreq)
					smallSquare(gc, j * 12, i * 12);
			}
		}

		// BottomBox
		for (int i = 17; i <= 24; i++) {
			for (int j = 8; j <= 16; j++) {
				if (Math.random() < qrFreq)
					smallSquare(gc, j * 12, i * 12);
			}
		}

		// RightOfAlignBox
		for (int i = 17; i <= 21; i++) {
			for (int j = 21; j <= 24; j++) {
				if (Math.random() < qrFreq)
					smallSquare(gc, j * 12, i * 12);
			}
		}

		// Under Align Box
		for (int i = 21; i <= 24; i++) {
			for (int j = 8; j <= 24; j++) {
				if (Math.random() < qrFreq)
					smallSquare(gc, j * 12, i * 12);
			}
		}

		middleSquare(gc, 192, 192);
	}

	private void bigSquare(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.BLACK);
		gc.fillRect(x, y, 84, 84);
		gc.setFill(Color.WHITE);
		gc.fillRect(x + 12, y + 12, 60, 60);
		gc.setFill(Color.BLACK);
		gc.fillRect(x + 24, y + 24, 36, 36);
	}

	private void middleSquare(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.BLACK);
		gc.fillRect(x, y, 60, 60);
		gc.setFill(Color.WHITE);
		gc.fillRect(x + 12, y + 12, 36, 36);
		gc.setFill(Color.BLACK);
		gc.fillRect(x + 24, y + 24, 12, 12);
	}

	private void smallSquare(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.BLACK);
		gc.fillRect(x, y, 12, 12);
	}
}
