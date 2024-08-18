import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***********");
		System.out.println("Tic tac toe !!");
		System.out.println("***********");
		
		//Δημιουργία πίνακα δύο διαστάσεων.
		char[][]board = {{' ',' ',' '}
		                ,{' ',' ',' '},
		                 {' ',' ',' '}};
		
		printBoard(board);
		
		while(true){
		playerMove(board,scanner);
		if(IsGameFinished(board))
			break;

		computerTurn(board);
		if(IsGameFinished(board))
			break;
		}
		
		
		
		
		
        
       
				
		
		

	}

	private static boolean IsGameFinished(char[][] board) {
		
		if(trytowon(board,'X')) {
			System.out.println("   ");
			System.out.println("YOU WIN !!! ");
			return true;
		}
		if(trytowon(board,'O')) {
			System.out.println("   ");
			System.out.println("COMPUTER WIN !!! ");
			return true;
		}
			
		
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[i].length; j++) {
				if(board[i][j] == ' ') {
					return false;
				}
			}
		}
		System.out.println("the game ended in a tie!! ");
		return true;
		
		
		
	}

	private static boolean trytowon(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
			(board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
			(board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
			
			(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
			(board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
			(board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
			
			(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
			(board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol)) {
			return true;
		}
		return false;
	}

	private static void computerTurn(char[][] board) {
		
		
		Random rand = new Random();
		int computerMove;
		while(true) {
			computerMove = rand.nextInt(9) + 1; //Επιστρέφει έναν ακέραιο απο το 0 μεχρι το 8 , γιαυτο προσθετουμε με 1 .
			if (IsValidMove(board,computerMove)) {
				break;
			}
		}
		
		String theRightMove = ComputerStringMove(computerMove); //μετατροπή του τυχαίου ακέραιου αριθμου σε αντίστοιχη αλφαριθμιτική θεση.
		placeMove(board,theRightMove,'O');
		System.out.println("   ");
		System.out.println("Computer Move (O) : " + theRightMove);
		System.out.println("   ");
		printBoard(board);
	}
	
	private static String ComputerStringMove(int c) {
		switch(c) {
		case 1:
			return "A1";
		case 2:
			return "B1";
		case 3:
			return "C1";
		case 4:
			return "A2";
		case 5:
			return "B2";
		case 6:
			return "C2";
		case 7:
			return "A3";
		case 8:
			return "B3";
		case 9:
			return "C3";
		default:
			return " :( ";
		}
	}
	
	private static boolean IsValidMove (char[][]board, int position_c)
	{
		switch(position_c) {
		case 1:
			return (board[0][0] == ' ');
		case 2:
			return (board[0][1] == ' ');
		case 3:
			return (board[0][2] == ' ');
		case 4:
			return (board[1][0] == ' ');
		case 5:
			return (board[1][1] == ' ');
		case 6:
			return (board[1][2] == ' ');
		case 7:
			return (board[2][0] == ' ');
		case 8:
			return (board[2][1] == ' ');
		case 9:
			return (board[2][2] == ' ');
		default:
		return false;
		
		}
	}

	
	private static boolean IsValidMove_Player (char[][]board, String x)
	{
		switch(x) {
		case "A1":
			return (board[0][0] == ' ');
		case "A2":
			return (board[1][0] == ' ');
		case "A3":
			return (board[2][0] == ' ');
		case "B1":
			return (board[0][1] == ' ');
		case "B2":
			return (board[1][1] == ' ');
		case "B3":
			return (board[2][1] == ' ');
		case "C1":
			return (board[0][2] == ' ');
		case "C2":
			return (board[1][2] == ' ');
		case "C3":
			return (board[2][2] == ' ');
		default:
			return false;
		}
	}
	
	private static void playerMove(char[][] board,Scanner scanner) {
		String userInput;
		while(true) {
		System.out.println("    ");
		System.out.println("Please enter the column (A, B or C) and then the row (1, 2, or 3) of your move. " );		
		System.out.println("    ");		
		userInput = scanner.nextLine();
		
		//έλενγχος εγκυρότητας απάντησης χρηστη.
		if(!"A1".equals(userInput) && (!"A2".equals(userInput)) && (!"A3".equals(userInput)) && (!"B1".equals(userInput)) &&
				(!"B2".equals(userInput)) && (!"B3".equals(userInput)) && (!"C1".equals(userInput)) && (!"C2".equals(userInput))
				&& (!"C3".equals(userInput))) 
				System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1).");
		else if(IsValidMove_Player(board,userInput))  // έλενγχος κενής θέσης.
		{
			break;
		}
		else
			System.out.println("The space entered is already taken.");
		
		}	
		
		
		System.out.println("    ");
		System.out.println("Player Move (X) : " + userInput);
		System.out.println("    ");
		
		placeMove(board, userInput, 'X');
		printBoard(board);
	}

	private static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
		case "A1":
			board[0][0] = symbol;
			break;
		case "A2":
			board[1][0] = symbol;
			break;
		case "A3":
			board[2][0] = symbol;
			break;
		case "B1":
			board[0][1] = symbol;
			break;
		case "B2":
			board[1][1] = symbol;
			break;
		case "B3":
			board[2][1] = symbol;
			break;
		case "C1":
			board[0][2] = symbol;
			break;
		case "C2":
			board[1][2] = symbol;
			break;
		case "C3":
			board[2][2] = symbol;
			break;
			default:
				System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1).");
		}
	}

	private static void printBoard(char[][] board) {
		System.out.println("  " + "A B C");
		System.out.println("1" + "|" +board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|");
		System.out.println("2" + "|" +board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|");
		System.out.println("3" + "|" +board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|");
	}
	
	
}
