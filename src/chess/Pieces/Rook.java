package chess.Pieces;

import chess.Piece;
import chess.Square;

public class Rook extends Piece {
    public Rook(Square square) {
        super(square);
    }

    public String getLetter() {
        return "R";
    }
}
