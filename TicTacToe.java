import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/**JFrame that holds TicTacToe game!*/
public class TicTacToe extends JFrame{

//Show us whose turn it is
   private char whoseTurn='X';
   private boolean gameOver= false;
   
                         //create cells grid
   private Cell[][] cells=new Cell[3][3];
   
   /**No argument constructor*/
   public  TicTacToe(){
   
      JOptionPane.showMessageDialog(null," X turn to play!");
   
          //panel to hold cells
      JPanel panel= new JPanel(new GridLayout(3,3,0,0));
      for(int i=0; i<3; i++)
         for(int j=0; j<3; j++)
            panel.add(cells[i][j]=new Cell());
      add(panel, BorderLayout.CENTER);   
   }
   
   /** It shows if the game border is full
       @return true if the game border is full, if not false */ 
   public boolean isFull(){
      for(int i=0; i<3; i++)
         for(int j=0; j<3; j++)
            if(cells[i][j].getToken()==' ')
               return false ;
      return true;
   }
   
   /** It shows if the given token has won
   @param token-To test the winning
   @return true if the token has won, else false*/
   
   public boolean isWon(char token){
         //check rows
      for(int i=0; i<3; i++)
         if(cells[i][0].getToken() ==token && cells[i][1].getToken()==token && cells[i][2].getToken()==token)
         {
            return true;
         }
         //check columns
      for(int j=0; j<3; j++)
         if(cells[0][j].getToken() ==token && cells[1][j].getToken()==token && cells[2][j].getToken()==token)
         {
            return true;
         }
        //check diagonals
      if(cells[0][0].getToken() ==token && cells[1][1].getToken()==token && cells[2][2].getToken()==token)
      {
         return true;
      }
      if(cells[0][2].getToken() ==token && cells[1][1].getToken()==token && cells[2][0].getToken()==token)
      {
         return true;
      }
      return false;
   }
   
   /** Difines a cell in TicTacToe game board.*/
   
   public class Cell extends JPanel{
   
   //token of this cell
      private char token=' ';
   
      public Cell()
      {
         setBorder(new LineBorder(Color.black,1));
         addMouseListener(new MyMouseListener());
      }
      
      /** Gets the token of the cell.
      @return The token value of the cell.*/
      
      public char getToken()
      {
         return token;
      }
     
     /** Sets the token of the cell
     @param c- Character to use the token value. */
     
      public void setToken(char c)
      {
         token=c;
         repaint();
      }
   
      protected void paintComponent(Graphics g){
         super.paintComponent(g);
         if(token == 'X')
         {  
            g.drawLine(10,10 , getWidth()-10, getHeight()-10);
            g.drawLine(getWidth()-10, 10,10 , getHeight()-10);
         }
         else if(token== 'O')
         { 
            g.drawOval(10,10 ,getWidth()-20, getHeight()-20);
         }
      }
   
      private class MyMouseListener extends MouseAdapter{
      
         public void mouseClicked(MouseEvent e){
         
            if(gameOver)
               return ;
               
            //If the cell is empty and the game is not over
            if(token==' ' && whoseTurn != ' ')
               setToken(whoseTurn);
         
            if (isWon(whoseTurn))
            {
               JOptionPane.showMessageDialog(null, whoseTurn + "'s won! Game Over!");
               whoseTurn=' ';
               gameOver=true;
            }
            else if(isFull())
            {
               JOptionPane.showMessageDialog(null, "Tie game! Game Over!");
               whoseTurn=' ';
               gameOver=true;
            }
            else
            {
               whoseTurn=(whoseTurn == 'X')? 'O' : 'X';
            }
         }
      }
   }
}