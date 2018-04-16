import java.util.ArrayList;

public class Players {
	
	public static final int MAX_PLAYERS = 8;
	public static ArrayList<Player> playersArray;
	
	public Players() {
		
		playersArray = new ArrayList<Player>();
	}
	
	public void addPlayers(Player player){ 
		playersArray.add(player);
	}

	public void removePlayers(Player player) {
		
		boolean removed = false;
		
		for(Player p: playersArray) {
			
			if(p.getName().equals(player.getName())) {
				playersArray.remove(player);
				removed = true;
				break;
			}
		}
	}
	
	
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
