package chess.Pieces;

public enum PieceColor {
    WHITE {
        @Override
        public PieceColor invert() {
            return PieceColor.BLACK;
        }
    },
    BLACK {
        @Override
        public PieceColor invert() {
            return PieceColor.WHITE;
        }
    };

    public abstract PieceColor invert();

}
