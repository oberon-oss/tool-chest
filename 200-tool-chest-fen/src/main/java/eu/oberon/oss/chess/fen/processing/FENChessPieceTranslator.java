package eu.oberon.oss.chess.fen.processing;

import eu.oberon.oss.chess.base.defs.enums.PieceType;
import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.Piece;
import org.jetbrains.annotations.NotNull;

import static eu.oberon.oss.chess.base.defs.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.defs.enums.PieceType.*;


/**
 * Extends the information contained in the {@link PieceType} enumeration by adding the representation of the black and white pieces
 * as defined in a FEN setup string.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public class FENChessPieceTranslator {

    private FENChessPieceTranslator() {

    }

    public static PieceType translate(@NotNull String fenPieceType) {
        return switch (fenPieceType.toLowerCase()) {
            case "k" -> KING;
            case "q" -> QUEEN;
            case "r" -> ROOK;
            case "b" -> BISHOP;
            case "n" -> KNIGHT;
            case "p" -> PAWN;
            default ->
                    throw new IllegalArgumentException("Parameter 'fenPieceType': invalid type was specified: " + fenPieceType);
        };
    }

    /**
     * Returns the correct single character representation of the provided pieces based on its type and color.
     *
     * @param piece The piece to return the character representation for.
     * @return The character representation of the provided piece
     * @since 1.0.0
     */
    public static String getFENCharacterForPiece(@NotNull Piece<? extends Field> piece) {
        if (piece.getPieceType() == PAWN) {
            return piece.getPieceColor() == BLACK
                    ? "p"
                    : "P";
        } else {
            return piece.getPieceColor() == BLACK
                    ? piece.getPieceType().getShortHandName().toLowerCase()
                    : piece.getPieceType().getShortHandName();
        }
    }
}
