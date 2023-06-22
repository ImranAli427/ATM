package ATM_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceInquery extends JFrame implements ActionListener {
    String pin;
    JButton back;
    balanceInquery(String pin){
        this.pin = pin;
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

        int balance =0;
//        query
        try {
            connec c = new connec();
            String query = "select * from bankdata where pin = '" + pin + "'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else if (rs.getString("type").equals("withdraw")){
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }


        }catch (Exception ea){
            System.out.println(ea);
        }
        JLabel text =  new JLabel("Your current balance is "+ balance);
        text.setBounds(170,300,200,30);
        text.setForeground(Color.WHITE);
        image.add(text);
//        back= new JButton("BACK");
        back = new JButton("BACK");
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(330,435,120,25);
        back.addActionListener(this);
        image.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new balanceInquery("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pin).setVisible(true);
    }
}
