package ui;

import interfaces.ITabbedPanel;
import model.FComboBoxModel;
import model.IComboBoxModel;
import model.TextureComboBoxModel;
import strategys.shadertoy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sabrallte
 */
public class NodeEditorPanel extends javax.swing.JPanel implements ITabbedPanel {

    /**
     * Creates new form NodeEditorPanel
     */
    public NodeEditorPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jComboBox5 = new javax.swing.JComboBox<>();
        jl_input = new javax.swing.JLabel();
        jl_source = new javax.swing.JLabel();
        label_iResolution = new javax.swing.JLabel();
        label_iGlobalTime = new javax.swing.JLabel();
        label_iTimeDelta = new javax.swing.JLabel();
        label_iFrame = new javax.swing.JLabel();
        label_iChannelTime = new javax.swing.JLabel();
        cb_iResolution_x = new javax.swing.JComboBox<>();
        cb_iGlobalTime_x = new javax.swing.JComboBox<>();
        cb_iTimeDelta = new javax.swing.JComboBox<>();
        cb_iFrame_x = new javax.swing.JComboBox<>();
        cb_iChannelTime_q = new javax.swing.JComboBox<>();
        label_iMouse = new javax.swing.JLabel();
        label_iChannel0 = new javax.swing.JLabel();
        label_iChannel1 = new javax.swing.JLabel();
        label_iChannel2 = new javax.swing.JLabel();
        label_iChannel3 = new javax.swing.JLabel();
        label_iDate = new javax.swing.JLabel();
        label_iSampleRate = new javax.swing.JLabel();
        cb_iMouse_x = new javax.swing.JComboBox<>();
        cb_iChannel0 = new javax.swing.JComboBox<>();
        cb_iChannel1 = new javax.swing.JComboBox<>();
        jb_iChannel2 = new javax.swing.JComboBox<>();
        cb_iChannel3 = new javax.swing.JComboBox<>();
        cb_iDate_x = new javax.swing.JComboBox<>();
        cb_SampleRate_x = new javax.swing.JComboBox<>();
        jb_reset = new javax.swing.JButton();
        jb_apply = new javax.swing.JButton();
        jl_type = new javax.swing.JLabel();
        label_type_iResolution = new javax.swing.JLabel();
        label_type_iGlobalTime = new javax.swing.JLabel();
        labell_type_iTimeDelta = new javax.swing.JLabel();
        label_type_iFrame = new javax.swing.JLabel();
        label_type_iChannelTime = new javax.swing.JLabel();
        label_type_iMouse = new javax.swing.JLabel();
        label_type_iChannel0 = new javax.swing.JLabel();
        label_type_iChannel1 = new javax.swing.JLabel();
        label_type_iChannel2 = new javax.swing.JLabel();
        label_type_iChannel3 = new javax.swing.JLabel();
        label_type_iDate = new javax.swing.JLabel();
        label_type_iSampleRate = new javax.swing.JLabel();
        label_iChannelResolution = new javax.swing.JLabel();
        cb_iChannelResolution_x = new javax.swing.JComboBox<>();
        label_type_iChannelResolution = new javax.swing.JLabel();
        cb_iResolution_y = new javax.swing.JComboBox<>();
        cb_iResolution_z = new javax.swing.JComboBox<>();
        cb_iChannelTime_x = new javax.swing.JComboBox<>();
        cb_iChannelTime_y = new javax.swing.JComboBox<>();
        cb_iChannelTime_z = new javax.swing.JComboBox<>();
        cb_iDate_y = new javax.swing.JComboBox<>();
        cb_iDate_z = new javax.swing.JComboBox<>();
        cb_iDate_q = new javax.swing.JComboBox<>();
        cb_iChannelResolution_y = new javax.swing.JComboBox<>();
        cb_iChannelResolution_z = new javax.swing.JComboBox<>();
        cb_iMouse_y = new javax.swing.JComboBox<>();
        cb_iMouse_z = new javax.swing.JComboBox<>();
        cb_iMouse_q = new javax.swing.JComboBox<>();
        jb_iResolution_reset = new javax.swing.JButton();
        jb_iGlobalTime_reset = new javax.swing.JButton();
        jb_iTimeDelta_reset = new javax.swing.JButton();
        jb_iFrame_reset = new javax.swing.JButton();
        jb_iChannelTime_reset = new javax.swing.JButton();
        jb_iMouse_reset = new javax.swing.JButton();
        jb_iChannel0_reset = new javax.swing.JButton();
        jb_iChannel1_reset = new javax.swing.JButton();
        jb_iChannel2_reset = new javax.swing.JButton();
        jb_iChannel3_reset = new javax.swing.JButton();
        jb_iDate_reset = new javax.swing.JButton();
        jb_iSampleRate_reset = new javax.swing.JButton();
        jb_iChannelResolution_reset = new javax.swing.JButton();

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jl_input.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_input.setText("Input");

        jl_source.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_source.setText("Source");

        label_iResolution.setText("iResolution");

        label_iGlobalTime.setText("iGlobalTime");

        label_iTimeDelta.setText("iTimeDelta");

        label_iFrame.setText("iFrame");

        label_iChannelTime.setText("iChannelTime");

        cb_iResolution_x.setModel(new FComboBoxModel());

        cb_iGlobalTime_x.setModel(new FComboBoxModel());

        cb_iTimeDelta.setModel(new FComboBoxModel());

        cb_iFrame_x.setModel(new IComboBoxModel());

        cb_iChannelTime_q.setModel(new FComboBoxModel());

        label_iMouse.setText("iMouse");

        label_iChannel0.setText("iChannel0");

        label_iChannel1.setText("iChannel1");

        label_iChannel2.setText("iChannel2");

        label_iChannel3.setText("iChannel3");

        label_iDate.setText("iDate");

        label_iSampleRate.setText("iSampleRate");

        cb_iMouse_x.setModel(new FComboBoxModel());

        cb_iChannel0.setModel(new TextureComboBoxModel());

        cb_iChannel1.setModel(new TextureComboBoxModel());

        jb_iChannel2.setModel(new TextureComboBoxModel());

        cb_iChannel3.setModel(new TextureComboBoxModel());

        cb_iDate_x.setModel(new IComboBoxModel());

        cb_SampleRate_x.setModel(new FComboBoxModel());

        jb_reset.setText("Reset all");

        jb_apply.setText("Apply");

        jl_type.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jl_type.setText("Type");

        label_type_iResolution.setText("3f");

        label_type_iGlobalTime.setText("1f");

        labell_type_iTimeDelta.setText("1f");

        label_type_iFrame.setText("1i");

        label_type_iChannelTime.setText("4f");

        label_type_iMouse.setText("4f");

        label_type_iChannel0.setText("Texture 2D");

        label_type_iChannel1.setText("Texture 2D");

        label_type_iChannel2.setText("Texture 2D");

        label_type_iChannel3.setText("Texture 2D");

        label_type_iDate.setText("4i");

        label_type_iSampleRate.setText("1f");

        label_iChannelResolution.setText("iChannelResolution");

        cb_iChannelResolution_x.setModel(new FComboBoxModel());

        label_type_iChannelResolution.setText("3f");

        cb_iResolution_y.setModel(new FComboBoxModel());

        cb_iResolution_z.setModel(new FComboBoxModel());

        cb_iChannelTime_x.setModel(new FComboBoxModel());

        cb_iChannelTime_y.setModel(new FComboBoxModel());

        cb_iChannelTime_z.setModel(new FComboBoxModel());

        cb_iDate_y.setModel(new IComboBoxModel());

        cb_iDate_z.setModel(new IComboBoxModel());

        cb_iDate_q.setModel(new IComboBoxModel());

        cb_iChannelResolution_y.setModel(new FComboBoxModel());

        cb_iChannelResolution_z.setModel(new FComboBoxModel());

        cb_iMouse_y.setModel(new FComboBoxModel());

        cb_iMouse_z.setModel(new FComboBoxModel());

        cb_iMouse_q.setModel(new FComboBoxModel());

        jb_iResolution_reset.setText("Rest");

        jb_iGlobalTime_reset.setText("Rest");

        jb_iTimeDelta_reset.setText("Rest");

        jb_iFrame_reset.setText("Rest");

        jb_iChannelTime_reset.setText("Rest");

        jb_iMouse_reset.setText("Rest");

        jb_iChannel0_reset.setText("Rest");

        jb_iChannel1_reset.setText("Rest");

        jb_iChannel2_reset.setText("Rest");

        jb_iChannel3_reset.setText("Rest");

        jb_iDate_reset.setText("Rest");

        jb_iSampleRate_reset.setText("Rest");

        jb_iChannelResolution_reset.setText("Rest");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_input)
                            .addComponent(label_iChannelTime)
                            .addComponent(label_iResolution)
                            .addComponent(label_iGlobalTime)
                            .addComponent(label_iTimeDelta)
                            .addComponent(label_iFrame)
                            .addComponent(label_iMouse)
                            .addComponent(label_iChannel0)
                            .addComponent(label_iChannel1)
                            .addComponent(label_iChannel2)
                            .addComponent(label_iChannel3)
                            .addComponent(label_iDate)
                            .addComponent(label_iSampleRate))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cb_iTimeDelta, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_iFrame_x, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jb_apply)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_reset))
                            .addComponent(jl_source, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_iChannel1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_iChannel2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_iChannel3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_iChannel0, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_SampleRate_x, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_iResolution_x, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(cb_iResolution_y, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_iResolution_z, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cb_iGlobalTime_x, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(cb_iDate_x, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(cb_iDate_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_iDate_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_iDate_q, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cb_iMouse_x, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_iChannelTime_x, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_iChannelTime_y, 0, 56, Short.MAX_VALUE)
                                    .addComponent(cb_iMouse_y, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_iMouse_z, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_iChannelTime_z, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_iMouse_q, 0, 59, Short.MAX_VALUE)
                                    .addComponent(cb_iChannelTime_q, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_iChannelResolution)
                        .addGap(18, 18, 18)
                        .addComponent(cb_iChannelResolution_x, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_iChannelResolution_y, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_iChannelResolution_z, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jb_iResolution_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_iGlobalTime_reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jb_iTimeDelta_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jb_iFrame_reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jb_iChannelTime_reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jb_iMouse_reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_iChannel0_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_iChannel1_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_iChannel2_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_iChannel3_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_iDate_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_iSampleRate_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_iChannelResolution_reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_type)
                    .addComponent(label_type_iResolution)
                    .addComponent(label_type_iGlobalTime)
                    .addComponent(labell_type_iTimeDelta)
                    .addComponent(label_type_iFrame)
                    .addComponent(label_type_iChannelTime)
                    .addComponent(label_type_iMouse)
                    .addComponent(label_type_iChannel0)
                    .addComponent(label_type_iChannel1)
                    .addComponent(label_type_iChannel2)
                    .addComponent(label_type_iChannel3)
                    .addComponent(label_type_iDate)
                    .addComponent(label_type_iSampleRate)
                    .addComponent(label_type_iChannelResolution))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_iChannelTime_q, cb_iChannelTime_x, cb_iChannelTime_y, cb_iChannelTime_z});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_iMouse_q, cb_iMouse_x, cb_iMouse_y, cb_iMouse_z});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_iResolution_x, cb_iResolution_y, cb_iResolution_z});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_iDate_q, cb_iDate_x, cb_iDate_y, cb_iDate_z});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_iChannelResolution_x, cb_iChannelResolution_y, cb_iChannelResolution_z});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_input)
                    .addComponent(jl_source)
                    .addComponent(jl_type))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iResolution)
                    .addComponent(cb_iResolution_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iResolution)
                    .addComponent(cb_iResolution_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_iResolution_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_iResolution_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iGlobalTime)
                    .addComponent(cb_iGlobalTime_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iGlobalTime)
                    .addComponent(jb_iGlobalTime_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iTimeDelta)
                    .addComponent(cb_iTimeDelta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labell_type_iTimeDelta)
                    .addComponent(jb_iTimeDelta_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iFrame)
                    .addComponent(cb_iFrame_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iFrame)
                    .addComponent(jb_iFrame_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iChannelTime)
                    .addComponent(cb_iChannelTime_q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iChannelTime)
                    .addComponent(cb_iChannelTime_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_iChannelTime_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_iChannelTime_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_iChannelTime_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iMouse)
                    .addComponent(cb_iMouse_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iMouse)
                    .addComponent(cb_iMouse_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_iMouse_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_iMouse_q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_iMouse_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iChannel0)
                    .addComponent(cb_iChannel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iChannel0)
                    .addComponent(jb_iChannel0_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iChannel1)
                    .addComponent(cb_iChannel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iChannel1)
                    .addComponent(jb_iChannel1_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iChannel2)
                    .addComponent(jb_iChannel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iChannel2)
                    .addComponent(jb_iChannel2_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iChannel3)
                    .addComponent(cb_iChannel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iChannel3)
                    .addComponent(jb_iChannel3_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iDate)
                    .addComponent(cb_iDate_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iDate)
                    .addComponent(cb_iDate_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_iDate_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_iDate_q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_iDate_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iSampleRate)
                    .addComponent(cb_SampleRate_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iSampleRate)
                    .addComponent(jb_iSampleRate_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_iChannelResolution)
                    .addComponent(cb_iChannelResolution_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_type_iChannelResolution)
                    .addComponent(cb_iChannelResolution_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_iChannelResolution_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_iChannelResolution_reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_reset)
                    .addComponent(jb_apply))
                .addContainerGap())
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> cb_SampleRate_x;
    private javax.swing.JComboBox<String> cb_iChannel0;
    private javax.swing.JComboBox<String> cb_iChannel1;
    private javax.swing.JComboBox<String> cb_iChannel3;
    private javax.swing.JComboBox<String> cb_iChannelResolution_x;
    private javax.swing.JComboBox<String> cb_iChannelResolution_y;
    private javax.swing.JComboBox<String> cb_iChannelResolution_z;
    private javax.swing.JComboBox<String> cb_iChannelTime_q;
    private javax.swing.JComboBox<String> cb_iChannelTime_x;
    private javax.swing.JComboBox<String> cb_iChannelTime_y;
    private javax.swing.JComboBox<String> cb_iChannelTime_z;
    private javax.swing.JComboBox<String> cb_iDate_q;
    private javax.swing.JComboBox<String> cb_iDate_x;
    private javax.swing.JComboBox<String> cb_iDate_y;
    private javax.swing.JComboBox<String> cb_iDate_z;
    private javax.swing.JComboBox<String> cb_iFrame_x;
    private javax.swing.JComboBox<String> cb_iGlobalTime_x;
    private javax.swing.JComboBox<String> cb_iMouse_q;
    private javax.swing.JComboBox<String> cb_iMouse_x;
    private javax.swing.JComboBox<String> cb_iMouse_y;
    private javax.swing.JComboBox<String> cb_iMouse_z;
    private javax.swing.JComboBox<String> cb_iResolution_x;
    private javax.swing.JComboBox<String> cb_iResolution_y;
    private javax.swing.JComboBox<String> cb_iResolution_z;
    private javax.swing.JComboBox<String> cb_iTimeDelta;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JButton jb_apply;
    private javax.swing.JButton jb_iChannel0_reset;
    private javax.swing.JButton jb_iChannel1_reset;
    private javax.swing.JComboBox<String> jb_iChannel2;
    private javax.swing.JButton jb_iChannel2_reset;
    private javax.swing.JButton jb_iChannel3_reset;
    private javax.swing.JButton jb_iChannelResolution_reset;
    private javax.swing.JButton jb_iChannelTime_reset;
    private javax.swing.JButton jb_iDate_reset;
    private javax.swing.JButton jb_iFrame_reset;
    private javax.swing.JButton jb_iGlobalTime_reset;
    private javax.swing.JButton jb_iMouse_reset;
    private javax.swing.JButton jb_iResolution_reset;
    private javax.swing.JButton jb_iSampleRate_reset;
    private javax.swing.JButton jb_iTimeDelta_reset;
    private javax.swing.JButton jb_reset;
    private javax.swing.JLabel jl_input;
    private javax.swing.JLabel jl_source;
    private javax.swing.JLabel jl_type;
    private javax.swing.JLabel label_iChannel0;
    private javax.swing.JLabel label_iChannel1;
    private javax.swing.JLabel label_iChannel2;
    private javax.swing.JLabel label_iChannel3;
    private javax.swing.JLabel label_iChannelResolution;
    private javax.swing.JLabel label_iChannelTime;
    private javax.swing.JLabel label_iDate;
    private javax.swing.JLabel label_iFrame;
    private javax.swing.JLabel label_iGlobalTime;
    private javax.swing.JLabel label_iMouse;
    private javax.swing.JLabel label_iResolution;
    private javax.swing.JLabel label_iSampleRate;
    private javax.swing.JLabel label_iTimeDelta;
    private javax.swing.JLabel label_type_iChannel0;
    private javax.swing.JLabel label_type_iChannel1;
    private javax.swing.JLabel label_type_iChannel2;
    private javax.swing.JLabel label_type_iChannel3;
    private javax.swing.JLabel label_type_iChannelResolution;
    private javax.swing.JLabel label_type_iChannelTime;
    private javax.swing.JLabel label_type_iDate;
    private javax.swing.JLabel label_type_iFrame;
    private javax.swing.JLabel label_type_iGlobalTime;
    private javax.swing.JLabel label_type_iMouse;
    private javax.swing.JLabel label_type_iResolution;
    private javax.swing.JLabel label_type_iSampleRate;
    private javax.swing.JLabel labell_type_iTimeDelta;
    // End of variables declaration                   
	@Override
	public void onTabSelected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActiveShader(shadertoy shader) {
		// TODO Auto-generated method stub
		
	}
}
