package eu.oberon.oss.chess.base.interfaces;

import java.time.Duration;

/**
 * @author TigerLilly64
 */
public interface TimeControl {
    String getName();

    int numberOfRequiredMoves();

    Duration timeControlDuration();
}
