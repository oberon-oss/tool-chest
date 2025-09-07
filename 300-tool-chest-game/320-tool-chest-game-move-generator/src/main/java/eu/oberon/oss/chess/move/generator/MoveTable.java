package eu.oberon.oss.chess.move.generator;

import eu.oberon.oss.chess.base.defs.enums.ChessColor;
import eu.oberon.oss.chess.base.defs.enums.PieceType;
import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import org.jetbrains.annotations.Nullable;

/**
 * @author TigerLilly64
 */
public interface MoveTable<F extends Field> {
    @Nullable TargetFieldMapping<F> getFieldMapping(F field);

    PieceType getPiece();

    @Nullable ChessColor getColor();
}
