package eu.oberon.oss.chess.pgn.data.element;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Stores a move comment from a game in PGN format.
 *
 * @param text The comment text
 *
 * @author TigerLilly64
 * @since 1.0.0
 */
public record MoveComment(String text) implements Element<String> {
    private static final Pattern STRIPPER = Pattern.compile("^\\{(.*)}$");

    /**
     * Creates a move text record. The text is validated, and stored without the '{' and '}' characters. The remaining string is
     * then trimmed to removed leading and/or trailing spaces.
     *
     * @param text The actual comment.
     *
     * @throws IllegalArgumentException If the specified string does not conform to the move text pattern
     *                                  <b>{@literal ^\{(.*)\}$"}</b>
     * @since 1.0.0
     */
    public MoveComment(@NotNull String text) {
        String cleanedString = text.replace("\n","").replace("\r","");
        Matcher matcher = STRIPPER.matcher(cleanedString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Move text invalid: '" + cleanedString + "'");
        }
        this.text = matcher.group(1).trim();
    }

    @Override
    public @NotNull String toString() {
        return "MoveComment{" + "text='" + text + '\'' + '}';
    }

    @Override
    public String getElementData() {
        return "{" + text + "}";
    }

}
