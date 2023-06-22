package ATM_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.util.Date;
import java.sql.ResultSet;

public class Fastcash extends JFrame implements ActionListener {
    JButton     onehundred,twohundred,fivehundred,thousand,fivethousand,tenthousand,back,otheramouunt;
    String pin;
    Fastcash(String pinnumber){
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

        JLabel l1 = new JLabel("Select Withdraw Amount");
        l1.setBounds(170,280,250,30);
        l1.setFont(new Font("Arial",Font.BOLD,18));
        l1.setForeground(Color.WHITE);
        j1.add(l1);

        onehundred = new JButton("100");
        onehundred.setBounds(140,370,150,26);
        onehundred.setFont(new Font("Arial",Font.BOLD,15));
        onehundred.addActionListener(this);
        j1.add(onehundred);

        twohundred = new JButton("200");
        twohundred.setBounds(310,370,150,26);
        twohundred.setFont(new Font("Arial",Font.BOLD,15));
        twohundred.addActionListener(this);
        j1.add(twohundred);

        fivehundred = new JButton("500");
        fivehundred.setBounds(140,400,150,26);
        fivehundred.setFont(new Font("Arial",Font.BOLD,15));
        fivehundred.addActionListener(this);
        j1.add(fivehundred);

        thousand = new JButton("1000");
        thousand.setBounds(310,400,150,26);
        thousand.setFont(new Font("Arial",Font.BOLD,15));
        thousand.addActionListener(this);
        j1.add(thousand);

        fivethousand = new JButton("5000");
        fivethousand.setBounds(140,430,150,26);
        fivethousand.setFont(new Font("Arial",Font.BOLD,15));
        fivethousand.addActionListener(this);
        j1.add(fivethousand);

        tenthousand = new JButton("10000");
        tenthousand.setBounds(310,430,150,26);
        tenthousand.setFont(new Font("Arial",Font.BOLD,15));
        tenthousand.addActionListener(this);
        j1.add(tenthousand);

        back = new JButton("Back");
        back.setBounds(310,460,150,26);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.addActionListener(this);
        j1.add(back);

        otheramouunt = new JButton("Other Amount");
        otheramouunt.setBounds(140,460,150,26);
        otheramouunt.setFont(new Font("Arial",Font.BOLD,15));
        otheramouunt.addActionListener(this);
        j1.add(otheramouunt);


        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String amount;
        if (e.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        } else if (e.getSource()==otheramouunt) {
            setVisible(false);
            new withdrawl(pin).setVisible(true);
        }else {
            amount = ((JButton)e.getSource()).getText();
            int balance =0;
            connec c = new connec();
            try{
                ResultSet rs = c.s.executeQuery("select * from bankdata where pin = '"+pin+"'");
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        System.out.println(amount);
                        balance += Integer.parseInt(rs.getString("amount"));

                    }else if (rs.getString("type").equals("withdraw")){
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    if (balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Not enough balance");
                        System.exit(0);
                    }else {
                        Date date = new Date();
                        String query = "insert into bankdata values ('"+pin+"','"+date+"','withdraw','"+amount+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Amount withdrew successfully");
                        setVisible(false);
                        new Transaction(pin).setVisible(true);
                    }

                }
            }catch (Exception ea){
                System.out.println(ea);
            }
        }
    }
    public static void main(String[] args) {
        Fastcash t1= new Fastcash("");
    }


}
