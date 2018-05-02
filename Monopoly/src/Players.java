import java.util.ArrayList;

public class Players {
	
	public static final int MAX_PLAYERS = 8;
	public static ArrayList<Player> playersArray;
	private static boolean playerRemoved;
	
	public Players() {
		
		playersArray = new ArrayList<Player>();
		
	}
	
	public void addPlayers(Player player){ 
		playersArray.add(player);
	}

	public void removePlayers(Player player) {
		
		
		for(Player p: playersArray) {
			
			if(p.getName().equals(player.getName())) {
				playersArray.remove(player);
				playerRemoved= true;
				break;
			}
		}
	}
	
	public Player getPlayer(int index) {
		return playersArray.get(index);
	}
	
	public Player get (int playerId) {
		return playersArray.get(playerId);
	}
	
	public Player getNext(Player currPlayer) {
		
		Player nextPlayer;
		
		nextPlayer = get((playersArray.indexOf(currPlayer) + 1) % playersArray.size());
		
		return nextPlayer;
	}
	
	public void getNextPlayer(Player player) {
		
		Player next;
		
		if(playerRemoved) {
			next = player;
		}		
	}
	
	
	//Testing methods needs to be deleted at end
	
	public static void main(String args[]) {
		Players p = new Players();
		Player person = new Player("Niall");
		Player person2 = new Player("Stephen");
		Player person3 = new Player("Cian");
		
		p.addPlayers(person);
		p.addPlayers(person2);
		p.addPlayers(person3);

		System.out.println(playersArray.toString());
		
		p.removePlayers(person);
		
		System.out.println(playersArray.toString());

	}
}
