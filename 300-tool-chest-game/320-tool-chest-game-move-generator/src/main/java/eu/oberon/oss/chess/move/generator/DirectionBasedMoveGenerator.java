package eu.oberon.oss.chess.move.generator;

import eu.oberon.oss.chess.base.defs.enums.MoveDirection;
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

/**
 * @author TigerLilly64
 */
public class DirectionBasedMoveGenerator {
    private DirectionBasedMoveGenerator() {

    }

    @SuppressWarnings("unchecked")
    static <F extends Field, P extends Piece<F>> List<Move<F, P>> generate(
        @NotNull TargetFieldMapping<Field> fieldMapping,
        @NotNull Piece<Field> pieceToMove,
        @NotNull Position<F, P> position,
        @NotNull MoveDirection... directions) {
        List<Move<F, P>> moves        = new ArrayList<>();
        Map<F, P>        pieceMapping = position.board().getPieceMapping();

        for (MoveDirection direction : directions) {
            Direction<Field> currentDirection = fieldMapping.getDirectionMap().getDirection(direction);
            if (currentDirection == null) {
                continue;
            }
            for (Field targetField : currentDirection.getTargetFields()) {
                //noinspection SuspiciousMethodCalls
                Piece<Field> pieceFound = (Piece<Field>) pieceMapping.get(targetField);
                if (pieceFound == null) {
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
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
