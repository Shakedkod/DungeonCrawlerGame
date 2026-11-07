public class FightAction extends Action
{
    public FightAction(Tile tile)
    {
        super(tile);
    }

    public FightAction(Action next, Tile tile)
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
