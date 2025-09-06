package eu.oberon.oss.chess.pgn.data;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import eu.oberon.oss.chess.pgn.data.element.ElementSequence;
import eu.oberon.oss.chess.base.enums.GameResult;
import eu.oberon.oss.chess.pgn.data.tags.TagSection;


@Builder
@Getter
@ToString
public class Game {
    private final TagSection      tagSection;
    private final ElementSequence elementSequence;
    private final GameResult      gameResult;
}
