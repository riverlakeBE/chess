package chess.Logic;

import chess.ChessBoard;
import chess.Location;
import chess.Pieces.Piece;
import chess.Pieces.PieceColor;
import chess.Pieces.PieceType;

import java.util.ArrayList;
import java.util.List;

public class ExecutedMove {
    private List<SquareChange> changes = new ArrayList<>();
    private PieceType pieceType;
    private PieceColor playerColor;
    private Location location1;
    private Location location2;
    private boolean isCapture;

    public void addSquareChange(Location location, Piece pieceBefore, Piece pieceAfter) {
        changes.add(new SquareChange(location, pieceBefore, pieceAfter));
    }

    public void execute(ChessBoard board) {
        for (SquareChange change : changes) {
            change.doChange(board);
        }
    }

    public void reverse(ChessBoard board) {
        for (SquareChange change : changes) {
            change.reverseChange(board);
        }
    }

    public PieceColor getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(PieceColor playerColor) {
        this.playerColor = playerColor;
    }

    public Location getLocation1() {
        return location1;
    }

    public void setLocation1(Location location1) {
        this.location1 = location1;
    }

    public Location getLocation2() {
        return location2;
    }

    public void setLocation2(Location location2) {
        this.location2 = location2;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public boolean isCapture() {
        return isCapture;
    }

    public void setCapture(boolean capture) {
        isCapture = capture;
    }

    public void merge(ExecutedMove executedMove2) {
        changes.addAll(executedMove2.changes);

    }

    private class SquareChange {
        private final Location location;
        private final Piece pieceAfter;
        private final Piece pieceBefore;

        private SquareChange(Location location, Piece pieceBefore, Piece pieceAfter) {
            this.location = location;
            this.pieceAfter = pieceAfter;
            this.pieceBefore = pieceBefore;
        }

        private void doChange(ChessBoard board) {
            board.getSquare(location).setPiece(pieceAfter);
        }

        private void reverseChange(ChessBoard board) {
            board.getSquare(location).setPiece(pieceBefore);
        }
    }
}
