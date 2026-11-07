public class CollectAction extends Action
{
    public CollectAction(Tile tile)
    {
        super(tile);
    }

    public CollectAction(Action next, Tile tile)
    {
        super(next, tile);
    }

    @Override
    public boolean doSomething(Tile playerTile, Player player)
    {
        player.collect();
        _tile.setType(TileType.Empty);

        return doSomethingNext(playerTile, player);
    }
}
