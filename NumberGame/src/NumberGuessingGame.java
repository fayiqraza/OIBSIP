import java.util.*;

public class NumberGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

    public static void main(String[] args) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        methodChange.menu(scoreBoard);
    }

    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("1) Play Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit");
        System.out.println("--------------------");

        try {
            System.out.print("What would you like to do? ");
            int menuOption = input.nextInt();

            switch (menuOption) {
                case 1:
                    System.out.print("\n"+"What would you like the range of the game to be? ");
                    int numberRange = input.nextInt();

                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid entry. Please Try again");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(scoreBoard);
        }
    }

    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;

        return randomNumber;
    }

    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);

        int userGuess;
        int guess = 0;

        do {
            System.out.print("Enter your guess: ");
            userGuess = input.nextInt();
            guess++;

            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }

        } while (randomNumber != userGuess);

        System.out.println(" ");

        if (guess == 1) {
            System.out.println("You answered right in " + guess + " try!");
        } else {
            System.out.println("You answered right in " + guess + " tries!");
        }

        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }

    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");

        System.out.println("Your fastest games today: " +"\n");
        Collections.sort(scoreBoard);

        for (Integer scores : scoreBoard) {
            System.out.println("Finished the game in " + scores + " tries");
            System.out.println("Your score is "+((11-scores)*10)+" out of 100");

        }

        System.out.println(" ");
        menu(scoreBoard);
    }
}