package model;

public enum Level {
	EASY("easy", 3, 0.4, 8, 4), HARD("hard", 5, 0.2, 7, 3), INSANE("insane", 10, 0.3, 5, 6);

	private String name;
	private int numberOfVampires;
	private double vampireFrequency;
	private int dim_x, dim_y;

	private Level(String name, int numberOfVampires, double vampireFrequency, int dim_x, int dim_y) {
		this.name = name;
		this.numberOfVampires = numberOfVampires;
		this.vampireFrequency = vampireFrequency;
		this.dim_x = dim_x;
		this.dim_y = dim_y;
	}

	// TODO fill your code
	
	public static int getRows(Level level) {
		int x=0;
		
		x = level.dim_x;
		return x;
	}
	public static int getCols(Level level) {
		int y=0;
		
		y = level.dim_y;
		return y;
	}
	public static double getProb(Level level) {
		double p=0;
		
		p = level.vampireFrequency;
		return p;
	}
	

    public static Level parse(String inputString) {
        for (Level level : Level.values())
            if (level.name().equalsIgnoreCase(inputString)) 
            	return level;
        return null;
    }
    
    public static String all(String separator) {
        String allLevels = "";
        for (Level level : Level.values())
            allLevels += level.name() + separator;
        return allLevels.substring(0, allLevels.length() - separator.length());
    }

}
