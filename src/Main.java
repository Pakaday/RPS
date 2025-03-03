import java.util.Random;//Import for usage of Random
import java.util.Scanner;//Import for usage of Scanner

class Main{
    public static void main(String[] args){
        boolean endApp = false;
        Random randChoice = new Random();
        Scanner choiceInput = new Scanner(System.in);//Make 1 Scanner object for all input

        do{
            int numRounds = 0;
            do {
                System.out.println("Let's play Rock, Paper, Scissors!\n");
                System.out.print("Choose number of rounds: ");
                String input = choiceInput.nextLine();//User input from Scanner 
                try {
                    numRounds = Integer.parseInt(input);
                    if (numRounds <= 0) {
                        System.out.println("Enter a valid number of rounds.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid number");
                }
            } while (numRounds <= 0);

            int playerScore = 0;
            int computerScore = 0;

            for (int round = 1; round <= numRounds; round++){
                String playerChoice = "";
                String[] choices = {"R", "P", "S"};
                String computerChoice = choices[randChoice.nextInt(choices.length)];

                do{
                    System.out.println("Choose from the following:");
                    System.out.println("\tR - Rock");
                    System.out.println("\tP - Paper");
                    System.out.println("\tS - Scissors");
                    System.out.println("What is your choice? ");
                    playerChoice = choiceInput.nextLine().toUpperCase();
                    System.out.println("Your choice is: " + playerChoice);
                    System.out.println("Computer chose: " + computerChoice);
                    System.out.println("\n");

                    if (!playerChoice.equals("R") && !playerChoice.equals("P") && !playerChoice.equals("S")){//How Java handles does or does not equal to option
                        System.out.println("You must choose either R, P or S!\n");
                    }
                }
                while (!playerChoice.equals("R") && !playerChoice.equals("P") && !playerChoice.equals("S"));

                String result = Winner(choiceInput, computerChoice);
                System.out.println(result);

                if (result.equals("Victory!\n")){
                    playerScore++;
                }
                else if (result.equals("Defeated!\n")){
                    computerScore++;
                }
            }

            System.out.println("Player score: " + playerScore);
            System.out.println("Computer score: " + computerScore);
            if (playerScore > computerScore){
                System.out.println("You were victorious!\n");
            }
            else if (playerScore < computerScore){
                System.out.println("You have been defeated!\n");
            }
            else{
                System.out.println("It's a tie!\n");
            }

            System.out.println("Would you like to play again? Y(es)\\N(o)\n");
//            Scanner choice = new Scanner(System.in);
            String userChoice = choiceInput.nextLine();
            System.out.println(userChoice);
            if (userChoice.equalsIgnoreCase("N"))//IgnoreCase will accept lower and upper
                endApp = true;
        } while (!endApp);

        choiceInput.close();
    }

    public static String Winner(Scanner choiceInput, String computerChoice){
        if (choiceInput.equals(computerChoice)){
            return "It's a tie!";
        } else if ((choiceInput.equals("R") && computerChoice.equals("S")) || (choiceInput.equals("S") && computerChoice.equals("P")) || (choiceInput.equals("P") && computerChoice.equals("R"))){
            return "You were victorious!";
        } else {
            return "You have been defeated!";
        }
    }
}