package eu.oberon.oss.chess.fen.processing;

import eu.oberon.oss.chess.base.defs.enums.ChessColor;
import eu.oberon.oss.chess.base.defs.interfaces.*;
import eu.oberon.oss.chess.base.impl.PositionImpl.PositionBuilder;
import lombok.experimental.Accessors;

import java.util.Objects;
import java.util.Set;

import static eu.oberon.oss.chess.base.defs.enums.CastlingType.KING_SIDE;
import static eu.oberon.oss.chess.base.defs.enums.CastlingType.QUEEN_SIDE;
import static eu.oberon.oss.chess.base.defs.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.defs.enums.ChessColor.WHITE;
import static eu.oberon.oss.chess.base.defs.interfaces.CastlingConfiguration.isCastlingConfigurationPresent;


/**
 * Default implementation of the {@link FENPosition} interface.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@Accessors(fluent = true)
public final class FENPositionImpl<F extends Field, P extends Piece<F>> implements FENPosition<F, P> {
    private final Board<F, P> board;
    private final int halveMoveClock;
    private final int fullMoveNumber;
    private final ChessColor sideToMove;
    private final Field enPassantField;
    private final Set<CastlingConfiguration<F>> castlingConfigurations;

    FENPositionImpl(FenPositionBuilder<F, P> builder) {
        board = builder.getBoard();
        halveMoveClock = builder.getHalveMoveClock();
        fullMoveNumber = builder.getFullMoveNumber();
        sideToMove = builder.getSideToMove();
        enPassantField = builder.getEnPassantField();
        castlingConfigurations = builder.getCastlingConfigurations();

    }

    @Override
    public Position<F, P> createPosition() {
        //noinspection unchecked
        return (Position<F, P>) new PositionBuilder<>()
                .board((Board<Field, Piece<Field>>) board)
                .sideToMove(sideToMove)
                .fullMoveNumber(fullMoveNumber)
                .halfMoveClock(halveMoveClock)
                .enPassantField(enPassantField)
                .blackCanCastleKingSide(isCastlingConfigurationPresent(castlingConfigurations, BLACK, KING_SIDE))
                .blackCanCastleQueenSide(isCastlingConfigurationPresent(castlingConfigurations, BLACK, QUEEN_SIDE))
                .whiteCanCastleKingSide(isCastlingConfigurationPresent(castlingConfigurations, WHITE, KING_SIDE))
                .whiteCanCastleQueenSide(isCastlingConfigurationPresent(castlingConfigurations, WHITE, QUEEN_SIDE))
                .build();
    }

    public Board<F, P> board() {
        return board;
    }

    public int halveMoveClock() {
        return halveMoveClock;
    }

    public int fullMoveNumber() {
        return fullMoveNumber;
    }

    public ChessColor sideToMove() {
        return sideToMove;
    }

    public Field enPassantField() {
        return enPassantField;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        FENPositionImpl<?, ?> that = (FENPositionImpl<?, ?>) o;
        return halveMoveClock == that.halveMoveClock && fullMoveNumber == that.fullMoveNumber && Objects.equals(
                board,
                that.board
        )
                && sideToMove == that.sideToMove
                && Objects.equals(enPassantField, that.enPassantField)
                && Objects.equals(castlingConfigurations, that.castlingConfigurations);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(board);
        result = 31 * result + halveMoveClock;
        result = 31 * result + fullMoveNumber;
        result = 31 * result + Objects.hashCode(sideToMove);
        result = 31 * result + Objects.hashCode(enPassantField);
        result = 31 * result + Objects.hashCode(castlingConfigurations);
        return result;
    }

    @Override
    public String toString() {
        return "FENPositionImpl[" +
                "board=" + board + ", " +
                "halveMoveClock=" + halveMoveClock + ", " +
                "fullMoveNumber=" + fullMoveNumber + ", " +
                "sideToMove=" + sideToMove + ", " +
                "enPassantField=" + enPassantField + ']';
    }

}
