package eu.oberon.oss.chess.game.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Chess960StartingPositionsTest {
    @Test
    void test960Entries() {
        assertEquals(960,Chess960StartingPositions.values().length);
    }
}