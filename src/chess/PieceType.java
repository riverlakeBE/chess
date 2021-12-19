package chess;

public enum PieceType {
    PAWN {
        @Override
        public boolean canMove(Location location1, Location location2, ChessBoard board) {
            // TODO: 19/12/2021 En Passant
            Piece.PieceColor playerColor = board.getSquare(location1).getPiece().getColor();
            if (playerColor == Piece.PieceColor.WHITE) {
//                  pawn moves one forward
                if (location2.getI() == location1.getI() && location2.getJ() == location1.getJ() + 1) {
                    if (board.getSquare(location2).getPiece() != null) {
                        return false;
                    }
//                  pawn takes diagonally
                } else if (Math.abs(location2.getI() - location1.getI()) <= 1 && location2.getJ() == location1.getJ() + 1) {
                    if (board.getSquare(location2).getPiece() == null) {
                        return false;
                    }
//                  pawn moves up two squares as first move
                } else if (location2.getI() == location1.getI() && location1.getJ() == 1 && location2.getJ() == 3) {
                    if (board.getSquare(location2).getPiece() != null || board.getSquare(location1.getI(), location1.getJ() + 1).getPiece() != null) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (playerColor == Piece.PieceColor.BLACK) {
//                  pawn moves one forward
                if (location2.getI() == location1.getI() && location2.getJ() == location1.getJ() - 1) {
                    if (board.getSquare(location2).getPiece() != null) {
                        return false;
                    }
//                  pawn takes diagonally
                } else if (Math.abs(location2.getI() - location1.getI()) <= 1 && location2.getJ() == location1.getJ() - 1) {
                    if (board.getSquare(location2).getPiece() == null) {
                        return false;
                    }
//                  pawn moves up two squares as first move
                } else if (location2.getI() == location1.getI() && location1.getJ() == 6 && location2.getJ() == 4) {
                    if (board.getSquare(location2).getPiece() != null || board.getSquare(location1.getI(), location1.getJ() + 1).getPiece() != null) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        }
    },
    ROOK {
        @Override
        public boolean canMove(Location location1, Location location2, ChessBoard board) {
            if (location1.getI() == location2.getI()) {
                int increment = (int) Math.signum(location2.getJ() - location1.getJ());
                for (int j = location1.getJ() + 1; j != location2.getJ(); j += increment) {
                    if (j != location2.getJ() && board.getSquare(location1.getI(), j).getPiece() != null) {
                        return false;
                    }
                }
                Piece loc2Piece = board.getSquare(location2).getPiece();
                if (loc2Piece != null && loc2Piece.getColor() == board.getSquare(location1).getPiece().getColor()) {
                    return false;
                }
            } else if (location1.getJ() == location2.getJ()) {
                int increment = (int) Math.signum(location2.getI() - location1.getI());
                for (int i = location1.getI() + 1; i != location2.getI(); i += increment) {
                    if (board.getSquare(i, location1.getJ()).getPiece() != null) {
                        if (i != location2.getI()) {
                            return false;
                        }
                    }
                }
                Piece loc2Piece = board.getSquare(location2).getPiece();
                if (loc2Piece != null && loc2Piece.getColor() == board.getSquare(location1).getPiece().getColor()) {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        }
    },

    KNIGHT {
        @Override
        public boolean canMove(Location location1, Location location2, ChessBoard board) {
            if (Math.abs(location1.getI() - location2.getI()) + Math.abs(location1.getJ() - location2.getJ()) != 3 ||
                    Math.abs(location1.getI() - location2.getI()) > 2 || Math.abs(location1.getJ() - location2.getJ()) > 2
            ) {
                return false;
            }
            Piece loc2Piece = board.getSquare(location2).getPiece();
            if (loc2Piece != null && loc2Piece.getColor() == board.getSquare(location1).getPiece().getColor()) {
                return false;
            }
            return true;
        }
    },
    BISHOP {
        @Override
        public boolean canMove(Location location1, Location location2, ChessBoard board) {
            if (Math.abs(location1.getI() - location2.getI()) == Math.abs(location1.getJ() - location2.getJ())) {
                int incrementI = (int) Math.signum(location2.getI() - location1.getI());
                int incrementJ = (int) Math.signum(location2.getJ() - location1.getJ());
                int i = location1.getI() + incrementI;
                int j = location1.getJ() + incrementJ;
                while (board.getSquare(i, j).getPiece() == null && i != location2.getI()) {
                    i += incrementI;
                    j += incrementJ;
                }
                if (board.getSquare(i, j).getPiece() != null) {
                    return false;
                }
                Piece loc2Piece = board.getSquare(location2).getPiece();
                if (loc2Piece != null && loc2Piece.getColor() == board.getSquare(location1).getPiece().getColor()) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }
    },
    QUEEN {
        @Override
        public boolean canMove(Location location1, Location location2, ChessBoard board) {
            return BISHOP.canMove(location1, location2, board) || ROOK.canMove(location1, location2, board);
        }
    },
    KING {
        // TODO: 19/12/2021 Castling
        @Override
        public boolean canMove(Location location1, Location location2, ChessBoard board) {
            if (Math.abs(location1.getI() - location2.getI()) <= 1 && Math.abs(location1.getJ() - location2.getJ()) <= 1) {
                Piece loc2Piece = board.getSquare(location2).getPiece();
                if (loc2Piece == null || loc2Piece.getColor() != board.getSquare(location1).getPiece().getColor()) {
                    return true;
                }
            }
            return false;
        }
    };

    public abstract boolean canMove(Location location1, Location location2, ChessBoard board);
}
