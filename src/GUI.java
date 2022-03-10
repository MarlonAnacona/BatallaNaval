import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class is used for ...
 * @author Jhon Alexander Valencia Hilamo jhon.hilamo@correounivalle.edu.co
 * @author Janiert Sebastian Salas Castillo janiert.salas@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {
    GridBagConstraints constraints = new GridBagConstraints();
    private Header headerProject;
    private JPanel panelBarcos,panelMiTablero,panelTableroPc,panelTableroPc2, MiBase, baseEnemiga;
    private Escucha escucha;
    private  ImageIcon image;
    private Mouse mouse=new Mouse();
    private JButton ayuda,salir,tableroPc,quitarTablero;
    private JButton [][] btBase;
    private JButton [][] btEnemy;
    private int numerobarcos;



    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();
        numerobarcos=4;
        //Default JFrame configuration
        this.setTitle("Batalla Naval");
        //this.setPreferredSize(new Dimension(1095,528));
        this.setBackground(new Color(255,255,255));
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */

    public void llenarBase(){
        int x=10,y=10;
        btBase=new JButton[10][10];
        for (int j=0;j<btBase.length;j++){
            for (int i=0;i<btBase[j].length;i++){
                btBase[i][j]=new JButton();
                btBase[i][j].setBackground(Color.ORANGE);
                btBase[i][j].setBounds(x,y,35,33);
                btBase[i][j].addMouseListener(mouse);
                MiBase.add(btBase[i][j],BorderLayout.CENTER);
                x+=35;
            }
            x=10;
            y+=33;
        }
    }




    public void llenarEnemy() {
        int x = 10, y = 10;
        btEnemy = new JButton[10][10];
        for (int j= 0; j < btBase.length; j++) {
            for (int i = 0; i < btBase[j].length; i++) {
                btEnemy[i][j] = new JButton();
                btEnemy[i][j].setBackground(Color.ORANGE);
                btEnemy[i][j].setBounds(x, y, 35, 33);
                btEnemy[i][j].addActionListener(escucha);
                baseEnemiga.add(btEnemy[i][j], BorderLayout.CENTER);
                x += 35;
            }
            x = 10;
            y += 33;
        }
    }


    public void elegirBarcos(){



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
        escucha =new Escucha();

        headerProject = new Header("Batalla Naval", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=4;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

        ayuda = new JButton(" ? ");
        ayuda.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(ayuda,constraints);

        salir = new JButton(" X ");
        salir.addActionListener(escucha);
        constraints.gridx=2;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(salir,constraints);

        panelBarcos=new JPanel();
        panelBarcos.setPreferredSize(new Dimension(165, 315));
        panelBarcos.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0,0,0),2,true),"Mis Barcos", TitledBorder.CENTER,TitledBorder.TOP,new Font("Tahoma", 1, 14)));
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        add(panelBarcos,constraints);

        tableroPc = new JButton("Mostrar Tablero");
        tableroPc.addActionListener(escucha);
        constraints.gridx=2;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.FIRST_LINE_START;
        this.add(tableroPc,constraints);

        quitarTablero = new JButton("Ocultar Tablero");
        quitarTablero.addActionListener(escucha);
        constraints.gridx=2;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.FIRST_LINE_END;
        this.add(quitarTablero,constraints);

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

        panelTableroPc=new JPanel();
        panelTableroPc.setPreferredSize(new Dimension(440, 400));
        panelTableroPc.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0),3,true),"MAPA",TitledBorder.CENTER,TitledBorder.TOP,new Font("Tahoma", 1, 15)));
        constraints.gridx=2;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        llenarEnemy();
        panelTableroPc.add(baseEnemiga);
        add(panelTableroPc,constraints);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==salir){
                System.exit(0);
            }

            if(e.getSource()==tableroPc){
                //JOptionPane.showMessageDialog(null,"Mostrar");
             /*   panelTableroPc2=new JPanel();
                panelTableroPc2.setPreferredSize(new Dimension(440, 448));
                panelTableroPc2.setBorder(BorderFactory.createTitledBorder(new LineBorder(new Color(0, 0, 0),3,true),"MAPA",TitledBorder.CENTER,TitledBorder.TOP,new Font("Tahoma", 1, 15)));
                constraints.gridx=1;
                constraints.gridy=3;
                constraints.gridwidth=1;
                constraints.fill=GridBagConstraints.NONE;
                constraints.anchor=GridBagConstraints.CENTER;
                add(panelTableroPc2,constraints);
            */
            tableroRival mitablero= new tableroRival();
            mitablero.setVisible(true);
            }




        }
    }

    private  class Mouse implements MouseListener{

        public  void mouseMove(MouseEvent e){

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            for (int h = 0; h < numerobarcos; h++) {
                for (int i = 0; i < btBase.length; i++) {
                    for (int j = 0; j < btBase[i].length; j++) {
                        if(j<=10-numerobarcos){
                            if (e.getSource() == btBase[i][j]) {
                                image = new ImageIcon(getClass().getResource("/resources/granada.png"));
                                btBase[i][j].setIcon(image);
                                btBase[i][j].setEnabled(false);

                               // j++;
                                btBase[i][h + j].setIcon(image);
                                btBase[i][h + j].setEnabled(false);
                            }
                        }

                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {


            for (int h = 0; h < numerobarcos; h++) {
                for (int i = 0; i < btBase.length; i++) {
                    for (int j = 0; j < btBase[i].length; j++) {
                        if(j<10-numerobarcos){
                            if (e.getSource() == btBase[i][j]) {
                                image = new ImageIcon(getClass().getResource("/resources/granada.png"));
                                //if(btBase[i][j].isEnabled()==true&&btBase[i][h + j+numerobarcos-1].isEnabled()==false) {

                               // }else{
                                    //if(btBase[i][j].isEnabled()==true){
                                        btBase[i][j].setIcon(image);
                                      // j++;
                                        btBase[i][h + j].setIcon(image);
                                    }
                               // }
                            }
                        //}

                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            for (int h = 0; h < numerobarcos; h++) {
                for (int i = 0; i < btBase.length; i++) {
                    for (int j = 0; j < btBase[i].length; j++) {
                        if(j<10-numerobarcos){
                            if (e.getSource() == btBase[i][j]) {
                                if(btBase[i][j].isEnabled()==true){
                                    btBase[i][j].setIcon(null);
                                    j++;
                                    if(btBase[i][h + j].isEnabled()==true){
                                    btBase[i][h + j].setIcon(null);
                                    }
                                }

                            }
                        }else{

                        }

                    }
                }
            }
        }
    }


}