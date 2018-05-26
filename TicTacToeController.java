import javax.swing.*;
import java.awt.*;

/** This is a TicTacToe game!! */

public class TicTacToeController{
   public static void main(String[] args){
      JFrame ticTacToe=new TicTacToe();
      ticTacToe.setTitle("TicTacToe Game!!");
      ticTacToe.setSize(400,400);
      ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ticTacToe.setLocationRelativeTo(null); 
      ticTacToe.setVisible(true);
   }
}