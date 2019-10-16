package com.bearsucker.rookbot.gui;

import java.awt.Color;

import javax.swing.JFrame;

import com.bearsucker.rookbot.board.Board;

public class Overlay extends JFrame {

    private static final long serialVersionUID = -2095870715941752227L;

    private final static String TITLE = "Bot";

    private final static int WIDTH = 625;

    private final static int HEIGHT = 477;

    private MainPanel panel;

    public Overlay(int x, int y) {
        JFrame frame = new JFrame();
        frame.setTitle(TITLE);
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(x, y);

        this.panel = new MainPanel();
        frame.setContentPane(this.panel);

        frame.setVisible(true);
    }

    public void update(Board board) {
        panel.update(board);
    }
}
