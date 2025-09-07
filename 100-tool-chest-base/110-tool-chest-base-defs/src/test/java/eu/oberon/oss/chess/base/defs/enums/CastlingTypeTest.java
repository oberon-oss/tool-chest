package eu.oberon.oss.chess.base.defs.enums;

import org.junit.jupiter.api.Test;

import static eu.oberon.oss.chess.base.defs.enums.CastlingType.KING_SIDE;
import static eu.oberon.oss.chess.base.defs.enums.CastlingType.QUEEN_SIDE;
import static eu.oberon.oss.chess.base.defs.enums.ChessField.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CastlingTypeTest {

    @Test
    void testBlackKingSide() {
        assertEquals(G8, KING_SIDE.getKingTargetField(ChessColor.BLACK));
        assertEquals(F8, KING_SIDE.getRookTargetField(ChessColor.BLACK));
    }

    @Test
    void testBlackQueenSide() {
        assertEquals(C8, CastlingType.QUEEN_SIDE.getKingTargetField(ChessColor.BLACK));
        assertEquals(D8, CastlingType.QUEEN_SIDE.getRookTargetField(ChessColor.BLACK));
    }

    @Test
    void testWhiteKingSide() {
        assertEquals(G1, KING_SIDE.getKingTargetField(ChessColor.WHITE));
        assertEquals(F1, KING_SIDE.getRookTargetField(ChessColor.WHITE));
    }

    @Test
    void testWhiteQueenSide() {
        assertEquals(C1, CastlingType.QUEEN_SIDE.getKingTargetField(ChessColor.WHITE));
        assertEquals(D1, CastlingType.QUEEN_SIDE.getRookTargetField(ChessColor.WHITE));
    }

    @Test
    void testFromNotationShort() {
        assertEquals(KING_SIDE, CastlingType.fromNotation("O-O"));
    }

    @Test
    void testFromNotationLong() {
        assertEquals(QUEEN_SIDE, CastlingType.fromNotation("O-O-O"));
    }

    @Test
    void testFromInvalidNotation() {
        IllegalArgumentException exception;
        exception = assertThrows(IllegalArgumentException.class, () -> CastlingType.fromNotation("0-0"));
        assertEquals("0-0 is not a valid castling type", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> CastlingType.fromNotation("0-0-0"));
        assertEquals("0-0-0 is not a valid castling type", exception.getMessage());
    }

}