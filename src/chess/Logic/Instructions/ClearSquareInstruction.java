package chess.Logic.Instructions;

import chess.ChessBoard;
import chess.Location;
import chess.Pieces.Piece;

public class ClearSquareInstruction implements MoveInstruction {
    private final Location location;
    private Piece piece;

    public ClearSquareInstruction(Location location) {
        this.location = location;
    }

    @Override
    public void execute(ChessBoard board) {
        piece = board.getSquare(location).getPiece();
        board.getSquare(location).setPiece(null);
    }

    @Override
    public void reverse(ChessBoard board) {
        board.getSquare(location).setPiece(piece);
    }
}
