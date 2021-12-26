package chess.Logic.Conditions;

import chess.ChessBoard;
import chess.Location;

public class EmptyRangeCondition implements MoveCondition {
    private final Location location1;
    private final Location location2;

    public EmptyRangeCondition(Location location1, Location location2) {
        this.location1 = location1;
        this.location2 = location2;
    }

    @Override
    public boolean evaluate(ChessBoard board) {
        boolean result = true;
        int incrementI = (int) Math.signum(location2.getI() - location1.getI());
        int incrementJ = (int) Math.signum(location2.getJ() - location1.getJ());
        int j = location1.getJ() + incrementJ;
        for (int i = location1.getI() + incrementI; !(i == location2.getI() && j == location2.getJ()); i += incrementI) {
            if (result) {
                result = new EmptySquareCondition(new Location(i, j)).evaluate(board);
            }
            j += incrementJ;
        }
        return result;
    }
}
