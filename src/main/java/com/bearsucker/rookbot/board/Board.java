package com.bearsucker.rookbot.board;

import static com.bearsucker.rookbot.pieces.Piece.recognize;

import java.awt.Color;
import java.util.ArrayList;

import com.bearsucker.rookbot.gui.Overlay;
import com.bearsucker.rookbot.gui.Screen;
import com.bearsucker.rookbot.pieces.Bishop;
import com.bearsucker.rookbot.pieces.Ghost;
import com.bearsucker.rookbot.pieces.King;
import com.bearsucker.rookbot.pieces.Knight;
import com.bearsucker.rookbot.pieces.Pawn;
import com.bearsucker.rookbot.pieces.Piece;
import com.bearsucker.rookbot.pieces.Player;
import com.bearsucker.rookbot.pieces.Queen;
import com.bearsucker.rookbot.pieces.Rook;

public class Board implements Cloneable {

    public static final Color WHITE = new Color(182, 182, 182);

    public static final Color BLACK = new Color(117, 117, 117);

    public static final int BOARD_SIZE = 8;

    public static final int TILE_WIDTH = 78;

    public static final int TILE_HEIGHT = 60;

    private ArrayList<Piece> pieces;

    private boolean[][] tiles;

    private Overlay overlay;

    private Player player;

    private int dx;

    private int dy;

    public Board(Overlay overlay, int x, int y) {
        this.pieces = new ArrayList<Piece>();
        this.tiles = new boolean[8][8];
        this.overlay = overlay;
        this.dx = x;
        this.dy = y;
    }

    public static boolean check(int x, int y) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Color begin = Screen.get().getPixel(x + i * TILE_WIDTH, y + j * TILE_HEIGHT);
                if (((i + j) % 2 == 0 && !begin.equals(BLACK)) || ((i + j) % 2 != 0 && !begin.equals(WHITE))) {
                    return false;
                }

                Color end = Screen.get().getPixel(x + (i + 1) * TILE_WIDTH - 1, y + (j + 1) * TILE_HEIGHT - 2);
                if (((i + j) % 2 == 0 && !end.equals(BLACK)) || ((i + j) % 2 != 0 && !end.equals(WHITE))) {
                    return false;
                }
            }
        }

        return true;
    }

    public void update() {
        pieces.clear();
        player = null;
        tiles = new boolean[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Color[] colors = new Color[4];
                colors[0] = Screen.get().getPixel(dx + i * TILE_WIDTH + 23, dy + j * TILE_HEIGHT);
                colors[1] = Screen.get().getPixel(dx + i * TILE_WIDTH + 26, dy + j * TILE_HEIGHT);
                colors[2] = Screen.get().getPixel(dx + i * TILE_WIDTH + 17, dy + j * TILE_HEIGHT);
                colors[3] = Screen.get().getPixel(dx + i * TILE_WIDTH + 20, dy + j * TILE_HEIGHT + 3);

                if (recognize(Pawn.COLORS, colors)) {
                    pieces.add(new Pawn(i, j));
                } else if (recognize(King.COLORS, colors)) {
                    pieces.add(new King(i, j));
                } else if (recognize(Rook.COLORS, colors)) {
                    pieces.add(new Rook(i, j));
                } else if (recognize(Bishop.COLORS, colors)) {
                    pieces.add(new Bishop(i, j));
                } else if (recognize(Knight.COLORS, colors)) {
                    pieces.add(new Knight(i, j));
                } else if (recognize(Queen.COLORS, colors)) {
                    pieces.add(new Queen(i, j));
                } else if (recognize(Player.COLORS, colors)) {
                    player = new Player(i, j);
                } else if (!colors[0].equals(Ghost.COLORS[0]) && !colors[0].equals(Ghost.COLORS[1])) {
                    pieces.add(new Ghost(i, j));
                }
            }
        }

        for (Piece piece : pieces) {
            piece.compute(this);
        }

        overlay.update(this);
    }

    public void setTile(int x, int y) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            tiles[x][y] = true;
        }
    }

    public boolean getTile(int x, int y) {
        return tiles[x][y];
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isPieceOn(int x, int y) {
        return pieces.stream().filter(p -> !p.isPlayable()).anyMatch(p -> p.getX() == x && p.getY() == y);
    }

    @SuppressWarnings("unchecked")
    public Board clone() {
        Board o = null;
        try {
            o = (Board) super.clone();
            o.pieces = (ArrayList<Piece>) this.pieces.clone();
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }

        return o;
    }
}
