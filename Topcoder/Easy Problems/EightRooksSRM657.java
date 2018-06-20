/*
Original problem statement - https://community.topcoder.com/stat?c=problem_statement&pm=13773
Problem Statement
        Cat Snuke is playing a puzzle called Eight Rooks Puzzle. 
In this puzzle, he must put exactly eight rooks onto an 8x8 chessboard. No two rooks must be in the same row, and no two rooks must be in the same column. 
You are given a String[] board. The j-th character of the i-th element of board is either 'R' or '.'. If this is 'R', the cell in row i, column j contains a rook. Otherwise the cell doesn't contain a rook. 
Determine whether Snuke solved the puzzle correctly. If he solved the puzzle correctly, return "Correct". Otherwise return "Incorrect".
 
Definition        
Class:  EightRooks
Method: isCorrect
Parameters: String[]
Returns:    String
Method signature:   String isCorrect(String[] board)
(be sure your method is public)
     
Constraints
-   board will contain exactly 8 elements.
-   Each element of board will contain exactly 8 characters.
-   Each character in board will be either 'R' or '.'.
 
Examples
0)  
{"R.......",
 ".R......",
 "..R.....",
 "...R....",
 "....R...",
 ".....R..",
 "......R.",
 ".......R"}
Returns: "Correct"

1)  
{"........",
 "....R...",
 "........",
 ".R......",
 "........",
 "........",
 "..R.....",
 "........"}
Returns: "Incorrect"
The number of rooks is not eight.

2)  
{"......R.",
 "....R...",
 "...R....",
 ".R......",
 "R.......",
 ".....R..",
 "..R.....",
 ".......R"}
Returns: "Correct"

3)  
{"......R.",
 "....R...",
 "...R....",
 ".R......",
 "R.......",
 ".......R",
 "..R.....",
 ".......R"}
Returns: "Incorrect"
The rightmost column contains two rooks.

4)          
{"........",
 "........",
 "........",
 "........",
 "........",
 "........",
 "........",
 "........"}
Returns: "Incorrect"
*/

public class EightRooks {
    static String isCorrect(String[] board) {
        String isPuzzleCorrect="Correct";
        boolean isFound=true;
        //only rows
        for(int i=0; i<board.length; i++) {
            int numRs=0;
            for(int j=0; j<board[i].length(); j++) {
                if(board[i].charAt(j)=='R') {
                    numRs++;
                }
            }
            if(numRs!=1) {  
                isPuzzleCorrect="Incorrect"; 
                isFound=false;
                break;  
            }
        }

        //only columns
        for(int i=0; i<board.length&isFound; i++) {
            int numRs=0;
            for(int j=0; j<board.length; j++) {
                if(board[j].charAt(i)=='R') {
                    numRs++;
                }
            }
            if(numRs!=1) {
                isPuzzleCorrect="Incorrect";
                break;
            }
        }
        return isPuzzleCorrect;
    }

    public static void main(String[] args) {
            
        String[] puzzle1 = {"R.......", ".R......", "..R.....", "...R....", 
                "....R...", ".....R..", "......R.", ".......R"};
        
        String[] puzzle2 = {"........", "....R...", "........", ".R......",
                "........", "........", "..R.....", "........"};

        String[] puzzle3 = {"......R.", "....R...", "...R....", ".R......",
                "R.......", ".....R..", "..R.....", ".......R"};

        String[] puzzle4 = {"......R.", "....R...", "...R....", ".R......",
                "R.......", ".......R", "..R.....", ".......R"};

        String[] puzzle5 = {"........", "........", "........", "........",
                "........", "........", "........", "........"};

        System.out.println("puzzle1 is : " + isCorrect(puzzle1));
        System.out.println("puzzle2 is : " + isCorrect(puzzle2));
        System.out.println("puzzle3 is : " + isCorrect(puzzle3));
        System.out.println("puzzle4 is : " + isCorrect(puzzle4));
        System.out.println("puzzle5 is : " + isCorrect(puzzle5));
    }
}
