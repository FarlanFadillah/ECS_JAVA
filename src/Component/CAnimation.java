package Component;

import Animation.Animation;

public class CAnimation extends Component
{
    public Animation m_animation;
    public boolean m_repeat = false;
    public CAnimation(){}
    public CAnimation(Animation animation, boolean repeat)
    {
        this.m_animation = animation;
        this.m_repeat = repeat;
    }
}
