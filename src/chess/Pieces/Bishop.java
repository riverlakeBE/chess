package chess.Pieces;

import chess.Piece;
import chess.Square;

public class Bishop extends Piece {
    public Bishop(Square square){
        super(square);
    }
    public String getLetter() {
        return "B";
    }
}
