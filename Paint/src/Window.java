import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;


public class Window extends JFrame implements ActionListener, Serializable {
         public Drawing2 draw;
         public Window(String Title,int x,int y)
 {
         super(Title);
         this.setSize(x,y);
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         Container contentPanel = this.getContentPane() ;

         JMenuBar m= new JMenuBar();

         JMenu menu1= new JMenu("File");
         JMenu menu2= new JMenu("A Propos");
         JMenuItem author= new JMenuItem("Author");
         author.addActionListener(this);
         menu2.add(author);
         JMenuItem ne = new JMenuItem("New") ;
         ne.addActionListener(this);
         JMenuItem open = new JMenuItem("Open") ;
         open.addActionListener(this);
         JMenuItem save = new JMenuItem("Save") ;
         save.addActionListener(this);
         save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
         JMenuItem quit = new JMenuItem("Quit") ;
         quit.addActionListener(this);
         menu1.add(ne);
         menu1.add(open);
         menu1.add(save);
         menu1.addSeparator();
         menu1.add(quit);
         m.add(menu1);
         m.add(menu2);
         this.setJMenuBar(m);

         JButton noir= new JButton("Noir");
         JButton rouge= new JButton("Rouge");
         JButton vert= new JButton("Vert");
         JButton bleu= new JButton("Bleu");
         JButton jaune= new JButton("Jaune");
         JButton rose= new JButton("Rose");
         JButton magenta= new JButton("Magenta");
         JButton orange= new JButton("Orange");
         JButton ell = new JButton("paint Ellipse");
         JButton cir = new JButton("paint Circle");
         JButton rec = new JButton("paint Rectangle");
         JButton car = new JButton("paint Carre");

         JPanel southPanel = new JPanel();
         southPanel.setLayout(new GridBagLayout());
         GridBagConstraints c = new GridBagConstraints();
         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.25;
         c.gridx = 0;
         c.gridy = 0;
         noir.setBackground(Color.BLACK );
         noir.setForeground(Color.WHITE);
         southPanel.add(noir,c);
         noir.addActionListener(this);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.25;
         c.gridx = 1;
         c.gridy = 0;
         rouge.setBackground(Color.RED );
         rouge.addActionListener(this);
         southPanel.add(rouge,c);
         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.15;
         c.gridx = 2;
         c.gridy = 0;
         vert.setBackground(Color.GREEN );
         vert.addActionListener(this);
         southPanel.add(vert,c);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.25;
         c.gridx = 3;
         c.gridy = 0;
         bleu.setBackground(Color.BLUE );
         bleu.setForeground(Color.WHITE);
         bleu.addActionListener(this);
         southPanel.add(bleu,c);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.25;
         c.gridx = 0;
         c.gridy = 1;
         jaune.setBackground(Color.YELLOW );
         jaune.addActionListener(this);
         southPanel.add(jaune,c);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.25;
         c.gridx = 1;
         c.gridy = 1;
         rose.setBackground(Color.PINK );
         rose.addActionListener(this);
         southPanel.add(rose,c);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.15;
         c.gridx = 2;
         c.gridy = 1;
         magenta.setBackground(Color.MAGENTA );
         magenta.addActionListener(this);
         southPanel.add(magenta,c);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.25;
         c.gridx = 3;
         c.gridy = 1;
         orange.setBackground(Color.ORANGE );
         orange.addActionListener(this);
         southPanel.add(orange,c);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.8;
         c.gridx = 4;
         c.gridy = 0;
         c.gridwidth = 2;
         ell.addActionListener(this);
         southPanel.add(ell,c);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.9;
         c.gridx = 6;
         c.gridy = 0;
         cir.addActionListener(this);
         southPanel.add(cir,c);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.8;
         c.gridx = 4;
         c.gridy = 1;
         rec.addActionListener(this);
         southPanel.add(rec,c);

         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx = 0.9;
         c.gridx = 6;
         c.gridy = 1;
         car.addActionListener(this);
         southPanel.add(car,c);

         contentPanel.add(southPanel,"South");

         this.draw=new Drawing2();
         contentPanel.add(this.draw);

         this.setVisible(true);
         }


         public static void main (String[] args){
         Window win = new Window("Paint",800,600);
         }



        @Override
        public void actionPerformed(ActionEvent e)
        {
                String cmd=e.getActionCommand();
                switch (cmd)
                {
                        case "Noir":
                                this.draw.setColor(Color.BLACK);
                                break;

                        case "Rouge":
                                this.draw.setColor(Color.RED);
                                break;
                        case "Vert":
                                this.draw.setColor(Color.GREEN);
                                break;
                        case "Bleu":
                                this.draw.setColor(Color.BLUE);
                                break;
                        case "Jaune":
                                this.draw.setColor(Color.YELLOW);
                                break;
                        case "Magenta":
                                this.draw.setColor(Color.MAGENTA);
                                System.out.println(draw.getColor());
                                break;
                        case "Orange":
                                this.draw.setColor(Color.ORANGE);
                                break;
                        case "paint Ellipse":
                                this.draw.setShape("Ellipse");
                                break;
                        case "paint Rectangle":
                                this.draw.setShape("Rectangle");
                                break;
                        case "paint Carre":
                                this.draw.setShape("Carre");
                                break;
                        case "paint Circle":
                                this.draw.setShape("Circle");
                                break;
                        case "Author":
                                JOptionPane info = new JOptionPane("info");
                                info.showInternalMessageDialog( info, "Authors: CARNOT Prisca",
                                        "information",JOptionPane.INFORMATION_MESSAGE);
                                break;
                        case "New":
                                this.draw.List=new ArrayList<Figure>();
                                repaint();
                                break;
                        case "Open":
                                JFrame fileopen = new JFrame();
                                String getMessage = JOptionPane.showInputDialog(fileopen, "Name of the file :");
                                this.draw.List=new ArrayList<Figure>();
                                this.open(getMessage);
                                repaint();
                                break;
                        case "Save":
                                JFrame filesave = new JFrame();
                                String getMessage2 = JOptionPane.showInputDialog(filesave, "Save as :");
                                this.save(getMessage2);
                                break;
                        case "Quit":
                                this.dispose();
                                break;
                }
        }

        public void save(String Message){
                try{
                        FileOutputStream fos = new FileOutputStream(Message);

                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeInt(this.draw.List.size());
                        System.out.println(this.draw.List);
                        for(Figure f : this.draw.List){
                                oos.writeObject(f);
                                }
                         oos.close();
                        System.out.println("Done!");
                        }
                catch (Exception e){
                        System.out.println("Problemos !");
                        }
                }

        public void open (String Message){
                try{
                        FileInputStream fos = new FileInputStream(Message);
                        ObjectInputStream oos = new ObjectInputStream(fos);
                        int total=oos.readInt();
                        for(int i=0;i<total;i++){
                                this.draw.List.add((Figure) oos.readObject());
                        }
                        oos.close();
                        fos.close();
                        System.out.println("Done!");
                }
                catch (Exception e){
                        System.out.println("Problemos !");
                }
        }
}

