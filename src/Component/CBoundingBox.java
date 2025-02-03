package Component;

import Math.Vec2;

public class CBoundingBox extends Component
{
    public Vec2 m_size, m_halfSize;
    public CBoundingBox()
    {}
    public CBoundingBox(Vec2 size)
    {
        this.m_size = size;
        this.m_halfSize = size.div(2);
    }
}
