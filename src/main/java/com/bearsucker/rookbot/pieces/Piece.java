package com.bearsucker.rookbot.pieces;

import java.awt.Color;

import com.bearsucker.rookbot.board.Board;

public abstract class Piece {

    protected int x;

    protected int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void compute(Board board);

    public static boolean recognize(Color[] model, Color[] colors) {
        for (int i = 0; i < model.length; i++) {
            if (!colors[i].equals(model[i])) {
                return false;
            }
        }

        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
