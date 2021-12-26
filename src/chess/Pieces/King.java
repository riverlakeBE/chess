package chess.Pieces;

import chess.Location;
import chess.Logic.Conditions.*;
import chess.Logic.Instructions.AndMoveInstruction;
import chess.Logic.Instructions.MovePieceInstruction;
import chess.Logic.Move;
import chess.Logic.SimpleMove;
import chess.Logic.XORMove;

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
        //King move
        SimpleMove move1 = new SimpleMove();
        move1.addPreCondition(new KingAttackCondition(location, location2));
        move1.addPreCondition(new ColorOrEmptyCondition(location2, color.invert()));
        move1.setInstruction(new MovePieceInstruction(location, location2));

        SimpleMove move2 = new SimpleMove();
        if (color==PieceColor.WHITE && location.equals(4,0)){
            //Short Castles
            if(location2.equals(6,0)){
                move2.addPreCondition(new NeverMovedCondition(location));
                move2.addPreCondition(new NeverMovedCondition(new Location(7,0)));
                move2.addPreCondition(new NotAtackedCondition(location, PieceColor.BLACK));
                move2.addPreCondition(new NotAtackedCondition(new Location(5,0), PieceColor.BLACK));
                move2.setInstruction(new AndMoveInstruction(new MovePieceInstruction(location, location2), new MovePieceInstruction(new Location(7,0), new Location(5,0))));
            }else if(location2.equals(2,0)){
                move2.addPreCondition(new NeverMovedCondition(location));
                move2.addPreCondition(new NeverMovedCondition(new Location(0,0)));
                move2.addPreCondition(new NotAtackedCondition(location, PieceColor.BLACK));
                move2.addPreCondition(new NotAtackedCondition(new Location(4,0), PieceColor.BLACK));
                move2.addPreCondition(new NotAtackedCondition(new Location(5,0), PieceColor.BLACK));
                move2.setInstruction(new AndMoveInstruction(new MovePieceInstruction(location, location2), new MovePieceInstruction(new Location(0,0), new Location(3,0))));
            }else {
                move2.addPreCondition(new BooleanCondition(false));
            }
        }else if(color==PieceColor.BLACK && location.equals(4,7)){
            if(location2.equals(6,7)){
                move2.addPreCondition(new NeverMovedCondition(location));
                move2.addPreCondition(new NeverMovedCondition(new Location(7,7)));
                move2.addPreCondition(new NotAtackedCondition(location, PieceColor.WHITE));
                move2.addPreCondition(new NotAtackedCondition(new Location(5,7), PieceColor.WHITE));
                move2.setInstruction(new AndMoveInstruction(new MovePieceInstruction(location, location2), new MovePieceInstruction(new Location(7,7), new Location(5,7))));
            }else if(location2.equals(2,7)){
                move2.addPreCondition(new NeverMovedCondition(location));
                move2.addPreCondition(new NeverMovedCondition(new Location(0,7)));
                move2.addPreCondition(new NotAtackedCondition(location, PieceColor.WHITE));
                move2.addPreCondition(new NotAtackedCondition(new Location(4,7), PieceColor.WHITE));
                move2.addPreCondition(new NotAtackedCondition(new Location(5,7), PieceColor.WHITE));
                move2.setInstruction(new AndMoveInstruction(new MovePieceInstruction(location, location2), new MovePieceInstruction(new Location(0,7), new Location(3,7))));
            }else {
                move2.addPreCondition(new BooleanCondition(false));

            }
        }else {
            move2.addPreCondition(new BooleanCondition(false));
        }
        return new XORMove(move1, move2);
    }

    @Override
    public MoveCondition getAttackCondition(Location location2) {
        return new KingAttackCondition(location, location2);
    }

    public List<Location> getMoves(Location location) {
        return movesFromDiffs(location, moveDiffs);
    }

}
