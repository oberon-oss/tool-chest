package eu.oberon.oss.chess.base.defs.exceptions;

import eu.oberon.oss.chess.base.defs.interfaces.ValidatorResult;
import lombok.Getter;

/**
 * @author TigerLilly64
 */
@Getter
public class ValidationResultException extends RuntimeException {
    private final transient ValidatorResult validatorResult;

    public ValidationResultException(String msg, ValidatorResult validatorResult) {
        super(msg);
        this.validatorResult = validatorResult;
    }
}
