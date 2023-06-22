package ATM_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class change extends JFrame implements ActionListener {
    JPasswordField t1,t2;
    JButton change,back;
    String pin;
    change(String pin){
        this.pin = pin;
        setSize(800,800);
        setLocation(300,0);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel, BorderLayout.CENTER);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(0,0,800,800);
        panel.add(j1);

        JLabel j2 = new JLabel("Changing Pin");
        j2.setBounds(170,270,200,30);
        j2.setFont(new Font("Arial",Font.BOLD,16));
        j2.setForeground(Color.WHITE);
        j1.add(j2);

        JLabel j3 = new JLabel("Enter Pin");
        j3.setBounds(150,370,200,30);
        j3.setFont(new Font("Arial",Font.BOLD,16));
        j3.setForeground(Color.WHITE);
        j1.add(j3);

        JLabel j4 = new JLabel("Re-Enter Pin");
        j4.setBounds(150,400,200,30);
        j4.setFont(new Font("Arial",Font.BOLD,16));
        j4.setForeground(Color.WHITE);
        j1.add(j4);

        t1 = new JPasswordField();
        t1.setBounds(300,370,150,25);
        t1.setFont(new Font("Arial",Font.BOLD,14));
        j1.add(t1);
        t2 = new JPasswordField();
        t2.setBounds(300,400,150,25);
        t2.setFont(new Font("Arial",Font.BOLD,14));
        j1.add(t2);

        change = new JButton("CHANGE");
        change.setFont(new Font("Arial",Font.BOLD,15));
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.setBounds(330,435,120,25);
        change.addActionListener(this);
        j1.add(change);


        back = new JButton("BACK");
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(330,465,120,25);
        back.addActionListener(this);
        j1.add(back);



        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        } else if (e.getSource()==change) {
            String jpin = t1.getText();
            String repin = t2.getText();
            if (jpin.equals("") || repin.equals("")){
                JOptionPane.showMessageDialog(null,"Empty pin is not allowed");
                return;
            }else if (jpin.equals(repin)){
                try{
                    connec c1 = new connec();
                    String query1 = "update bankdata set pin  = '"+repin+"' where pin = '"+pin+"'";
                    String query2 = "update signupthree set pin  = '"+repin+"' where pin = '"+pin+"'";
                    String query3 = "update login set pin  = '"+repin+"' where pin = '"+pin+"'";

                    c1.s.executeUpdate(query1);
                    c1.s.executeUpdate(query2);
                    c1.s.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null,"Password Changed Succesfully");

                    setVisible(false);
                    new Transaction(repin).setVisible(true);
                }catch (Exception ea){
                    System.out.println(ea);
                }

            }else {
                JOptionPane.showMessageDialog(null,"Incorrect re pin");

            }

        }

    }


    public static void main(String[] args) {
        new change("");
    }


}
