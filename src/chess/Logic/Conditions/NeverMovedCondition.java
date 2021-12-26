package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;
import chess.Logic.ExecutedMove;

public class NeverMovedCondition implements MoveCondition {
    private final Location location;

    public NeverMovedCondition(Location location) {
        this.location = location;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        for (ExecutedMove executedMove : board.getMoves()){
            if(executedMove.getLocation1().equals(location)){
                return false;
            }
        }
        return true;
    }
}
