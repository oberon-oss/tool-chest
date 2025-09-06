package eu.oberon.oss.chess.fen.processing;

import eu.oberon.oss.chess.base.defs.enums.ChessColor;
import eu.oberon.oss.chess.base.defs.interfaces.Board;
import eu.oberon.oss.chess.base.defs.interfaces.CastlingConfiguration;
import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.Piece;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter(AccessLevel.PACKAGE)
public class FenPositionBuilder<F extends Field, P extends Piece<F>> {
    private Board<F, P> board;
    private int halveMoveClock;
    private int fullMoveNumber;
    private ChessColor sideToMove;
    private Field enPassantField;
    private Set<CastlingConfiguration<F>> castlingConfigurations = new HashSet<>();

    public FenPositionBuilder<F, P> setBoard(Board<F, P> board) {
        this.board = board;
        return this;
    }

    public FenPositionBuilder<F, P> setHalveMoveClock(int halveMoveClock) {
        this.halveMoveClock = halveMoveClock;
        return this;
    }

    public FenPositionBuilder<F, P> setFullMoveNumber(int fullMoveNumber) {
        this.fullMoveNumber = fullMoveNumber;
        return this;
    }

    public FenPositionBuilder<F, P> setSideToMove(ChessColor sideToMove) {
        this.sideToMove = sideToMove;
        return this;
    }

    public FenPositionBuilder<F, P> setEnPassantField(Field enPassantField) {
        this.enPassantField = enPassantField;
        return this;
    }

    public FenPositionBuilder<F, P> addCastlingConfiguration(CastlingConfiguration<F> castlingConfiguration) {
        castlingConfigurations.add(castlingConfiguration);
        return this;
    }

    public FENPosition<F, P> build() {
        return new FENPositionImpl<>(this);
    }
}
