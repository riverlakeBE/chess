package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Pieces.Piece;
import chess.Pieces.PieceColor;
import chess.Pieces.PieceType;
import chess.Square;

public class NotInCheckCondition implements MoveCondition {

    private final PieceColor color;

    public NotInCheckCondition(PieceColor color) {
        this.color = color;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        for (Square square : board.getSquareIterable()) {
            if (!square.isEmpty()) {
                Piece piece = square.getPiece();
                if (piece.getPieceType() == PieceType.KING && piece.getColor() == color) {
                    return new IsAttackedCondition(square.getLocation(), color).evaluate(board);
                }
            }
        }
        return false;
    }
}
