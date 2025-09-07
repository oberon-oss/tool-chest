package eu.oberon.oss.chess.move.generator.tables;

import eu.oberon.oss.chess.base.defs.enums.MoveDirection;
import eu.oberon.oss.chess.base.defs.interfaces.Field;
import lombok.Getter;

import java.util.List;

/**
 * @author TigerLilly64
 */
@Getter
public class Direction<F extends Field> {
    private final MoveDirection moveDirection;
    private final List<F>       targetFields;

    @SafeVarargs
    public Direction(MoveDirection moveDirection, F... targetFields) {
        this.moveDirection = moveDirection;
        this.targetFields  = List.of(targetFields);
    }
}
