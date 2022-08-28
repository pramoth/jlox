package th.co.geniustree.experiment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LoxTest {
    @Test
    public void parseExpression() {
        Scanner scanner = new Scanner("6+2*3/1");
        List<Token> tokens = scanner.scanTokens();
        Parser parser = new Parser(tokens);
        Expr expression = parser.parse();
        AstPrinter astPrinter = new AstPrinter();
        System.out.println(astPrinter.print(expression));
        Assertions.assertEquals("(+ 6.0 (/ (* 2.0 3.0) 1.0))",astPrinter.print(expression));
    }
}
