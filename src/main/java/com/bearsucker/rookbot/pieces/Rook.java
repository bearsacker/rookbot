package com.bearsucker.rookbot.pieces;

import java.awt.Color;

import com.bearsucker.rookbot.board.Board;

public class Rook extends Piece {

    public final static Color[] COLORS = new Color[] {new Color(207, 207, 207), new Color(156, 156, 156)};

    public Rook(int x, int y) {
        super(x, y);
    }

    @Override
    public void compute(Board board) {
        for (int i = x - 1; i >= 0; i--) {
            board.setTile(i, y);

            if (board.isPieceOn(i, y)) {
                break;
            }
        }

        for (int i = x + 1; i < 8; i++) {
            board.setTile(i, y);

            if (board.isPieceOn(i, y)) {
                break;
            }
        }

        for (int i = y - 1; i >= 0; i--) {
            board.setTile(x, i);

            if (board.isPieceOn(x, i)) {
                break;
            }
        }

        for (int i = y + 1; i < 8; i++) {
            board.setTile(x, i);

            if (board.isPieceOn(x, i)) {
                break;
            }
        }
    }

}
