package chess.Pieces;

import chess.Piece;
import chess.Square;

public class King extends Piece {
    public King(Square square){
        super(square);
    }

    public String getLetter(){
        return "K";
    }
}
