import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class ProKeyListener extends KeyAdapter {
    private EditPanel panel;

    public ProKeyListener(EditPanel panel) {
        this.panel = panel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            panel.changeColor();
            panel.togglePaintPicture();
        }
    }
}