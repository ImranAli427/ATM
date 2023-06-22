package ATM_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.jar.JarEntry;

public class miniStatement extends JFrame{
    miniStatement(String pin){
        setSize(400,500);
        setLocation(100,100);

        Panel panel = new Panel();
        panel.setLayout(null);
        add(panel,BorderLayout.CENTER);

        JLabel mini = new JLabel();
        mini.setBounds(50,90,1000,60);
        panel.add(mini); 


        JLabel name = new JLabel("BANK AL-HABIB");
        name.setBounds(130,30,150,30);
        name.setFont(new Font("Arial",Font.BOLD,18));
        panel.add(name);

        JLabel card = new JLabel();
        card.setBounds(50,150,500,30);
        panel.add(card);

        try{
            connec c = new connec();
            String query = "select * from login where pin = '"+pin+"'";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()){
                card.setText("Card no : "+rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        try{
            connec c = new connec();
            ResultSet rs = c.s.executeQuery("select * from bankdata where pin = '"+pin+"'");
            while (rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount"));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        setVisible(true);
    }
    public static void main(String[] args) {
        new miniStatement("");
    }

}
