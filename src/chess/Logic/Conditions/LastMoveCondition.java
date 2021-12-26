package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;
import chess.Logic.ExecutedMove;
import chess.Pieces.PieceColor;
import chess.Pieces.PieceType;

import java.util.List;

public class LastMoveCondition implements MoveCondition {
    private final PieceColor color;
    private final Location location1;
    private final Location location2;
    private final PieceType pieceType;

    public LastMoveCondition(PieceType pieceType, PieceColor color, Location location1, Location location2) {
        this.pieceType = pieceType;
        this.color = color;
        this.location1 = location1;
        this.location2 = location2;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        List<ExecutedMove> moves = board.getMoves();
        if (!moves.isEmpty()) {
            ExecutedMove lastMove = moves.get(moves.size() - 1);
            System.out.println(lastMove.getLocation1().toString() + lastMove.getLocation2().toString());
            if (lastMove.getPlayerColor() == color && lastMove.getPieceType() == pieceType) {
                if (lastMove.getLocation1().equals(location1) && lastMove.getLocation2().equals(location2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
