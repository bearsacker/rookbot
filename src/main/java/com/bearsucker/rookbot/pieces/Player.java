package com.bearsucker.rookbot.pieces;

import java.awt.Color;

import com.bearsucker.rookbot.board.Board;

public class Player extends Piece {

    public final static Color[] COLORS = new Color[] {new Color(150, 150, 150), new Color(98, 98, 98)};

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void compute(Board board) {

    }

}
