package chess.Logic.Instructions;

import chess.ChessBoard;
import chess.Location;
import chess.Pieces.Piece;
import chess.Square;

public class MovePieceInstruction implements MoveInstruction {
    private final Location location1;
    private final Location location2;
    private Piece piece1;
    private Piece piece2;

    public MovePieceInstruction(Location location1, Location location2){
        this.location1 = location1;
        this.location2 = location2;
    }
    public void execute(ChessBoard board){
        Square square1 = board.getSquare(location1);
        Square square2 = board.getSquare(location2);
        piece1 = square1.getPiece();
        piece2 = square2.getPiece();
        square2.setPiece(piece1);
        square1.setPiece(null);
    }

    @Override
    public void reverse(ChessBoard board) {
        Square square1 = board.getSquare(location1);
        Square square2 = board.getSquare(location2);
        square1.setPiece(piece1);
        square2.setPiece(piece2);
    }
}
