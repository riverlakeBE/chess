package chess;

import chess.Pieces.*;
import javafx.scene.layout.GridPane;

public class ChessBoard extends GridPane {
    private final Square[][] squares = new Square[8][8];

    public ChessBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = new Square();
                square.setLocation(new Location(i, j));
                squares[i][j] = square;
                square.setPrefWidth(20);
                square.setPrefHeight(20);
                this.add(square, i, 8 - j);
            }
        }
        Square square;
        square = squares[0][0];
        square.setPiece(new Rook(square));
        square = squares[1][0];
        square.setPiece(new Knight(square));
        square = squares[2][0];
        square.setPiece(new Bishop(square));
        square = squares[3][0];
        square.setPiece(new Queen(square));
        square = squares[4][0];
        square.setPiece(new King(square));
        square = squares[5][0];
        square.setPiece(new Bishop(square));
        square = squares[6][0];
        square.setPiece(new Knight(square));
        square = squares[7][0];
        square.setPiece(new Rook(square));
        square = squares[0][7];
        square.setPiece(new Rook(square));
        square = squares[1][7];
        square.setPiece(new Knight(square));
        square = squares[2][7];
        square.setPiece(new Bishop(square));
        square = squares[3][7];
        square.setPiece(new Queen(square));
        square = squares[4][7];
        square.setPiece(new King(square));
        square = squares[5][7];
        square.setPiece(new Bishop(square));
        square = squares[6][7];
        square.setPiece(new Knight(square));
        square = squares[7][7];
        square.setPiece(new Rook(square));
        for (int i = 0; i < 8; i++) {
            square = squares[i][1];
            square.setPiece(new Pawn(square));
        }
        for (int i = 0; i < 8; i++) {
            square = squares[i][6];
            square.setPiece(new Pawn(square));
        }

        for (int i = 0; i < 8; i++) {
            squares[i][0].getPiece().setColor(Piece.PieceColor.WHITE);
            squares[i][1].getPiece().setColor(Piece.PieceColor.WHITE);
            squares[i][6].getPiece().setColor(Piece.PieceColor.BLACK);
            squares[i][7].getPiece().setColor(Piece.PieceColor.BLACK);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                square = squares[i][j];
                square.setPrefHeight(Main.squareSize);
                square.setPrefWidth(Main.squareSize);
                square.updateView();
            }
        }
        this.setWidth(320);
        this.setHeight(320);
    }
}
