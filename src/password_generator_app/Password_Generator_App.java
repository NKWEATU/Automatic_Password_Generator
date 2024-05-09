/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package password_generator_app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import static javax.swing.UIManager.get;

/**
 *
 * @author USER
 */
public class Password_Generator_App extends JFrame {

   private JCheckBox lowerCaseCheckBox;
   private JCheckBox upperCaseCheckBox;
   private JCheckBox numbersCheckBox;
   private JCheckBox specialCharsCheckBox;
   private JSpinner  lengthSpinner;
   private JButton   generateButton;
   private JTextField passwordField;
   
    public Password_Generator_App() {
      setTitle("Password Generator");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(400,400);
      setLocationRelativeTo(null);
      initialize(); //initialize the user interface
    }
    private void initialize(){
        //the code below suggests the user for different option of what to 
        //include in the password
    
       lowerCaseCheckBox = new JCheckBox("Include lower case");
       upperCaseCheckBox = new JCheckBox("Include upper case");
       numbersCheckBox   = new JCheckBox("Include numbers");
       specialCharsCheckBox = new JCheckBox("Include special characters");
  
    
       lowerCaseCheckBox.setFocusPainted(false);
       lowerCaseCheckBox.setBorderPainted(false);
       lowerCaseCheckBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
       
       upperCaseCheckBox .setFocusPainted(false);
       upperCaseCheckBox .setBorderPainted(false);
       upperCaseCheckBox .setCursor(new Cursor(Cursor.HAND_CURSOR));
       
       
       numbersCheckBox.setFocusPainted(false);
       numbersCheckBox.setBorderPainted(false);
       numbersCheckBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
       
       specialCharsCheckBox.setFocusPainted(false);
       specialCharsCheckBox.setBorderPainted(false);
       specialCharsCheckBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
    //create a spinner for password length selection
      lengthSpinner = new JSpinner(new SpinnerNumberModel(8,4,20,1));
      
      //creates a textfield to display the generated password
      passwordField = new JTextField(20);
      passwordField.setFont(new Font ("Arial", Font.PLAIN, 16) );
      passwordField.setEditable(false);
       
       //code to create a button to generate password 
       generateButton = new JButton("Generate password");
       generateButton.setBackground(new Color(63, 81, 181));
       generateButton.setForeground(Color.red);
       generateButton.setFocusPainted(false);
       generateButton.setBorderPainted(false);
       generateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
       generateButton.addActionListener(new ActionListener(){
      
        @Override
        public void actionPerformed(ActionEvent e) {
        generatePassword();
        }
       
       });
       
       //code to create panels to hold the user interface (UI)
       JPanel mainPanel = new JPanel(new GridLayout(8,1,10,10));
       mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
       mainPanel.setBackground(Color.white);
       
       mainPanel.add(lowerCaseCheckBox);
       mainPanel.add(upperCaseCheckBox);
       mainPanel.add(numbersCheckBox);
       mainPanel.add(specialCharsCheckBox);
       
       JPanel LengthPanel = new  JPanel(new FlowLayout(FlowLayout.LEFT));
       LengthPanel.setBackground(Color.white);
       LengthPanel.add(new JLabel("Password length"));
       LengthPanel.add(lengthSpinner);
       mainPanel.add(LengthPanel);
       
       JPanel buttonPanel = new  JPanel(new FlowLayout(FlowLayout.CENTER));
       buttonPanel.setBackground(Color.white);
       buttonPanel.add(generateButton);
       mainPanel.add(buttonPanel);
       mainPanel.add( passwordField);
       
       getContentPane().setBackground(Color.white);
       add(mainPanel);
    }

    //code to generate password length  from the spinner
private String generatePassword(){
      //code to generate password length  from the spinner
         int passwordLength = (int)lengthSpinner.getValue();
         
         //code to define characeter set for password generation
         String lowerCase    = "abcdefghijklmnopqrstuvwxyz";
         String upperCase    = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         String numbers      = "0123456789";
         String specialChars = "!@#$%^&*()_+:><?/,.[]{}*-=|";
         
        
         
         //initialize the characeter string based on user selection
          String characters =  "";
         if(lowerCaseCheckBox.isSelected()) characters += lowerCase;
         if(upperCaseCheckBox.isSelected()) characters += upperCase ;
         if(numbersCheckBox.isSelected()) characters +=  numbers;
         if(specialCharsCheckBox.isSelected()) characters += specialChars;

            // shows error message if no caharetcer type is selscted
         if(characters.isEmpty())
         {
          JOptionPane.showMessageDialog(this, "Please select at least one character type");
          return "";
         }
         
         
         // Code to Generate the password by selecting random characters
         //...from the character string
             Random random = new Random();
             StringBuilder password = new  StringBuilder();
             
             for(int i = 0; i < passwordLength; i++)
             {
             int randomIndex = random.nextInt(characters.length());
             char randomChar = characters.charAt(randomIndex );
             password.append(randomChar);
             
             }
             
             //Displays the generated password in the texfield
         passwordField.setText(password.toString());
         return password.toString();
}
    public static void main(String[] args)
  
    {
    SwingUtilities.invokeLater(() ->{
        try{
        
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        
        
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        
       Password_Generator_App app = new  Password_Generator_App ();
        app.setVisible(true);
        
        
        
    });
        
        
    }
}
