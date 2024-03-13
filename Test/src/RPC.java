import java.util.ArrayList;
import java.util.Scanner;

import RPC.RPCControler.RPCControler;

public class RPC {

	final static String RPC[] = { "グー  ", "パー  ", "チョキ" };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> resultList = new ArrayList<>();
		int impleValue, playerValue, opponentValue = 0;
		int winCount = 0, loseCount = 0, drawCount = 0;
		
		RPCControler.showHome();
		impleValue = scanner.nextInt();
		RPCControler.doubleIndent();
		
		for (int i = 0; i < impleValue; i++) {
			RPCControler.showImpleValue(i);
			RPCControler.showOption();
			playerValue = scanner.nextInt();
			
			RPCControler.showMatch(RPC, playerValue, opponentValue, resultList);
		}
		scanner.close();
		
		RPCControler.countResult(winCount, loseCount, drawCount, resultList);
	}
}
