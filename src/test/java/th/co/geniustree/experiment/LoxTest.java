package th.co.geniustree.experiment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LoxTest {
    @Test
    public void parseExpression() {
        Lox.run("""
                var x = 10;
                print "one";
                print true;
                print 2 - 1 + 1 + x;
                
                var a = "global a";
                var b = "global b";
                var c = "global c";
                {
                  var a = "outer a";
                  var b = "outer b";
                  {
                    var a = "inner a";
                    print a;
                    print b;
                    print c;
                  }
                  print a;
                  print b;
                  print c;
                }
                print a;
                print b;
                print c;
                """);
    }
    @Test
    public void forLoop(){
        Lox.run("""
                var a = 0;
                var temp;
                                
                for (var b = 1; a < 10000; b = temp + b) {
                  print a;
                  temp = a;
                  a = b;
                }
                """);
    }
    @Test
    public void function(){
        Lox.run("""
                fun fib(n) {
                   if (n <= 1) return n;
                   return fib(n - 2) + fib(n - 1);
                 }
                 
                 for (var i = 0; i < 20; i = i + 1) {
                   print fib(i);
                 }
                """);
    }

    @Test
    public void closure(){
        Lox.run("""
                fun makeCounter() {
                  var i = 0;
                  fun count() {
                    i = i + 1;
                    print i;
                  }
                              
                  return count;
                }
                              
                var counter = makeCounter();
                counter(); // "1".
                counter(); // "2".
                """);
    }
}
