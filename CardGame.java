/**
 *  Cody Vickroy
 *  Java 110 | UVM
 *  December 7th, 2014
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
    private Card cCard;
    private Card uCard;
    
    /**
    * Makes a CadGame, and starts the GUI
    */
    public CardGame(){
    }//end CardGame constructor
    
    /**
    * sorts a deck of cards into two hands
    */
    public void setUp(){
        CardGameGUI gui = new CardGameGUI();

        //Creates a Deck of 52 Cards
        for(int i = 1 ; i <= 52; i++){
            int suit = (i/13) + 1;
            int rank = (i%13);
            Card c = new Card(suit,rank);
            allCards.add(c);
        }
        
        Collections.shuffle(allCards);   //shuffles our cards

        //distributes the cards to the hands
        for(int i = 1 ; i <= allCards.size()-1; i++){
            if(i <= 26){
                uCards.add(allCards.get(i));
            }else if (i >= 27){
                cCards.add(allCards.get(i));
            }
        }      
    } //end setUp

    /**
    * @return a Card
    * takes in an int that specifies the user (0: User | 1: CPU)
    */
    public Card draw(int player){
        if(player == 0){
            return uCards.get(0);
        }else{
            return cCards.get(0);
        }//end if 0
    }//end draw

    /**
    * @return users card
    */
    public Card getUCard(){
        return uCard;
    }

    /**
    * @return computers card
    */
    public Card getCCard(){
        return cCard;
    }

    /**
    * @return returns the status
    */
    public String setStatus(String status){
        return status;
    }//end set status

    /**
    * plays the game
    */
    public void play(){
        
        boolean keepPlaying = true;
        while(keepPlaying == true){
            
            uCard = draw(0);
            cCard = draw(0);
            if(uCard.getRank() > cCard.getRank()){
                setStatus("Player: " + uCard.toString() + " | Computer: " + cCard.toString());
                setStatus("You Won the Draw!");
                uCards.add(uCards.remove(0));
                uCards.add(cCard);
                uCards.remove(uCard);
            }else if(uCard.getRank() < cCard.getRank()){
                setStatus("Player: " + uCard.toString() + " | Computer: " + cCard.toString());
                setStatus("You Lost the Draw!");
                uCards.add(uCards.remove(0));
                cCards.add(uCard);
                uCards.remove(uCard);
            }else{
                setStatus("Player: " + uCard.toString() + " | Computer: " + cCard.toString());
                setStatus("WAR!");
                if(uCards.size() <= 3 && cCards.size() <= 3){
                    setStatus("Neither player can not finish the war and widespread peace breaks out D=");
                    break;
                }else if(uCards.size() <= 3){
                    setStatus("Player can not finish the war and forfits.  Computer Victory!!");
                    break;
                }else if(cCards.size() <= 3){
                    setStatus("Computer can not finish the war and forfits.  You win!!");
                    break;
                }
                
                uCard = draw(2);
                uCard = draw(3);
                uCard = draw(2);
                uCard = draw(3);
                if(uCard3.getRank() > cCard3.getRank()){
                    setStatus("Player: " + uCard3.toString() + " | Computer: " + cCard3.toString());
                    setStatus("You Won the War!");
                    setStatus("You Won: " + cCard.toString() + " " + cCard2.toString() + " " + cCard3.toString());
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
                    setStatus("Player: " + uCard3.toString() + " | Computer: " + cCard3.toString());
                    setStatus("You Lost the War!");
                    setStatus("You Lost: " + uCard.toString() + " & " + uCard2.toString() + " & " + uCard3.toString());
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
                setStatus("You Lost!");
                keepPlaying = false;
            }else if (cCards.size() <= 0){
                setStatus("You Won!");
                keepPlaying = false;
            }
        }
       
    } //end play
    
    
    
}//end class CardGame
