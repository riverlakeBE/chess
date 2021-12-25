package chess.Pieces;

import chess.Location;
import chess.Logic.Conditions.ColorOrEmptyCondition;
import chess.Logic.Conditions.KingAttacksCondition;
import chess.Logic.Conditions.MoveCondition;
import chess.Logic.Conditions.NotInCheckCondition;
import chess.Logic.Move;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private final List<Location> moveDiffs = new ArrayList<>();
    {
        moveDiffs.add(new Location(1, 1));
        moveDiffs.add(new Location(1, 0));
        moveDiffs.add(new Location(1, -1));
        moveDiffs.add(new Location(0, 1));
        moveDiffs.add(new Location(0, -1));
        moveDiffs.add(new Location(-1, 0));
        moveDiffs.add(new Location(-1, 1));
        moveDiffs.add(new Location(-1, -1));
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.KING;
    }

    @Override
    public Move getMove(Location location2) {
        //TODO Castling
        Move move = new Move();
        move.addPreCondition(new KingAttacksCondition(location, location2));
        move.addPreCondition(new ColorOrEmptyCondition(location2, color.invert()));
        return move;
    }

    @Override
    public MoveCondition getAttacksCondition(Location location2) {
        return new KingAttacksCondition(location, location2);
    }

    public List<Location> getMoves(Location location) {
        return movesFromDiffs(location, moveDiffs);
    }

}
