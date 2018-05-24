import java.util.*;


public class RPSMain{
   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      System.out.println("Welcome to Rock, Paper, Scissors");
      int players = numberOfPlayers(console);
      if(players == 2){
      twoPlayerGame(console);
      }      
   }
   //lets the user choose to play a 1 or 2 player game
   public static int numberOfPlayers(Scanner console){
      System.out.print("1 or 2 players? ");
      int players = console.nextInt();
       if(players > 2){
         System.out.println("Thats too many players! try again");
         System.out.print("1 or 2 players? ");
         players = console.nextInt();
      }
      if(players == 1){
         System.out.println("Single player isn't ready yet. Please try two player");
         System.out.print("1 or 2 players? ");
         players = console.nextInt();
      }
      if(players == 2){
         System.out.println("here we go");
      }
      return players;
      
   }
   //lets 2 players choose their moves
   public static void twoPlayerGame(Scanner console){
      System.out.println("Player 2 don't look!");
      System.out.print("Player 1 choose a move. rock, paper or scissors: ");
      String player1 = console.next();
      if(!player1.equalsIgnoreCase("rock")){
         if(!player1.equalsIgnoreCase("paper")){
            if(!player1.equalsIgnoreCase("scissors")){
               System.out.print("not a valid move try again: ");
               player1 = console.next();
            }
         }
      }
      for(int i = 0; i < 15; i++){
      System.out.println("****************");
      }
      System.out.println("Player 1 don't look!");
      System.out.print("Player 2 choose a move. rock, paper or scissors: ");
      String player2 = console.next();
      if(!player1.equalsIgnoreCase("rock")){
         if(!player1.equalsIgnoreCase("paper")){
            if(!player1.equalsIgnoreCase("scissors")){
               System.out.print("not a valid move try again: ");
               player1 = console.next();
            }
         }
      }
   }
}