package chess.Logic;

import chess.ChessBoard;
import chess.Logic.Instructions.MoveInstruction;

public class SimpleMove extends Move {
    @Override
    public boolean executeMove(ChessBoard board) {
        if (Move.evaluate(preConditions, board)) {
            instruction.execute(board);
            if(!Move.evaluate(postConditions,board)){
                instruction.reverse(board);
                return false;
            }
            return true;
        }
        return false;
    }
    public void setInstruction(MoveInstruction instruction) {
        super.instruction = instruction;
    }
}
