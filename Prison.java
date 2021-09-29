import java.util.Random;
import java.util.Scanner;

public class Prison {


  //True : the prisoner betrayed.
  //False : the prisoner stayed silent.
  final static boolean BETRAYED = true;
  final static boolean SILENT = false;

  public static void main(String[] args){

    boolean playerChoice     = true; 
    boolean playerLastChoice = true;
    boolean agentChoice      = true;
    boolean agentLastChoice = true;
    int playerYears=0, agentYears=0;

    Random rand = new Random();

    System.out.println("Welcome to the Prisoner's Dilemma Game!");
    System.out.println("I know how to play this game many ways.");
    System.out.println("Here is a list of the strategies I know:");
    System.out.println("1. Betray at random");
    System.out.println("2. Always Betray");
    System.out.println("3. Tit for Tat");
    System.out.println("4. Grudger");

    System.out.println("Enter the number for the strategy that you would like me to use:");

    

    Scanner input = new Scanner(System.in);
    System.out.print("Enter a strategy choice: ");

    int strategyChoice = input.nextInt();

    //Easter Egg, makes them enter a lesser number if theirs is too high
    if (strategyChoice > 4){
        System.out.println("Choose a lesser number");
    }

    //First strategy is a random one
    if(strategyChoice == 1){
      System.out.println("Very good. I will betray at random");
    }

    //asks how many rounds the player would like to play

    System.out.println("How many rounds would you like to play?");

    int numRounds = input.nextInt(), currentRound = 1;
    System.out.println("Very good. We will play " + numRounds + " rounds together");

    System.out.println("Round " + currentRound);

    //Strategy 1: Agent using no prior information and choosing at random
    agentChoice = rand.nextBoolean();


    // created a do- while loop to play until the currentRound is less than the numRounds
    do{

    // second strategy is an "evil" one that always betrays regardless
     if(strategyChoice == 2){
        System.out.println("The agent will always BETRAY!");
        System.out.println("Enter TRUE for betray or FALSE for silent: ");
        playerChoice = input.nextBoolean();

        System.out.println(agentChoice = BETRAYED);

        //call the method and print the score
        int[] scoreArray = new int[2];
        scoreArray = scoring(playerChoice, agentChoice);
        int i ;
        int playerPoints = scoreArray[0];
        int agentPoints = scoreArray[1];

        System.out.println("You have " + playerPoints + " points");
        System.out.println("The agent has " + agentPoints + " points");


        // UPDATE PLAYER YEARS AND AGENT YEARS USING scoreArray with indexes

     }
    
     // third strategy is tit- for -tat; agent plays whatever the player just played 
     if(strategyChoice == 3){
        System.out.println("Enter TRUE for betray or FALSE for silent: ");
        playerChoice = input.nextBoolean();

        boolean firstAgentChoice = false;

        if (firstAgentChoice = false){
            if (playerChoice = true){
                System.out.println (BETRAYED);
            }
            else
                System.out.println (SILENT);
        }

        // call the method and print the score
        int[] scoreArray = new int[2];
        scoreArray = scoring(playerChoice, agentChoice);
        int i ;
        int playerPoints = scoreArray[0];
        int agentPoints = scoreArray[1];

        System.out.println("You have " + playerPoints + " points");
        System.out.println("The agent has " + agentPoints + " points");

     }

    //fourth strategy is the "grudger"; agent cooperates until player betrays, then agent will always betray regardless of what the player does

     if (strategyChoice == 4){
        System.out.println("Enter TRUE for betray or FALSE for silent: ");
        playerChoice = input.nextBoolean();


        boolean firstAgentChoice = false;

        if (playerChoice == true || agentLastChoice == true){
            System.out.println(agentChoice = BETRAYED);
        }
        else
            System.out.println(agentChoice = SILENT);

         // call the method and print the score
        int[] scoreArray = new int[2];
        int i ; 
        scoreArray = scoring(playerChoice, agentChoice);
        int playerPoints = scoreArray[0];
        int agentPoints = scoreArray[1];

        System.out.println("You have " + playerPoints + " points");
        System.out.println("The agent has " + agentPoints + " points");

      }

     // finish the do- while by adding a round then continue to play 
     currentRound++;
    }

    // continue to play until currentRound equals the numRounds
    while (currentRound <= numRounds);

    playerLastChoice = playerChoice;
    agentLastChoice = agentChoice;

  }

  // create a method which takes in the player's choice and the agent's choice and uses the boolean outcome to add years the the integer playerYears and agentYears
  public static int[] scoring(boolean p, boolean a){
    int tempPlayerYears = 0;
    int tempAgentYears  = 0;

    int[] outputArray = new int[2];

    if(p == true && a == true){
        tempPlayerYears = 2;
        tempAgentYears  = 2;
    }

    else if(p == true && a == false){
        tempPlayerYears = 0;
        tempAgentYears  = 3;
    }

    else if (p == false && a == true){
        tempPlayerYears = 3;
        tempAgentYears  = 0;
    }
    else if (p == false && a == false){
        tempPlayerYears = 1;
        tempAgentYears  = 1;
    }

    //Player choice at index 0
    outputArray[0] = tempPlayerYears;

    //Player choice at index 1
    outputArray[1] = tempAgentYears;

    return(outputArray);
  }
}
