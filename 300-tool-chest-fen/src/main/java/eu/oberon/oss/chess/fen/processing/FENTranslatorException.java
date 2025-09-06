package eu.oberon.oss.chess.fen.processing;

import eu.oberon.oss.chess.base.defs.exceptions.ValidationResultException;
import eu.oberon.oss.chess.base.defs.interfaces.ValidatorResult;

/**
 * Exception intended for implementations of the {@link FENPositionTranslator} interface.
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public class FENTranslatorException extends ValidationResultException {
    public FENTranslatorException(String message) {
        super(message, null);
    }

    public FENTranslatorException(String message, ValidatorResult validatorResult) {
        super(message, validatorResult);
    }
}
