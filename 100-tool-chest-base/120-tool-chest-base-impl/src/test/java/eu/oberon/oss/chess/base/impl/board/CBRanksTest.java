package eu.oberon.oss.chess.base.impl.board;

import eu.oberon.oss.chess.base.defs.enums.CBRanks;
import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.FieldIterator;
import eu.oberon.oss.chess.base.impl.FieldIteratorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author TigerLilly64
 */
class CBRanksTest {

    private FieldIterator<Field> iterator;

    @BeforeEach
    void setUp() {
        iterator = FieldIteratorImpl.chessBoardFieldIterator();
    }

    @Test
    void testRanks_compareRankForFieldWithRankNoOfField() {
        while (iterator.hasNext()) {
            Field field = iterator.next();
            assertEquals(CBRanks.getRank(field), CBRanks.getRank(field.getRank()));
            assertTrue(CBRanks.lookup(field).getFields().contains(field));
            switch (field.getRank()) {
                case 1 -> assertEquals(CBRanks.FIRST_RANK.getName(), CBRanks.getRank(1).getName());
                case 2 -> assertEquals(CBRanks.SECOND_RANK.getName(), CBRanks.getRank(2).getName());
                case 3 -> assertEquals(CBRanks.THIRD_RANK.getName(), CBRanks.getRank(3).getName());
                case 4 -> assertEquals(CBRanks.FOURTH_RANK.getName(), CBRanks.getRank(4).getName());
                case 5 -> assertEquals(CBRanks.FIFTH_RANK.getName(), CBRanks.getRank(5).getName());
                case 6 -> assertEquals(CBRanks.SIXTH_RANK.getName(), CBRanks.getRank(6).getName());
                case 7 -> assertEquals(CBRanks.SEVENTH_RANK.getName(), CBRanks.getRank(7).getName());
                case 8 -> assertEquals(CBRanks.EIGHTH_RANK.getName(), CBRanks.getRank(8).getName());
                default -> fail("Unrecognized rank: " + field.getRank());
            }
        }
    }
}