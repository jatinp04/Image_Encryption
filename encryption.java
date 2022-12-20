package Encryption_Project;


import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TreeExpansionListener;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.time.format.TextStyle;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;




public class encryption {

    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Test");
            JFrame f=new JFrame();
            f.setTitle("Image Encrption App"); //Application Name
            f.setLocationRelativeTo(null);   //Relative Location upon opening of the app
                        
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(300,300);  //Size of the application Window 
            

            Font font =new Font("Robot",Font.BOLD,15); //family name, Style, Size

            //Creating Button
            JButton button =new JButton();
            button.setText("Select Image");
            button.setFont(font);

            //Text Field

            JTextField textField =new JTextField(15);
            textField.setFont(font);

            f.setLayout(new FlowLayout());

            button.addActionListener(e->{
                System.out.println("Button Clicked");
                String text =textField.getText();
                int temp =Integer.parseInt(text);
                operate(temp);
            } );    

            f.add(button);
            f.add(textField);

            f.setVisible(true);   
    }

   
}
