package Component;

import Math.Vec2f;

public class CBoundingBox extends Component
{
    public Vec2f m_size, m_halfSize;
    public CBoundingBox()
    {}
    public CBoundingBox(Vec2f size)
    {
        this.m_size = size;
        this.m_halfSize = size.div(2);
    }
}
