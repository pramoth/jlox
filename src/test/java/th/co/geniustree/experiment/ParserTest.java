package th.co.geniustree.experiment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParserTest {
    @Test()
    public void parseExpressionError() {
        Scanner scanner = new Scanner("6+2*3/A");
        List<Token> tokens = scanner.scanTokens();
        Exception exception = Assertions.assertThrows(Parser.ParseError.class, () -> {
            Parser parser = new Parser(tokens);
            Expr expression = parser.parseOrThrow();

        });
    }
}
