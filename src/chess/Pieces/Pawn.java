package chess.Pieces;

import chess.Location;
import chess.Logic.Conditions.*;
import chess.Logic.Instructions.AndMoveInstruction;
import chess.Logic.Instructions.ClearSquareInstruction;
import chess.Logic.Instructions.MovePieceInstruction;
import chess.Logic.Move;
import chess.Logic.SimpleMove;
import chess.Logic.XORMove;

public class Pawn extends Piece {

    @Override
    public PieceType getPieceType() {
        return PieceType.PAWN;
    }

    protected Move getMove(Location location2) {
        Move move = null;
        if (color == PieceColor.WHITE) {
            //pawn moves one square up
            if (location2.getI() == location.getI() && location2.getJ() == location.getJ() + 1) {
                SimpleMove move1 = new SimpleMove();
                move1.addPreCondition(new EmptySquareCondition(location2));
                move1.setInstruction(new MovePieceInstruction(location, location2));
                move = move1;
                //pawn takes diagonally
            } else if (Math.abs(location2.getI() - location.getI()) <= 1 && location2.getJ() == location.getJ() + 1) {
                SimpleMove move1 = new SimpleMove();
                move1.addPreCondition(new PieceColorCondition(location2, color.invert()));
                move1.setInstruction(new MovePieceInstruction(location, location2));
                //En passent
                SimpleMove move2 = new SimpleMove();
                if (location.getJ() == 3) {
                    move2.addPreCondition(new LastMoveCondition(PieceType.PAWN, color.invert(), new Location(location2.getI(), 1), new Location(location2.getI(), 3)));
                    move2.setInstruction(new AndMoveInstruction(new MovePieceInstruction(location, location2), new ClearSquareInstruction(new Location(location2.getI(), location.getJ()))));
                } else {
                    move2.addPreCondition(new BooleanCondition(false));
                }
                move = new XORMove(move1, move2);

                //pawn moves up two squares as first move
            } else if (location2.getI() == location.getI() && location.getJ() == 1 && location2.getJ() == 3) {
                SimpleMove move1 = new SimpleMove();
                move1.addPreCondition(new EmptySquareCondition(location2));
                move1.addPreCondition(new EmptySquareCondition(new Location(location.getI(), 2)));
                move1.setInstruction(new MovePieceInstruction(location, location2));
                move = move1;
            } else {
                SimpleMove move1 = new SimpleMove();
                move1.addPreCondition(new BooleanCondition(false));
            }
        } else if (color == PieceColor.BLACK) {
            //pawn moves one square up
            if (location2.getI() == location.getI() && location2.getJ() == location.getJ() - 1) {
                SimpleMove move1 = new SimpleMove();
                move1.addPreCondition(new EmptySquareCondition(location2));
                move1.setInstruction(new MovePieceInstruction(location, location2));
                move = move1;
                //pawn takes diagonally
            } else if (Math.abs(location2.getI() - location.getI()) <= 1 && location2.getJ() == location.getJ() - 1) {
                SimpleMove move1 = new SimpleMove();
                move1.addPreCondition(new PieceColorCondition(location2, color.invert()));
                move1.setInstruction(new MovePieceInstruction(location, location2));
                //En passent
                SimpleMove move2 = new SimpleMove();
                if (location.getJ() == 4) {
                    move2.addPreCondition(new LastMoveCondition(PieceType.PAWN, color.invert(), new Location(location2.getI(), 6), new Location(location2.getI(), 4)));
                    move2.setInstruction(new AndMoveInstruction(new MovePieceInstruction(location, location2), new ClearSquareInstruction(new Location(location2.getI(), location.getJ()))));
                } else {
                    move2.addPreCondition(new BooleanCondition(false));
                }
                move = new XORMove(move1, move2);
                //pawn moves up two squares as first move
            } else if (location2.getI() == location.getI() && location.getJ() == 6 && location2.getJ() == 4) {
                SimpleMove move1 = new SimpleMove();
                move1.addPreCondition(new EmptySquareCondition(location2));
                move1.addPreCondition(new EmptySquareCondition(new Location(location.getI(), 5)));
                move1.setInstruction(new MovePieceInstruction(location, location2));
                move = move1;
            } else {
                SimpleMove move1 = new SimpleMove();
                move1.addPreCondition(new BooleanCondition(false));
            }
        } else {
            SimpleMove move1 = new SimpleMove();
            move1.addPreCondition(new BooleanCondition(false));
        }
        return move;
    }

    @Override
    public MoveCondition getAttackCondition(Location location2) {
        //todo
        return new BooleanCondition(false);
    }
}
