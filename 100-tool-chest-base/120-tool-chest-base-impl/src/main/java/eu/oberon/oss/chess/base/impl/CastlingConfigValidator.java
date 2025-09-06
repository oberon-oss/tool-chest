package eu.oberon.oss.chess.base.impl;

import eu.oberon.oss.chess.base.defs.enums.ChessColor;
import eu.oberon.oss.chess.base.defs.enums.ChessField;
import eu.oberon.oss.chess.base.defs.enums.PieceType;
import eu.oberon.oss.chess.base.defs.interfaces.validators.ExtendedChessValidator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TigerLilly64
 */
public class CastlingConfigValidator<F extends Field, P extends Piece<F>, S extends Board<F, P>> implements ExtendedChessValidator<S, CastlingConfiguration<F>> {
    private static final ExtendedChessValidator<?, ?> INSTANCE = new CastlingConfigValidator<>();

    private CastlingConfigValidator() {

    }

    public static <F extends Field, P extends Piece<F>, S extends Board<F, P>> ExtendedChessValidator<S, CastlingConfiguration<F>> getInstance() {
        //noinspection unchecked
        return (ExtendedChessValidator<S, CastlingConfiguration<F>>) INSTANCE;
    }

    @Override
    public ValidatorResult validate(@NotNull S source, @NotNull CastlingConfiguration<F> configuration) {
        List<String> messages = new ArrayList<>();
        checkIfPieceHasMoved(source, PieceType.KING, configuration.getInitialLocationKing(), configuration.getColor(), messages);
        checkIfPieceHasMoved(source, PieceType.ROOK, configuration.getInitialLocationRook(), configuration.getColor(), messages);
        return new ValidatorResultImpl(messages);
    }

    private void checkIfPieceHasMoved(Board<F, P> board, PieceType pieceType, F pieceLocation, ChessColor color, List<String> messages) {
        P pieceFound = board.getPieceOnField(pieceLocation);
        if (pieceFound == null) {
            messages.add(color + " " + pieceType + " not located on original field: " + ((ChessField) pieceLocation).name());
        } else if (pieceFound.getPieceColor() != color || pieceFound.getPieceType() != pieceType) {
            messages.add(String.format(
                "Expected a %s %s on %s, but found %s %s",
                color,
                pieceType,
                pieceLocation.getName(),
                pieceFound.getPieceColor(),
                pieceFound.getPieceType()
            ));
        } else if (pieceFound.getTimesMoved() != 0) {
            messages.add(pieceType + " has been moved");
        }
    }
}
