package eu.oberon.oss.chess.base.defs.interfaces;

import eu.oberon.oss.chess.base.defs.enums.CastlingType;
import eu.oberon.oss.chess.base.defs.enums.ChessColor;

import java.util.Collection;
import java.util.List;

/**
 * Contract for classes that want to provide castling configuration services.
 *
 * @param <F> Designates the class that extends/implements the {@link Field} interface
 *
 * @author TigerLilly64
 * @since 2.0.0
 */
public interface CastlingConfiguration<F extends Field> {

    /**
     * Defines the color of the side that the configuration applies to.
     *
     * @return A value from the ChessColor interface
     *
     * @since 2.0.0
     */
    ChessColor getColor();

    /**
     * Specifies the castling type.
     *
     * @return A value from the CastlingType interface
     *
     * @since 2.0.0
     */
    CastlingType getCastlingType();

    /**
     * The initial/starting of the KING for this configuration.
     *
     * @return The field where the king is expected to reside.
     *
     * @since 2.0.0
     */
    F getInitialLocationKing();

    /**
     * The initial/starting of the ROOk for this configuration.
     * <p>
     * The rook should be located to the right of the king for KING_SIDE castling (O-O), and to the LEFT for QUEEN side castling
     * (O-O-O)
     *
     * @return The field where the king is expected to reside.
     *
     * @since 2.0.0
     */
    F getInitialLocationRook();

    /**
     * A list of fields that are located between the KING and ROOk pieces.
     *
     * @return A list of zero or more fields that enumerates the fields located between the ROOK and KING
     *
     * @since 2.0.0
     */
    List<F> getIntermediateFields();

    /**
     * Checks the provided collection of configurations for a configurations that matches the specified color and castling type.
     *
     * @param configurations The collection to examine
     * @param color          The color of the castling configuration to find.
     * @param castlingType   The type of castling to check for.
     * @param <F>            Designates the class that extends/implements the {@link Field} interface
     *
     * @return <b>True</b> if  configuration for the specified color and type was found, or <b>false</b> otherwise.
     *
     * @since 2.0.0
     */
    static <F extends Field> boolean isCastlingConfigurationPresent(Collection<CastlingConfiguration<F>> configurations, ChessColor color, CastlingType castlingType) {
        for (CastlingConfiguration<F> configurationItem : configurations) {
            if (configurationItem.getCastlingType().equals(castlingType) && configurationItem.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }
}
