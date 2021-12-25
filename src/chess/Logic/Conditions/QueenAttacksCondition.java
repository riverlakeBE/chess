package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;

public class QueenAttacksCondition implements MoveCondition {
    private final Location location1;
    private final Location location2;

    public QueenAttacksCondition(Location location1, Location location2) {
        this.location1 = location1;
        this.location2 = location2;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        boolean result = new BishopAttackCondition(location1, location2).evaluate(board)
                || new RookAttacksCondition(location1, location2).evaluate(board);
        if (result){
            result = new EmptyRangeCondition(location1, location2).evaluate(board);
        }
        return result;
    }
}
