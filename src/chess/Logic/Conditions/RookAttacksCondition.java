package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;

public class RookAttacksCondition implements MoveCondition {
    private final Location location1;
    private final Location location2;

    public RookAttacksCondition(Location location1, Location location2) {
        this.location1 = location1;
        this.location2 = location2;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        return new OnSameLineCondition(location1, location2).evaluate(board)
                && new EmptyRangeCondition(location1, location2).evaluate(board);
    }
}
