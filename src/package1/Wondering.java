package package1;

import test.testMoveIntoDB;

public class Wondering {
	private static String url="123";
	private static String name="刘洋";
	public static void main (String [] args){
		String htmlPage = "data/test.txt";
		HtmlRemoveTag.Remove(htmlPage);
		
		
		DBConnection dbc= new DBConnection();
		testMoveIntoDB.addToDB2(dbc);
	}
}
