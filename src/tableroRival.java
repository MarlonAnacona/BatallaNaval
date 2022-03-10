import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class tableroRival extends JFrame {

    GridBagConstraints constraints = new GridBagConstraints();
    private Header headerProject;
    private JPanel panelBarcos,panelMiTablero,panelTableroPc,panelTableroPc2, MiBase, baseEnemiga;
    private  ImageIcon image;
    private JButton ayuda,salir,tableroPc,quitarTablero;
    private JButton [][] btBase;
    private JButton [][] btEnemy;



    public tableroRival(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Batalla Naval");
       // this.setPreferredSize(new Dimension(1095,528));
        this.setBackground(new Color(255,255,255));
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    private void initGUI() {
        this.getContentPane().setLayout(new GridBagLayout());
        Container contentPane = this.getContentPane();
        //contentPane.setLayout(new ());

        MiBase =new JPanel();
        MiBase.setLayout(null);

        MiBase.setPreferredSize(new Dimension(370,350));
        MiBase.setBackground(Color.DARK_GRAY);
        baseEnemiga =new JPanel();
        baseEnemiga.setLayout(null);
        baseEnemiga.setPreferredSize(new Dimension(370,350));
        baseEnemiga.setBackground(Color.darkGray);


        headerProject = new Header("Tablero enemigo", Color.BLUE);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=4;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);


        panelMiTablero=new JPanel();
        panelMiTablero.setPreferredSize(new Dimension(440, 400));
        panelMiTablero.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0),3,true),"BASE",TitledBorder.CENTER,TitledBorder.TOP,new Font("Tahoma", 1, 15)));
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        llenarBase();
        panelMiTablero.add(MiBase);
        add(panelMiTablero,constraints);


    }
    public void llenarBase(){
        int x=10,y=10;
        btBase=new JButton[10][10];
        for (int j=0;j<btBase.length;j++){
            for (int i=0;i<btBase[j].length;i++){
                btBase[i][j]=new JButton();
                btBase[i][j].setBackground(Color.ORANGE);
                btBase[i][j].setBounds(x,y,35,33);
                MiBase.add(btBase[i][j],BorderLayout.CENTER);
                x+=35;
            }
            x=10;
            y+=33;
        }
    }

}
