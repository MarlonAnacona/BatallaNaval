import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class tableroRival extends JFrame {

    GridBagConstraints constraints = new GridBagConstraints();
    private Header headerProject;
    private JPanel panelBarcos,panelMiTablero,panelTableroPc,panelTableroPc2, MiBase, baseEnemiga;
    private  ImageIcon image;
    private static boolean portaaviones,submarino,destructores,fragatas;
    private static int porta=1,subma=2,destruc=3,fragata=4;
    private int numerobarcos;
    private JButton ayuda,salir,tableroPc,quitarTablero;
    public static JButton [][] btBase1;
    public static ArrayList<JButton> botonesEnemigosColocados =new ArrayList<JButton>();
    private JButton [][] btEnemy;
    public static boolean contador;
    barcosRecibidos setInfo= new barcosRecibidos();

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
        llenarBaseEnemiga();
        if(setInfo.setNumero()<2){
            colocarBarcosEnemigos();
        }else{

        }


    }



    private void initGUI() {
        this.getContentPane().setLayout(new GridBagLayout());
        Container contentPane = this.getContentPane();
        //contentPane.setLayout(new ());

        MiBase =new JPanel();
        MiBase.setLayout(null);
        numerobarcos=4;
        portaaviones=true;
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

        panelMiTablero.add(MiBase);
        add(panelMiTablero,constraints);


    }
    public void llenarBaseEnemiga(){
        int x=10,y=10;
        btBase1 =new JButton[10][10];
        for (int j = 0; j< btBase1.length; j++){
            for (int i = 0; i< btBase1[j].length; i++){
                btBase1[i][j]=new JButton();
                btBase1[i][j].setBackground(Color.ORANGE);
                btBase1[i][j].setBounds(x,y,35,33);
                MiBase.add(btBase1[i][j],BorderLayout.CENTER);
                x+=35;
            }
            x=10;
            y+=33;
        }
    }

    public int elegirBarcos(int num){
        if(portaaviones==true){

            this.numerobarcos=num-1;

            portaaviones=false;
            submarino=true;

        }else{
            if(submarino==true&&subma!=0){
                subma--;

                if(subma==0){
                    this.numerobarcos=num-1;
                    submarino=false;
                    destructores=true;
                }

            }else{
                if(destructores==true&&destruc!=0){
                    destruc--;
                    if(destruc==0){
                        this.numerobarcos=num-1;
                        destructores=false;
                        fragatas=true;
                    }
                }else{
                    if(fragatas==true&&fragata!=0){
                        fragata--;
                        if(fragata==0){
                            this.numerobarcos=num-1;
                            fragatas=false;
                        }
                    }
                }
            }
        }
        return  numerobarcos;
    }

    public void colocarBarcosEnemigos(){


        Random aleatorio=new Random();

        int x,y;
       x=aleatorio.nextInt(9);
        y=aleatorio.nextInt(9);

        if(portaaviones==true){
           for (int h = 0; h < numerobarcos; h++) {
               for (int i = 0; i < btBase1.length; i++) {
                   for (int j = 0; j < btBase1[i].length; j++) {
                       if (j < (10 - numerobarcos)+1) {
                           if (btBase1[x][y] == btBase1[i][j]) {

                               image = new ImageIcon(getClass().getResource("/resources/granada.png"));
                               btBase1[i][j].setIcon(image);
                               botonesEnemigosColocados.add(btBase1[i][j]);

                               j++;
                               btBase1[i][(h + j)-1].setIcon(image);
                               botonesEnemigosColocados.add(btBase1[i][(h + j)-1]);
setInfo.getBarcos(botonesEnemigosColocados);
                           }
                       }else{
                           if (i <(10 - numerobarcos)+1 ) {
                               if (btBase1[x][y]== btBase1[i][j]) {


                                   image = new ImageIcon(getClass().getResource("/resources/granada.png"));
                                   btBase1[x][y].setIcon(image);
                                   btBase1[(i + h)-1 ][j].setIcon(image);
                                   botonesEnemigosColocados.add(btBase1[i][j]);
                                   i++;
                                   botonesEnemigosColocados.add(btBase1[(i + h)-1 ][j]);
                               }
                           } else {
                               if (btBase1[x][y]== btBase1[i][j]) {
                                   image = new ImageIcon(getClass().getResource("/resources/granada.png"));
                                   btBase1[(i) ][j].setIcon(image);
                                   botonesEnemigosColocados.add(btBase1[i][j]);


                                   btBase1[i - h][j].setIcon(image);
                                   botonesEnemigosColocados.add(btBase1[i - h][j]);
                               }
                           }
                       }

                   }
               }
           }
       }



}
}
