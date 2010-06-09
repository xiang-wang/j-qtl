/*
 * Copyright (c) 2009 The Jackson Laboratory
 * 
 * This software was developed by Gary Churchill's Lab at The Jackson
 * Laboratory (see http://research.jax.org/faculty/churchill).
 *
 * This is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this software.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jax.qtl.cross.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import org.jax.analyticgraph.data.NamedDataMatrix;
import org.jax.analyticgraph.framework.GraphCoordinateConverter;
import org.jax.analyticgraph.framework.SimpleGraphCoordinateConverter;
import org.jax.analyticgraph.graph.AxisRenderingGraph;
import org.jax.analyticgraph.graph.histogram.Histogram;
import org.jax.qtl.QTL;
import org.jax.qtl.cross.Cross;
import org.jax.qtl.gui.SimpleGraphContainerPanel;

/**
 * Dialog for launching a histogram graph
 * @author <A HREF="mailto:keith.sheppard@jax.org">Keith Sheppard</A>
 */
public class ShowHistogramDialog extends javax.swing.JDialog
{
    /**
     * every {@link java.io.Serializable} is supposed to have one of these
     */
    private static final long serialVersionUID = -3465398275452071520L;
    
    private static final Logger LOG = Logger.getLogger(
            ShowHistogramDialog.class.getName());
    
    private volatile Cross selectedCross;

    private final Cross[] availableCrosses;
    
    /**
     * Constructor
     * @param parent
     *          the parent frame
     * @param selectedCross
     *          the selected cross
     * @param availableCrosses
     *          the crosses that the user can select from
     */
    public ShowHistogramDialog(java.awt.Frame parent, Cross selectedCross, Cross[] availableCrosses)
    {
        super(parent, "Select Phenotype for Histogram Plot", true);
        
        this.selectedCross = selectedCross;
        this.availableCrosses = availableCrosses;
        
        this.initComponents();
        this.postGuiInit();
    }
    
    /**
     * 
     */
    private void postGuiInit()
    {
        this.phenotypeList.setModel(new DefaultListModel());
        this.phenotypeList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);
        
        Cross selectedCross = this.selectedCross;
        for(Cross currCross: this.availableCrosses)
        {
            this.crossComboBox.addItem(currCross);
        }
        
        if(selectedCross != null)
        {
            this.crossComboBox.setSelectedItem(selectedCross);
        }
    }

    /**
     * Rebuild the phenotype list using the selected cross
     */
    private void rebuildPhenotypeList()
    {
        Cross selectedCross = this.selectedCross;
        if(selectedCross != null)
        {
            ShowHistogramDialog.fillListWithPhenotypes(
                    selectedCross,
                    this.phenotypeList);
            
            if(this.phenotypeList.getModel().getSize() >= 1)
            {
                this.phenotypeList.setSelectedIndex(0);
            }
        }
    }
    
    /**
     * Fill in the given list with phenotype name strings from the given cross
     * @param selectedCross
     *          the source of the phenotype
     * @param phenotypeList
     *          the list
     */
    private static void fillListWithPhenotypes(
            Cross selectedCross,
            JList phenotypeList)
    {
        DefaultListModel listModel = (DefaultListModel)phenotypeList.getModel();
        listModel.removeAllElements();
        for(String phenotypeName:
            selectedCross.getPhenotypeData().getDataNames())
        {
            listModel.addElement(phenotypeName);
        }
    }
    
    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("all")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actionPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        crossLabel = new javax.swing.JLabel();
        crossComboBox = new javax.swing.JComboBox();
        phenotypeScrollPane = new javax.swing.JScrollPane();
        phenotypeList = new javax.swing.JList();
        phenotypeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        actionPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        actionPanel.add(cancelButton);

        crossLabel.setText("Cross:");

        crossComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                crossComboBoxItemStateChanged(evt);
            }
        });

        phenotypeScrollPane.setViewportView(phenotypeList);

        phenotypeLabel.setText("Phenotype:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(actionPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(crossLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(crossComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(phenotypeLabel)
                .addContainerGap(311, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(phenotypeScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(crossLabel)
                    .add(crossComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(phenotypeLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(phenotypeScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(actionPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        Cross selectedCross = this.selectedCross;
        int selectedPhenoIndex = this.phenotypeList.getSelectedIndex();
        if(selectedCross != null && selectedPhenoIndex != -1)
        {
            NamedDataMatrix<Number> allPhenoData = selectedCross.getPhenotypeData();
            
            GraphCoordinateConverter coordinateConverter = new SimpleGraphCoordinateConverter(
                    0.0, 0.0,
                    1.0, 1.0);
            
            Histogram histogram = new Histogram(coordinateConverter);
            histogram.setGraphData(allPhenoData.getNamedDataList().get(
                    selectedPhenoIndex));
            
            SimpleGraphCoordinateConverter coordinateConverter2 = new SimpleGraphCoordinateConverter(
                    0.0, 0.0,
                    1.0, 1.0);
            
            AxisRenderingGraph histogramWithAxes = new AxisRenderingGraph(
                    coordinateConverter2);
            histogramWithAxes.setInteriorGraph(histogram);
            
            org.jax.analyticgraph.framework.Graph2DComponent graphComponent =
                    new org.jax.analyticgraph.framework.Graph2DComponent();
            graphComponent.setBackground(Color.WHITE);
            graphComponent.addGraph2D(histogramWithAxes);
            graphComponent.setPreferredSize(new Dimension(400, 400));
            
            SimpleGraphContainerPanel simpleGraphContainerPanel =
                new SimpleGraphContainerPanel(
                        graphComponent,
                        histogram);
            
            QTL.getInstance().getDesktop().createInternalFrame(
                    simpleGraphContainerPanel,
                    "Histogram Plot: " +
                    this.phenotypeList.getSelectedValue().toString() +
                    " (" + selectedCross.toString() +")",
                    null,
                    "histogram for: " + this.phenotypeList.getSelectedValue().toString());
        }
        else
        {
            LOG.severe(
                    "failed to show histogram plot: " +
                    "phenotype index: " + selectedPhenoIndex +
                    " cross: " + selectedCross);
        }
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void crossComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_crossComboBoxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            this.selectedCross = (Cross)evt.getItem();
            this.rebuildPhenotypeList();
        }
    }//GEN-LAST:event_crossComboBoxItemStateChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox crossComboBox;
    private javax.swing.JLabel crossLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel phenotypeLabel;
    private javax.swing.JList phenotypeList;
    private javax.swing.JScrollPane phenotypeScrollPane;
    // End of variables declaration//GEN-END:variables
    
}