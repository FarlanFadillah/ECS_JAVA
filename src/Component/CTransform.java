package Component;

import Math.Vec2;

public class CTransform extends Component { 
    public Vec2 m_pos;
    public float m_speed;
    public Vec2 m_vel = new Vec2();
    public CTransform(){}
    public CTransform(Vec2 pos, float speed)
    {
        this.m_pos = pos;
        this.m_speed = speed;
    }
}

