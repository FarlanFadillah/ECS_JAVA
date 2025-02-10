package Animation;

import java.awt.image.BufferedImage;
import FileHandler.SpriteSheet;
public class Animation 
{

    private SpriteSheet m_sprite;
    private BufferedImage m_texture;
    private int         m_frameCount    = 1;
    private int         m_duration      = 1;
    private int         m_currentFrame  = 0;
    private int         m_gameFrames     = 0;
    private String      m_name          = "NONE";
    private int         W, H;
    public Animation(String name, SpriteSheet sprite, int frameCount, int duration)
    {
        this.m_name         = name;
        this.m_sprite       = sprite;
        this.m_frameCount   = frameCount;
        this.m_duration     = duration;

        this.W = m_sprite.getTexture().getWidth()/frameCount;
        this.H = m_sprite.getTexture().getHeight();
    }

    public BufferedImage getTexture()
    {
        return m_texture;
    }

    public void update()
    {
        if (m_duration <= 0) return;
        m_gameFrames++;
        m_currentFrame = (m_gameFrames / m_duration) % m_frameCount;
        m_texture = m_sprite.grabImage(m_currentFrame, 0, W , H);
    }    

    public String getName()
    {
        return m_name;
    }

    boolean hasEnded()
    {
        return (m_gameFrames > m_duration && m_currentFrame ==0);
    }

    int getGameFrame()
    {
        return m_gameFrames;
    }
}
