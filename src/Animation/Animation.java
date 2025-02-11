package Animation;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class Animation 
{

    private Sprite m_sprite;
    private int         m_frameCount    = 1;
    private int         m_duration      = 1;
    private int         m_currentFrame  = 0;
    private int         m_gameFrames     = 0;
    private String      m_name          = "NONE";
    private int         W, H;
    public Animation(String name, Texture texture, int frameCount, int duration)
    {
        this.m_name         = name;
        this.m_sprite       = new Sprite(texture);
        this.m_frameCount   = frameCount;
        this.m_duration     = duration;

        this.W = texture.getSize().x/frameCount;
        this.H = texture.getSize().y;
    }

    public Sprite getSprite()
    {
        return m_sprite;
    }

    public void update()
    {
        if (m_duration <= 0) return;
        m_gameFrames++;
        m_currentFrame = (m_gameFrames / m_duration) % m_frameCount;
        m_sprite.setTextureRect(new IntRect(m_currentFrame * W, 0, W , H));
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
