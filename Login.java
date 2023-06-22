package ATM_management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
//    global define button

    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField p1;
    Login(){

        setTitle("Bank Management");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/images.png"));
        setSize(800,480);//this is for creating frame
        setLocation(300,0);


        JPanel panel = new JPanel();
        panel.setBackground(new Color(239, 211, 159, 221));
        panel.setLayout(null);
        add(panel,BorderLayout.CENTER);


//        now set size of the image with get image and set it in new image class
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); // ye awt ki library me ata hai
//      now converting image into imag icon q k wo set nhi hoskta jlable k andar
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(100,30,100,100);
        getContentPane().setBackground(Color.gray);
        panel.add(lable);


//        label for text
        JLabel jl = new JLabel("Welcome to ATM ");
        jl.setBounds(300,70,300,30);
        jl.setFont(new Font("Osward",Font.BOLD,25));
        panel.add(jl);

        JLabel j1 = new JLabel("Card #: ");
        j1.setBounds(100,150,200,30);
        j1.setFont(new Font("Raleway",Font.BOLD,20));
        panel.add(j1);

         t1 = new JTextField();
        t1.setBounds(320, 150, 200,30);
        panel.add(t1);

        JLabel j2 = new JLabel("Password : ");
        j2.setBounds(100,200,200,30);
        j2.setFont(new Font("Raleway",Font.BOLD,20));
        panel.add(j2);

        p1 = new JPasswordField();
        p1.setBounds(320, 200, 200,30);
        panel.add(p1);
//        creating button
        b1 = new JButton("SIGN IN");
        b1.setBounds(320,250,80,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("CLEAR");
        b2.setBounds(440,250,80,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        panel.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("SIGN UP");
        b3.setBounds(320,300,200,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        panel.add(b3);
        b3.addActionListener(this);
        setVisible(true);

    }


    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String cardnumber=t1.getText();
            String password = p1.getText();
            connec c1 = new connec();
            String query = "select * from login where cardno = '"+cardnumber+"' and pin = '"+password+"'";
            try{
                ResultSet s1 = c1.s.executeQuery(query);
                if (s1.next()){
                    setVisible(false);
                    new Transaction(password).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Card number or password Incorrect");
                }

            }catch (Exception ea){
                System.out.println(ea);
            }
        }else if (e.getSource()==b3){ 
//            sign up
            setVisible(false);
            signupone s1 = new signupone();
            s1.setVisible(true);

        }else if (e.getSource()==b2){
            t1.setText("");
            p1.setText("");
        }

    }
}
