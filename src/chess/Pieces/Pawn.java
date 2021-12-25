package chess.Pieces;

import chess.Location;
import chess.Logic.Conditions.*;
import chess.Logic.Move;
import chess.Logic.SimpleMove;

public class Pawn extends Piece {

    @Override
    public PieceType getPieceType() {
        return PieceType.PAWN;
    }

    protected Move getMove(Location location2) {
        Move move = new SimpleMove();
        if (color == PieceColor.WHITE) {
            //pawn moves one square up
            if (location2.getI() == location.getI() && location2.getJ() == location.getJ() + 1) {
                move.addPreCondition(new EmptySquareCondition(location2));
                //pawn takes diagonally
            } else if (Math.abs(location2.getI() - location.getI()) <= 1 && location2.getJ() == location.getJ() + 1) {
                Move move1 = new SimpleMove();
                move1.addPreCondition(new PieceColorCondition(location2, color.invert()));
                //En passent
                Move move2 = new SimpleMove();
                if (location.getJ() == 3) {
                    move2.addPreCondition(new LastMoveCondition(PieceType.PAWN, color.invert(), new Location(location2.getI(), 1), new Location(location2.getI(), 3)));
                } else {
                    move2.addPreCondition(new BooleanCondition(false));
                }


                //pawn moves up two squares as first move
            } else if (location2.getI() == location.getI() && location.getJ() == 1 && location2.getJ() == 3) {
                move.addPreCondition(new EmptySquareCondition(location2));
                move.addPreCondition(new EmptySquareCondition(new Location(location.getI(), 2)));
            } else {
                move.addPreCondition(new BooleanCondition(false));
            }
        } else if (color == PieceColor.BLACK) {
            //pawn moves one square up
            if (location2.getI() == location.getI() && location2.getJ() == location.getJ() - 1) {
                move.addPreCondition(new EmptySquareCondition(location2));
                //pawn takes diagonally
            } else if (Math.abs(location2.getI() - location.getI()) <= 1 && location2.getJ() == location.getJ() - 1) {
                //TODO en passent
                move.addPreCondition(new PieceColorCondition(location2, color.invert()));
                //pawn moves up two squares as first move
            } else if (location2.getI() == location.getI() && location.getJ() == 6 && location2.getJ() == 4) {
                move.addPreCondition(new EmptySquareCondition(location2));
                move.addPreCondition(new EmptySquareCondition(new Location(location.getI(), 5)));
            } else {
                move.addPreCondition(new BooleanCondition(false));
            }
        } else {
            move.addPreCondition(new BooleanCondition(false));
        }
        return move;
    }

    @Override
    public MoveCondition getAttacksCondition(Location location2) {
        //TODO
        return null;
    }
}
