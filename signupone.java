package ATM_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupone extends JFrame implements ActionListener {
    Random r;
    Long random;
    JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9,j10;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton jb1;
    JRadioButton m1,m2,male,female;

    signupone(){
        setSize(850,800);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(239, 211, 159, 221));
        panel.setLayout(null);
        add(panel, BorderLayout.CENTER);


         r  = new Random();
        random =  Math.abs(r.nextLong()%9000L) ;
        j1 = new JLabel("Application NO : "+random);
        j1.setBounds(300,30,300,30);
        j1.setFont(new Font("arial",Font.BOLD,25));
        panel.add(j1);


        j2 = new JLabel("Name*: ");
        j2.setBounds(100,80,100,30);
        j2.setFont(new Font("arial",Font.BOLD,20));
        panel.add(j2);

        j3 = new JLabel("Father's Name*: ");
        j3.setBounds(100,130,200,30);
        j3.setFont(new Font("arial",Font.BOLD,20));
        panel.add(j3);

        j4 = new JLabel("Date of Birth*: ");
        j4.setBounds(100,180,200,30);
        j4.setFont(new Font("arial",Font.BOLD,20));
        panel.add(j4);

        j5 = new JLabel("Gender: ");
        j5.setBounds(100,230,200,30);
        j5.setFont(new Font("arial",Font.BOLD,20));
        panel.add(j5);

        j6 = new JLabel("Email Address*: ");
        j6.setBounds(100,280,200,30);
        j6.setFont(new Font("arial",Font.BOLD,20));
        panel.add(j6);

        j7 = new JLabel("Marital Status: ");
        j7.setBounds(100,330,200,30);
        j7.setFont(new Font("arial",Font.BOLD,20));
        panel.add(j7);

        j8 = new JLabel("Address: ");
        j8.setBounds(100,380,200,30);
        j8.setFont(new Font("arial",Font.BOLD,20));
        panel.add(j8);

        j9 = new JLabel("City: ");
        j9.setBounds(100,430,200,30);
        j9.setFont(new Font("arial",Font.BOLD,20));
        panel.add(j9);

        j10 = new JLabel("Pin Code*: ");
        j10.setBounds(100,480,200,30);
        j10.setFont(new Font("arial",Font.BOLD,20));
        panel.add(j10);



        t1 = new JTextField();
        t1.setFont(new Font("Arial",Font.ITALIC,18));
        t1.setBounds(300,80,300,30);
        panel.add(t1);

        t2 = new JTextField();
        t2.setFont(new Font("Arial",Font.ITALIC,18));
        t2.setBounds(300,130,300,30);
        panel.add(t2);

        t3 = new JTextField();
        t3.setFont(new Font("Arial",Font.ITALIC,18));
        t3.setBounds(300,280,300,30);
        panel.add(t3);

        t4 = new JTextField();
        t4.setFont(new Font("Arial",Font.ITALIC,18));
        t4.setBounds(300,380,300,30);
        panel.add(t4);

        t5 = new JTextField();
        t5.setFont(new Font("Arial",Font.ITALIC,18));
        t5.setBounds(300,430,300,30);
        panel.add(t5);

        t6 = new JTextField();
        t6.setFont(new Font("Arial",Font.ITALIC,18));
        t6.setBounds(300,480,300,30);
        panel.add(t6);

        male = new JRadioButton("Male");
        male.setBounds(300,230,60,30);
        male.setBackground(new Color(239, 211, 159, 221));
        panel.add(male);
        female = new JRadioButton("Female");
        female.setBounds(400,230,70,30);
        female.setBackground(new Color(239, 211, 159, 221));
        panel.add(female);


        ButtonGroup grouped = new ButtonGroup();
        grouped.add(male);
        grouped.add(female);

        m1 = new JRadioButton("Married");
        m1.setBounds(300,330,70,30);
        m1.setBackground(new Color(239, 211, 159, 221));
        panel.add(m1);
        m2 = new JRadioButton("UnMarried");
        m2.setBounds(400,330,100,30);
        m2.setBackground(new Color(239, 211, 159, 221));
        panel.add(m2);


        ButtonGroup groop = new ButtonGroup();
        groop.add(m1);
        groop.add(m2);

        jb1 = new JButton("Next");
        jb1.setBounds(550,600,80,30);
        jb1.setBackground(Color.BLACK);
        jb1.setForeground(Color.WHITE);
        jb1.setFont(new Font("Arial",Font.ITALIC,16));
        panel.add(jb1);
        jb1.addActionListener(this);

        t7 = new JTextField();
        t7.setBounds(300,180,300,30);
        t7.setFont(new Font("Arial",Font.ITALIC,18));
        panel.add(t7);
        setVisible(true);



    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        for text field
        String name = null;
        String formno = ""+ random;
        name = t1.getText();

        String fname = t2.getText();
        String email = t3.getText();
        String addres = t4.getText();
        String city = t5.getText();
        String pin = t6.getText();
        String dob = t7.getText();

//        for radio button

        String gender = null,marital = null;
        if (male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }

        if (m1.isSelected()){
            marital = "Married";
        } else if (m2.isSelected()) {
            marital = "Unmarried";
        }
//        for data base me yahan try catch lagaunga
        try{
            if (name.equals("") || fname.equals("") || email.equals("") || dob.equals("") || pin.equals("")){
                JOptionPane.showMessageDialog(null,"Must Enter Information containing * ");
            }else {
                connec c1 = new connec();
//                writing query
                String query = "insert into Signup2 values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+addres+"','"+city+"','"+pin+"')";
                c1.s.executeUpdate(query);

                setVisible(false);
                signup2 SS = new signup2(formno);
                SS.setVisible(true);

            }

        }catch (Exception ex){

            System.out.println("Exception occure : "+ex);

        }
    }
    public static void main(String[] args) {
        new signupone();
    }


}
