package chess.Pieces;

import chess.ChessBoard;
import chess.Location;
import chess.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public enum PieceType {
    PAWN {

        @Override
        public Piece getInstance() {
            return new Pawn();
        }
    },

    ROOK {
        @Override
        public Piece getInstance() {
            return new Rook();
        }
    },

    KNIGHT {
        @Override
        public Piece getInstance() {
            return new Knight();
        }
    },
    BISHOP {
        @Override
        public Piece getInstance() {
            return new Bishop();
        }
    },
    QUEEN {

        @Override
        public Piece getInstance() {
            return new Queen();
        }
    },
    KING {
        @Override
        public Piece getInstance() {
            return new King();
        }
    };


    public abstract Piece getInstance();

}
