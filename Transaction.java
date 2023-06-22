package ATM_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton     deposit,withdrawl,fast,mini,pinchange,balance,exit;
    String pin;
    Transaction(String pinnumber){
        this.pin = pinnumber;
        setSize(800,800);
        setLocation(300,0);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel,BorderLayout.CENTER);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(0,0,800,800);
        panel.add(j1);

        JLabel l1 = new JLabel("Select Transaction");
        l1.setBounds(170,280,200,30);
        l1.setFont(new Font("Arial",Font.BOLD,18));
        l1.setForeground(Color.WHITE);
        j1.add(l1);

        deposit = new JButton("Deposit");
        deposit.setBounds(140,370,150,26);
        deposit.setFont(new Font("Arial",Font.BOLD,15));
        deposit.addActionListener(this);
        j1.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(310,370,150,26);
        withdrawl.setFont(new Font("Arial",Font.BOLD,15));
        withdrawl.addActionListener(this);
        j1.add(withdrawl);

        fast = new JButton("Fast Cash");
        fast.setBounds(140,400,150,26);
        fast.setFont(new Font("Arial",Font.BOLD,15));
        fast.addActionListener(this);
        j1.add(fast);

        mini = new JButton("Mini Statement");
        mini.setBounds(310,400,150,26);
        mini.setFont(new Font("Arial",Font.BOLD,15));
        mini.addActionListener(this);
        j1.add(mini);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(140,430,150,26);
        pinchange.setFont(new Font("Arial",Font.BOLD,15));
        pinchange.addActionListener(this);
        j1.add(pinchange);

        balance = new JButton("Balance Inquiry");
        balance.setBounds(310,430,150,26);
        balance.setFont(new Font("Arial",Font.BOLD,15));
        balance.addActionListener(this);
        j1.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(310,460,150,26);
        exit.setFont(new Font("Arial",Font.BOLD,15));
        exit.addActionListener(this);
        j1.add(exit);

        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit){
            System.exit(0);
        } else if (e.getSource()==deposit) {
            setVisible(false);
            new Deposite(pin).setVisible(true);
        } else if (e.getSource()==withdrawl) {
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        }  else if (e.getSource()==fast){
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        } else if (e.getSource()==pinchange) {
            setVisible(false);
            new change(pin).setVisible(true);
        } else if (e.getSource()==balance) {
            setVisible(false);
            new balanceInquery(pin).setVisible(true);
        } else if (e.getSource()==mini) {
            setVisible(false);
            new miniStatement(pin);
        }
    }
    public static void main(String[] args) {
        Transaction t1= new Transaction("");
    }


}
