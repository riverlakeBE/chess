package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends Application {

    public static final int squareSize = 80;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * One time method to create Piece icons from data/Pieces.png
     */
    private static void makePieceIcons() {
        File file = new File("src/data/Pieces.png");
        try {
            BufferedImage image = ImageIO.read(file);
            int iconWidth = image.getWidth() / 6;
            int iconHeight = image.getHeight() / 2;
            String[] pieceNames = new String[]{"King", "Queen", "Bishop", "Knight", "Rook", "Pawn"};
            for (int i = 0; i < 6; i++) {
                BufferedImage icon = image.getSubimage(i * iconWidth, 0, iconWidth, iconHeight);
                ImageIO.write(icon, "png", new File("src/data/" + pieceNames[i] + "White.png"));
                BufferedImage icon2 = image.getSubimage(i * iconWidth, iconHeight, iconWidth, iconHeight);
                ImageIO.write(icon2, "png", new File("src/data/" + pieceNames[i] + "Black.png"));
            }
        } catch (IOException e) {

            e.printStackTrace();

        }
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
