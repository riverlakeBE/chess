package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;
import chess.Pieces.PieceColor;

public class NotAtackedCondition implements MoveCondition{
    private final IsAttackedCondition condition;
    public NotAtackedCondition(Location location, PieceColor color) {
        condition = new IsAttackedCondition(location, color);
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        return !condition.evaluate(board);
    }
}
