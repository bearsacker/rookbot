package com.bearsucker.rookbot.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;

import com.bearsucker.rookbot.board.Board;

public class Overlay extends JFrame implements MouseInputListener, MouseMotionListener {

    private static final long serialVersionUID = -2095870715941752227L;

    private final static String TITLE = "Bot";

    private final static int WIDTH = Board.BOARD_SIZE * Board.TILE_WIDTH + 2;

    private final static int HEIGHT = Board.BOARD_SIZE * Board.TILE_HEIGHT + 32 + 2;

    private MainPanel panel;

    private int draggedAtX;

    private int draggedAtY;

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

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void update(Board board) {
        panel.update(board);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.setLocation(e.getX() - draggedAtX + getLocation().x, e.getY() - draggedAtY + getLocation().y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        draggedAtX = e.getX();
        draggedAtY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
