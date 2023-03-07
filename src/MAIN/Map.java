package MAIN;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Map {
    String[] city ={"凯尔特","海特斯","阿卡斯迦","洛比克","塞拉","艾西西比亚","库古","阿卡斯","弗罗里昂","巴里亚","克格鲁"};
    String[] logo_src ={"freljord","shadow-isles","targon","piltover","noxus","shurima","zaun","demacia","bilgewater","ixtal","ionia"};
    int[][] logo_position ={{480,20},{660,80},{180,230},{305,250},{675,235},{700,330},{120,390},{340,500},{430,430},{940,575},{170,530}};
    JButton[] button =new JButton[11];
    JFrame jf;
    JPanel panel;
    Map(){
        jf = new JFrame();
        jf.setTitle("瓦力马尼亚大陆");
        jf.setVisible(true);
        jf.setSize(1200,800);
        jf.setLocation(0,0);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);

        //导入地图背景
        ImageIcon bg=new ImageIcon("src/images/map2.jpg");
        JLabel label=new JLabel(bg);
        label.setSize(bg.getIconWidth(),bg.getIconHeight());
        jf.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel)jf.getContentPane();
        j.setOpaque(false);
        panel=new JPanel();
        ImageIcon icon;

        //处理地图中各个地点的按钮
        for(int i=0;i<11;i++){
            icon=new ImageIcon(new ImageIcon("src/images/terrain/"+logo_src[i]+".png").getImage().getScaledInstance(64 ,64, Image.SCALE_SMOOTH));
            ImageIcon icon_hover=new ImageIcon("src/images/terrain/"+logo_src[i]+"-hover.png");
            icon_hover=new ImageIcon(icon_hover.getImage().getScaledInstance(64 ,64, Image.SCALE_SMOOTH));
            button[i]=new JButton(city[i],icon);
            //设置字体，和字体位置
            Font font = new Font("黑体", Font.BOLD, 15);
            button[i].setFont(font);
            button[i].setVerticalTextPosition(JButton.BOTTOM);
            button[i].setHorizontalTextPosition(JButton.CENTER);
            button[i].setIconTextGap(-8);
            button[i].setSize(icon.getIconWidth()+20,icon.getIconHeight()+20);
            button[i].setBorderPainted(false);
            button[i].setContentAreaFilled(false);
            button[i].setFocusPainted(false);
            button[i].setMargin(new Insets(0,0,0,0));
            button[i].setIcon(icon);
            button[i].setRolloverIcon(icon_hover);
            button[i].setPressedIcon(icon_hover);
            button[i].setDisabledIcon(icon);
            button[i].setLocation(logo_position[i][0], logo_position[i][1]);
            String logoi=logo_src[i];

            //这个没调用可以删除
            String cityi=city[i];

            JButton btn=button[i];
            button[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 获取到的事件源就是按钮本身
                    // JButton btn = (JButton) e.getSource();
                    //生成故事底层（全透明）纯容器
                    //禁用按钮
                    for(int j=0;j<11;j++){
                        button[j].setEnabled(false);
                    }

                    //导入城市页面右侧英雄图片
                    ImageIcon icon_dec=new ImageIcon(new ImageIcon("src/images/map_hero/"+logoi+".png").getImage().getScaledInstance(900 ,532, Image.SCALE_SMOOTH));
                    JLabel decoration=new JLabel(icon_dec);
                    decoration.setSize(icon_dec.getIconWidth(),icon_dec.getIconHeight());
                    decoration.setLocation(0,0);

                    //城市界面的面板
                    JPanel decoration_base=new JPanel();
                    decoration_base.setSize(860,icon_dec.getIconHeight()+30);
                    decoration_base.setLocation(340,jf.getHeight()-decoration_base.getHeight());
                    decoration_base.setBackground(new Color(1,10,19));
                    decoration_base.setLayout(null);
                    decoration_base.setOpaque(false);

                    //故事页右侧英雄下方底边
                    JPanel dec_bg=new JPanel();
                    dec_bg.setSize(decoration_base.getWidth(),200);
                    dec_bg.setBackground(new Color(1,10,19));
                    dec_bg.setLocation(0,decoration_base.getHeight()-200);
                    decoration_base.add(decoration);
                    decoration_base.add(dec_bg);

                    //界面的右侧处理完毕，加入到内容面板上
                    jf.getLayeredPane().add(decoration_base,btn.getDisplayedMnemonicIndex()+1);
                    JPanel story_base=new JPanel();
                    story_base.setSize(430,800);
                    jf.getLayeredPane().add(story_base,btn.getDisplayedMnemonicIndex()+1);
                    //生成回退按钮
                    //导入图标
                    ImageIcon icon=new ImageIcon(new ImageIcon("src/images/back6.png").getImage().getScaledInstance(45 ,92, Image.SCALE_SMOOTH));
                    ImageIcon icon_hover=new ImageIcon(new ImageIcon("src/images/back6-hover.png").getImage().getScaledInstance(45 ,92, Image.SCALE_SMOOTH));
                    JButton remv=new JButton(icon);
                    remv.setSize(icon.getIconWidth(),icon.getIconHeight());
                    remv.setLocation(story_base.getWidth()-icon.getIconWidth(),20);
                    remv.setIcon(icon);
                    remv.setRolloverIcon(icon_hover);
                    remv.setPressedIcon(icon_hover);
                    remv.setBorderPainted(false);
                    remv.setContentAreaFilled(false);
                    remv.setFocusPainted(false);
                    //回退按钮触发，直接删除最底层容器
                    remv.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            for(int j=0;j<11;j++){
                                button[j].setEnabled(true);
                            }
                            decoration_base.removeAll();
                            decoration_base.setVisible(false);
                            jf.getLayeredPane().remove(decoration_base);
                            story_base.removeAll();
                            story_base.setVisible(false);
                            jf.getLayeredPane().remove(story_base);
                        }
                    });

                    //生成真正写故事的面板
                    JPanel story=new JPanel();
                    story.setBackground(new Color(1,10,19));
                    story.setSize(story_base.getWidth()-icon.getIconWidth(),800);
                    story.setLocation(0,0);

                    //top，bottom均为填充用，无实际作用
                    JPanel story_top=new JPanel();
                    story_top.setBackground(new Color(1,10,19));
                    story_top.setSize(icon.getIconWidth(),remv.getLocation().y);
                    story_top.setLocation(story_base.getWidth()-icon.getIconWidth(),0);

                    JPanel story_bottom=new JPanel();
                    story_bottom.setBackground(new Color(1,10,19));
                    story_bottom.setSize(icon.getIconWidth(),800-(remv.getLocation().y+remv.getHeight()));
                    story_bottom.setLocation(story_base.getWidth()-icon.getIconWidth(),remv.getLocation().y+remv.getHeight());

                    //左半边变成四个模块，文本面板，返回按钮，上下两个装饰
                    story_base.add(story);
                    story_base.add(story_top);
                    story_base.add(story_bottom);
                    story_base.add(remv);
                    story_base.setLayout(null);
                    story_base.setOpaque(false);

                    //开始创建故事页
                    //导入故事页面上方logo
                    ImageIcon icon_logo=new ImageIcon("src/images/logo/"+logoi+".png");
                    icon_logo=new ImageIcon(icon_logo.getImage().getScaledInstance(70 ,80, Image.SCALE_SMOOTH));
                    JLabel select_logo=new JLabel(icon_logo);
                    select_logo.setSize(icon_logo.getIconWidth(),icon_logo.getIconHeight());
                    select_logo.setLocation(30,50);

                    //文件读写，读取信息
                    char[] info = new char[10000];
                    File file=new File("src/data/city/"+logoi+".txt");
                    FileReader reader = null;
                    try {
                        reader = new FileReader(file);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        reader.read(info);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    //导入故事页主体文本
                    String story_info=new String(info);
                    String name=story_info.substring(story_info.indexOf("name")+5,story_info.indexOf("\n",story_info.indexOf("name")));
                    String description=story_info.substring(story_info.indexOf("description")+12,story_info.indexOf("\n",story_info.indexOf("description")));
                    String governance=story_info.substring(story_info.indexOf("governance")+11,story_info.indexOf("\n",story_info.indexOf("governance")));
                    String technologyLevel=story_info.substring(story_info.indexOf("technologyLevel")+16,story_info.indexOf("\n",story_info.indexOf("technologyLevel")));
                    String magic=story_info.substring(story_info.indexOf("magic")+6,story_info.indexOf("\n",story_info.indexOf("magic")));
                    String environment=story_info.substring(story_info.indexOf("environment")+12,story_info.indexOf("\n",story_info.indexOf("environment")));
                    String main=story_info.substring(story_info.indexOf("main")+5,story_info.indexOf("\n",story_info.indexOf("main")));

                    //导入分割线
                    ImageIcon icon_divide=new ImageIcon(new ImageIcon("src/images/divide5.png").getImage().getScaledInstance(350 ,10, Image.SCALE_SMOOTH));
                    JLabel label_divide1=new JLabel(icon_divide);
                    JLabel label_divide2=new JLabel(icon_divide);

                    //一系列生成文本标签
                    JLabel label_name=new JLabel(name);
                    JLabel label_description=new JLabel(description);
                    JLabel label_governance=new JLabel("统治管理:");
                    JLabel label_technologyLevel=new JLabel("科技水平:");
                    JLabel label_magic=new JLabel("魔法水平:");
                    JLabel label_environment=new JLabel("总体环境:");
                    JLabel label_governance_info=new JLabel(governance);
                    JLabel label_technologyLevel_info=new JLabel(technologyLevel);
                    JLabel label_magic_info=new JLabel(magic);
                    JLabel label_environment_info=new JLabel(environment);

                    //城市介绍部分
                    JTextArea textArea_main=new JTextArea(main,50,20);
                    setLabel(label_name,Font.BOLD,40,240,230,210,230,50,120,55);
                    setLabel(label_description,Font.BOLD,15,160,155,140,200,50,120,90);
                    label_divide1.setSize(350,10);
                    label_divide1.setLocation(30,140);


                    setLabel(label_governance,Font.PLAIN,15,160,155,140,200,50,30,160);
                    setLabel(label_governance_info,Font.PLAIN,15,240,230,210,200,50,30,180);
                    setLabel(label_technologyLevel,Font.PLAIN,15,160,155,140,200,50,30,205);
                    setLabel(label_technologyLevel_info,Font.PLAIN,15,240,230,210,200,50,30,225);
                    setLabel(label_magic,Font.PLAIN,15,160,155,140,200,50,240,160);
                    setLabel(label_magic_info,Font.PLAIN,15,240,230,210,200,50,240,180);
                    setLabel(label_environment,Font.PLAIN,15,160,155,140,200,50,240,205);
                    setLabel(label_environment_info,Font.PLAIN,15,240,230,210,200,50,240,225);

                    label_divide2.setSize(350,10);
                    label_divide2.setLocation(30,275);

                    Font font_textArea_main = new Font("黑体",Font.PLAIN,18);
                    textArea_main.setForeground(new Color(160,155,140));
                    textArea_main.setFont(font_textArea_main);
                    textArea_main.setLineWrap(true);
                    textArea_main.setEditable(false);
                    textArea_main.setOpaque(false);
                    textArea_main.setLocation(30,300);
                    textArea_main.setSize(350,400);

                    story.setLayout(null);
                    story.add(select_logo);
                    story.add(label_name);
                    story.add(label_description);
                    story.add(label_divide1);
                    story.add(label_governance);
                    story.add(label_governance_info);
                    story.add(label_technologyLevel);
                    story.add(label_technologyLevel_info);
                    story.add(label_magic);
                    story.add(label_magic_info);
                    story.add(label_environment);
                    story.add(label_environment_info);
                    story.add(label_divide2);
                    story.add(textArea_main);
                }
            });
            panel.add(button[i]);
        }
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setSize(1200,800);
        jf.getLayeredPane().add(panel,-1);

        //生成菜单栏
        Build_menu build_menu=new Build_menu();
        JPanel menu_up_base=new JPanel();
        JButton hide_up=new JButton();
        JPanel menu_base=new JPanel();
        JButton hide=new JButton();
        JLabel border_line=new JLabel();
        JPanel menu=new JPanel();
        JButton map=new JButton();
        JLabel underline_map=new JLabel();
        JButton hero=new JButton();
        JLabel underline_hero=new JLabel();
        JButton home=new JButton();
        JLabel underline_home=new JLabel();
        build_menu.build_menu(jf,jf.getWidth(),jf.getHeight(),true,false,false,menu_up_base,hide_up,menu_base,hide,border_line,menu,map,underline_map,hero,underline_hero,home,underline_home);

        menu.add(underline_map);
        menu.add(underline_hero);
        menu.add(underline_home);
        menu.add(map);
        menu.add(hero);
        menu.add(home);
        menu_base.add(hide);
        menu_base.add(menu);
        menu_up_base.add(hide_up);
        jf.getLayeredPane().add(menu_base,1);
        jf.getLayeredPane().add(border_line,1);
        jf.getLayeredPane().add(menu_up_base,3);
    }
    void setLabel(JLabel label,int font_style,int size,int r,int g,int b,int width,int height,int x,int y){
        Font font_description = new Font("黑体", font_style, size);
        label.setFont(font_description);
        label.setForeground(new Color(r,g,b));
        label.setSize(width,height);
        label.setLocation(x,y);
    }
}
