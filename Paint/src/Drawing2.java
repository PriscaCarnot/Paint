import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;

public class Drawing2 extends JPanel implements MouseListener, Serializable {
    protected Color Color;
    protected String Shape;
    protected ArrayList<Figure> List;
    protected int X;
    protected int Y;

    public Drawing2(){
        this.setBackground(Color.WHITE);
        this .setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        this.Color= java.awt.Color.BLACK;
        this.Shape= "Rectangle";
        this.List = new ArrayList<Figure>();
        this.addMouseListener(this);
    }

    public void setColor(Color C){
        this.Color=C;
    }

    public void setShape(String fig){
        this.Shape=fig;
    }

    public java.awt.Color getColor() {
        return Color;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.X=e.getX();
        this.Y=e.getY();
        switch(this.Shape){
            case "Rectangle":
                this.List.add(new Rectangle(this.Color,this.X,this.Y));
                break;
            case "Ellipse":
                this.List.add(new Ellipse(this.Color,this.X,this.Y));
                break;
            case "Carre":
                this.List.add(new Carre(this.Color,this.X,this.Y));
                break;
            case "Circle":
                this.List.add(new Cercle(this.Color,this.X,this.Y));
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.List.get(this.List.size()-1).setBoundingBox(e.getX()-this.X,e.getY()-this.Y);
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < this.List.size(); i++) {
            this.List.get(i).draw(g);
        }
    }
}
