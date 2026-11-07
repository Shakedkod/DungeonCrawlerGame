public class Tile
{
    private TileType _type;

    public Tile()
    {
        _type = TileType.Empty;
    }

    public Tile(TileType type)
    {
        _type = type;
    }

    public Action collide()
    {
        return switch (_type) {
            case Empty -> new MoveToAction(this);
            case Enemy -> new FightAction(this);
            case Treasure -> new CollectAction(new MoveToAction(this), this);
            case Exit -> new FinishAction(this);
            default -> new CantMoveToAction(this);
        };
    }

    public TileType getType()
    {
        return _type;
    }

    public void setType(TileType type)
    {
        _type = type;
    }

    @Override
    public String toString()
    {
        return switch (_type)
        {
            case Enemy -> "E";
            case Block -> "#";
            case Exit -> "X";
            case Player -> "P";
            case Treasure -> "T";
            default -> " ";
        };
    }
}