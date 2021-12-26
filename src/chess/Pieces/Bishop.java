package chess.Pieces;

import chess.Location;
import chess.Logic.Conditions.BishopAttackCondition;
import chess.Logic.Conditions.MoveCondition;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends MovementPiece {
    private final List<Location> moveDiffs = new ArrayList<>();

    {
        for (int i = 1; i < 8; i++) {
            moveDiffs.add(new Location(i, i));
            moveDiffs.add(new Location(-i, i));
            moveDiffs.add(new Location(i, -i));
            moveDiffs.add(new Location(-i, -i));
        }
    }

    public static List<Location> getMoves(Location location) {
        List<Location> moves = new ArrayList<>();
        int diagNr1 = -location.getI() + location.getJ();
        int diagNr2 = location.getI() + location.getJ();
        for (int i = 0; i < 8; i++) {
            if (i != location.getI()) {
                Location location1 = new Location(i, i + diagNr1);
                if (location1.isOnBoard()) {
                    moves.add(location1);
                }
                Location location2 = new Location(i, diagNr2 - i);
                if (location2.isOnBoard()) {
                    moves.add(location2);
                }
            }
        }
        return moves;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.BISHOP;
    }

    @Override
    public MoveCondition getAttackCondition(Location location2) {
        return new BishopAttackCondition(location, location2);
    }
}
