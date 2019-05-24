package UItest;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageLabel extends JTextField {
    private TexturePaint paint;
    public ImageLabel(){
        super();
        File file = new File("F:\\2019\\pix\\2.jpg");
        try{
            BufferedImage image = ImageIO.read(file);
            System.out.println(image.getWidth());
            Rectangle rect = new Rectangle(0,0,image.getWidth(),image.getHeight());
            paint = new TexturePaint(image,rect);
            this.setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
            setOpaque(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void paintComponent(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        g2.setPaint(paint);
        g.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(g);
    }
}
