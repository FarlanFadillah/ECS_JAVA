package Component;

import Math.Vec2f;
import Math.Vec2i;

public class CBoundingBox extends Component
{
    public Vec2i m_size, m_halfSize;
    public CBoundingBox()
    {}
    public CBoundingBox(Vec2i size)
    {
        this.m_size = size;
        this.m_halfSize = size.div(2);
    }
}
