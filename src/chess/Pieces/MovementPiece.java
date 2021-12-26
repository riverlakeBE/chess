package chess.Pieces;

import chess.Location;
import chess.Logic.Conditions.ColorOrEmptyCondition;
import chess.Logic.Instructions.MovePieceInstruction;
import chess.Logic.Move;
import chess.Logic.SimpleMove;

public abstract class MovementPiece extends Piece {

    @Override
    public Move getMove(Location location2) {
        SimpleMove move = new SimpleMove();
        move.addPreCondition(getAttackCondition(location2));
        move.addPreCondition(new ColorOrEmptyCondition(location2, color.invert()));
        move.setInstruction(new MovePieceInstruction(location, location2));
        return move;
    }
}
