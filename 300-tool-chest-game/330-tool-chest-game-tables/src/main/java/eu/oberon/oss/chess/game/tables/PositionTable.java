package eu.oberon.oss.chess.game.tables;

import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.Piece;

import java.util.List;

public interface PositionTable<F extends Field, P extends Piece<F>> {
    List<F> getAttackersForField(F field);
    List<F> getDefendersForField(F field);
}
