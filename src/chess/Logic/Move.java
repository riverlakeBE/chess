package chess.Logic;

import chess.ChessBoard;
import chess.Logic.Conditions.MoveCondition;
import chess.Logic.Instructions.MoveInstruction;

import java.util.ArrayList;
import java.util.List;

public abstract class Move {
    protected List<MoveCondition> preConditions = new ArrayList<>();

    protected MoveInstruction instruction;

    protected List<MoveCondition> postConditions = new ArrayList<>();

    public void addPreCondition(MoveCondition preConditions) {
        this.preConditions.add(preConditions);
    }

    public void addPostCondition(MoveCondition postCondition) {
        postConditions.add(postCondition);
    }

    public abstract ExecutedMove executeMove(ChessBoard board);

    public List<MoveCondition> getPreConditions() {
        return preConditions;
    }

    protected static boolean evaluate(List<MoveCondition> list, ChessBoard board) {
        boolean preCheck = true;
        for (MoveCondition preCondition : list) {
            if (preCheck) {
                preCheck = preCondition.evaluate(board);
            }
        }
        return preCheck;
    }


    public List<MoveCondition> getPostConditions() {
        return postConditions;
    }

    protected void setPostConditions(List<MoveCondition> postConditions) {
        postConditions = postConditions;
    }
}
