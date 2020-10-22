package com.bearsucker.rookbot;

import com.bearsucker.rookbot.board.Board;
import com.bearsucker.rookbot.gui.Overlay;
import com.bearsucker.rookbot.gui.Screen;

public class RookBot {

    private static final int X = 643;

    private static final int Y = 192;

    public static void main(String[] args) throws InterruptedException {
        int x = X;
        int y = Y;

        if (args.length == 2) {
            x = Integer.parseInt(args[0]);
            y = Integer.parseInt(args[1]);
        }

        Overlay overlay = new Overlay(x - 1, y - 1);
        Board board = new Board(overlay, x, y);

        while (true) {
            Screen.get().update();
            board.update();
        }
    }

}
