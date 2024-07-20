import javax.swing.*;

public class Window extends JFrame {
    private int WINDOW_WIDTH = 1920;
    private int WINDOW_HEIGHT = 1080;
    private EditPanel editPanel;


public Window() {
    this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setFocusable(true);
    this.editPanel= new EditPanel(0,0,WINDOW_HEIGHT,WINDOW_WIDTH);
    this.add(editPanel);

}
public int getWINDOW_WIDTH() {
    return WINDOW_WIDTH;
}
public int getWINDOW_HEIGHT(int WINDOW_WIDTH) {
    return  WINDOW_HEIGHT;
}

}
