package chess.Pieces;

import chess.Piece;
import chess.Square;

public class Pawn extends Piece {
    public Pawn(Square square){
        super(square);
    }
    public String getLetter(){
        return "p";
    }
}
