package eu.oberon.oss.chess.pgn.data.element;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junitpioneer.jupiter.params.IntRangeSource;

import static org.junit.jupiter.api.Assertions.*;

class NagTest {
    private LogCaptor logCaptor;

    @BeforeEach
    void setUp() {
        logCaptor = LogCaptor.forClass(Nag.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"$1-not-so-good", "[White \"some player\"]"})
    void testIllegalStrings(String text) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Nag(text));
        String expected = "text '" + text + "' is not allowed for pattern: ";
        assertTrue(exception.getMessage().startsWith(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MAX_VALUE, 256})
    void testIllegalNagValue(int value) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Nag("$" + value));
        String expected = "GLYPH code " + value + " is greater outside expected range 0..255";
        assertEquals(expected, exception.getMessage());
    }

    @ParameterizedTest
    @IntRangeSource(from = 0, to = 139, closed = true)
    void testStandardNags(int nagCode) {
        testExpectingValidNagCode(nagCode);
    }

    @ParameterizedTest
    @IntRangeSource(from = 140, to = 148, closed = true)
    void testNonStandardNags1(int nagCode) {
        testExpectingValidNagCode(nagCode);
    }

    @ParameterizedTest
    @IntRangeSource(from = 149, to = 219, closed = true)
    void testUnknownGlyphs1(int nagCode) {
        testUnknownNagCodes(nagCode);
    }

    @ParameterizedTest
    @IntRangeSource(from = 220, to = 221, closed = true)
    void testNonStandardNags2(int nagCode) {
        testExpectingValidNagCode(nagCode);
    }

    @ParameterizedTest
    @IntRangeSource(from = 222, to = 237, closed = true)
    void testUnknownGlyphs2(int nagCode) {
        testUnknownNagCodes(nagCode);
    }

    @ParameterizedTest
    @IntRangeSource(from = 238, to = 255, closed = true)
    void testNonStandardNags3(int nagCode) {
        testExpectingValidNagCode(nagCode);
    }


    private void testExpectingValidNagCode(int nagCode) {
        Nag nag = assertDoesNotThrow(() -> new Nag("$" + nagCode));
        assertNotNull(nag);
        assertEquals(nagCode, nag.getElementData());
        assertNotNull(Nag.lookupNagCode(nagCode));
    }

    private void testUnknownNagCodes(int nagCode) {
        Nag nag = assertDoesNotThrow(() -> new Nag("$" + nagCode));
        assertNotNull(nag);
        assertEquals(nagCode, nag.getElementData());
        assertTrue(logCaptor.getWarnLogs().contains("Unknown GLYPH code: " + nagCode));
    }
}