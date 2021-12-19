package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int squareSize = 80;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        primaryStage.setTitle("Chess");
        Scene scene = new Scene(gridPane, 8 * squareSize, 8 * squareSize);
        primaryStage.setScene(scene);
        primaryStage.show();
        ChessBoard chessBoard = new ChessBoard();
        gridPane.getChildren().add(chessBoard);
    }
}
