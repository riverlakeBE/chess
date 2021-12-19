package chess.Pieces;

import chess.Piece;
import chess.Square;

public class Knight extends Piece {
    public Knight(Square square){
        super(square);
    }
    public String getLetter(){
        return "k";
    }
}
