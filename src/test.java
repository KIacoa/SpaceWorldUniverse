
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class test {
    public static void main(String args[]) {
        int a=11111;
        System.out.println(getType(Integer.toString(a))+getType("11111"));


    }
    public static String getType(Object o) {
        return o.getClass().toString();
    }
}
