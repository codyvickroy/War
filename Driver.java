/**
 *  Cody Vickroy
 *  Java 110 | UVM
 *  December 3rd, 2014
 * 
 *  Our Driver
 */

import javax.swing.*;

public class Driver
{
   public static void main(String [] args)
   {
      JFrame frame = new CardGameGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(500,500);
      frame.validate();
      frame.setVisible(true);

   }
}