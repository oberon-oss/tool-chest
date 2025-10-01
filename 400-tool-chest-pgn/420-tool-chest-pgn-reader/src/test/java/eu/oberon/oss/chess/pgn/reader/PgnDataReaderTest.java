package eu.oberon.oss.chess.pgn.reader;

import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Log4j2
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PgnDataReaderTest {
    private static final String PATH = "src/test/resources/data/";

    private static @NotNull Stream<Arguments> testReadingFile() {
        return Stream.of(
              Arguments.of(PATH + "365chess_games.pgn"),    // Small file, all data on one long line
              Arguments.of(PATH + "ChessAdmin-Class C.pgn") // Small file, data over multiple lines.
        );
    }

    @ParameterizedTest
    @MethodSource
    void testReadingFile(String filename) {
        assertDoesNotThrow(
              () -> PgnDataReader.processPgnData(
                    new FilePgnSectionProvider(new File(filename)),
                    new PgnGameContainerProcessorImpl()
              )
        );
    }

    private static class PgnGameContainerProcessorImpl implements PgnGameContainerProcessor {
        @Override
        public void processGameContainer(PgnGameContainer container) {
            LOGGER.info(container.getFormattedLogRecord());
            assertFalse(container.hasErrors());
        }
    }
}