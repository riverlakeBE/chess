package chess.Pieces;

import chess.Piece;
import chess.Square;

public class Queen extends Piece {
    public Queen(Square square){
        super(square);
    }
    public String getLetter(){
        return "Q";
    }
}
