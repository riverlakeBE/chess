package chess.Logic;

import chess.ChessBoard;
import chess.Logic.Instructions.MoveInstruction;

public class SimpleMove extends Move {
    @Override
    public ExecutedMove executeMove(ChessBoard board) {
        if (Move.evaluate(preConditions, board)) {
            ExecutedMove executedMove = instruction.getExecutedMove(board);
            executedMove.execute(board);
            if(!Move.evaluate(postConditions,board)){
                executedMove.reverse(board);
                return null;
            }
            return executedMove;
        }
        return null;
    }
    public void setInstruction(MoveInstruction instruction) {
        super.instruction = instruction;
    }
}
