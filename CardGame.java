/**
 *  Cody Vickroy
 *  Java 110 | UVM
 *  December 7th, 2013
 * 
 *  Plays a Game of War!
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardGame {
    
    ArrayList<Card> allCards = new ArrayList();
    ArrayList<Card> uCards = new ArrayList();
    ArrayList<Card> cCards = new ArrayList();
    Scanner keyboard = new Scanner(System.in);
    
    /**
    * Makes a Person
    */
    public CardGame(){
        
    }//end CardGame constructor
    
    /**
    * sorts a deck of cards into two hands
    */
    public void setUp(){
        for(int i = 1 ; i <= 52; i++){
            int suit = (i/13) + 1;
            int rank = (i%13);
            Card c = new Card(suit,rank);
            allCards.add(c);
        }
        
        Collections.shuffle(allCards);
        for(int i = 1 ; i <= allCards.size()-1; i++){
            if(i <= 26){
                uCards.add(allCards.get(i));
            }else if (i >= 27){
                cCards.add(allCards.get(i));
            }
        }      
    } //end setUp
    
    public void play(){
        
        System.out.println("Welcome to the game!");
        boolean keepPlaying = true;
        while(keepPlaying == true){
            
            Card uCard = uCards.get(0);
            Card cCard = cCards.get(0);
            if(uCard.getRank() > cCard.getRank()){
                System.out.println("Player: " + uCard.toString() + " | Computer: " + cCard.toString());
                System.out.println("You Won the Draw!");
                uCards.add(uCards.remove(0));
                uCards.add(cCard);
                uCards.remove(uCard);
            }else if(uCard.getRank() < cCard.getRank()){
                System.out.println("Player: " + uCard.toString() + " | Computer: " + cCard.toString());
                System.out.println("You Lost the Draw!");
                uCards.add(uCards.remove(0));
                cCards.add(uCard);
                uCards.remove(uCard);
            }else{
                System.out.println("Player: " + uCard.toString() + " | Computer: " + cCard.toString());
                System.out.println("WAR!");
                if(uCards.size() <= 3 && cCards.size() <= 3){
                    System.out.println("Neither player can not finish the war and widespread peace breaks out D=");
                    break;
                }else if(uCards.size() <= 3){
                    System.out.println("Player can not finish the war and forfits.  Computer Victory!!");
                    break;
                }else if(cCards.size() <= 3){
                    System.out.println("Computer can not finish the war and forfits.  You win!!");
                    break;
                }
                
                Card uCard2 = uCards.get(2);
                Card uCard3 = uCards.get(3);
                Card cCard2 = cCards.get(2);
                Card cCard3 = cCards.get(3);
                if(uCard3.getRank() > cCard3.getRank()){
                    System.out.println("Player: " + uCard3.toString() + " | Computer: " + cCard3.toString());
                    System.out.println("You Won the War!");
                    System.out.println("You Won: " + cCard.toString() + " " + cCard2.toString() + " " + cCard3.toString());
                    uCards.add(uCards.remove(0));
                    uCards.add(uCards.remove(0));
                    uCards.add(uCards.remove(0));
                    uCards.add(cCard);
                    uCards.add(cCard2);
                    uCards.add(cCard3);    
                    cCards.remove(cCard);
                    cCards.remove(cCard2);
                    cCards.remove(cCard3);
                }else if(cCard3.getRank() >= uCard3.getRank()){
                    System.out.println("Player: " + uCard3.toString() + " | Computer: " + cCard3.toString());
                    System.out.println("You Lost the War!");
                    System.out.println("You Lost: " + uCard.toString() + " & " + uCard2.toString() + " & " + uCard3.toString());
                    cCards.add(cCards.remove(0));
                    cCards.add(cCards.remove(0));
                    cCards.add(cCards.remove(0));
                    cCards.add(uCard);
                    cCards.add(uCard2);
                    cCards.add(uCard3);
                    uCards.remove(uCard);
                    uCards.remove(uCard2);
                    uCards.remove(uCard3);
                }
            }
            
            if(uCards.size() <= 0){
                System.out.println("You Lost!");
                keepPlaying = false;
            }else if (cCards.size() <= 0){
                System.out.println("You Won!");
                keepPlaying = false;
            }else{
                System.out.print("Keep Playing? (y/n): ");
                String choice = keyboard.nextLine();
                if (choice.equals("n") || choice.equals("N")){
                    System.out.println("You Forfited! Computer Victory!!");
                    keepPlaying = false;
                }
            }
        }
       
    } //end play
    
    
    
}//end class CardGame
