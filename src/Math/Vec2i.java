package Math;

public class Vec2i {
    public int x = 0;
    public int y = 0;

    public Vec2i()
    {
    }

    public Vec2i(int xin, int yin)
    {
        this.x = xin;
        this.y = yin;
    }

    public boolean equals(Vec2i rhs)
    {
        return this.x == rhs.x && this.y == rhs.y;
    }
    
    public boolean GTOET(Vec2i rhs)
    {
        return this.x >= rhs.x || this.y >= rhs.y;
    }

    public boolean LTOET(Vec2i rhs)
    {
        return this.x <= rhs.x || this.y <= rhs.y;
    }

    public boolean NET(Vec2i rhs)
    {
        return !equals(rhs);
    }

    public Vec2i add(Vec2i rhs)
    {
        return new Vec2i(this.x + rhs.x, this.y + rhs.y);
    }

    public Vec2i sub(Vec2i rhs)
    {
        return new Vec2i(this.x - rhs.x, this.y - rhs.y);
    }

    public Vec2i div(Vec2i rhs)
    {
        return new Vec2i(this.x / rhs.x, this.y / rhs.y);
    }
    public Vec2i div(int val)
    {
        return new Vec2i(this.x / val, this.y / val);
    }

    public Vec2i mult(Vec2i rhs)
    {
        return new Vec2i(this.x * rhs.x, this.y * rhs.y);
    }
    public Vec2i mult(int val)
    {
        return new Vec2i(this.x * val, this.y * val);
    }

    public void plus(Vec2i rhs)
    {
        this.x += rhs.x;
        this.y += rhs.y;
    }

    public void min(Vec2i rhs)
    {
        this.x -= rhs.x;
        this.y -= rhs.y;
    }

    public void times(int val)
    {
        this.x *= val;
        this.y *= val;
    }

    public void divide(int val)
    {
        this.x /= val;
        this.y /= val;
    }


    public int dist(Vec2i rhs)
    {
        return (int)Math.sqrt(Math.pow(x - rhs.x, 2) + Math.pow(y - rhs.y, 2));
    }

    public int length()
    {
        return (int) Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));
    }

    public void normalize()
    {
        int len = length();
        if(len <= 0) return;
        this.x /= len;
        this.y /= len;
    }

    public int dot(Vec2i rhs)
    {
        Vec2i temp1 = new Vec2i(x, y);
        Vec2i temp2 = new Vec2i(rhs.x, rhs.y);

        temp1.normalize();
        temp2.normalize();

        return (temp1.x * temp2.x) + (temp1.y * temp2.y);
    }
}
