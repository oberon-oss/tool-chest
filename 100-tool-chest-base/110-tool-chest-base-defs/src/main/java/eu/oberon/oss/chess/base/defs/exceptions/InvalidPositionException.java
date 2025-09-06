package eu.oberon.oss.chess.base.defs.exceptions;

/**
 * Exception that can be thrown in case validation of a chess position fails.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String message) {
        super(message);
    }
}
