package com.bearsucker.rookbot.pieces;

import static java.awt.Color.BLACK;

import java.awt.Color;

import com.bearsucker.rookbot.board.Board;

public class King extends Piece {

    public final static Color[] COLORS = new Color[] {new Color(207, 207, 207), new Color(156, 156, 156), BLACK};

    public King(int x, int y) {
        super(x, y);
    }

    @Override
    public void compute(Board board) {
        board.setTile(x - 1, y - 1);
        board.setTile(x, y - 1);
        board.setTile(x + 1, y - 1);

        board.setTile(x - 1, y);
        board.setTile(x + 1, y);

        board.setTile(x - 1, y + 1);
        board.setTile(x, y + 1);
        board.setTile(x + 1, y + 1);
    }

}
