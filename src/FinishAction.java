public class FinishAction extends Action
{
    public FinishAction(Tile tile)
    {
        super(tile);
    }

    public FinishAction(Action next, Tile tile)
    {
        super(next, tile);
    }

    @Override
    public boolean doSomething(Tile playerTile, Player player)
    {
        // TODO
        return true;
    }
}
