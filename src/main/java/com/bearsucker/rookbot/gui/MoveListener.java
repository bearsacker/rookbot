package com.bearsucker.rookbot.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveListener implements KeyListener {

    private Overlay overlay;

    public MoveListener(Overlay overlay) {
        this.overlay = overlay;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
            overlay.setLocation(overlay.getLocation().x - 1, overlay.getLocation().y);
            break;
        case KeyEvent.VK_RIGHT:
            overlay.setLocation(overlay.getLocation().x + 1, overlay.getLocation().y);
            break;
        case KeyEvent.VK_UP:
            overlay.setLocation(overlay.getLocation().x, overlay.getLocation().y - 1);
            break;
        case KeyEvent.VK_DOWN:
            overlay.setLocation(overlay.getLocation().x, overlay.getLocation().y + 1);
            break;
        default:
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
