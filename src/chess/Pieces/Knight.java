package chess.Pieces;

import chess.ChessBoard;
import chess.Location;
import chess.Logic.Conditions.*;
import chess.Logic.Instructions.MovePieceInstruction;
import chess.Logic.Move;
import chess.Logic.SimpleMove;

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
        SimpleMove move = new SimpleMove();
        move.addPreCondition(new KnightAttackCondition(location, location2));
        move.addPreCondition(new ColorOrEmptyCondition(location2, color.invert()));
        move.setInstruction(new MovePieceInstruction(location, location2));
        return move;
    }

    @Override
    public MoveCondition getAttackCondition(Location location2) {
        return new KnightAttackCondition(location, location2);
    }

    public List<Location> getMoves(Location location) {
        return movesFromDiffs(location, moveDiffs);
    }

}
