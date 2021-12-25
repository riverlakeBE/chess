package chess.Pieces;

import chess.ChessBoard;
import chess.Location;
import chess.Logic.Conditions.*;
import chess.Logic.Move;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    private final List<Location> moveDiffs = new ArrayList<>();

    {
        moveDiffs.add(new Location(1, 2));
        moveDiffs.add(new Location(-1, 2));
        moveDiffs.add(new Location(1, -2));
        moveDiffs.add(new Location(-1, -2));
        moveDiffs.add(new Location(2, 1));
        moveDiffs.add(new Location(-2, 1));
        moveDiffs.add(new Location(2, -1));
        moveDiffs.add(new Location(-2, -1));
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.KNIGHT;
    }

    @Override
    public Move getMove(Location location2) {
        Move move = new Move();
        move.addPreCondition(new KnightAttackCondition(location, location2));
        move.addPreCondition(new ColorOrEmptyCondition(location2, color));
        return move;
    }

    @Override
    public MoveCondition getAttacksCondition(Location location2) {
        return new KnightAttackCondition(location, location2);
    }

    public List<Location> getMoves(Location location) {
        return movesFromDiffs(location, moveDiffs);
    }

}
