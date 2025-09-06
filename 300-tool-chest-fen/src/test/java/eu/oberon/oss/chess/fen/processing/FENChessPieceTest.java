package eu.oberon.oss.chess.fen.processing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import eu.oberon.oss.chess.base.enums.ChessColor;
import eu.oberon.oss.chess.base.impl.PieceImpl;
import eu.oberon.oss.chess.base.enums.PieceType;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.ChessColor.WHITE;
import static eu.oberon.oss.chess.base.enums.ChessField.A1;
import static eu.oberon.oss.chess.base.enums.PieceType.*;


/**
 * @author TigerLilly64
 */
class FENChessPieceTest {
    public static Stream<Arguments> fenPieceDefs() {
        return Stream.of(
            Arguments.of("K", KING, WHITE),
            Arguments.of("k", KING, BLACK),
            Arguments.of("Q", QUEEN, WHITE),
            Arguments.of("q", QUEEN, BLACK),
            Arguments.of("R", ROOK, WHITE),
            Arguments.of("r", ROOK, BLACK),
            Arguments.of("B", BISHOP, WHITE),
            Arguments.of("b", BISHOP, BLACK),
            Arguments.of("N", KNIGHT, WHITE),
            Arguments.of("n", KNIGHT, BLACK),
            Arguments.of("P", PAWN, WHITE),
            Arguments.of("p", PAWN, BLACK)
        );
    }

    @ParameterizedTest
    @MethodSource("fenPieceDefs")
    void translate(String fenChessPieceName, PieceType pieceType) {
        assertEquals(pieceType, FENChessPieceTranslator.translate(fenChessPieceName));
    }

    @ParameterizedTest
    @MethodSource("fenPieceDefs")
    void get(String fenChessPieceName, PieceType pieceType, ChessColor color) {
        assertEquals(fenChessPieceName, FENChessPieceTranslator.getFENCharacterForPiece(new PieceImpl<>(pieceType, color, A1)));
    }

    @Test
    void testInvalidFenChessPieceName() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> FENChessPieceTranslator.translate("X")
        );

        assertEquals("Parameter 'fenPieceType': invalid type was specified: X", exception.getMessage());
    }
}