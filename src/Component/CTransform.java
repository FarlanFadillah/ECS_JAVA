package Component;

import Math.Vec2f;

public class CTransform extends Component { 
    public Vec2f m_pos;
    public float m_speed;
    public Vec2f m_vel = new Vec2f();
    public CTransform(){}
    public CTransform(Vec2f pos, float speed)
    {
        this.m_pos = pos;
        this.m_speed = speed;
    }
}

