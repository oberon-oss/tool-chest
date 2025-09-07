package eu.oberon.oss.chess.base.impl.field;

import eu.oberon.oss.chess.base.defs.enums.CBFiles;
import eu.oberon.oss.chess.base.defs.enums.CBRanks;
import eu.oberon.oss.chess.base.defs.enums.ChessField;
import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.FieldIterator;
import eu.oberon.oss.chess.base.impl.FieldIteratorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static eu.oberon.oss.chess.base.defs.enums.CBFiles.*;
import static eu.oberon.oss.chess.base.defs.enums.CBRanks.*;
import static eu.oberon.oss.chess.base.defs.enums.ChessField.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author TigerLilly64
 */
class ChessFieldTest {

    @ParameterizedTest
    @MethodSource("eu.oberon.oss.chess.base.impl.field.util.MethodSources#getRankFields")
    void getRankFields(int rank, List<ChessField> target) {
        assertTrue(CBRanks.getRank(rank).getFields().containsAll(target));
    }

    @ParameterizedTest
    @MethodSource("eu.oberon.oss.chess.base.impl.field.util.MethodSources#getFileFields")
    void getFileFields(String file, List<ChessField> target) {
        assertTrue(CBFiles.getFile(file).getFields().containsAll(target));
    }

    @ParameterizedTest
    @MethodSource("eu.oberon.oss.chess.base.impl.field.util.MethodSources#getFieldByCoordinates")
    void getFieldByCoordinates(int rank, String file, ChessField target) {
        assertEquals(target, ChessField.getFieldByCoordinates(file, rank));
    }

    @Test
    void testInvalidRanks() {
        assertThrows(IllegalArgumentException.class, () -> CBRanks.getRank(0));
        assertThrows(IllegalArgumentException.class, () -> CBRanks.getRank(-1));
        assertThrows(IllegalArgumentException.class, () -> CBRanks.getRank(9));
    }

    @Test
    void testInvalidFiles() {
        assertThrows(IllegalArgumentException.class, () -> CBFiles.getFile("1"));
        assertThrows(IllegalArgumentException.class, () -> CBFiles.getFile(" "));
        assertThrows(IllegalArgumentException.class, () -> CBFiles.getFile("Z"));

        //noinspection DataFlowIssue
        Exception exception = assertThrows(Exception.class, () -> CBFiles.getFile((String) null));
        assertTrue(exception instanceof IllegalArgumentException || exception instanceof NullPointerException);
        assertThrows(IllegalArgumentException.class, () -> CBFiles.getFile("IllegalFieldLength"));
    }

    @Test
    void testInvalidCoordinates() {
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("Invalid length", 1));
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("Z", 1));
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("A", 0));
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("F", -1));
        assertThrows(IllegalArgumentException.class, () -> ChessField.getFieldByCoordinates("H", 10));
    }

    @Test
    void testFieldBitMasks() {
        long result = 0L;
        FieldIterator<Field> iterator = FieldIteratorImpl.chessBoardFieldIterator();
        while (iterator.hasNext()) {
            result |= iterator.next().getBitMask();
        }
        assertEquals(0xFFFF_FFFF_FFFF_FFFFL, result);
    }

    public static Stream<Arguments> testFromCoordinates() {
        return Stream.of(
                Arguments.of(A8, A_FILE, EIGHTH_RANK),
                Arguments.of(B8, B_FILE, EIGHTH_RANK),
                Arguments.of(C8, C_FILE, EIGHTH_RANK),
                Arguments.of(D8, D_FILE, EIGHTH_RANK),
                Arguments.of(E8, E_FILE, EIGHTH_RANK),
                Arguments.of(F8, F_FILE, EIGHTH_RANK),
                Arguments.of(G8, G_FILE, EIGHTH_RANK),
                Arguments.of(H8, H_FILE, EIGHTH_RANK),


                Arguments.of(A7, A_FILE, SEVENTH_RANK),
                Arguments.of(B7, B_FILE, SEVENTH_RANK),
                Arguments.of(C7, C_FILE, SEVENTH_RANK),
                Arguments.of(D7, D_FILE, SEVENTH_RANK),
                Arguments.of(E7, E_FILE, SEVENTH_RANK),
                Arguments.of(F7, F_FILE, SEVENTH_RANK),
                Arguments.of(G7, G_FILE, SEVENTH_RANK),
                Arguments.of(H7, H_FILE, SEVENTH_RANK),

                Arguments.of(A6, A_FILE, SIXTH_RANK),
                Arguments.of(B6, B_FILE, SIXTH_RANK),
                Arguments.of(C6, C_FILE, SIXTH_RANK),
                Arguments.of(D6, D_FILE, SIXTH_RANK),
                Arguments.of(E6, E_FILE, SIXTH_RANK),
                Arguments.of(F6, F_FILE, SIXTH_RANK),
                Arguments.of(G6, G_FILE, SIXTH_RANK),
                Arguments.of(H6, H_FILE, SIXTH_RANK),

                Arguments.of(A5, A_FILE, FIFTH_RANK),
                Arguments.of(B5, B_FILE, FIFTH_RANK),
                Arguments.of(C5, C_FILE, FIFTH_RANK),
                Arguments.of(D5, D_FILE, FIFTH_RANK),
                Arguments.of(E5, E_FILE, FIFTH_RANK),
                Arguments.of(F5, F_FILE, FIFTH_RANK),
                Arguments.of(G5, G_FILE, FIFTH_RANK),
                Arguments.of(H5, H_FILE, FIFTH_RANK),

                Arguments.of(A4, A_FILE, FOURTH_RANK),
                Arguments.of(B4, B_FILE, FOURTH_RANK),
                Arguments.of(C4, C_FILE, FOURTH_RANK),
                Arguments.of(D4, D_FILE, FOURTH_RANK),
                Arguments.of(E4, E_FILE, FOURTH_RANK),
                Arguments.of(F4, F_FILE, FOURTH_RANK),
                Arguments.of(G4, G_FILE, FOURTH_RANK),
                Arguments.of(H4, H_FILE, FOURTH_RANK),

                Arguments.of(A3, A_FILE, THIRD_RANK),
                Arguments.of(B3, B_FILE, THIRD_RANK),
                Arguments.of(C3, C_FILE, THIRD_RANK),
                Arguments.of(D3, D_FILE, THIRD_RANK),
                Arguments.of(E3, E_FILE, THIRD_RANK),
                Arguments.of(F3, F_FILE, THIRD_RANK),
                Arguments.of(G3, G_FILE, THIRD_RANK),
                Arguments.of(H3, H_FILE, THIRD_RANK),

                Arguments.of(A2, A_FILE, SECOND_RANK),
                Arguments.of(B2, B_FILE, SECOND_RANK),
                Arguments.of(C2, C_FILE, SECOND_RANK),
                Arguments.of(D2, D_FILE, SECOND_RANK),
                Arguments.of(E2, E_FILE, SECOND_RANK),
                Arguments.of(F2, F_FILE, SECOND_RANK),
                Arguments.of(G2, G_FILE, SECOND_RANK),
                Arguments.of(H2, H_FILE, SECOND_RANK),

                Arguments.of(A1, A_FILE, FIRST_RANK),
                Arguments.of(B1, B_FILE, FIRST_RANK),
                Arguments.of(C1, C_FILE, FIRST_RANK),
                Arguments.of(D1, D_FILE, FIRST_RANK),
                Arguments.of(E1, E_FILE, FIRST_RANK),
                Arguments.of(F1, F_FILE, FIRST_RANK),
                Arguments.of(G1, G_FILE, FIRST_RANK),
                Arguments.of(H1, H_FILE, FIRST_RANK)

        );
    }

    @ParameterizedTest
    @MethodSource
    void testFromCoordinates(Field targetField, CBFiles file, CBRanks rank) {
        assertTrue(file.getFields().contains(targetField));
        assertTrue(rank.getFields().contains(targetField));
    }
}