package chess.Logic.Conditions;


import chess.ChessBoard;
import chess.Location;
import chess.Pieces.PieceColor;
import chess.Square;

import java.util.List;

/**
 * evaluates if on the board, the square on location is attacked by the piece color.
 */
public class IsAttackedCondition implements MoveCondition {
    private final Location location;
    private final PieceColor color;

    public IsAttackedCondition(Location location, PieceColor color) {
        this.location = location;
        this.color = color;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        for(Square[] squareList : board.getSquares()){
            for(Square square : squareList){
                if (square.getPiece()!=null && square.getPiece().getColor() == color) {
                    MoveCondition condition = square.getPiece().getAttackCondition(location);
                    if (condition.evaluate(board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
