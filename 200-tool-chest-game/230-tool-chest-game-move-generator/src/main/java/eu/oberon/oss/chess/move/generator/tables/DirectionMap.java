package eu.oberon.oss.chess.move.generator.tables;

import eu.oberon.oss.chess.base.defs.enums.MoveDirection;
import eu.oberon.oss.chess.base.defs.interfaces.Field;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author TigerLilly64
 */
public class DirectionMap<F extends Field> {
    private final Map<MoveDirection, Direction<F>> directionMapping;

    public DirectionMap(Map<MoveDirection, Direction<F>> directionMapping) {
        this.directionMapping = directionMapping;
    }

    public @Nullable Direction<F> getDirection(final MoveDirection direction) {
        return directionMapping.get(direction);
    }

    /**
     * @author TigerLilly64
     */
    public static class DirectionMapBuilder<F extends Field> {
        private final Map<MoveDirection, Direction<F>> directionMapping = new EnumMap<>(MoveDirection.class);

        public DirectionMapBuilder<F> addDirection(Direction<F> direction) {
            directionMapping.put(direction.getMoveDirection(), direction);
            return this;
        }


        public DirectionMap<F> build() {
            return new DirectionMap<>(directionMapping);
        }
    }
}
