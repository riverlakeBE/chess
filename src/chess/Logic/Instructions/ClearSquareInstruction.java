package chess.Logic.Instructions;

import chess.ChessBoard;
import chess.Location;
import chess.Logic.ExecutedMove;
import chess.Pieces.Piece;

public class ClearSquareInstruction implements MoveInstruction {
    private final Location location;

    public ClearSquareInstruction(Location location) {
        this.location = location;
    }

    @Override
    public ExecutedMove getExecutedMove(ChessBoard board) {
        Piece piece = board.getSquare(location).getPiece();
        ExecutedMove executedMove = new ExecutedMove();
        executedMove.addSquareChange(location, piece, null);
        executedMove.setCapture(false);
        executedMove.setPieceType(piece.getPieceType());
        executedMove.setPlayerColor(piece.getColor());
        return executedMove;
    }
}
