package eu.oberon.oss.chess.pgn.data.element;

/**
 * Represents an element read from a PGN data source
 *
 * @param <T> the target element type.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public interface Element<T> {

    /**
     * Retrieves the actual data from an element.
     *
     * @return The elements data as an object of type {@literal  <T>}
     *
     * @since 1.0.0
     */
    @SuppressWarnings("unused")
    T getElementData();
}
