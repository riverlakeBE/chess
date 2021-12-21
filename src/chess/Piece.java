package chess;

import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Piece extends Label {

    public static final Font font = new Font(Main.squareSize * 0.4);

    private PieceColor color;
    private Square square;
    private PieceType pieceType;

    public Piece(PieceType pieceType, Square square) {
        this();
        this.pieceType = pieceType;
        this.square = square;
    }

    private Piece() {
        this.setOnDragDetected(
                this::onDragDetected
        );
    }

    public PieceColor getColor() {
        return color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
        updateView();
    }

    public String getLetter() {
        String letter = pieceType.name().substring(0, 1).toLowerCase();
        if (pieceType == PieceType.KING) {
            letter = letter.toUpperCase();
        }
        return letter;
    }

    public void updateView() {
        this.setText(getLetter());
        this.setPrefSize(Main.squareSize, Main.squareSize);
        this.setFont(font);
        this.setTextAlignment(TextAlignment.CENTER);
        if (color != null) {
            this.setTextFill(Paint.valueOf(color.toString()));
        }
    }


    public void onDragDetected(MouseEvent event) {
        Dragboard db = this.startDragAndDrop(TransferMode.ANY);
        ClipboardContent clipboardContent = new ClipboardContent();
        clipboardContent.put(Location.DATAFORMAT, square.getLocation());
        db.setContent(clipboardContent);
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public enum PieceColor {
        WHITE,
        BLACK
    }
}

