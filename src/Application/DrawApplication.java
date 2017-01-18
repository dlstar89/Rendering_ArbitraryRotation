package Application;

import Utilities.MyUtility;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import MyMathsLibrary.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 *
 * @author DI
 */
enum cubeSide
{
   backTopLeft,      //0
   backTopRight,     //1
   backBottomLeft,   //2
   backBottomRight,  //3    
   frontTopLeft,     //4
   frontTopRight,    //5
   frontBottomLeft,  //6
   frontBottomRight  //7
};

public class DrawApplication extends javax.swing.JFrame
{
   private JFrame renderWindow = new JFrame("RenderWindow");
   private MyMathLib myMathLib = new MyMathLib();
   private MyUtility myUtility = new MyUtility();
   private boolean ScaleUp = false, ScaleDown = false;
   private boolean playPause = true;
   private boolean projectilePlayPause = false;
   
   //-------------------------COLORS--------------------------------------------
   private Color cubeColor, XYZPlane, Background;
   
   //--------------------- CUBE VECTORS-----------------------------------------    
   private Vector3 COMS = new Vector3(0, 0, 0);
   private Vector3 COM = COMS;
   private int pointLenght = 50;//length of the cube sides from COM
   private Vector3[] cubeVectors = AssignCubeVectors(pointLenght);
   
   //--------------------- ARBITRARY POINTS + TRANSLATION -------------------------------------    
   private Vector3 p1;
   private Vector3 p2;
   private float rotationDegree;
   private int translateX = 0, translateY = 0, translateZ = 0;
   
   //------------------------XYZ PLANE-----------------------------------------
   //mini plane
   private Vector3 X1CornerXYZPlane;
   private Vector3 X2CornerXYZPlane;
   private Vector3 Y1CornerXYZPlane;
   private Vector3 Y2CornerXYZPlane;
   //big centre plane
   private Vector3 x1CenterPlane;
   private Vector3 x2CenterPlane;
   private Vector3 y1CenterPlane;
   private Vector3 y2CenterPlane;
   


   /** Creates new form DrawApplication */
   public DrawApplication()
   {
      initComponents();

      renderWindow.addWindowListener(new WindowAdapter()
      {
         public void windowClosing(WindowEvent e)
         {
            System.exit(0);
         }
      });

      JApplet applet = new RenderingApplication();
      renderWindow.getContentPane().add("Center", applet);
      applet.init();
      renderWindow.pack();
      renderWindow.setSize(new Dimension(1000, 1000));
      renderWindow.setResizable(false);
      renderWindow.show();

      this.cubeColor = Color.GREEN;
      this.XYZPlane = Color.LIGHT_GRAY;
      this.Background = Color.BLACK;

      X1CornerXYZPlane = new Vector3(-renderWindow.getSize().width / 2f + 50, -renderWindow.getSize().height / 2f + 60, 1);
      X2CornerXYZPlane = new Vector3(-renderWindow.getSize().width / 2f + 150, -renderWindow.getSize().height / 2f + 60, 1);
      Y1CornerXYZPlane = new Vector3(-renderWindow.getSize().width / 2f + 100, -renderWindow.getSize().height / 2f + 20, 1);
      Y2CornerXYZPlane = new Vector3(-renderWindow.getSize().width / 2f + 100, -renderWindow.getSize().height / 2f + 100, 1);

      this.x1CenterPlane = new Vector3(-renderWindow.getSize().width / 2f, 0, 0);
      this.x2CenterPlane = new Vector3(renderWindow.getSize().width / 2f, 0, 0);
      this.y1CenterPlane = new Vector3(0, -renderWindow.getSize().height / 2f, 0);
      this.y2CenterPlane = new Vector3(0, renderWindow.getSize().height / 2f, 0);



      ApplyArbitraryPoints();
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        RK4ResultList = new javax.swing.DefaultListModel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        TransformationsPanel = new javax.swing.JPanel();
        ArbitraryAnimationPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        P1Xspinner = new javax.swing.JSpinner();
        P1Yspinner = new javax.swing.JSpinner();
        P1Zspinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        P2Xspinner = new javax.swing.JSpinner();
        P2Yspinner = new javax.swing.JSpinner();
        P2Zspinner = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        ArbitraryDegreeSpinner = new javax.swing.JSpinner();
        ApplyArbitraryPoints = new javax.swing.JButton();
        arbitraryXaxisCheckBox = new javax.swing.JCheckBox();
        arbitraryZaxisCheckBox = new javax.swing.JCheckBox();
        arbitraryYaxisCheckBox = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        CubePropertiesPanel = new javax.swing.JPanel();
        comXpositionSpinner = new javax.swing.JSpinner();
        comYpositionSpinner = new javax.swing.JSpinner();
        comZpositionSpinner = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ApplyNewPosition = new javax.swing.JButton();
        AdditionalAnimation = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        scaleUpButton = new javax.swing.JButton();
        scaleDownButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();
        playPauseButton = new javax.swing.JButton();
        arbitraryAnimationRadioButton = new javax.swing.JRadioButton();
        SettingsPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jColorChooser1 = new javax.swing.JColorChooser();
        jLabel27 = new javax.swing.JLabel();
        interfaceColors = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        animationSpeed = new javax.swing.JSlider();
        ShowXYZPLaneCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        ShowDebugCoordinatesCheckBox = new javax.swing.JCheckBox();
        showP1P2PointsCheckBox = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenuBarItem = new javax.swing.JMenu();
        exitProgramButton = new javax.swing.JMenuItem();
        saveRK4ResultsButton = new javax.swing.JMenuItem();
        ShowMenuBarItem = new javax.swing.JMenu();
        ShowRenderWindowCheckBox = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DrawAppProperties");
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(1000, 0, 0, 0));
        setName("MainFrame"); // NOI18N
        setResizable(false);

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ArbitraryAnimationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Arbitrary Animation", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setText("P1:");

        jLabel3.setText("X");

        jLabel4.setText("Y");

        jLabel5.setText("Z");

        jLabel6.setText("P2:");

        jLabel7.setText("X");

        jLabel8.setText("Y");

        jLabel9.setText("Z");

        P2Xspinner.setValue(1);

        P2Yspinner.setValue(1);

        P2Zspinner.setValue(1);

        jLabel10.setText("Degree");

        ArbitraryDegreeSpinner.setValue(1);

        ApplyArbitraryPoints.setText("Apply");
        ApplyArbitraryPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyArbitraryPointsActionPerformed(evt);
            }
        });

        arbitraryXaxisCheckBox.setSelected(true);
        arbitraryXaxisCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arbitraryXaxisCheckBoxActionPerformed(evt);
            }
        });

        arbitraryZaxisCheckBox.setSelected(true);
        arbitraryZaxisCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arbitraryZaxisCheckBoxActionPerformed(evt);
            }
        });

        arbitraryYaxisCheckBox.setSelected(true);
        arbitraryYaxisCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arbitraryYaxisCheckBoxActionPerformed(evt);
            }
        });

        jLabel28.setText("Enable/Disable P2XYZ");

        javax.swing.GroupLayout ArbitraryAnimationPanelLayout = new javax.swing.GroupLayout(ArbitraryAnimationPanel);
        ArbitraryAnimationPanel.setLayout(ArbitraryAnimationPanelLayout);
        ArbitraryAnimationPanelLayout.setHorizontalGroup(
            ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                        .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(ApplyArbitraryPoints))
                            .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(P1Zspinner, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(P1Yspinner, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(P1Xspinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ArbitraryDegreeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(P2Zspinner)
                                    .addComponent(P2Yspinner)
                                    .addComponent(P2Xspinner, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14)
                        .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arbitraryZaxisCheckBox)
                            .addComponent(arbitraryYaxisCheckBox)
                            .addComponent(arbitraryXaxisCheckBox))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArbitraryAnimationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addContainerGap())))
        );
        ArbitraryAnimationPanelLayout.setVerticalGroup(
            ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArbitraryAnimationPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(P1Xspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P1Yspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P1Zspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(19, 19, 19)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(arbitraryXaxisCheckBox)
                    .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(P2Xspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArbitraryAnimationPanelLayout.createSequentialGroup()
                        .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(P2Yspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(P2Zspinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArbitraryAnimationPanelLayout.createSequentialGroup()
                        .addComponent(arbitraryYaxisCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(arbitraryZaxisCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(ArbitraryAnimationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ArbitraryDegreeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(ApplyArbitraryPoints)
                .addContainerGap())
        );

        CubePropertiesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Cube Properties", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel11.setText("Y");

        jLabel12.setText("Z");

        jLabel13.setText("X");

        ApplyNewPosition.setText("Apply");
        ApplyNewPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyNewPositionActionPerformed(evt);
            }
        });

        AdditionalAnimation.setText("Animate Translation");

        jLabel14.setText("Translation");

        scaleUpButton.setText("ScaleUp");
        scaleUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleUpButtonActionPerformed(evt);
            }
        });

        scaleDownButton.setText("ScaleDown");
        scaleDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleDownButtonActionPerformed(evt);
            }
        });

        jLabel15.setText("Scaling");

        resetButton.setText("RESET!");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CubePropertiesPanelLayout = new javax.swing.GroupLayout(CubePropertiesPanel);
        CubePropertiesPanel.setLayout(CubePropertiesPanelLayout);
        CubePropertiesPanelLayout.setHorizontalGroup(
            CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comYpositionSpinner)
                    .addComponent(comZpositionSpinner)
                    .addComponent(comXpositionSpinner))
                .addGap(18, 18, 18)
                .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(ApplyNewPosition))
                    .addComponent(AdditionalAnimation))
                .addGap(25, 25, 25))
            .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scaleDownButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scaleUpButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
            .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel14))
                    .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(resetButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CubePropertiesPanelLayout.setVerticalGroup(
            CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comXpositionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(comYpositionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CubePropertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comZpositionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(CubePropertiesPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(AdditionalAnimation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ApplyNewPosition)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scaleUpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scaleDownButton)
                .addGap(44, 44, 44)
                .addComponent(resetButton)
                .addGap(21, 21, 21))
        );

        playPauseButton.setText("PAUSE");
        playPauseButton.setPreferredSize(new java.awt.Dimension(120, 60));
        playPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPauseButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(arbitraryAnimationRadioButton);
        arbitraryAnimationRadioButton.setSelected(true);
        arbitraryAnimationRadioButton.setText("Arbitrary Animation");

        javax.swing.GroupLayout TransformationsPanelLayout = new javax.swing.GroupLayout(TransformationsPanel);
        TransformationsPanel.setLayout(TransformationsPanelLayout);
        TransformationsPanelLayout.setHorizontalGroup(
            TransformationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransformationsPanelLayout.createSequentialGroup()
                .addGroup(TransformationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TransformationsPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(TransformationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TransformationsPanelLayout.createSequentialGroup()
                                .addComponent(ArbitraryAnimationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CubePropertiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TransformationsPanelLayout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(playPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(TransformationsPanelLayout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(arbitraryAnimationRadioButton)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        TransformationsPanelLayout.setVerticalGroup(
            TransformationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransformationsPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(arbitraryAnimationRadioButton)
                .addGap(35, 35, 35)
                .addGroup(TransformationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CubePropertiesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ArbitraryAnimationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(playPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Arbitrary Rotation", TransformationsPanel);

        jColorChooser1.setColor(new java.awt.Color(0, 153, 204));

        jLabel27.setText("Components Color:");

        interfaceColors.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cubes Wireframe", "XYZ Plane", "Background" }));

        jButton2.setText("Apply Color");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(interfaceColors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interfaceColors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        jTabbedPane2.addTab("Color", jPanel6);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        animationSpeed.setMaximum(250);
        animationSpeed.setValue(30);
        animationSpeed.setInverted(true);

        ShowXYZPLaneCheckBox.setSelected(true);
        ShowXYZPLaneCheckBox.setText("Show XYZ Plane");

        jLabel1.setText("-                  Animation Speed                +");

        ShowDebugCoordinatesCheckBox.setSelected(true);
        ShowDebugCoordinatesCheckBox.setText("Show Debug Coordiantes");

        showP1P2PointsCheckBox.setSelected(true);
        showP1P2PointsCheckBox.setText("Show P1,P2 Points");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(animationSpeed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showP1P2PointsCheckBox)
                    .addComponent(ShowXYZPLaneCheckBox)
                    .addComponent(ShowDebugCoordinatesCheckBox))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ShowDebugCoordinatesCheckBox)
                .addGap(18, 18, 18)
                .addComponent(ShowXYZPLaneCheckBox)
                .addGap(18, 18, 18)
                .addComponent(showP1P2PointsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(animationSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("More", jPanel4);

        javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
        SettingsPanel.setLayout(SettingsPanelLayout);
        SettingsPanelLayout.setHorizontalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, Short.MAX_VALUE)
                .addContainerGap())
        );
        SettingsPanelLayout.setVerticalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Settings", SettingsPanel);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        FileMenuBarItem.setText("File");

        exitProgramButton.setText("Exit");
        exitProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitProgramButtonActionPerformed(evt);
            }
        });
        FileMenuBarItem.add(exitProgramButton);

        saveRK4ResultsButton.setText("Save RK4 Results");
        saveRK4ResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRK4ResultsButtonActionPerformed(evt);
            }
        });
        FileMenuBarItem.add(saveRK4ResultsButton);

        jMenuBar1.add(FileMenuBarItem);

        ShowMenuBarItem.setText("Show");

        ShowRenderWindowCheckBox.setSelected(true);
        ShowRenderWindowCheckBox.setText("RenderWindow");
        ShowRenderWindowCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowRenderWindowCheckBoxActionPerformed(evt);
            }
        });
        ShowMenuBarItem.add(ShowRenderWindowCheckBox);

        jMenuBar1.add(ShowMenuBarItem);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//Java Automatically Generated Code
private void exitProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitProgramButtonActionPerformed
// TODO add your handling code here:
   System.exit(0);
}//GEN-LAST:event_exitProgramButtonActionPerformed

//Java Automatically Generated Code
private void ShowRenderWindowCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowRenderWindowCheckBoxActionPerformed
// TODO add your handling code here:
   if (ShowRenderWindowCheckBox.isSelected())
   {
      renderWindow.show();
   }
   else
   {
      renderWindow.hide();
   }
}//GEN-LAST:event_ShowRenderWindowCheckBoxActionPerformed

//Java Automatically Generated Code
private void saveRK4ResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRK4ResultsButtonActionPerformed
// TODO add your handling code here:
   try
   {
      Object[] results = RK4ResultList.toArray();

      Writer output = null;
      File file = new File("RK4 Result Set.txt");
      output = new BufferedWriter(new FileWriter(file));

      for (Object o : results)
      {
         output.write(o.toString());
         output.write("\r\n");
      }

      output.close();
   } catch (Exception e)
   {//Catch exception if any
      System.err.println("Error: " + e.getMessage());
   }
}//GEN-LAST:event_saveRK4ResultsButtonActionPerformed

//Java Automatically Generated Code
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int option = interfaceColors.getSelectedIndex();

        if (option == 0)
        {
            this.cubeColor = jColorChooser1.getColor();
        }
        else if (option == 1)
        {
            this.XYZPlane = jColorChooser1.getColor();
        }
        else if (option == 2)
        {
            this.Background = jColorChooser1.getColor();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

//Java Automatically Generated Code
    private void playPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseButtonActionPerformed
        // TODO add your handling code here:
        if (playPause)
        {
            playPause = false;
            playPauseButton.setText("Play");
        }
        else if (!playPause)
        {
            playPause = true;
            playPauseButton.setText("Pause");
        }
    }//GEN-LAST:event_playPauseButtonActionPerformed

//Java Automatically Generated Code
    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        ResetCubeVectors();
    }//GEN-LAST:event_resetButtonActionPerformed

//Java Automatically Generated Code
    private void scaleDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleDownButtonActionPerformed
        // TODO add your handling code here:
        ScaleDown = true;
    }//GEN-LAST:event_scaleDownButtonActionPerformed

//Java Automatically Generated Code
    private void scaleUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleUpButtonActionPerformed
        // TODO add your handling code here:
        ScaleUp = true;
    }//GEN-LAST:event_scaleUpButtonActionPerformed

//Java Automatically Generated Code
    private void ApplyNewPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyNewPositionActionPerformed
        // TODO add your handling code here:
        translateX = Integer.parseInt(comXpositionSpinner.getValue().toString());
        translateY = Integer.parseInt(comYpositionSpinner.getValue().toString());
        translateZ = Integer.parseInt(comZpositionSpinner.getValue().toString());
    }//GEN-LAST:event_ApplyNewPositionActionPerformed

//Java Automatically Generated Code
    private void arbitraryYaxisCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbitraryYaxisCheckBoxActionPerformed
        // TODO add your handling code here:
        ApplyArbitraryPoints();
    }//GEN-LAST:event_arbitraryYaxisCheckBoxActionPerformed

//Java Automatically Generated Code
    private void arbitraryZaxisCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbitraryZaxisCheckBoxActionPerformed
        // TODO add your handling code here:
        ApplyArbitraryPoints();
    }//GEN-LAST:event_arbitraryZaxisCheckBoxActionPerformed

//Java Automatically Generated Code
    private void arbitraryXaxisCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbitraryXaxisCheckBoxActionPerformed
        // TODO add your handling code here:
        ApplyArbitraryPoints();
    }//GEN-LAST:event_arbitraryXaxisCheckBoxActionPerformed

//Java Automatically Generated Code
    private void ApplyArbitraryPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyArbitraryPointsActionPerformed
        // TODO add your handling code here:
        ApplyArbitraryPoints();
    }//GEN-LAST:event_ApplyArbitraryPointsActionPerformed

   public static void main(String args[])
   {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
       * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try
      {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
         {
            if ("Nimbus".equals(info.getName()))
            {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex)
      {
         java.util.logging.Logger.getLogger(RenderingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex)
      {
         java.util.logging.Logger.getLogger(RenderingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex)
      {
         java.util.logging.Logger.getLogger(RenderingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex)
      {
         java.util.logging.Logger.getLogger(RenderingApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
        /* Create and display the form */

      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new DrawApplication().setVisible(true);
         }
      });
   }
//--------------------------------------------------------------------------------

   public class RenderingApplication extends JApplet
   {
      public void init()
      {
         getContentPane().add(new AnimationPanel());
      }

      public class AnimationPanel extends JPanel
      {
         MyMathLib lib = new MyMathLib();

         public AnimationPanel()
         {
         }

         public void paint(Graphics g)
         {
            try
            {
               super.paint(g);
               setBackground(Background);
               g.translate(renderWindow.getSize().width / 2, renderWindow.getSize().height / 2);

                  DrawCube(g);//draws all the cube lines

                  if (translateX != 0 || translateY != 0 || translateZ != 0)
                  {
                     Translate();
                  }
                  else
                  {
                     if (playPause)
                     {
                        if (arbitraryXaxisCheckBox.isSelected() || arbitraryYaxisCheckBox.isSelected() || arbitraryZaxisCheckBox.isSelected())
                        {
                           RotateAroundArbitraryAxis();
                        }
                     }
                  }
               
   

               if (ShowXYZPLaneCheckBox.isSelected())
               {
                  DrawXYZPlane(g);
               }

               if (ShowDebugCoordinatesCheckBox.isSelected())
               {
                  DrawDebugCoordinates(g);
               }

               if (showP1P2PointsCheckBox.isSelected())
               {
                  DrawP1P2Points(g);
               }

               if (ScaleUp || ScaleDown)
               {
                  Scale();
               }

               repaint();

               Thread.sleep(animationSpeed.getValue());
            } catch (InterruptedException ex)
            {
               //do nothing
            }
         }

         //draws all the lines of hte cube on hte screen
         private void DrawCube(Graphics g)
         {
            g.setColor(cubeColor);

            //Back
            g.drawLine((int) cubeVectors[cubeSide.backTopLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.backTopLeft.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.backTopRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.backTopRight.ordinal()].GetY());//TR-TL

            g.drawLine((int) cubeVectors[cubeSide.backBottomLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.backBottomLeft.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.backBottomRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.backBottomRight.ordinal()].GetY());//BR-BL

            g.drawLine((int) cubeVectors[cubeSide.backTopLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.backTopLeft.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.backBottomLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.backBottomLeft.ordinal()].GetY());//TL-BL

            g.drawLine((int) cubeVectors[cubeSide.backTopRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.backTopRight.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.backBottomRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.backBottomRight.ordinal()].GetY());//TR-BR                        

            //Front
            g.drawLine((int) cubeVectors[cubeSide.frontTopLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontTopLeft.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.frontTopRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontTopRight.ordinal()].GetY());//TR-TL

            g.drawLine((int) cubeVectors[cubeSide.frontBottomLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontBottomLeft.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.frontBottomRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontBottomRight.ordinal()].GetY());//BR-BL

            g.drawLine((int) cubeVectors[cubeSide.frontTopLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontTopLeft.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.frontBottomLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontBottomLeft.ordinal()].GetY());//TL-BL

            g.drawLine((int) cubeVectors[cubeSide.frontTopRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontTopRight.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.frontBottomRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontBottomRight.ordinal()].GetY());//TR-BR

            //Sides
            g.drawLine((int) cubeVectors[cubeSide.backTopLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.backTopLeft.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.frontTopLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontTopLeft.ordinal()].GetY());//BTL-FTL

            g.drawLine((int) cubeVectors[cubeSide.backTopRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.backTopRight.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.frontTopRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontTopRight.ordinal()].GetY());//BTR-FTR

            g.drawLine((int) cubeVectors[cubeSide.backBottomLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.backBottomLeft.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.frontBottomLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontBottomLeft.ordinal()].GetY());//BBL-FBL

            g.drawLine((int) cubeVectors[cubeSide.backBottomRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.backBottomRight.ordinal()].GetY(),
                       (int) cubeVectors[cubeSide.frontBottomRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontBottomRight.ordinal()].GetY());//BBR-FBR
         }

         //Point letters and coordiantes for debug coordiantes
         private void DrawDebugCoordinates(Graphics g)
         {
            g.setColor(Color.red);
            int x = renderWindow.getSize().width / 2 - 300;
            int y = -renderWindow.getSize().height / 2 + 50;

               g.drawString("BTL: " + cubeVectors[cubeSide.backTopLeft.ordinal()].printVector(), x, y);
               g.drawString("BTL", (int) cubeVectors[cubeSide.backTopLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.backTopLeft.ordinal()].GetY());
               g.drawString("BTR: " + cubeVectors[cubeSide.backTopRight.ordinal()].printVector(), x, y + 20);
               g.drawString("BTR", (int) cubeVectors[cubeSide.backTopRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.backTopRight.ordinal()].GetY());
               g.drawString("BBL: " + cubeVectors[cubeSide.backBottomLeft.ordinal()].printVector(), x, y + 40);
               g.drawString("BBL", (int) cubeVectors[cubeSide.backBottomLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.backBottomLeft.ordinal()].GetY());
               g.drawString("BBR: " + cubeVectors[cubeSide.backBottomRight.ordinal()].printVector(), x, y + 60);
               g.drawString("BBR", (int) cubeVectors[cubeSide.backBottomRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.backBottomRight.ordinal()].GetY());

               g.setColor(Color.white);
               g.drawString("FTL: " + cubeVectors[cubeSide.frontTopLeft.ordinal()].printVector(), x, y + 100);
               g.drawString("FTL", (int) cubeVectors[cubeSide.frontTopLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontTopLeft.ordinal()].GetY());
               g.drawString("FTR: " + cubeVectors[cubeSide.frontTopRight.ordinal()].printVector(), x, y + 120);
               g.drawString("FTR", (int) cubeVectors[cubeSide.frontTopRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontTopRight.ordinal()].GetY());
               g.drawString("FBL: " + cubeVectors[cubeSide.frontBottomLeft.ordinal()].printVector(), x, y + 140);
               g.drawString("FBL", (int) cubeVectors[cubeSide.frontBottomLeft.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontBottomLeft.ordinal()].GetY());
               g.drawString("FBR: " + cubeVectors[cubeSide.frontBottomRight.ordinal()].printVector(), x, y + 160);
               g.drawString("FBR", (int) cubeVectors[cubeSide.frontBottomRight.ordinal()].GetX(), (int) cubeVectors[cubeSide.frontBottomRight.ordinal()].GetY());
         }

         private void DrawXYZPlane(Graphics g)
         {
            g.setColor(XYZPlane);
            
            g.drawString("X", (int) X2CornerXYZPlane.GetX() + 5, (int) X2CornerXYZPlane.GetY() + 5);
            g.drawLine((int) X1CornerXYZPlane.GetX(), (int) X1CornerXYZPlane.GetY(), (int) X2CornerXYZPlane.GetX(), (int) X2CornerXYZPlane.GetY());
            g.drawString("Y", (int) Y1CornerXYZPlane.GetX() - 3, (int) Y1CornerXYZPlane.GetY() - 3);
            g.drawLine((int) Y1CornerXYZPlane.GetX(), (int) Y1CornerXYZPlane.GetY(), (int) Y2CornerXYZPlane.GetX(), (int) Y2CornerXYZPlane.GetY());
            g.drawString("Z", (int) X2CornerXYZPlane.GetX() + 5, (int) Y1CornerXYZPlane.GetY());
            g.drawLine((int) X2CornerXYZPlane.GetX(), (int) Y1CornerXYZPlane.GetY(), (int) X1CornerXYZPlane.GetX(), (int) Y2CornerXYZPlane.GetY());

            g.drawLine((int) x1CenterPlane.GetX(), (int) x1CenterPlane.GetY(), (int) x2CenterPlane.GetX(), (int) x2CenterPlane.GetY());
            g.drawLine((int) y1CenterPlane.GetX(), (int) y1CenterPlane.GetY(), (int) y2CenterPlane.GetX(), (int) y2CenterPlane.GetY());
         }

         private void DrawP1P2Points(Graphics g)
         {
            g.setColor(Color.ORANGE);
            
            g.drawString("P1", (int) p1.GetX(), (int) p1.GetY());
            g.drawString("P2", (int) p2.GetX(), (int) p2.GetY());
         }
         
         //Translation can be performed either with animation or straight away
         private void Translate()
         {
            if (AdditionalAnimation.isSelected())
            {
               if (translateX > 0 || translateY > 0 || translateZ > 0)
               {
                  if (translateX != 0)
                  {
                     for (int i = 0; i < cubeVectors.length; i++)
                     {
                        cubeVectors[i] = myMathLib.Transalte(cubeVectors[i], 1, 0, 0);
                     }
                     translateX--;
                  }
                  else if (translateY != 0)
                  {
                     for (int i = 0; i < cubeVectors.length; i++)
                     {
                        cubeVectors[i] = myMathLib.Transalte(cubeVectors[i], 0, 1, 0);
                     }
                     translateY--;
                  }
                  else if (translateZ != 0)
                  {
                     for (int i = 0; i < cubeVectors.length; i++)
                     {
                        cubeVectors[i] = myMathLib.Transalte(cubeVectors[i], 0, 0, 1);
                     }
                     translateZ--;
                  }
               }
               else
               {
                  if (translateX != 0)
                  {
                     for (int i = 0; i < cubeVectors.length; i++)
                     {
                        cubeVectors[i] = myMathLib.Transalte(cubeVectors[i], -1, 0, 0);
                     }
                     translateX++;
                  }
                  else if (translateY != 0)
                  {
                     for (int i = 0; i < cubeVectors.length; i++)
                     {
                        cubeVectors[i] = myMathLib.Transalte(cubeVectors[i], 0, -1, 0);
                     }
                     translateY++;
                  }
                  else if (translateZ != 0)
                  {
                     for (int i = 0; i < cubeVectors.length; i++)
                     {
                        cubeVectors[i] = myMathLib.Transalte(cubeVectors[i], 0, 0, -1);
                     }
                     translateZ++;
                  }
               }
            }
            else
            {
               for (int i = 0; i < cubeVectors.length; i++)
               {
                  cubeVectors[i] = myMathLib.Transalte(cubeVectors[i],
                          Integer.parseInt(comXpositionSpinner.getValue().toString()),
                          Integer.parseInt(comYpositionSpinner.getValue().toString()),
                          Integer.parseInt(comZpositionSpinner.getValue().toString()));
               }
               translateX = 0;
               translateY = 0;
               translateZ = 0;
            }
         }

         private void Scale()
         {
            float cX = ((cubeVectors[cubeSide.backTopLeft.ordinal()].GetX() + cubeVectors[cubeSide.backTopRight.ordinal()].GetX()) / 2);

            float cY = ((cubeVectors[cubeSide.backTopLeft.ordinal()].GetY() + cubeVectors[cubeSide.backBottomLeft.ordinal()].GetY()) / 2);

            float cZ = (cubeVectors[cubeSide.backTopLeft.ordinal()].GetZ() + cubeVectors[cubeSide.frontTopLeft.ordinal()].GetZ()) / 2;

            if (ScaleUp)
            {
               for (int i = 0; i < cubeVectors.length; i++)
               {
                  cubeVectors[i] = myMathLib.Transform3DScale(cubeVectors[i], 1.1f, 1.1f, 1.1f, cX, cY, cZ);
               }
               ScaleUp = false;
            }
            else if (ScaleDown)
            {
               for (int i = 0; i < cubeVectors.length; i++)
               {
                  cubeVectors[i] = myMathLib.Transform3DScale(cubeVectors[i], 0.9f, 0.9f, 0.9f, cX, cY, cZ);
               }
               ScaleDown = false;
            }
         }

         private void RotateAroundArbitraryAxis()
         {
            if (!arbitraryXaxisCheckBox.isSelected() && (Integer.parseInt(P2Xspinner.getValue().toString()) != 0))
            {
               p2.SetX(0);
            }
            if (!arbitraryYaxisCheckBox.isSelected() && (Integer.parseInt(P2Yspinner.getValue().toString()) != 0))
            {
               p2.SetY(0);
            }
            if (!arbitraryZaxisCheckBox.isSelected() && (Integer.parseInt(P2Zspinner.getValue().toString()) != 0))
            {
               p2.SetZ(0);
            }

            //work out the arbitrary matrix first and after apply it to each point
            float[][] arbitraryMatrix = lib.RotateAroundArbitraryAxis(p1, p2, rotationDegree, false);

            for (int i = 0; i < cubeVectors.length; i++)
            {
               cubeVectors[i] = myMathLib.multiplyVector3WithMatrix4by4(cubeVectors[i], arbitraryMatrix);
            }
         }
      }
   }

   private Vector3[] AssignCubeVectors(int sideLenghts)
   {
      COM = COMS;

      pointLenght = sideLenghts;

      Vector3 StartBackTopLeft = new Vector3(COM.GetX() - pointLenght, COM.GetY() - pointLenght, COM.GetZ() + pointLenght);
      Vector3 StartBackTopRight = new Vector3(COM.GetX() + pointLenght, COM.GetY() - pointLenght, COM.GetZ() + pointLenght);
      Vector3 StartBackBottomLeft = new Vector3(COM.GetX() - pointLenght, COM.GetY() + pointLenght, COM.GetZ() + pointLenght);
      Vector3 StartBackBottomRight = new Vector3(COM.GetX() + pointLenght, COM.GetY() + pointLenght, COM.GetZ() + pointLenght);

      Vector3 StartFrontTopLeft = new Vector3(COM.GetX() - pointLenght, COM.GetY() - pointLenght, COM.GetZ() - pointLenght);
      Vector3 StartFrontTopRight = new Vector3(COM.GetX() + pointLenght, COM.GetY() - pointLenght, COM.GetZ() - pointLenght);
      Vector3 StartFrontBottomLeft = new Vector3(COM.GetX() - pointLenght, COM.GetY() + pointLenght, COM.GetZ() - pointLenght);
      Vector3 StartFrontBottomRight = new Vector3(COM.GetX() + pointLenght, COM.GetY() + pointLenght, COM.GetZ() - pointLenght);

      Vector3[] cubeStartVectors =
      {
         StartBackTopLeft, StartBackTopRight, StartBackBottomLeft, StartBackBottomRight,
         StartFrontTopLeft, StartFrontTopRight, StartFrontBottomLeft, StartFrontBottomRight
      };

      return cubeStartVectors;
   }

   private void ResetCubeVectors()
   {
      cubeVectors = AssignCubeVectors(pointLenght);
   }

   private void ApplyArbitraryPoints()
   {
      p1 = new Vector3(Float.parseFloat(P1Xspinner.getValue().toString()),
                       Float.parseFloat(P1Yspinner.getValue().toString()),
                       Float.parseFloat(P1Zspinner.getValue().toString()));

      p2 = new Vector3(Float.parseFloat(P2Xspinner.getValue().toString()),
                       Float.parseFloat(P2Yspinner.getValue().toString()),
                       Float.parseFloat(P2Zspinner.getValue().toString()));

      rotationDegree = Float.parseFloat(ArbitraryDegreeSpinner.getValue().toString());
   }
   //Java Automatically Generated Code
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AdditionalAnimation;
    private javax.swing.JButton ApplyArbitraryPoints;
    private javax.swing.JButton ApplyNewPosition;
    private javax.swing.JPanel ArbitraryAnimationPanel;
    private javax.swing.JSpinner ArbitraryDegreeSpinner;
    private javax.swing.JPanel CubePropertiesPanel;
    private javax.swing.JMenu FileMenuBarItem;
    private javax.swing.JSpinner P1Xspinner;
    private javax.swing.JSpinner P1Yspinner;
    private javax.swing.JSpinner P1Zspinner;
    private javax.swing.JSpinner P2Xspinner;
    private javax.swing.JSpinner P2Yspinner;
    private javax.swing.JSpinner P2Zspinner;
    public static javax.swing.DefaultListModel RK4ResultList;
    private javax.swing.JPanel SettingsPanel;
    private javax.swing.JCheckBox ShowDebugCoordinatesCheckBox;
    private javax.swing.JMenu ShowMenuBarItem;
    private javax.swing.JCheckBoxMenuItem ShowRenderWindowCheckBox;
    private javax.swing.JCheckBox ShowXYZPLaneCheckBox;
    private javax.swing.JPanel TransformationsPanel;
    private javax.swing.JSlider animationSpeed;
    private javax.swing.JRadioButton arbitraryAnimationRadioButton;
    private javax.swing.JCheckBox arbitraryXaxisCheckBox;
    private javax.swing.JCheckBox arbitraryYaxisCheckBox;
    private javax.swing.JCheckBox arbitraryZaxisCheckBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSpinner comXpositionSpinner;
    private javax.swing.JSpinner comYpositionSpinner;
    private javax.swing.JSpinner comZpositionSpinner;
    private javax.swing.JMenuItem exitProgramButton;
    private javax.swing.JComboBox interfaceColors;
    private javax.swing.JButton jButton2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton playPauseButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JMenuItem saveRK4ResultsButton;
    private javax.swing.JButton scaleDownButton;
    private javax.swing.JButton scaleUpButton;
    private javax.swing.JCheckBox showP1P2PointsCheckBox;
    // End of variables declaration//GEN-END:variables
}
