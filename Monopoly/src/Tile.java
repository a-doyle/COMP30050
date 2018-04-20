package monopoly;

import monopoly.GameState;
import monopoly.Player;

public interface Tile {
	// hasLandedOn function
	GameState hasLandedOn(Player player);
	
	// return TileType
	TileType getTileType();
}
