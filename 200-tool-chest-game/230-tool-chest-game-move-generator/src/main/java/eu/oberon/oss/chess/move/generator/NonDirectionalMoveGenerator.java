package eu.oberon.oss.chess.move.generator;

import eu.oberon.oss.chess.base.defs.interfaces.Field;
import eu.oberon.oss.chess.base.defs.interfaces.Move;
import eu.oberon.oss.chess.base.defs.interfaces.Piece;
import eu.oberon.oss.chess.base.defs.interfaces.Position;
import eu.oberon.oss.chess.base.impl.MoveImpl;
import eu.oberon.oss.chess.move.generator.tables.Direction;
import eu.oberon.oss.chess.move.generator.tables.TargetFieldMapping;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static eu.oberon.oss.chess.base.defs.enums.MoveDirection.NONE;

/**
 * @author TigerLilly64
 */
public class NonDirectionalMoveGenerator {
    private NonDirectionalMoveGenerator() {

    }

    public static <F extends Field, P extends Piece<F>> List<Move<F, P>> generate(
        @NotNull TargetFieldMapping<Field> fieldMapping,
        @NotNull Piece<Field> pieceToMove,
        @NotNull Position<F, P> position) {
        List<Move<F, P>> moves        = new ArrayList<>();
        Map<F, P>        pieceMapping = position.board().getPieceMapping();

        Direction<Field> direction = fieldMapping.getDirectionMap().getDirection(NONE);
        assert direction != null;

        for (Field targetField : direction.getTargetFields()) {
            //noinspection unchecked,SuspiciousMethodCalls
            Piece<Field> pieceFound = (Piece<Field>) pieceMapping.get(targetField);

            if (pieceFound == null) {
                //noinspection unchecked
                moves.add(
                    (Move<F, P>) MoveImpl
                        .builder()
                        .moveFlags(Move.BIT_FLAG_REGULAR_MOVE)
                        .pieceToMove(pieceToMove)
                        .fromField(pieceToMove.getCurrentField())
                        .toField(targetField)
                        .build()
                );
            } else if (pieceFound.getPieceColor() != pieceToMove.getPieceColor()) {
                //noinspection unchecked
                moves.add(
                    (Move<F, P>) MoveImpl
                        .builder()
                        .moveFlags(Move.BIT_FLAG_CAPTURE)
                        .pieceToMove(pieceToMove)
                        .fromField(pieceToMove.getCurrentField())
                        .toField(targetField)
                        .capturedPiece(pieceFound)
                        .build()
                );
            }
        }
        return moves;
    }
}
