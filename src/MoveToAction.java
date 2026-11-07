public class MoveToAction extends Action
{
    public MoveToAction(Tile tile)
    {
        super(tile);
    }

    public MoveToAction(Action next, Tile tile)
    {
        super(next, tile);
    }

    @Override
    public boolean doSomething(Tile playerTile, Player player)
    {
        playerTile.setType(TileType.Empty);
        _tile.setType(TileType.Player);

        doSomethingNext(playerTile, player);
        return true;
    }
}