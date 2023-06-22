package ATM_management;

import javax.management.relation.RoleInfoNotFoundException;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JLabel topic,Type,card,cnumber,cdetails,pin,pnumber,pdetails,service;
    JRadioButton j1,j2,j3,j4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    Random r = new Random();
    String formno=null;
    Signup3(String formno){
        this.formno = formno;
        setSize(800,800);
        setLocation(300,0);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(239, 211, 159, 221));
        panel.setLayout(null);
        add(panel,BorderLayout.CENTER);

        topic = new JLabel("Page 3: verifying");
        topic.setBounds(300,50,200,30);
        topic.setFont(new Font("raleways",Font.BOLD,25));
        panel.add(topic);

        Type = new JLabel("Account Type: ");
        Type.setBounds(100,100,200,30);
        Type.setFont(new Font("Arial",Font.BOLD,25));
        panel.add(Type);

        j1 = new JRadioButton("Saving Account");
        j1.setBounds(100,130,200,30);
        j1.setFont(new Font("raleways",Font.BOLD,15));
        j1.setBackground(new Color(239, 211, 159, 221));
        panel.add(j1);

        j2 = new JRadioButton("Fixed Deposit Account");
        j2.setBounds(300,130,200,30);
        j2.setFont(new Font("raleways",Font.BOLD,15));
        j2.setBackground(new Color(239, 211, 159, 221));
        panel.add(j2);

        j3 = new JRadioButton("Current Account");
        j3.setBounds(100,180,200,30);
        j3.setFont(new Font("raleways",Font.BOLD,15));
        j3.setBackground(new Color(239, 211, 159, 221));
        panel.add(j3);

        j4 = new JRadioButton("Recurring Deposit Account");
        j4.setBounds(300,180,300,30);
        j4.setFont(new Font("raleways",Font.BOLD,15));
        j4.setBackground(new Color(239, 211, 159, 221));
        panel.add(j4);

        ButtonGroup bg = new ButtonGroup();
        bg.add(j1);
        bg.add(j2);
        bg.add(j3);
        bg.add(j4);


        card = new JLabel("Card Number:");
        card.setBounds(100,230,200,30);
        card.setFont(new Font("Arial",Font.BOLD,25));
        panel.add(card);

        cnumber = new JLabel("XXXX-XXXX-XXXX-####");
        cnumber.setBounds(350,230,300,30);
        cnumber.setFont(new Font("Arial",Font.BOLD,25));
        panel.add(cnumber);

        cdetails = new JLabel("Your 16 digit Card number");
        cdetails.setBounds(100,250,500,30);
        cdetails.setFont(new Font("Arial",Font.BOLD,10));
        panel.add(cdetails);

        pin = new JLabel("Pin:");
        pin.setBounds(100,330,100,30);
        pin.setFont(new Font("Arial",Font.BOLD,25));
        panel.add(pin);

        pnumber = new JLabel("####");
        pnumber.setBounds(350,330,300,30);
        pnumber.setFont(new Font("Arial",Font.BOLD,25));
        panel.add(pnumber);

        pdetails = new JLabel("Your 14 digit code");
        pdetails.setBounds(100,350,500,30);
        pdetails.setFont(new Font("Arial",Font.BOLD,10));
        panel.add(pdetails);

        service = new JLabel("Services Required: ");
        service.setBounds(100,430,300,30);
        service.setFont(new Font("Arial",Font.BOLD,25));
        panel.add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(new Color(239, 211, 159, 221));
        c1.setBounds(100,480,100,20);
        panel.add(c1);


        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(239, 211, 159, 221));
        c2.setBounds(300,480,130,20);
        panel.add(c2);


        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(239, 211, 159, 221));
        c3.setBounds(100,530,120,20);
        panel.add(c3);


        c4 = new JCheckBox("Email & SMS alert");
        c4.setBackground(new Color(239, 211, 159, 221));
        c4.setBounds(300,530,150,20);
        panel.add(c4);


        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(new Color(239, 211, 159, 221));
        c5.setBounds(100,580,100,20);
        panel.add(c5);


        c6 = new JCheckBox("E-statement");
        c6.setBackground(new Color(239, 211, 159, 221));
        c6.setBounds(300,580,100,20);
        panel.add(c6);

        c7 = new JCheckBox("I confirm the information that I provided above");
        c7.setBounds(100,620,500,20);
        c7.setBackground(new Color(239, 211, 159, 221));
        c7.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(c7);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,650,100,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Arial", Font.BOLD,20));
        cancel.addActionListener(this);
        panel.add(cancel);

        submit = new JButton("Submit");
        submit.setBounds(400,650,100,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Arial", Font.BOLD,20));
        submit.addActionListener(this);
        panel.add(submit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            String accounttype =null;
            if (j1.isSelected()){
                accounttype = "saving account";
            } else if (j2.isSelected()) {
                accounttype = "Fixed deposit account";
            } else if (j3.isSelected()) {
                accounttype = "Current account";
            } else if (j4.isSelected()) {
                accounttype = "Recurring Deposite account";
            }
            String cardnumber = ""+ Math.abs(r.nextLong()% 90000000L + 5040936000000000L);
            String pinnumber = ""+ Math.abs(r.nextLong() % 9000L + 1000L);

            String facility = null;

            if (c1.isSelected()){
                facility = facility + "ATM Card";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + "Email & SMS alert";
            } else if (c5.isSelected()) {
                facility = facility + "cheque book";
            } else if (c6.isSelected()) {
                facility = facility + "E-statement";
            }
//            Database
            try{
                if (accounttype==""){
                    JOptionPane.showMessageDialog(null,"Must Enter any account type");
                } else if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null,"Must agree with our privacy");
                } else {
                    connec c1 = new connec();
//                    connec c2 = new connec();
                    String query = "insert into signupthree values ('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
//                  Query number 2
                    String query2 = "insert into login values ('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c1.s.executeUpdate(query);
                    c1.s.executeUpdate(query2);
                    setVisible(false);

                    JOptionPane.showMessageDialog(null,"Your card number is : "+cardnumber+"\nPin: "+pinnumber);


                }
            }catch (Exception ec){
                System.out.println("Error occured");
            }

        }else if (e.getSource()==cancel){
            setVisible(false);
            new Signup3(formno).setVisible(true);

        }

    }

    public static void main(String[] args) {
        Signup3 s3 = new Signup3("");

    }

}
