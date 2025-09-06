package eu.oberon.oss.chess.base.defs.interfaces.validators;

import eu.oberon.oss.chess.base.defs.interfaces.ValidatorResult;

/**
 * @param <S> Specifies the source against wich the castling validation should take place.
 * @param <V> Specifies the class of the object that should control the actual validation to take place.
 *
 * @author TigerLilly64
 */
public interface ExtendedChessValidator<S, V> {
    ValidatorResult validate(S source, V validationEngine);
}
