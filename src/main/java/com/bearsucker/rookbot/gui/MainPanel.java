package com.bearsucker.rookbot.gui;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.Font.BOLD;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.bearsucker.rookbot.board.Board;

public class MainPanel extends JPanel {

    private static final long serialVersionUID = 7066138982654999791L;

    private static final Color RED = new Color(255, 0, 0, 100);

    private static final Color GREEN = new Color(0, 255, 0, 100);

    private Board board;

    public MainPanel() {
        this.setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g.setColor(WHITE);
        g.drawRect(this.getX(), this.getY(), this.getWidth() - 1, this.getHeight() - 32 - 1);
        g.fillRect(0, this.getHeight() - 32, this.getWidth(), 20);

        g.setColor(BLACK);
        g.setFont(new Font("Dialog", BOLD, 12));
        g.drawString("RookBot by Bearsacker", 16, this.getHeight() - 18);

        if (board != null && board.getPlayer() != null) {
            for (int i = board.getPlayer().getX() - 1; i >= 0; i--) {
                boolean painted = false;

                if (board.getTile(i, board.getPlayer().getY())) {
                    g.setColor(RED);
                    g.fillRect(i * Board.TILE_WIDTH + 10, board.getPlayer().getY() * Board.TILE_HEIGHT + 10, 60, 42);
                    painted = true;
                }

                if (board.isPieceOn(i, board.getPlayer().getY())) {
                    if (!painted) {
                        g.setColor(GREEN);
                        g2.setStroke(new BasicStroke(4));
                        g.drawRect(i * Board.TILE_WIDTH + 12, board.getPlayer().getY() * Board.TILE_HEIGHT + 12, 56, 38);
                    }

                    break;
                }
            }

            for (int i = board.getPlayer().getX() + 1; i < 8; i++) {
                boolean painted = false;

                if (board.getTile(i, board.getPlayer().getY())) {
                    g.setColor(RED);
                    g.fillRect(i * Board.TILE_WIDTH + 10, board.getPlayer().getY() * Board.TILE_HEIGHT + 10, 60, 42);
                    painted = true;
                }

                if (board.isPieceOn(i, board.getPlayer().getY())) {
                    if (!painted) {
                        g.setColor(GREEN);
                        g2.setStroke(new BasicStroke(4));
                        g.drawRect(i * Board.TILE_WIDTH + 12, board.getPlayer().getY() * Board.TILE_HEIGHT + 12, 56, 38);
                    }

                    break;
                }
            }

            for (int i = board.getPlayer().getY() - 1; i >= 0; i--) {
                boolean painted = false;

                if (board.getTile(board.getPlayer().getX(), i)) {
                    g.setColor(RED);
                    g.fillRect(board.getPlayer().getX() * Board.TILE_WIDTH + 10, i * Board.TILE_HEIGHT + 10, 60, 42);
                    painted = true;
                }

                if (board.isPieceOn(board.getPlayer().getX(), i)) {
                    if (!painted) {
                        g.setColor(GREEN);
                        g2.setStroke(new BasicStroke(4));
                        g.drawRect(board.getPlayer().getX() * Board.TILE_WIDTH + 12, i * Board.TILE_HEIGHT + 12, 56, 38);
                    }

                    break;
                }
            }

            for (int i = board.getPlayer().getY() + 1; i < 8; i++) {
                boolean painted = false;

                if (board.getTile(board.getPlayer().getX(), i)) {
                    g.setColor(RED);
                    g.fillRect(board.getPlayer().getX() * Board.TILE_WIDTH + 10, i * Board.TILE_HEIGHT + 10, 60, 42);
                    painted = true;
                }

                if (board.isPieceOn(board.getPlayer().getX(), i)) {
                    if (!painted) {
                        g.setColor(GREEN);
                        g2.setStroke(new BasicStroke(4));
                        g.drawRect(board.getPlayer().getX() * Board.TILE_WIDTH + 12, i * Board.TILE_HEIGHT + 12, 56, 38);
                    }

                    break;
                }
            }
        }
    }

    public void update(Board board) {
        this.board = board.clone();
        this.repaint();
    }
}
