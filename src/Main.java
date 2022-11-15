import java.util.Scanner;

public class Main
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args)
    {

        boolean playersDone = false;
        String player = "X";
        Scanner in = new Scanner(System.in);
        int moveCounter = 0;



        do
        {
            clearBoard();
            display();
            System.out.println("In this game you will make moves in the (column, row) formula counting up with the origin in the top left");
            do
            {
                playerMove(in,player);
                display();
                moveCounter++;

                if (isWin(player))
                {
                    System.out.println("Game is over player " + player + " wins");
                    break;
                }
                else if (isTie(moveCounter))
                {
                    System.out.println("The game is over it is a tie");
                    break;
                }

                if (player.equals("X"))
                {
                    player = "O";
                }
                else
                {
                    player = "X";
                }
            } while (!isWin(player));
            playersDone = SafeInput.getYNConfirm(in,"Are you finished playing?");

        }while (!playersDone);
        System.out.println("Thanks for playing");


    }
    private static void playerMove(Scanner pipe, String player)
    {
        boolean done = false;
        int newMoveX;
        int newMoveY;
        do
        {
            System.out.println("Player " + player + " it is your turn");
            newMoveX = SafeInput.getRangedInt(pipe,"Where would you like to go left to right? ",1,3) - 1;
            newMoveY = SafeInput.getRangedInt(pipe,"Where would you like to move up to down? ",1,3) - 1;
            if(isValidMove(newMoveX,newMoveY))
            {
                board[newMoveY][newMoveX] = player;
                done = true;
            }
            else
            {
                System.out.println("That space is already taken");
            }
        } while (!done);
    }
    private static void display()
    {
        System.out.println();
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("----------");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("----------");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);


    }
    private static void clearBoard() // sets all the board elements to a space
    {
        for(int row=0; row < ROW; row++)
        {
            for(int col=0; col < COL; col++)
            {
                board[row][col] = " "; // make this cell a space
            }
        }
    }
    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[col][row].equals(" "))  // is it a space?
            retVal = true;
        return retVal;
    }

    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagnalWin(player))
        {
            return true;
        }
        return false;
    }

    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false; //no row win
    }

    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }
        return false; //no row win
    }


    private static boolean isDiagnalWin(String player)
    {

        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        }
        else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
        {
            return true;
        }
        return false; //no row win
    }

    private static boolean isTie(int moveCounter)
    {
        if (moveCounter == 9)
        {
            return true;
        }
        return false;
    }


}