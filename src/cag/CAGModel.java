package cag;

import java.util.*;
import java.io.File;

class CAGModel {
	private Map<Integer, String> animals = new TreeMap<Integer, String>();
	
	public CAGModel()
	{
		initializeAnimalMap();
	}
	
	/**
	 * Initializes the animal map for the generator. Entries must be line
	 * separated.
	 */
	private void initializeAnimalMap()
	{
		// sets the data folder in relation to the current directory
		File dataFolder = new File("./data");
		
		// loops through all the files in the data folder
		File[] dataFilesList = dataFolder.listFiles();
		int x = 0;
		for (File f : dataFilesList)
		{
			// opens each file and adds data line by line
			try
			{
				Scanner fScan = new Scanner(f);
				while(fScan.hasNext())
				{
					animals.put(x, fScan.next());
					x++;
				}
				fScan.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Returns a pseudo-random number between min and max - 1, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max - 1, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	private int randValue(int min, int max)
	{
		Random rnd = new Random();
		return rnd.nextInt(max - min) + min;
	}
	
	/**
	 * Returns a pseudo-randomized compound animal
	 * @param compoundNum - the number of animals to combine
	 * @return String of animals separated by dashes
	 */
	public String getNextCompoundAnimal(int compoundNum)
	{
		Set<Integer> used = new TreeSet<Integer>();
		StringBuilder compAnimal = new StringBuilder();
		
		// initialize the random animal
		int x = randValue(0, animals.size());
		for(int j = 0; j < compoundNum - 1; j++)
		{
			// finds a new random animal not yet used for this compound animal
			while (used.contains(x))
			{
				x = randValue(0, animals.size());
			}
			used.add(x);
			// prints the animal partial result
			compAnimal.append(animals.get(x));
			compAnimal.append("-");
		}
		// finds a new random animal not yet used for this compound animal
		while (used.contains(x))
		{
			x = randValue(0, animals.size());
		}
		// resets the animals that can be used for the next compound animal
		used.removeAll(used);
		// prints the final animal part
		compAnimal.append(animals.get(x));
		return compAnimal.toString();
	}
}