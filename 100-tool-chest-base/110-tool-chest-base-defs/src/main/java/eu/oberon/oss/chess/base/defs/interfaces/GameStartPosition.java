package eu.oberon.oss.chess.base.defs.interfaces;

import eu.oberon.oss.chess.base.defs.enums.CastlingType;
import eu.oberon.oss.chess.base.defs.enums.ChessColor;

import java.util.Collection;

/**
 * @author TigerLilly64
 */
public interface GameStartPosition<F extends Field, P extends Piece<F>> {
    Position<F, P> getStartPosition();

    Collection<CastlingConfiguration<F>> getCastlingTypes();

    CastlingConfiguration<F> getCastlingConfiguration(ChessColor color, CastlingType type);
}

