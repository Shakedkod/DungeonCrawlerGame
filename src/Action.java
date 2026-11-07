public abstract class Action
{
    private Action _next;
    protected Tile _tile;

    public Action(Tile tile)
    {
        _next = null;
        _tile = tile;
    }

    public Action(Action next, Tile tile)
    {
        _next = next;
        _tile = tile;
    }

    public Action getNext()
    {
        return _next;
    }

    public void setNext(Action next)
    {
        _next = next;
    }

    public Tile getTile()
    {
        return _tile;
    }

    protected boolean doSomethingNext(Tile playerTile, Player player)
    {
        if (_next == null) return true;
        return _next.doSomething(playerTile, player);
    }

    public abstract boolean doSomething(Tile playerTile, Player player);
}