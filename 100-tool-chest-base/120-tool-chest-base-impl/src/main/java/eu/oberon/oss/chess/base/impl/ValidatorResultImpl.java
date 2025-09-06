package eu.oberon.oss.chess.base.impl;

import eu.oberon.oss.chess.base.defs.interfaces.ValidatorResult;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author TigerLilly64
 */
@Getter
public class ValidatorResultImpl implements ValidatorResult {
    private final boolean      isValid;
    @NotNull
    private final List<String> messages;

    public ValidatorResultImpl(List<String> messages) {
        this.messages = messages == null ? List.of() : List.of(messages.toArray(new String[0]));
        this.isValid  = this.messages.isEmpty();
    }

}
