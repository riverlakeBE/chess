package chess;

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
        square.setPiece(new Piece(PieceType.ROOK, square));
        square = squares[1][0];
        square.setPiece(new Piece(PieceType.KNIGHT, square));
        square = squares[2][0];
        square.setPiece(new Piece(PieceType.BISHOP, square));
        square = squares[3][0];
        square.setPiece(new Piece(PieceType.QUEEN, square));
        square = squares[4][0];
        square.setPiece(new Piece(PieceType.KING, square));
        square = squares[5][0];
        square.setPiece(new Piece(PieceType.BISHOP, square));
        square = squares[6][0];
        square.setPiece(new Piece(PieceType.KNIGHT, square));
        square = squares[7][0];
        square.setPiece(new Piece(PieceType.ROOK, square));
        square = squares[0][7];
        square.setPiece(new Piece(PieceType.ROOK, square));
        square = squares[1][7];
        square.setPiece(new Piece(PieceType.KNIGHT, square));
        square = squares[2][7];
        square.setPiece(new Piece(PieceType.BISHOP, square));
        square = squares[3][7];
        square.setPiece(new Piece(PieceType.QUEEN, square));
        square = squares[4][7];
        square.setPiece(new Piece(PieceType.KING, square));
        square = squares[5][7];
        square.setPiece(new Piece(PieceType.BISHOP, square));
        square = squares[6][7];
        square.setPiece(new Piece(PieceType.KNIGHT, square));
        square = squares[7][7];
        square.setPiece(new Piece(PieceType.ROOK, square));
        for (int i = 0; i < 8; i++) {
            square = squares[i][1];
            square.setPiece(new Piece(PieceType.PAWN, square));
        }
        for (int i = 0; i < 8; i++) {
            square = squares[i][6];
            square.setPiece(new Piece(PieceType.PAWN, square));
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
                square.setBoard(this);
                square.setPrefHeight(Main.squareSize);
                square.setPrefWidth(Main.squareSize);
                square.updateView();
            }
        }
        this.setWidth(320);
        this.setHeight(320);
    }

    public Square getSquare(Location location) {
        return squares[location.getI()][location.getJ()];
    }

    public Square getSquare(int i, int j) {
        return squares[i][j];
    }

    public void handleDragDrop(Piece sourcePiece, Square dropSquare) {
        if(isLegalMove(sourcePiece, dropSquare)){
            doPieceMove(sourcePiece,dropSquare);
        }
    }

    private boolean isLegalMove(Piece piece, Square square) {
        boolean canMove = piece.getPieceType().canMove(piece.getSquare().getLocation(), square.getLocation(), this);
        System.out.println("canMove" + canMove);
        return canMove;
    }
}
