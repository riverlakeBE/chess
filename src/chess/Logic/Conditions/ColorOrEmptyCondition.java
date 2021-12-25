package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;
import chess.Pieces.PieceColor;

public class ColorOrEmptyCondition implements MoveCondition {
    private final Location location;
    private final PieceColor color;

    public ColorOrEmptyCondition(Location location, PieceColor color) {
        this.location = location;
        this.color = color;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        return new EmptySquareCondition(location).evaluate(board) || new PieceColorCondition(location, color).evaluate(board);
    }
}
