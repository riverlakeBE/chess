package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;
import chess.Pieces.Piece;
import chess.Pieces.PieceColor;

public class PieceColorCondition implements MoveCondition {
    private final Location location;
    private final PieceColor color;

    public PieceColorCondition(Location location, PieceColor color) {
        this.location = location;
        this.color = color;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        return board.getSquare(location).getPiece().getColor()==color;
    }
}
