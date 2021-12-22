package chess;

import javafx.scene.layout.GridPane;

public class ChessBoard extends GridPane {
    private final Square[][] squares = new Square[8][8];

    public ChessBoard() {
        this.setWidth(320);
        this.setHeight(320);
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                square = squares[i][j];
                square.setBoard(this);
                square.setPrefHeight(Main.squareSize);
                square.setPrefWidth(Main.squareSize);
                square.updateView();
            }
        }
    }

    public Square getSquare(Location location) {
        return squares[location.getI()][location.getJ()];
    }

    public Square getSquare(int i, int j) {
        return squares[i][j];
    }

    public void handleDragDrop(Piece sourcePiece, Square dropSquare) {

        if (isLegalMovement(sourcePiece, dropSquare)) {
            ChessBoard virtualBoard = new ChessBoard();
            virtualBoard.executeMove(sourcePiece, dropSquare);
            if (virtualBoard.isCheck(virtualBoard, sourcePiece.getColor())) {
                executeMove(sourcePiece, dropSquare);
            }
        }
    }

    private void executeMove(Piece piece, Square square) {
        piece.getSquare().setPiece(null);
        square.setPiece(piece);
    }

    private boolean isCheck(ChessBoard board, Piece.PieceColor color) {
        return false;
    }

    private boolean isLegalMovement(Piece piece, Square square) {
        return piece.getPieceType().canMove(piece.getSquare().getLocation(), square.getLocation(), this);
    }

    /**
     * @return deep copy of this.
     */
    public ChessBoard copy() {
        ChessBoard newBoard = new ChessBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece oldPiece = this.getSquare(i,j).getPiece();
                Square newSquare = newBoard.getSquare(i,j);
                Piece newPiece = new Piece(oldPiece.getPieceType(), newSquare);
                newPiece.setColor(oldPiece.getColor());
                newSquare.setPiece(newPiece);
            }
        }
        return newBoard;
    }

    public void resetPieces() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = squares[i][j];
                square.setPiece(null);
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
    }
}
