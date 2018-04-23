package monopoly;

// daniel uses an arraylist for the cards, so if we load up a deck of them, this is for that usage
import java.util.ArrayList;

// need to change package names when everything is up and running
// more efficient organisation
import monopoly.tiles.*;

public class Board {
	
	// member variables
	private Tile[] tiles;
	private FreeParking freeParking;
	private Go go;
	
	public Board(Tile[] tiles) {
		this.tiles = tiles;
		
		// gets location of free parking tile
		freeParking = null;
		for (Tile tile : tiles) {
			if (tile.getTileType() == TileType.FREE_PARKING) {
				freeParking = (FreeParking)tile;
				continue;
			}
		}
		
		// sets go as first tile on board
		go = (Go)tiles[0];
	}
	
	public int getTileAmount() {
		return tiles.length;
	}
	
	public Tile getTile(int tile) {
		return tiles[tile];
	}
	
	public FreeParking getFreeParking() {
		return freeParking;
	}
	
	public Go getGo() {
		return go;
	}
}
