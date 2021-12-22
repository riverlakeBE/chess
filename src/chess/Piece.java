package chess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class Piece extends Pane {

    public static final Font font = new Font(Main.squareSize * 0.4);
    private final ImageView imageView = new ImageView();
    private PieceColor color;
    private Square square;
    private PieceType pieceType;

    public Piece(PieceType pieceType, Square square) {
        this();
        this.square = square;
        this.setHeight(square.getHeight());
        this.setWidth(square.getWidth());
        this.pieceType = pieceType;
    }

    private Piece() {
        this.getChildren().add(imageView);
        this.setOnDragDetected(
                this::onDragDetected
        );
    }

    private static String getImageUrl(PieceColor color, PieceType pieceType) {
        return "file:src/data/" + pieceType.toString() + color.toString() + ".png";
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
        if (color != null && pieceType != null) {
            Image image = new Image(Piece.getImageUrl(color, pieceType), this.getWidth(), this.getHeight(), false, false);
            imageView.setImage(image);
            /*BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background background = new Background(backgroundImage);
            this.setBackground(background);*/
        }
        /*this.setText(getLetter());
        this.setPrefSize(Main.squareSize, Main.squareSize);
        this.setFont(font);
        this.setTextAlignment(TextAlignment.CENTER);
        if (color != null) {
            this.setTextFill(Paint.valueOf(color.toString()));
        }*/
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

