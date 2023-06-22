package ATM_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener {
    JButton deposit,back;
    JTextField amount;
    String pin;
    withdrawl (String pinnumber){
        this.pin = pinnumber;
        setSize(800,800);
        setLocation(300,0);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel, BorderLayout.CENTER);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        panel.add(image);

        JLabel l1= new JLabel("Enter amount you want to withdraw");
        l1.setBounds(150,270,250,30);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Arial",Font.BOLD,15));
        image.add(l1);

        amount = new JTextField();
        amount.setBounds(150,300,250,25);
        image.add(amount);

        deposit = new JButton("Withdraw");
        deposit.setFont(new Font("Arial",Font.BOLD,18));
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.setBounds(330,435,120,25);
        deposit.addActionListener(this);
        image.add(deposit);


        back = new JButton("Back");
        back.setFont(new Font("Arial",Font.BOLD,18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(330,465,120,25);
        back.addActionListener(this);
        image.add(back);

        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==deposit){
            String am = amount.getText();
            Date date = new Date();
            if (am.equals("")){
                JOptionPane.showMessageDialog(null,"Must Enter any amount");
            }else {
                connec c1= new connec();
                String query = "insert into bankdata values ('"+pin+"','"+date+"','"+"withdraw"+"','"+am+"')";
                try{
                    c1.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,am+" Withdrew successfully ");
                    setVisible(false);
                }catch (Exception ea){
                    System.out.println(ea);
                }
            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }

    }
    public static void main(String[] args) {
        withdrawl d1 = new withdrawl("");
    }


}
