package eu.oberon.oss.chess.game.data;

import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.Piece;
import eu.oberon.oss.chess.base.defs.interfaces.Position;

/**
 * @author TigerLilly64
 */
public interface MovePlayer<F extends Field, P extends Piece<F>> {
    Position<F, P> playMove(MoveListEntry<F, P> entry);
}
