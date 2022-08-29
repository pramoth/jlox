package th.co.geniustree.experiment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LoxTest {
    @Test
    public void parseExpression() {
        Lox.run("""
                print "one";
                print true;
                print 2 - 1 + 1;
                """);
    }
}
