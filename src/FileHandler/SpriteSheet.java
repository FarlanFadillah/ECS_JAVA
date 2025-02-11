package FileHandler;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class SpriteSheet {
    private BufferedImage m_texture;

    public SpriteSheet(String path){
        
        try {
             // Creates a FileInputStream
            FileInputStream in = new FileInputStream(path);
            m_texture = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public SpriteSheet(String path, int posX, int posY, int width, int height){
        try {
            FileInputStream in = new FileInputStream(path);
            m_texture = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m_texture = m_texture.getSubimage(posX, posY, width, height);
    }

    public BufferedImage grabImage(int col, int row, int w, int h){
        BufferedImage img = m_texture.getSubimage((col * w) - w, (row *h) - h, w, h);
        return img;
    }

    public BufferedImage grabImageXY(int x, int y, int w, int h){
        BufferedImage img = m_texture.getSubimage(x, y, w, h);
        return img;
    }

    public BufferedImage grabImage(int col, int row, int w, int h, BufferedImage image2){
        BufferedImage img = image2.getSubimage((col * w) - w, (row *h) - h, w, h);
        return img;
    }

    public void setImageRect(int posX, int posY, int width, int height)
    {
        m_texture = m_texture.getSubimage(posX, posY, width, height);
    }

    public BufferedImage getTexture()
    {
        return m_texture;
    }
}
