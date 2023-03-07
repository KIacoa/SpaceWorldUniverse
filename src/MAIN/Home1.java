package MAIN;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home1 {
    JFrame frame_home;
    JPanel panel;
    JPanel home_base;
    Home1(){
        frame_home=new JFrame();
        frame_home.setSize(600,400);
        frame_home.setTitle("主页");
        frame_home.setLocation(300,200);
        frame_home.setVisible(true);
        frame_home.setDefaultCloseOperation(frame_home.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(new Color(10,10,12));
        panel.setVisible(true);
        panel.setOpaque(true);
        panel.setSize(frame_home.getSize());
        panel.setLayout(null);
        JPanel j=(JPanel)frame_home.getContentPane();
        j.setOpaque(false);

        home_base=new JPanel();
        home_base.setBackground(new Color(10,10,12,180));
        home_base.setSize(frame_home.getSize());
        home_base.setVisible(true);
        home_base.setOpaque(false);
        home_base.setLayout(null);

        ImageIcon icon_home_bg=new ImageIcon("src/images/home-background2.jpg");
        JLabel home_bg=new JLabel(icon_home_bg);
        home_bg.setVisible(true);
        home_bg.setSize(icon_home_bg.getIconWidth(),icon_home_bg.getIconHeight());
        home_bg.setLocation(0,0);
        JLabel home_fog=new JLabel();
        home_fog.setBackground(new Color(10,10,12,180));
        home_fog.setVisible(true);
        home_fog.setOpaque(true);
        home_fog.setSize(icon_home_bg.getIconWidth(),icon_home_bg.getIconHeight());
        home_fog.setLocation(0,0);

        ImageIcon icon_home_top=new ImageIcon("src/images/home-top4.png");
        JLabel home_top=new JLabel(icon_home_top);
        home_top.setVisible(true);
        home_top.setSize(icon_home_top.getIconWidth(),icon_home_top.getIconHeight());
        home_top.setLocation((home_base.getWidth()-home_top.getWidth())/2,5);
        ImageIcon icon_home_bottom=new ImageIcon("src/images/hide_detail_image1.png");
        JLabel home_bottom=new JLabel(icon_home_bottom);
        home_bottom.setVisible(true);
        home_bottom.setSize(icon_home_bottom.getIconWidth(),icon_home_bottom.getIconHeight());
        home_bottom.setLocation((home_base.getWidth()-home_bottom.getWidth())/2,home_base.getHeight()-home_bottom.getHeight()-40);
        /*ImageIcon icon_map=new ImageIcon(new ImageIcon("src/images/red-book.png").getImage().getScaledInstance((64) ,(64) , Image.SCALE_SMOOTH));
        ImageIcon icon_hero=new ImageIcon(new ImageIcon("src/images/green-book.png").getImage().getScaledInstance((64) ,(64) , Image.SCALE_SMOOTH));
        ImageIcon icon_map_hover=new ImageIcon(new ImageIcon("src/images/red-book-hover.png").getImage().getScaledInstance((64) ,(64) , Image.SCALE_SMOOTH));
        ImageIcon icon_hero_hover=new ImageIcon(new ImageIcon("src/images/green-book-hover.png").getImage().getScaledInstance((64) ,(64) , Image.SCALE_SMOOTH));*/
        ImageIcon icon_map=new ImageIcon("src/images/red-book.png");
        ImageIcon icon_hero=new ImageIcon("src/images/green-book.png");
        ImageIcon icon_map_hover=new ImageIcon("src/images/red-book-hover.png");
        ImageIcon icon_hero_hover=new ImageIcon("src/images/green-book-hover.png");

        JButton map_button=new JButton(icon_map);
        map_button.setSize(icon_map.getIconWidth(),icon_map.getIconHeight());
        map_button.setIcon(icon_map);
        map_button.setRolloverIcon(icon_map_hover);
        map_button.setPressedIcon(icon_map_hover);
        map_button.setBorderPainted(false);
        map_button.setContentAreaFilled(false);
        map_button.setFocusPainted(false);
        map_button.setLocation(0,0);
        JButton hero_button=new JButton(icon_hero);
        hero_button.setSize(icon_hero.getIconWidth(),icon_hero.getIconHeight());
        hero_button.setIcon(icon_hero);
        hero_button.setRolloverIcon(icon_hero_hover);
        hero_button.setPressedIcon(icon_hero_hover);
        hero_button.setBorderPainted(false);
        hero_button.setContentAreaFilled(false);
        hero_button.setFocusPainted(false);
        hero_button.setLocation(map_button.getLocation().x+map_button.getWidth()+50,map_button.getLocation().y);
        map_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map map=new Map();
            }
        });

        hero_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero hero=new Hero();
            }
        });

        JLabel map_label=new JLabel("地图",JLabel.CENTER);
        map_label.setForeground(new Color(201,170,113));
        Font font=new Font("黑体",Font.BOLD,35);
        map_label.setFont(font);
        map_label.setSize(map_button.getWidth(),50);
        map_label.setLocation(0,0);
        JLabel hero_label=new JLabel("英雄",JLabel.CENTER);
        hero_label.setForeground(new Color(201,170,113));
        hero_label.setFont(font);
        hero_label.setSize(map_button.getWidth(),50);
        hero_label.setLocation(map_label.getLocation().x+hero_label.getWidth()+50,map_label.getLocation().y);
        map_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                map_label.setForeground(new Color(240,230,210));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                map_label.setForeground(new Color(201,170,113));
            }
        });
        hero_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hero_label.setForeground(new Color(240,230,210));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hero_label.setForeground(new Color(201,170,113));
            }
        });
        JPanel button_base=new JPanel();
        button_base.setVisible(true);
        button_base.setOpaque(false);
        button_base.setLayout(null);
        button_base.setSize(map_button.getWidth()+50+hero_button.getWidth(),map_button.getHeight());
        button_base.setLocation((home_base.getWidth()-button_base.getWidth())/2,(home_base.getHeight()-button_base.getHeight())/2-50);
        JPanel label_base=new JPanel();
        label_base.setVisible(true);
        label_base.setOpaque(false);
        label_base.setLayout(null);
        label_base.setSize(map_label.getWidth()+hero_label.getWidth()+50,map_label.getHeight());
        label_base.setLocation((home_base.getWidth()-label_base.getWidth())/2,(button_base.getLocation().y+button_base.getHeight())+20);

        button_base.add(map_button);
        button_base.add(hero_button);
        label_base.add(map_label);
        label_base.add(hero_label);

        home_base.add(home_top);
        home_base.add(home_bottom);
        home_base.add(button_base);
        home_base.add(label_base);
        panel.add(home_fog);
        panel.add(home_bg);

        frame_home.getLayeredPane().add(panel,new Integer(Integer.MIN_VALUE));
        frame_home.getLayeredPane().add(home_base,-1);
    }
}
