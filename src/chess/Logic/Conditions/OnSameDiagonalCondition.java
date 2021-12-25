package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;

public class OnSameDiagonalCondition implements MoveCondition{
    private final Location location1;
    private final Location location2;

    public OnSameDiagonalCondition(Location location1, Location location2) {

        this.location1 = location1;
        this.location2 = location2;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        return Math.abs(location1.getI() - location2.getI()) == Math.abs(location1.getJ() - location2.getJ());
    }
}
