/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acousticfield3d.gui.misc;

import acousticfield3d.gui.MainForm;
import acousticfield3d.math.M;
import acousticfield3d.math.Vector3f;
import acousticfield3d.utils.Parse;
import java.util.ArrayList;

/**
 *
 * @author am14010
 */
public class ShapePointsFrame extends javax.swing.JFrame {
    final MainForm mf;
    
    public ShapePointsFrame(MainForm mf) {
        this.mf = mf;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sepText = new javax.swing.JTextField();
        circleRadious = new javax.swing.JRadioButton();
        tetraRadious = new javax.swing.JRadioButton();
        cubeRadious = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        nPointsText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Separation:");

        sepText.setText("0.05");

        buttonGroup1.add(circleRadious);
        circleRadious.setSelected(true);
        circleRadious.setText("circle");

        buttonGroup1.add(tetraRadious);
        tetraRadious.setText("tetra");

        buttonGroup1.add(cubeRadious);
        cubeRadious.setText("cube");

        jLabel2.setText("nPoints");

        nPointsText.setText("8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(circleRadious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nPointsText))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sepText))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cubeRadious)
                            .addComponent(tetraRadious)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(101, 101, 101)
                                .addComponent(deleteButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sepText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(circleRadious)
                    .addComponent(jLabel2)
                    .addComponent(nPointsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tetraRadious)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cubeRadious)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        mf.pointsPanel.deleteAllPoints();
        mf.needUpdate();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private ArrayList<Vector3f> createPositions(){
        final ArrayList<Vector3f> points = new ArrayList<>();
        
        if (circleRadious.isSelected()){
            final int npoints = Parse.toInt( nPointsText.getText() );
            for (int i = 0; i < npoints; i++) {
                final float rads = M.TWO_PI * i / npoints;
                points.add( new Vector3f(M.cos(rads) / 2, 0, M.sin( rads ) / 2));
            }
        }else if (tetraRadious.isSelected()){
            points.add( new Vector3f( M.sqrt(8f/9), -1f/3, 0) );
            points.add( new Vector3f( -M.sqrt(2f/9), -1f/3, M.sqrt(2f/3) ) );
            points.add( new Vector3f( -M.sqrt(2f/9), -1f/3, -M.sqrt(2f/3)  ) );
            points.add( new Vector3f( 0, 1, 0 ) );
            
        }else if (cubeRadious.isSelected()){
            points.add( new Vector3f( -0.5, -0.5, -0.5 ) );
            points.add( new Vector3f( -0.5, -0.5, 0.5 ) );
            points.add( new Vector3f( 0.5, -0.5, -0.5 ) );
            points.add( new Vector3f( 0.5, -0.5, 0.5 ) );
            points.add( new Vector3f( -0.5, 0.5, -0.5 ) );
            points.add( new Vector3f( -0.5, 0.5, 0.5 ) );
            points.add( new Vector3f( 0.5, 0.5, -0.5 ) );
            points.add( new Vector3f( 0.5, 0.5, 0.5 ) );
        }
        
        final float sep = Parse.toFloat( sepText.getText() );
        final Vector3f center = mf.simulation.getSimulationCenter();
        for (Vector3f point : points) {
            point.multLocal( sep ).addLocal(center);
        }
        
        return points;
    }
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        final ArrayList<Vector3f> points = createPositions();
        for (Vector3f point : points) {
            mf.pointsPanel.addControlPoint(point);
        }
        mf.needUpdate();
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton circleRadious;
    private javax.swing.JRadioButton cubeRadious;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nPointsText;
    private javax.swing.JTextField sepText;
    private javax.swing.JRadioButton tetraRadious;
    // End of variables declaration//GEN-END:variables
}