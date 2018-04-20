package monopoly;

import monopoly.GameState;
import monopoly.Player;

public class Go implements Tile {
	private int goCash;
	
	public Go(int goCash) {
		this.goCash = goCash;
	}
	
	public int getGoCash() {
		return goCash;
	}
	
	public GameState hasLandedOn(Player player) {
		return GameState.PLAYING;
	}

	@Override
	public TileType getTileType() {
		return TileType.GO;
	}
}
