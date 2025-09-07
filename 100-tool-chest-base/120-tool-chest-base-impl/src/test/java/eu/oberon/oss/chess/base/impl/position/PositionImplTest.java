package eu.oberon.oss.chess.base.impl.position;

import eu.oberon.oss.chess.base.defs.enums.ChessColor;
import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.Piece;
import eu.oberon.oss.chess.base.defs.interfaces.Position;
import eu.oberon.oss.chess.base.impl.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author TigerLilly64
 * @since 1.2.0
 */
class PositionImplTest extends Util {

    @Test
    void testInitialPosition() {
        Position<Field, Piece<Field>> initialPosition = getInitialPosition();
        assertNotNull(initialPosition);

        assertEquals(ChessColor.WHITE, initialPosition.sideToMove());
        assertTrue(initialPosition.blackCanCastleKingSide());
        assertTrue(initialPosition.blackCanCastleQueenSide());
        assertTrue(initialPosition.whiteCanCastleKingSide());
        assertTrue(initialPosition.whiteCanCastleQueenSide());
    }

    @Test
    void testPositionDuplication() {
        Position<Field, Piece<Field>> position   = getInitialPosition();
        Position<Field, Piece<Field>> duplicated = position.duplicate();
        assertNotNull(duplicated);
        assertEquals(position,duplicated);
    }
}