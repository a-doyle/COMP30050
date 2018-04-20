package monopoly;

import monopoly.GameState;
import monopoly.Player;

public class CardTile implements Tile {
	GameState typeOfCard;
	
	public CardTile(GameState typeOfCard) {
		this.typeOfCard = typeOfCard;
	}
	
	@Override
	public GameState hasLandedOn(Player player) {
		// decides to draw a chance or community chest
		return typeOfCard;
	}
	
	@Override
	public TileType getTileType() {
		TileType TILE_TYPE;
		if (typeOfCard == GameState.CHANCE) {
			TILE_TYPE = TileType.CHANCE;
		} else if (typeOfCard == GameState.COMMUNITY) {
			TILE_TYPE = TileType.COMMUNITY;
		} else {
			TILE_TYPE = null;
		}
		
		return TILE_TYPE;
	}
}
