package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;
import chess.Logic.Conditions.MoveCondition;

public class EnPassentCondition implements MoveCondition {
    private final Location location;
    private final Location location2;

    public EnPassentCondition(Location location, Location location2) {
        this.location = location;
        this.location2 = location2;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        return false;
    }
}
