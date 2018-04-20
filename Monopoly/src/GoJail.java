package monopoly;

public class GoJail implements Tile {
	
	private int tile;
	private static final TileType TILE_TYPE = TileType.GO_JAIL;
	
	public GoJail(int tile) {
		this.tile = tile;
	}
	
	public int getDestinationTile() {
		return tile;
	}

	// unsure if this method is needed, but it's an idea to have to manage moving between tiles
	// to be implemented in Player class
	@Override
	public GameState hasLandedOn(Player player) {
		player.move(tile);
	}

	@Override
	public TileType getTileType() {
		return TILE_TYPE;
	}
}