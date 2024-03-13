package RPC.RPCControler;

import java.util.ArrayList;
import java.util.Random;

public class RPCControler {
	
	//初期画面表示
	public static void showHome() {
		System.out.println("対戦回数を入力してください");
		System.out.println("");
	}
	
	//対戦数表示
	public static void showImpleValue(int impleValue) {
		System.out.println("＜第"  + (impleValue + 1) + "回戦＞");
	}
	
	
	//オプション表示
	public static void showOption() {
		System.out.println("下記選択肢から番号を入力してください");
		System.out.println("1. グ- / 2. パー / 3. チョキ");
	}
	
	//対戦画面表示
	public static void showMatch(String[] RPC, int playerValue, int opponentValue, 
			                     ArrayList<String> resultList) {
		System.out.println("〇あなた         〇相手         〇結果");
		System.out.print(RPC[playerValue - 1] + "     ");

		System.out.print("VS");
		
		Random random = new Random();
		opponentValue = random.nextInt(3);
		System.out.print("     " + RPC[opponentValue] + "          ");

		System.out.println(judge(playerValue - 1, opponentValue));	
		resultList.add(judge(playerValue - 1, opponentValue));
		RPCControler.doubleIndent();
	}
	
	//対戦判定
	public static String judge(int playerValue, int opponentValue) {
		String judge = null;
		if((playerValue == 0 && opponentValue == 2) || 
		   (playerValue == 1 && opponentValue == 0) || 
	       (playerValue == 2 && opponentValue == 1)) {
			judge = "WIN";
		}
		else if((playerValue == 0 && opponentValue == 1) || 
				(playerValue == 1 && opponentValue == 2) || 
				(playerValue == 2 && opponentValue == 0)){
			judge = "LOSE";
		}else {
			judge = "DRAW";
		}
		return judge;
	}
	
	//2行インデント
	public static void doubleIndent() {
		System.out.println("");
		System.out.println("");
	}
	
	//試合結果表示
	public static void showResult(ArrayList<Integer> countList,  ArrayList<String> resultList) {
		System.out.println("- 総合結果 -");
		System.out.println("WIN:  "  + countList.get(0) +  "回");
		System.out.println("LOSE:  " + countList.get(1) + "回");
		System.out.println("DRAW:  " + countList.get(2) + "回");
		System.out.println("");
		
		showWinRate(countList.get(0), resultList);
	}
	
	//勝率表示
	public static void showWinRate(int winCount, ArrayList<String> resultList) {
		System.out.println("- 勝率 - ");
		System.out.println(Math.round(((double)winCount / resultList.size()) * 100) + " ％" );
	}
	
	
	//各countの計算 & listに格納
	public static void countResult(int winCount, int loseCount, int drawCount, 
			                       ArrayList<String> resultList) {
		for(int i = 0; i < resultList.size(); i++) {
			switch(resultList.get(i)) {
			case "WIN":
				winCount++;
				break;
			case "LOSE":
				loseCount++;
				break;
			case "DRAW":
				drawCount++;
				break;
			}
		}
		ArrayList<Integer> countList = new ArrayList<>();
		countList.add(winCount);
		countList.add(loseCount);
		countList.add(drawCount);
	
		showResult(countList, resultList);

	}

}
