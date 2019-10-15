package com.bearsucker.rookbot.pieces;

import java.awt.Color;

import com.bearsucker.rookbot.board.Board;

public class Ghost extends Piece {

    public final static Color[] COLORS = new Color[] {new Color(117, 117, 117), new Color(182, 182, 182)};

    public Ghost(int x, int y) {
        super(x, y);
    }

    @Override
    public void compute(Board board) {

    }

}
