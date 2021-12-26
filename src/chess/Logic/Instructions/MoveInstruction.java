package chess.Logic.Instructions;

import chess.ChessBoard;
import chess.Logic.ExecutedMove;

public interface MoveInstruction {
    ExecutedMove getExecutedMove(ChessBoard board);
}
