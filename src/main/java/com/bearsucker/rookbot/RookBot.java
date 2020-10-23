package com.bearsucker.rookbot;

import com.bearsucker.rookbot.board.Board;
import com.bearsucker.rookbot.gui.Overlay;
import com.bearsucker.rookbot.gui.Screen;

public class RookBot {

    private static final int X = 643;

    private static final int Y = 192;

    public static void main(String[] args) throws InterruptedException {
        Overlay overlay = new Overlay(X - 1, Y - 1);
        Board board = new Board(overlay);

        while (true) {
            Screen.get().update();
            board.update();
        }
    }

}
