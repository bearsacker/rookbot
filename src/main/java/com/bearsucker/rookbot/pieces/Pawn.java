package com.bearsucker.rookbot.pieces;

import static java.awt.Color.BLACK;

import java.awt.Color;

import com.bearsucker.rookbot.board.Board;

public class Pawn extends Piece {

    public final static Color[] COLORS = new Color[] {BLACK, new Color(156, 156, 156)};

    public Pawn(int x, int y) {
        super(x, y);
    }

    @Override
    public void compute(Board board) {
        board.setTile(x - 1, y + 1);
        board.setTile(x + 1, y + 1);
    }

}
