package com.bearsucker.rookbot.pieces;

import static java.awt.Color.BLACK;

import java.awt.Color;

import com.bearsucker.rookbot.board.Board;

public class Bishop extends Piece {

    public final static Color[] COLORS = new Color[] {BLACK, new Color(108, 108, 108)};

    public Bishop(int x, int y) {
        super(x, y);
    }

    @Override
    public void compute(Board board) {
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            board.setTile(i, j);

            if (board.isPieceOn(i, j)) {
                break;
            }
        }

        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            board.setTile(i, j);

            if (board.isPieceOn(i, j)) {
                break;
            }
        }

        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            board.setTile(i, j);

            if (board.isPieceOn(i, j)) {
                break;
            }
        }

        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            board.setTile(i, j);

            if (board.isPieceOn(i, j)) {
                break;
            }
        }
    }

}
