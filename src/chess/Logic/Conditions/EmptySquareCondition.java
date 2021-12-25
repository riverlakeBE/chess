package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;

public class EmptySquareCondition implements MoveCondition {

    private final Location location;

    public EmptySquareCondition(Location location){
        this.location= location;
    }
    @Override
    public boolean evaluate(ChessBoard board) {
        return board.getSquare(location).isEmpty();
    }
}
