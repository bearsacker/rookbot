package com.bearsucker.rookbot.gui;

import java.awt.Color;

import javax.swing.JFrame;

import com.bearsucker.rookbot.board.Board;

public class Overlay extends JFrame {

    private static final long serialVersionUID = -2095870715941752227L;

    private final static String TITLE = "Bot";

    private final static int WIDTH = Board.BOARD_SIZE * Board.TILE_WIDTH + 2;

    private final static int HEIGHT = Board.BOARD_SIZE * Board.TILE_HEIGHT + 32 + 2;

    private MainPanel panel;

    public Overlay(int x, int y) {
        setTitle(TITLE);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x, y);

        this.panel = new MainPanel();
        setContentPane(this.panel);

        setVisible(true);

        addKeyListener(new MoveListener(this));
    }

    public void update(Board board) {
        panel.update(board);
    }
}
