public class CantMoveToAction extends Action
{
    public CantMoveToAction(Tile tile)
    {
        super(tile);
    }

    public CantMoveToAction(Action next, Tile tile)
    {
        super(next, tile);
    }

    @Override
    public boolean doSomething(Tile playerTile, Player player)
    {
        doSomethingNext(playerTile, player);
        return false;
    }
}
