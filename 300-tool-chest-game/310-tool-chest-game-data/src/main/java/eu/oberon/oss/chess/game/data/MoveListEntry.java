package eu.oberon.oss.chess.game.data;


import eu.oberon.oss.chess.base.defs.interfaces.ChessClock;
import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.Move;
import eu.oberon.oss.chess.base.defs.interfaces.Piece;

/**
 * @author TigerLilly64
 */
public interface MoveListEntry<F extends Field, P extends Piece<F>> {
    int getMoveNumber();

    int getPlyNumber();

    ChessClock getWhiteClock();

    ChessClock getBlackClock();

    Move<F, P> getMove();
}
