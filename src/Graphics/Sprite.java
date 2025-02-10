package Graphics;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Math.Vec2i;

public class Sprite {
    
    private BufferedImage m_texture;
    private Vec2i m_pos     = new Vec2i();
    private Vec2i m_size    = new Vec2i();
    private Vec2i m_origin  = new Vec2i();

    public Sprite(){}
    public Sprite(BufferedImage texture)
    {
        this.m_texture  = texture; 
        this.m_size     = new Vec2i(m_texture.getWidth(), m_texture.getHeight());    
    }
    public void setTexture(BufferedImage texture){this.m_texture = texture;}
    public void setPosition(Vec2i pos) {this.m_pos = pos;}
    public void setPosition(int x, int y)
    {
        this.m_pos.x = x;
        this.m_pos.y = y;
    }
    public void setOrigin(Vec2i origin){this.m_origin = origin;}
    public void setOrigin(int x, int y)
    {
        this.m_origin.x = x;
        this.m_origin.y = y;
    }
    public void draw(Graphics2D g2d){g2d.drawImage(m_texture, m_pos.x - m_origin.x, m_pos.y - m_origin.y, m_size.x, m_size.y, null);}
    

}
