package chess.Logic.Conditions;

import chess.ChessBoard;

public interface MoveCondition {
    boolean evaluate(ChessBoard board);
}
