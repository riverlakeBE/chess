package chess.Logic.Instructions;

import chess.ChessBoard;
import chess.Logic.ExecutedMove;

public class AndMoveInstruction implements MoveInstruction {

    private final MoveInstruction moveInstruction1;
    private final MoveInstruction moveInstruction2;

    public AndMoveInstruction(MoveInstruction moveInstruction1, MoveInstruction moveInstruction2) {
        this.moveInstruction1 = moveInstruction1;
        this.moveInstruction2 = moveInstruction2;
    }

    @Override
    public ExecutedMove getExecutedMove(ChessBoard board) {
        ExecutedMove executedMove1 = moveInstruction1.getExecutedMove(board);
        ExecutedMove executedMove2 = moveInstruction2.getExecutedMove(board);
        executedMove1.merge(executedMove2);
        return executedMove1;
    }
}
