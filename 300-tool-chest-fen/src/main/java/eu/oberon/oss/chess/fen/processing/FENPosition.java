package eu.oberon.oss.chess.fen.processing;


import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;

/**
 * Allows the querying of the information extracted from a FEN setup string.
 *
 * @param <F> interface or class that extends the Field Interface.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public interface FENPosition<F extends Field, P extends Piece<F>> {
    Position<F, P> createPosition();
}
