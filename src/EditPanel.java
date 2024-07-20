import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EditPanel extends JPanel implements  KeyListener {
    private int MIDDLE_COLOR = 128;
    private BufferedImage originalImage;
    public String IMAGE_PATH = "C:\\Users\\orian\\IdeaProjects\\RewindColors\\Images\\download.png";
    private boolean paintPicture = false;

    public EditPanel(int x, int y, int height, int width) {

        this.setSize(width, height);
        this.setLocation(x, y);
        this.setVisible(true);
        this.setFocusable(true);
        try {
            originalImage = ImageIO.read(new File(IMAGE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                paintPicture = true;
                applyMirrorFilter();
                repaint();
                paintPicture = false;
            }
        });
        this.addKeyListener(this);


    }
    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the image on the panel
            if (originalImage != null) {
                g.drawImage(originalImage,0,0,getWidth(),getHeight(),null);


            }
        }

//        public BufferedImage changeColor() {
//            int blue=0, green=0, red=0;
//            BufferedImage editedImage = this.originalImage;
//            for (int x = 0; x <  editedImage.getWidth(); x++) {
//                for (int y = 0; y <  editedImage.getHeight(); y++) {
//                    Color c = new Color( editedImage.getRGB(x,y));
//                    if(c.getRed()<MIDDLE_COLOR) {red=c.getRed()+MIDDLE_COLOR;}
//                    else{red=c.getRed()-MIDDLE_COLOR;}
//                    if(c.getGreen()<MIDDLE_COLOR) {green=c.getGreen()+MIDDLE_COLOR;}
//                    else{green=c.getGreen()-MIDDLE_COLOR;}
//                    if(c.getBlue()<MIDDLE_COLOR) {blue=c.getBlue()+MIDDLE_COLOR;}
//                    else{blue=c.getBlue()-MIDDLE_COLOR;}
//
//// Pack RGB values into a single integer
//                    int rgb = (red << 16) | (green << 8) | blue;
//                    editedImage.setRGB(x,y,rgb);
//                    red=0;
//                    green=0;
//                    blue=0;
//                }
//
//            }
//            return editedImage;
//    }

    public void applyMirrorFilter() {
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        BufferedImage mirroredImage = new BufferedImage(width, height, originalImage.getType());

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                mirroredImage.setRGB(width - x - 1, y, originalImage.getRGB(x, y));
            }
        }

        originalImage = mirroredImage; // Update originalImage with mirrored version
        repaint(); // Repaint panel after applying mirror filter
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
           paintPicture = true;

            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
            paintPicture = false;
        }
    }
}




