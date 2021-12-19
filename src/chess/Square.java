package chess;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;

public class Square extends Pane {
    private Location location;
    private Piece piece;

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
        this.getChildren().add(piece);
        piece.setAlignment(Pos.CENTER);
    }

    public void updateView() {
        if (location != null) {
            String squareColor = (location.getI() + location.getJ()) % 2 == 0 ? "rgb(0,76,153)" : "rgb(160,160,160)";
            this.setStyle("-fx-background-color: " + squareColor);
        }
        if (piece != null) {
            piece.updateView();
        }
    }
}
