package chess.Logic;

import chess.ChessBoard;

public class XORMove extends Move {
    private final Move move1;
    private final Move move2;

    public XORMove(Move move1, Move move2) {
        this.move1 = move1;
        this.move2 = move2;
    }

    @Override
    public boolean executeMove(ChessBoard board) {
        move1.setPostConditions(postConditions);
        move2.setPostConditions(postConditions);
        return (move1.executeMove(board) || move2.executeMove(board));
    }
}
