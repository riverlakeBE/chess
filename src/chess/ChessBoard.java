package chess;

import chess.Logic.ExecutedMove;
import chess.Logic.Move;
import chess.Pieces.Piece;
import chess.Pieces.PieceColor;
import chess.Pieces.PieceType;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChessBoard extends GridPane {
    private final Square[][] squares = new Square[8][8];
    private List<ExecutedMove> moveList = new ArrayList<>();

    public ChessBoard() {
        this.setWidth(8 * Main.squareSize);
        this.setHeight(8 * Main.squareSize);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = new Square();
                square.setLocation(new Location(i, j));
                square.setPrefHeight(Main.squareSize);
                square.setPrefWidth(Main.squareSize);
                square.updateView();
                square.setBoard(this);
                squares[i][j] = square;
                this.add(square, i, 8 - j);
            }
        }
    }

    public Square getSquare(Location location) {
        return squares[location.getI()][location.getJ()];
    }

    public Square getSquare(int i, int j) {
        return squares[i][j];
    }

    public List<Square> getSquareList() {
        return Arrays.stream(squares).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    public void handleDragDrop(Piece sourcePiece, Square dropSquare) {
        Move move = sourcePiece.getMove(dropSquare.getLocation(), true);
        System.out.println("Move:" + sourcePiece.getLocation() + dropSquare.getLocation());
        ExecutedMove executedMove = move.executeMove(this);

        if (executedMove != null) {
            moveList.add(executedMove);
        }
    }

    /**
     * @return deep copy of this.
     */
    public ChessBoard copy() {
        ChessBoard newBoard = new ChessBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece oldPiece = this.getSquare(i, j).getPiece();
                Square newSquare = newBoard.getSquare(i, j);
                Piece newPiece = oldPiece.getPieceType().getInstance();
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
        square.setPiece(Piece.getInstance(PieceType.ROOK, square));
        square = squares[1][0];
        square.setPiece(Piece.getInstance(PieceType.KNIGHT, square));
        square = squares[2][0];
        square.setPiece(Piece.getInstance(PieceType.BISHOP, square));
        square = squares[3][0];
        square.setPiece(Piece.getInstance(PieceType.QUEEN, square));
        square = squares[4][0];
        square.setPiece(Piece.getInstance(PieceType.KING, square));
        square = squares[5][0];
        square.setPiece(Piece.getInstance(PieceType.BISHOP, square));
        square = squares[6][0];
        square.setPiece(Piece.getInstance(PieceType.KNIGHT, square));
        square = squares[7][0];
        square.setPiece(Piece.getInstance(PieceType.ROOK, square));
        square = squares[0][7];
        square.setPiece(Piece.getInstance(PieceType.ROOK, square));
        square = squares[1][7];
        square.setPiece(Piece.getInstance(PieceType.KNIGHT, square));
        square = squares[2][7];
        square.setPiece(Piece.getInstance(PieceType.BISHOP, square));
        square = squares[3][7];
        square.setPiece(Piece.getInstance(PieceType.QUEEN, square));
        square = squares[4][7];
        square.setPiece(Piece.getInstance(PieceType.KING, square));
        square = squares[5][7];
        square.setPiece(Piece.getInstance(PieceType.BISHOP, square));
        square = squares[6][7];
        square.setPiece(Piece.getInstance(PieceType.KNIGHT, square));
        square = squares[7][7];
        square.setPiece(Piece.getInstance(PieceType.ROOK, square));
        for (int i = 0; i < 8; i++) {
            square = squares[i][1];
            square.setPiece(Piece.getInstance(PieceType.PAWN, square));
        }
        for (int i = 0; i < 8; i++) {
            square = squares[i][6];
            square.setPiece(Piece.getInstance(PieceType.PAWN, square));
        }

        for (int i = 0; i < 8; i++) {
            squares[i][0].getPiece().setColor(PieceColor.WHITE);
            squares[i][1].getPiece().setColor(PieceColor.WHITE);
            squares[i][6].getPiece().setColor(PieceColor.BLACK);
            squares[i][7].getPiece().setColor(PieceColor.BLACK);
        }
        moveList = new ArrayList<>();
    }

    public List<ExecutedMove> getMoves() {
        return moveList;
    }

    public void addMove(ExecutedMove executedMove) {
        moveList.add(executedMove);
    }

    public Square[][] getSquares() {
        return squares;
    }
}
