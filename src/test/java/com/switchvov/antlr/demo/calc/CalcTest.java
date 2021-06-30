package com.switchvov.antlr.demo.calc;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;


/**
 * @author switch
 * @since 2021/6/30
 */
public class CalcTest {

    public static int exec(String input) {
        CodePointCharStream cs = CharStreams.fromString(input);
        CalcLexer lexer = new CalcLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        ParseTree tree = parser.expr();
        ParseTreeWalker walker = new ParseTreeWalker();

        CalcExecuteListener listener = new CalcExecuteListener();
        walker.walk(listener, tree);
        return listener.result();
    }

    @Test
    public void testCalc() {
        String input = "1+2";
        System.out.println(exec(input));
    }

}


