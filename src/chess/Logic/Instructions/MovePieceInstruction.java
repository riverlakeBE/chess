package chess.Logic.Instructions;

import chess.ChessBoard;
import chess.Location;
import chess.Logic.ExecutedMove;
import chess.Pieces.Piece;
import chess.Square;

public class MovePieceInstruction implements MoveInstruction {
    private final Location location1;
    private final Location location2;

    public MovePieceInstruction(Location location1, Location location2){
        this.location1 = location1;
        this.location2 = location2;
    }
    public ExecutedMove getExecutedMove(ChessBoard board){
        ExecutedMove executedMove = new ExecutedMove();
        Square square1 = board.getSquare(location1);
        Square square2 = board.getSquare(location2);
        Piece piece1 = square1.getPiece();
        Piece piece2 = square2.getPiece();
        executedMove.addSquareChange(location1, piece1, null);
        executedMove.addSquareChange(location2, piece2, piece1);

        executedMove.setPieceType(piece1.getPieceType());
        executedMove.setPlayerColor(piece1.getColor());
        executedMove.setCapture(piece2 !=null && piece2.getColor()!= piece1.getColor());
        return executedMove;
    }
}
