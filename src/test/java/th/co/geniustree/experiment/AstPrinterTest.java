package th.co.geniustree.experiment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AstPrinterTest {
    @Test public void testPrint(){
        Expr expression = new Expr.Binary(
                new Expr.Unary(new Token(TokenType.MINUS, "-", null, 1),
                new Expr.Literal(123)),
                new Token(TokenType.STAR, "*", null, 1),
                new Expr.Grouping(new Expr.Literal(45.67))
        );
        AstPrinter astPrinter = new AstPrinter();
        System.out.println(astPrinter.print(expression));
        Assertions.assertEquals("(* (- 123) (group 45.67))",astPrinter.print(expression));
    }

}
