package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int squareSize = 80;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chess");
        Controller controller = new Controller(primaryStage);
        VBox vBox = new VBox();
        Scene scene = new Scene(vBox, 8 * squareSize, 8 * squareSize);
        primaryStage.setScene(scene);
        // add MenuBar
        MenuBar menuBar = new MenuBar();
        vBox.getChildren().add(menuBar);
        // add Game Menu
        Menu gameMenu = new Menu("Game");
        menuBar.getMenus().add(gameMenu);
        controller.setGameMenu(gameMenu);
        MenuItem newGameMenuItem = new MenuItem("New Game");
        newGameMenuItem.setOnAction(controller::handleNewGame);
        gameMenu.getItems().add(newGameMenuItem);
        // add ChessBoard
        ChessBoard chessBoard = new ChessBoard();
        vBox.getChildren().add(chessBoard);
        controller.setBoard(chessBoard);

        primaryStage.show();
    }
}
