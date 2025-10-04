package eu.oberon.oss.chess.pgn.data.element;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Getter
@ToString
public class Nag implements Element<Integer> {
    private final Integer elementData;

    private static final Pattern SPLITTER = Pattern.compile("^\\s*\\$(\\d+)");

    /**
     * Creates a new NAG token from the provided text.
     *
     * @param text the input text to process.
     *
     * @throws IllegalArgumentException In one of the following cases:
     *                                  <ul>
     *                                      <li>The provided text is not a valid formatter NAG ($n) where n is in the range 0-255 (inclusive). </li>
     *                                      <li>The glyph value (the number) is outside the range 0-255 (inclusive) </li>
     *                                  </ul>
     * @since 1.0.0
     */
    public Nag(String text) {
        Matcher matcher = SPLITTER.matcher(text);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("text '" + text + "' is not allowed for pattern: " + SPLITTER.pattern());
        }

        int glyph = Integer.parseInt(matcher.group(1));

        if (!NAG_LOOKUP_TABLE.containsKey(glyph)) {
            LOGGER.warn("Unknown GLYPH code: {}", glyph);
        }

        if (glyph > 255) {
            throw new IllegalArgumentException("GLYPH code " + glyph + " is greater outside expected range 0..255");
        }

        elementData = glyph;
    }

    private static final Map<Integer, String> NAG_LOOKUP_TABLE;

    static {
        String nagProperties = "nag-lookup.properties";
        Map<Integer, String> wrk = new HashMap<>();

        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(nagProperties)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            for (Object o : properties.keySet()) {
                String key = o.toString();
                wrk.put(Integer.parseInt(key), properties.getProperty(key));
                properties.getProperty(o.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failure loading resource " + nagProperties, e);
        }

        NAG_LOOKUP_TABLE = Map.copyOf(wrk);
    }

    @SuppressWarnings("unused")
    public static @Nullable String lookupNagCode(int glyphNumber) {
        return NAG_LOOKUP_TABLE.get(glyphNumber);
    }
}
