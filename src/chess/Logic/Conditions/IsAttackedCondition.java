package chess.Logic.Conditions;


import chess.ChessBoard;
import chess.Location;
import chess.Pieces.PieceColor;
import chess.Square;

/**
 * evaluates if on the board, the square on location is attacked by the piece color.
 */
public class IsAttackedCondition implements MoveCondition {
    private final Location location;
    private final PieceColor color;

    public IsAttackedCondition(Location location, PieceColor color) {
        this.location = location;
        this.color = color;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        for (Square square : board.getSquareIterable()) {
            if (!square.isEmpty() && square.getPiece().getColor() == color) {
                MoveCondition condition = square.getPiece().getAttacksCondition(location);
                if (condition.evaluate(board)) {
                    return true;
                }
            }
        }
        return false;
    }
}
