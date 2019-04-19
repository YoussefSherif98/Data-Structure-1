package eg.edu.alexu.csd.datastructure.iceHockey.cs79;

import java.awt.Point;

public interface IPlayersFinder {
	
	Point[] findPlayers(String[] photo, int team, int threshold);

}
