package chess.Pieces;

import chess.Location;
import chess.Logic.Conditions.*;
import chess.Logic.Move;

import java.util.ArrayList;
import java.util.List;

public class Rook extends MovementPiece {

    public static List<Location> getMoves(Location location) {
        List<Location> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (i != location.getI()) {
                Location move = new Location(i, location.getJ());
                moves.add(move);
            }
            if (i != location.getJ()) {
                Location move = new Location(location.getI(), i);
                moves.add(move);
            }
        }
        return moves;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.ROOK;
    }

    @Override
    public MoveCondition getAttackCondition(Location location2) {
        return new RookAttacksCondition(location, location2);
    }
}
