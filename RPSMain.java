import java.util.*;


public class RPSMain{
   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      System.out.println("Welcome to Rock, Paper, Scissors");
      int players = numberOfPlayers(console);
      int[] score = new int[2];
      if(players == 2){
         twoPlayerGame(console, score);
      }
      if(players == 1){
         System.out.print("Do you want to play with Randy or Bonny? ");
         String Opponent = console.next();
         onePlayerGame(console, score, Opponent, " ");
      }         
   }
   //lets the user choose to play a 1 or 2 player game
   public static int numberOfPlayers(Scanner console){
      System.out.print("1 or 2 players? ");
      int players = console.nextInt();
      while(players > 2){ // to ensure a valid move
         System.out.println("Thats too many players! try again");
         System.out.print("1 or 2 players? ");
         players = console.nextInt();
      }
      if(players == 1){
         System.out.println("get ready!");
      }
      if(players == 2){
         System.out.println("here we go");
      }
      return players;
      
   }
   //lets 2 players choose their moves
   public static void twoPlayerGame(Scanner console, int[] score){
      
      System.out.println("Player 2 don't look!");
      System.out.print("Player 1 choose a move. rock, paper or scissors: ");
      String player1 = console.next();
      player1 = Validate(player1, console);      
      for(int i = 0; i < 50; i++){ //an attempt to make sure player 2 doesn't cheat. it's not perfect
         System.out.println("****************");
      }
      System.out.println("Player 1 don't look! (make sure your move is hidden)");
      System.out.print("Player 2 choose a move. rock, paper or scissors: ");
      String player2 = console.next();
      player2 = Validate(player2, console);      
      determineWinner(player1, player2, score, "player 2");
      System.out.println("score: " + score[0] + " to " + score[1]);
      System.out.print("play again? y or n ");
      String again = console.next();
      if(again.equalsIgnoreCase("y")){
         twoPlayerGame(console, score);
      }
   }
   //one player chooses their move, then the program randomly chooses another move
   public static void onePlayerGame(Scanner console, int[] score, String Opponent, String P1Last){
      System.out.print("Player 1 choose a move. rock, paper or scissors: ");
      String player1 = console.next();
      player1 = Validate(player1, console);
      System.out.println(Opponent + " is thinking...");
      String player2 = computerChoose(Opponent, P1Last);   
                  
      determineWinner(player1, player2, score, Opponent);
      System.out.println("score: " + score[0] + " to " + score[1]);
      System.out.print("play again? y or n ");
      String again = console.next();
      if(again.equalsIgnoreCase("y")){
         onePlayerGame(console, score, Opponent, player1);
      }

   }
   //takes the players input moves and compares them then updates a score
   public static int[] determineWinner(String player1, String player2, int[] score, String P2name){     
      System.out.println("player 1 chose: " + player1 + " and " + P2name + " chose: " + player2);
      if(player1.equalsIgnoreCase("rock") && player2.equalsIgnoreCase("paper")){
         System.out.println(P2name + " wins!");
         score[1]++;
      }
      if(player1.equalsIgnoreCase("rock") && player2.equalsIgnoreCase("scissors")){
         System.out.println("player 1 wins!");
         score[0]++;
      }
      if(player1.equalsIgnoreCase(player2)){
         System.out.println("tie! no one wins");
      }
      if(player1.equalsIgnoreCase("paper") && player2.equalsIgnoreCase("rock")){
         System.out.println("player 1 wins!");
         score[0]++;
      }
      if(player1.equalsIgnoreCase("paper") && player2.equalsIgnoreCase("scissors")){
         System.out.println(P2name + " wins!");
         score[1]++;
      }
            if(player1.equalsIgnoreCase("scissors") && player2.equalsIgnoreCase("rock")){
         System.out.println(P2name + " wins!");
         score[1]++;
      }
      if(player1.equalsIgnoreCase("scissors") && player2.equalsIgnoreCase("paper")){
         System.out.println("player 1 wins!");
         score[0]++;
      }
      return score;
   }
   //used in single player game for the computer to make a move. includes multiple ways of selecting a move.
   public static String computerChoose(String playerName, String P1Last){
      Random rand = new Random();
      int r = rand.nextInt(3);
      String player2 = " ";
      //randy
      if(!"bonny".equalsIgnoreCase(playerName)){
         if(r == 0){
            player2 = "rock";
         }else if(r == 1){
            player2 = "paper";
         }else if(r == 2){
            player2 = "scissors";
         }
      }
      //bonny
      if(playerName.equalsIgnoreCase("bonny")){
         if(P1Last.equals(" ")){
            player2 = "rock";  
         }
         if(P1Last.equalsIgnoreCase("rock")){
            player2 = "paper";  
         }
         if(P1Last.equalsIgnoreCase("paper")){
            player2 = "scissors";  
         }
         if(P1Last.equalsIgnoreCase("scissors")){
            player2 = "rock";  
         }
      }
      
   return player2;
   }
   
   public static String Validate(String player, Scanner console){
      int p1 = 0;
      while(p1 == 0){ //makes sure user puts a valid move
         if(player.equalsIgnoreCase("r")){
            player = "rock";
         }
         if(player.equalsIgnoreCase("p")){
            player = "paper";
         }
         if(player.equalsIgnoreCase("s")){
            player = "scissors";
         }
         if(!player.equalsIgnoreCase("rock")){
            if(!player.equalsIgnoreCase("paper")){
               if(!player.equalsIgnoreCase("scissors")){
                  System.out.print("not a valid move try again: ");
                  player = console.next();
               }else{
                  p1 = 1;
               }
            }else{
               p1 = 1;
            }
         }else{
            p1 = 1;
         }
      }
   return player;
   }
}