package com.reedoei.imp;

import com.reedoei.imp.expr.ExprLexer;
import com.reedoei.imp.expr.ExprParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            run(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void run(final String sourceFile) throws IOException {
        final CharStream charStream = CharStreams.fromFileName(sourceFile);
        final ExprLexer exprLexer = new ExprLexer(charStream);
        final CommonTokenStream commonTokenStream = new CommonTokenStream(exprLexer);
        final ExprParser exprParser = new ExprParser(commonTokenStream);
        final ExprParser.ProgContext prog = exprParser.prog();

        final Program program = Program.from(prog);
        program.execute(new Environment());
    }
}
