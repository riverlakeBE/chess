package chess;

import chess.Pieces.Piece;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class Square extends Pane {
    private Location location;
    private Piece piece=null;
    private ChessBoard board;

    public Square() {
        this.setOnDragDropped(
                this::onDragDropped
        );
        this.setOnDragOver(this::onDragOver);
    }

    public void onDragDropped(DragEvent event) {
        Object source = event.getGestureSource();
        if (source instanceof Piece) {
            board.handleDragDrop((Piece) source, this);
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    public void onDragOver(DragEvent event) {
        Object source = event.getGestureSource();
        if (source instanceof Piece && source != piece) {
            event.acceptTransferModes(TransferMode.ANY);
        }
        event.consume();
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        this.getChildren().clear();
        if (piece != null) {
            piece.setLocation(location);
            this.getChildren().add(piece);
        }
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public void updateView() {
        if (location != null) {
            String squareColor = (location.getI() + location.getJ()) % 2 == 0 ? "rgb(0,76,153)" : "rgb(160,160,160)";
            this.setStyle("-fx-background-color: " + squareColor);
        }
    }

    public ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }
}
