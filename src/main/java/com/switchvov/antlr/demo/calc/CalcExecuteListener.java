package com.switchvov.antlr.demo.calc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author switch
 * @since 2021/6/30
 */
public class CalcExecuteListener extends CalcBaseListener {

    Deque<Integer> queue = new ArrayDeque<>(16);

    @Override
    public void exitInt(CalcParser.IntContext ctx) {
        queue.add(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public void exitAdd(CalcParser.AddContext ctx) {
        int r = queue.pop();
        int l = queue.pop();
        queue.add(l + r);
    }

    @Override
    public void exitSub(CalcParser.SubContext ctx) {
        int r = queue.pop();
        int l = queue.pop();
        queue.add(l - r);
    }

    public int result() {
        return queue.pop();
    }
}

