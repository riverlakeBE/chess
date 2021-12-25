package chess.Logic.Instructions;

import chess.ChessBoard;
import chess.Location;

public class EnPassentInstruction implements MoveInstruction {

    private final MovePieceInstruction movePieceInstruction;
    private final ClearSquareInstruction clearSquareInstruction;

    public EnPassentInstruction(Location location1, Location location2) {
        movePieceInstruction = new MovePieceInstruction(location1, location2);
        clearSquareInstruction = new ClearSquareInstruction(new Location(location2.getI(), location1.getJ()));
    }

    @Override
    public void execute(ChessBoard board) {
        movePieceInstruction.execute(board);
        clearSquareInstruction.execute(board);
    }

    @Override
    public void reverse(ChessBoard board) {
        movePieceInstruction.reverse(board);
        clearSquareInstruction.reverse(board);
    }
}
