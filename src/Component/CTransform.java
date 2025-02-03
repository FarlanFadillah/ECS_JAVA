package Component;

import Math.Vec2;

public class CTransform extends Component { 
    public Vec2 m_pos;
    public Vec2 m_vel;
    public CTransform(){}
    public CTransform(Vec2 pos, Vec2 vel)
    {
        this.m_pos = pos;
        this.m_vel = vel;
    }
}

