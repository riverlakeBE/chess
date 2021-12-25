package chess.Logic.Conditions;

import chess.ChessBoard;

public class BooleanCondition implements MoveCondition {
    private final boolean b;

    public BooleanCondition(boolean b) {
        this.b = b;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        return b;
    }
}
