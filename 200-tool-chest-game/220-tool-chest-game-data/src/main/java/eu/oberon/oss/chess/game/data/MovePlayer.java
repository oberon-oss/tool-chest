package eu.oberon.oss.chess.game.data;

import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.interfaces.Position;

/**
 * @author TigerLilly64
 */
public interface MovePlayer<F extends Field, P extends Piece<F>> {
    Position<F, P> playMove(MoveListEntry<F, P> entry);
}
