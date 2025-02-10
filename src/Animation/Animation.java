package Animation;

import java.awt.image.BufferedImage;
import FileHandler.SpriteSheet;
public class Animation {

    private SpriteSheet m_spriteSheet;
    private BufferedImage m_sprite;
    private int         m_frameCount    = 1;
    private int         m_duration      = 1;
    private int         m_currentFrame  = 0;
    private int         m_gameFrames     = 0;
    private String      m_name          = "NONE";
    private int         W, H;
    public Animation(){}
    public Animation(String name, String filepath)
    {
        this.m_spriteSheet = new SpriteSheet(filepath);
        this.m_name = name;
    }
    public Animation(String name, String filePath, int frameCount, int duration, int w, int h)
    {
        this.m_name         = name;
        this.m_spriteSheet  = new SpriteSheet(filePath);
        this.m_frameCount   = frameCount;
        this.m_duration     = duration;
        this.W = w;
        this.H = h;
    }

    public BufferedImage getSprite()
    {
        return m_sprite;
    }

    public void update()
    {
        if (m_duration <= 0) return;
        m_gameFrames++;
        m_currentFrame = (m_gameFrames / m_duration) % m_frameCount;
        m_sprite = m_spriteSheet.grabImage(m_currentFrame, 0, W , H);
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
