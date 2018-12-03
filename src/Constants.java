package application;

public class Constants {
	
	private static final String NORMAL_MODE_DESCRIPTION = "Normal Mode : \n"
			+ "\n The classic way to"
			+ "\n play Domi'Nation !"; 
	private static final String DYNASTIE_MODE_DESCRIPTION = "Dynastie Mode :\n"
			+ "\n You play the game in"
			+ "\n 3 handle. At the end,"
			+ "\n the player who"
			+ "\n cumulate the the "
			+ "\n highest count of"
			+ "\n  points win the game !";
	private static final String MIDDLE_EMPIRE_MODE_DESCRIPTION = "Middle Empire Mode :\n"
			+ "\n The rules are the "
			+ "\n same that for normal "
			+ "\n mode"
			+ "\n except that you may "
			+ "\n earn 10 bonus points "
			+ "\n if your castle is in  "
			+ "\n the middle of your territory !";
	private static final String HARMONY_MODE_DESCRIPTION = "Harmony Mode :\n"
			+ "\n The rules are the"
			+ "\n same that for normal"
			+ "\n mode"
			+ "\n except that you may "
			+ "\n earn 5 bonus points"
			+ "\n if the kingdom is"
			+ "\n complete !"
			+ "\n(meaning 5 by 5 square)";
			
	private static final String GREAT_DUEL_MODE_DESCRIPTION = "The Great Duel Mode :\n"
			+ "\n Only with 2 players."
			+ "\n The kingdom can now be a"
			+ "\n 7 by 7 squares territory."
			+ "\n You must use all the"
			+ "\n dominos in the play box"
			+ "\n to build such a kingdom !";
	
	public static String getNormalModeDescription() {
		return NORMAL_MODE_DESCRIPTION;
	}
	
	public static String getDynastieModeDescription() {
		return DYNASTIE_MODE_DESCRIPTION;
	}
	
	public static String getMiddleEmpireModeDescription() {
		return MIDDLE_EMPIRE_MODE_DESCRIPTION;
	}
	
	public static String getHarmonyModeDescription() {
		return HARMONY_MODE_DESCRIPTION;
	}
	
	public static String getGreatDuelModeDescription() {
		return GREAT_DUEL_MODE_DESCRIPTION;
	}

}
