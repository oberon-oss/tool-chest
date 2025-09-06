package eu.oberon.oss.chess.base.impl.position;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import eu.oberon.oss.chess.base.impl.validators.PositionValidatorImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author TigerLilly64
 */
@Log4j2
class PositionValidatorImplTest {

    @Test
    void getInstance() {
        assertNotNull(PositionValidatorImpl.getInstance());
    }
}