package chess.Logic.Conditions;

import chess.ChessBoard;

public class XORCondition implements MoveCondition {
    private final MoveCondition condition1;
    private final MoveCondition condition2;

    public XORCondition(MoveCondition condition1, MoveCondition condition2) {
        this.condition1 = condition1;
        this.condition2 = condition2;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        return condition1.evaluate(board)^condition2.evaluate(board);
    }
}
