package chess;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

public class Controller {
    private ChessBoard board;
    private Stage stage;
    private Menu gameMenu;

    public Controller(Stage stage){
        this.stage = stage;
    }
    public void handleNewGame(ActionEvent actionEvent) {
        board.resetPieces();
    }

    public void setGameMenu(Menu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public Menu getGameMenu() {
        return gameMenu;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }
    public ChessBoard getBoard(){
        return board;
    }
}
