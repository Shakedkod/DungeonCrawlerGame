public class Player extends Entity
{
    private final int DEFAULT_TREASURES = 0;
    private final int DEFAULT_X = 0;
    private final int DEFAULT_Y = 0;

    private int _treasureNumber;
    private int _x;
    private int _y;

    public Player()
    {
        _treasureNumber = DEFAULT_TREASURES;
        _x = DEFAULT_X;
        _y = DEFAULT_Y;
    }

    public int getTreasures()
    {
        return _treasureNumber;
    }

    public void collect()
    {
        _treasureNumber++;
    }

    public void move(Tile[][] map, char direction)
    {
        // u - up, d - down, r - right, l - left
        switch (direction)
        {
            case 'u':
                if (!(_y - 1 < 0))
                {
                    if (map[_y - 1][_x].collide().doSomething(map[_y][_x], this))
                        _y--;
                }
                break;
            case 'd':
                if (!(_y + 1 > map.length - 1))
                {
                    if (map[_y + 1][_x].collide().doSomething(map[_y][_x], this))
                        _y++;
                }
                break;
            case 'r':
                if (!(_x + 1 > map.length - 1))
                {
                    if (map[_y][_x + 1].collide().doSomething(map[_y][_x], this))
                        _x++;
                }
                break;
            case 'l':
                if (!(_x - 1 < 0))
                {
                    if (map[_y][_x - 1].collide().doSomething(map[_y][_x], this))
                        _x--;
                }
                break;
        }
    }

    public int getX()
    {
        return _x;
    }

    public int getY()
    {
        return _y;
    }

    public void setX(int x)
    {
        _x = x;
    }

    public void setY(int y)
    {
        _y = y;
    }
}