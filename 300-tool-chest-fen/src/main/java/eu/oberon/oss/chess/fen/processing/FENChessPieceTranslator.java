package eu.oberon.oss.chess.fen.processing;

import org.jetbrains.annotations.NotNull;
import eu.oberon.oss.chess.base.interfaces.Field;
import eu.oberon.oss.chess.base.interfaces.Piece;
import eu.oberon.oss.chess.base.enums.PieceType;

import static eu.oberon.oss.chess.base.enums.ChessColor.BLACK;
import static eu.oberon.oss.chess.base.enums.PieceType.*;


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
