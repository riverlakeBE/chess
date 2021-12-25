package chess.Logic.Instructions;

import chess.ChessBoard;

public interface MoveInstruction {
    void execute(ChessBoard board);
    void reverse(ChessBoard board);
}
