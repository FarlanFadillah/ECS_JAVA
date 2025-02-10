package Math;

public class Vec2f {
    public float x = 0;
    public float y = 0;

    public Vec2f()
    {
    }

    public Vec2f(float xin, float yin)
    {
        this.x = xin;
        this.y = yin;
    }

    public boolean equals(Vec2f rhs)
    {
        return this.x == rhs.x && this.y == rhs.y;
    }
    
    public boolean GTOET(Vec2f rhs)
    {
        return this.x >= rhs.x || this.y >= rhs.y;
    }

    public boolean LTOET(Vec2f rhs)
    {
        return this.x <= rhs.x || this.y <= rhs.y;
    }

    public boolean NET(Vec2f rhs)
    {
        return !equals(rhs);
    }

    public Vec2f add(Vec2f rhs)
    {
        return new Vec2f(this.x + rhs.x, this.y + rhs.y);
    }

    public Vec2f sub(Vec2f rhs)
    {
        return new Vec2f(this.x - rhs.x, this.y - rhs.y);
    }

    public Vec2f div(Vec2f rhs)
    {
        return new Vec2f(this.x / rhs.x, this.y / rhs.y);
    }
    public Vec2f div(float val)
    {
        return new Vec2f(this.x / val, this.y / val);
    }

    public Vec2f mult(Vec2f rhs)
    {
        return new Vec2f(this.x * rhs.x, this.y * rhs.y);
    }
    public Vec2f mult(float val)
    {
        return new Vec2f(this.x * val, this.y * val);
    }

    public void plus(Vec2f rhs)
    {
        this.x += rhs.x;
        this.y += rhs.y;
    }

    public void min(Vec2f rhs)
    {
        this.x -= rhs.x;
        this.y -= rhs.y;
    }

    public void times(float val)
    {
        this.x *= val;
        this.y *= val;
    }

    public void divide(float val)
    {
        this.x /= val;
        this.y /= val;
    }


    public float dist(Vec2f rhs)
    {
        return (float)Math.sqrt(Math.pow(x - rhs.x, 2) + Math.pow(y - rhs.y, 2));
    }

    public float length()
    {
        return (float) Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));
    }

    public void normalize()
    {
        float len = length();
        if(len <= 0) return;
        this.x /= len;
        this.y /= len;
    }

    public float dot(Vec2f rhs)
    {
        Vec2f temp1 = new Vec2f(x, y);
        Vec2f temp2 = new Vec2f(rhs.x, rhs.y);

        temp1.normalize();
        temp2.normalize();

        return (temp1.x * temp2.x) + (temp1.y * temp2.y);
    }
}
