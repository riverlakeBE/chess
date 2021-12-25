package chess.Pieces;

import chess.Location;
import chess.Logic.Conditions.MoveCondition;
import chess.Logic.Conditions.NotInCheckCondition;
import chess.Logic.Move;
import chess.Square;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece extends Pane {

    private final ImageView imageView = new ImageView();
    protected PieceColor color;
    protected Location location;

    protected Piece() {
        this.getChildren().add(imageView);
        this.setOnDragDetected(
                this::onDragDetected
        );
    }

    private static String getImageUrl(PieceColor color, PieceType pieceType) {
        return "file:src/data/" + pieceType.toString() + color.toString() + ".png";
    }

    public static Piece getInstance(PieceType pieceType, Square square) {
        Piece piece = pieceType.getInstance();
        piece.setLocation(square.getLocation());
        piece.setWidth(square.getWidth());
        piece.setHeight(square.getHeight());
        return piece;
    }

    abstract public PieceType getPieceType();

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
        updateView();
    }

    private void updateView() {
        if (color != null) {
            Image image = new Image(Piece.getImageUrl(color, getPieceType()), this.getWidth(), this.getHeight(), false, false);
            imageView.setImage(image);
        }
    }

    public void onDragDetected(MouseEvent event) {
        Dragboard db = this.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.put(Location.DATAFORMAT, location);
        db.setContent(clipboardContent);
    }


    public Move getMove(Location location2, boolean verifyCheck) {
        Move move = getMove(location2);
        if (verifyCheck) {
            move.addPostCondition(new NotInCheckCondition(color));
        }
        return move;
    }

    protected abstract Move getMove(Location location2);

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    protected List<Location> movesFromDiffs(Location location, List<Location> moveDiffs) {
        List<Location> moves = new ArrayList<>();
        for (Location moveDiff : moveDiffs) {
            Location moveLoc = new Location(location);
            moveLoc.add(moveDiff);
            if (moveLoc.isOnBoard()) {
                moves.add(moveLoc);
            }
        }
        return moves;
    }

    public abstract MoveCondition getAttacksCondition(Location location2);
}

