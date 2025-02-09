package Math;

public class Vec2 {
    public float x = 0;
    public float y = 0;

    public Vec2()
    {
    }

    public Vec2(float xin, float yin)
    {
        this.x = xin;
        this.y = yin;
    }

    public boolean equals(Vec2 rhs)
    {
        return this.x == rhs.x && this.y == rhs.y;
    }
    
    public boolean GTOET(Vec2 rhs)
    {
        return this.x >= rhs.x || this.y >= rhs.y;
    }

    public boolean LTOET(Vec2 rhs)
    {
        return this.x <= rhs.x || this.y <= rhs.y;
    }

    public boolean NET(Vec2 rhs)
    {
        return !equals(rhs);
    }

    public Vec2 add(Vec2 rhs)
    {
        return new Vec2(this.x + rhs.x, this.y + rhs.y);
    }

    public Vec2 sub(Vec2 rhs)
    {
        return new Vec2(this.x - rhs.x, this.y - rhs.y);
    }

    public Vec2 div(Vec2 rhs)
    {
        return new Vec2(this.x / rhs.x, this.y / rhs.y);
    }
    public Vec2 div(float val)
    {
        return new Vec2(this.x / val, this.y / val);
    }

    public Vec2 mult(Vec2 rhs)
    {
        return new Vec2(this.x * rhs.x, this.y * rhs.y);
    }
    public Vec2 mult(float val)
    {
        return new Vec2(this.x * val, this.y * val);
    }

    public void plus(Vec2 rhs)
    {
        this.x += rhs.x;
        this.y += rhs.y;
    }

    public void min(Vec2 rhs)
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


    public float dist(Vec2 rhs)
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

    public float dot(Vec2 rhs)
    {
        Vec2 temp1 = new Vec2(x, y);
        Vec2 temp2 = new Vec2(rhs.x, rhs.y);

        temp1.normalize();
        temp2.normalize();

        return (temp1.x * temp2.x) + (temp1.y * temp2.y);
    }
}
