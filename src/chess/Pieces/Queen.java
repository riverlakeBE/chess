package chess.Pieces;

import chess.Location;
import chess.Logic.Conditions.MoveCondition;
import chess.Logic.Conditions.QueenAttacksCondition;

import java.util.List;

public class Queen extends MovementPiece {

    @Override
    public PieceType getPieceType() {
        return PieceType.QUEEN;
    }

    @Override
    public MoveCondition getAttackCondition(Location location2) {
        return new QueenAttacksCondition(location, location2);
    }

    public List<Location> getMoves(Location location2) {
        List<Location> moves = Rook.getMoves(location2);
        moves.addAll(Bishop.getMoves(location2));
        return moves;
    }
}
