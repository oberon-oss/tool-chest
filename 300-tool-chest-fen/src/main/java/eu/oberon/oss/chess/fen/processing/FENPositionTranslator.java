package eu.oberon.oss.chess.fen.processing;

import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.Piece;
import eu.oberon.oss.chess.base.defs.interfaces.Position;
import org.jetbrains.annotations.NotNull;


/**
 * Provides services to create a {@link FENPosition} object from a setup string, or vice versa.
 *
 * @param <F> interface or class that extends the Field Interface.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public interface FENPositionTranslator<F extends Field, P extends Piece<F>> {
    /**
     * Represents chess board at the start of a chess game.
     *
     * @since 1.0.0
     */
    String INITIAL_POSITION_FEN_SETUP_STRING = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w QKqk - 0 0";

    /**
     * Constructs a {@link FENPosition} object from the provided setup string.
     *
     * @param fenPositionSetupString The string to create the FENPosition object from.
     *
     * @return The FENPosition
     *
     * @throws FENTranslatorException if an error is detected while processing the setup string.
     * @since 1.0.0
     */
    FENPosition<F, P> toFENPosition(@NotNull String fenPositionSetupString);

    /**
     * Converts the provided position into the equivalent FEN string representation.
     *
     * @param position The position to create the setup string for
     *
     * @return The resulting string object.
     *
     * @since 1.0.0
     */
    String toFENString(@NotNull Position<F, P> position);
}
