package com.bearsucker.rookbot.pieces;

import java.awt.Color;

import com.bearsucker.rookbot.board.Board;

public class Knight extends Piece {

    public final static Color[] COLORS = new Color[] {new Color(108, 108, 108), new Color(156, 156, 156)};

    public Knight(int x, int y) {
        super(x, y);
    }

    @Override
    public void compute(Board board) {
        board.setTile(x + 2, y - 1);
        board.setTile(x + 2, y + 1);

        board.setTile(x - 2, y - 1);
        board.setTile(x - 2, y + 1);

        board.setTile(x - 1, y + 2);
        board.setTile(x + 1, y + 2);

        board.setTile(x - 1, y - 2);
        board.setTile(x + 1, y - 2);
    }

}
