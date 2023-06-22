package ATM_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class signup2 extends JFrame implements ActionListener{
    JLabel topic,l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JComboBox c1,c2,c3,c4,c5;
    JTextField t6,t7;
    JRadioButton r8yes,r8no,r9yes,r9no;
    JButton jb1;
    String formno;

    signup2(String formno){
        this.formno = formno;
        setSize(850,800);
        setLocation(300,0);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(239, 211, 159, 221));
        panel.setLayout(null);
        add(panel,BorderLayout.CENTER);

        topic = new JLabel("Page 2: More Details");
        topic.setBounds(300,80,300,30);
        topic.setFont(new Font("Arial",Font.BOLD,25));
        panel.add(topic);

        l1 = new JLabel("Religion: ");
        l1.setBounds(100,130,100,30);
        l1.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(l1);
String st[] = {"Islam","Hindu","Sikh","Others"};
        c1 = new JComboBox(st);
        c1.setBounds(300,130,300,30);
        c1.setFont(new Font("Arial",Font.ITALIC,15));
        panel.add(c1);


        l2 = new JLabel("Category: ");
        l2.setBounds(100,180,100,30);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(l2);

        String st1[] = {"A","B","C","Others"};
        c2 = new JComboBox(st1);
        c2.setBounds(300,180,300,30);
        c2.setFont(new Font("Arial",Font.ITALIC,15));
        panel.add(c2);

        l3 = new JLabel("Income: ");
        l3.setBounds(100,230,100,30);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(l3);

        String st2[] = {"<150,000","<200,000","<300,000"};
        c3 = new JComboBox(st2);
        c3.setBounds(300,230,300,30);
        c3.setFont(new Font("Arial",Font.ITALIC,15));
        panel.add(c3);

        l4 = new JLabel("Education: ");
        l4.setBounds(100,280,150,30);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(l4);

        String st3[] = {"Undergrad","Graduation","Post Grad","Other"};
        c4 = new JComboBox(st3);
        c4.setBounds(300,280,300,30);
        c4.setFont(new Font("Arial",Font.ITALIC,15));
        panel.add(c4);

        l5 = new JLabel("Occupation: ");
        l5.setBounds(100,330,150,30);
        l5.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(l5);

        String st4[] = {"Salaried","No salary","No job","Other"};
        c5 = new JComboBox(st4);
        c5.setBounds(300,330,300,30);
        c5.setFont(new Font("Arial",Font.ITALIC,15));
        panel.add(c5);

        l6 = new JLabel("PAN Number: ");
        l6.setBounds(100,380,150,30);
        l6.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(l6);

        t6 = new JTextField();
        t6.setBounds(300,380,300,30);
        t6.setFont(new Font("Arial",Font.ITALIC,15));
        panel.add(t6);

        l7 = new JLabel("CNIC Number: ");
        l7.setBounds(100,430,150,30);
        l7.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(l7);

        t7 = new JTextField();
        t7.setBounds(300,430,300,30);
        t7.setFont(new Font("Arial",Font.ITALIC,15));
        panel.add(t7);

        l8 = new JLabel("Senior Citizen: ");
        l8.setBounds(100,480,150,30);
        l8.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(l8);

        r8yes = new JRadioButton("Yes");
        r8no = new JRadioButton("No");
        r8yes.setBounds(350,480,80,30);
        r8no.setBounds(450,480,80,30);
        r8yes.setBackground(new Color(239, 211, 159, 221));
        r8no.setBackground(new Color(239, 211, 159, 221));
        panel.add(r8yes);
        panel.add(r8no);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r8yes);
        bg.add(r8no);


        l9 = new JLabel("Any Existing Account: ");
        l9.setBounds(100,530,250,30);
        l9.setFont(new Font("Arial",Font.BOLD,20));
        panel.add(l9);

        r9yes = new JRadioButton("Yes");
        r9no = new JRadioButton("No");
        r9yes.setBounds(350,530,80,30);
        r9no.setBounds(450,530,80,30);
        r9yes.setBackground(new Color(239, 211, 159, 221));
        r9no.setBackground(new Color(239, 211, 159, 221));
        panel.add(r9yes);
        panel.add(r9no);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r9yes);
        bg1.add(r9no);

        jb1 = new JButton("Next");
        jb1.setBounds(550,600,80,30);
        jb1.setBackground(Color.BLACK);
        jb1.setForeground(Color.WHITE);
        jb1.setFont(new Font("Arial",Font.ITALIC,16));
        panel.add(jb1);
        jb1.addActionListener(this);


        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) c1.getSelectedItem();
        String category = (String) c2.getSelectedItem();
        String income = (String) c3.getSelectedItem();
        String education = (String) c4.getSelectedItem();
        String occupation = (String) c5.getSelectedItem();

        String pan = t6.getText();
        String nic = t7.getText();

        String senior=null,exist=null;
        if (r8yes.isSelected()){
            senior = "Yes";
        }else if (r8no.isSelected()){
            senior = "No";
        }
        if (r9yes.isSelected()){
            exist = "yes";
        }else if (r9no.isSelected()){
            exist = "No";
        }

        try{
            if (nic.equals("")){
                JOptionPane.showMessageDialog(null,"Must enter nic");
            }else {
                connec c = new connec();
                String query = "insert into signuptwo values ('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+nic+"','"+senior+"','"+exist+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup3(formno).setVisible(true);
            }
        }catch (Exception es){
            System.out.println("Exeption occure");
        }

    }


    public static void main(String[] args) {
        signup2 s2 = new signup2("");
    }

}
