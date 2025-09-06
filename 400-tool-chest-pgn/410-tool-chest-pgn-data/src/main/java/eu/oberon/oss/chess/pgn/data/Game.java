package eu.oberon.oss.chess.pgn.data;

import eu.oberon.oss.chess.base.defs.enums.GameResult;
import eu.oberon.oss.chess.pgn.data.element.ElementSequence;
import eu.oberon.oss.chess.pgn.data.tags.TagSection;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Builder
@Getter
@ToString
public class Game {
    private final TagSection      tagSection;
    private final ElementSequence elementSequence;
    private final GameResult      gameResult;
}
