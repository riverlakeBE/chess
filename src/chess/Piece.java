package chess;

import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public abstract class Piece extends Label {
    public static final Font font = new Font(Main.squareSize * 0.4);

    private PieceColor color;
    private Square square;

    public Piece(Square square){
        this();
        this.square = square;
    }

    public Piece() {
        this.setOnDragDetected(
                this::onDragDetected
        );
        this.setOnDragDropped(
                this::onDragDropped
        );
        this.setOnDragOver(this::onDragOver);
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public abstract String getLetter();

    public void updateView() {
        this.setText(getLetter());
        this.setPrefSize(Main.squareSize, Main.squareSize);
        this.setFont(font);
        this.setTextAlignment(TextAlignment.CENTER);
        this.setTextFill(Paint.valueOf(color.toString()));
    }

    public void onDragDropped(DragEvent event) {
        Dragboard db = event.getDragboard();
        if (db.hasContent(Location.DATAFORMAT)) {

            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    }

    public void onDragDetected(MouseEvent event) {
        Dragboard db = this.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.put(Location.DATAFORMAT, square.getLocation());
        db.setContent(clipboardContent);
    }

    public void onDragOver(DragEvent event) {
        if (event.getGestureSource() != this && event.getDragboard().hasContent(Location.DATAFORMAT)) {
            event.acceptTransferModes(TransferMode.ANY);
        }
        event.consume();
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public enum PieceColor {
        WHITE,
        BLACK
    }
}

