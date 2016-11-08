package view;

public class Programa extends javax.swing.JFrame {

    private final PaneFuncoes funcoes = new PaneFuncoes();
    private boolean configAtiva = false;

    public Programa() {
        initComponents();
    }

    public void setStatus(String msg) {
        lbStatus.setText(msg);
    }

    public void setMensagem(String mensagem) {
        // TxtBox.append(mensagem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        lbImagem = new javax.swing.JLabel();
        btConfig = new javax.swing.JButton();
        lbStatus = new javax.swing.JLabel();
        lbSinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EMSoft bot");
        setBackground(new java.awt.Color(255, 0, 0));
        setState(1);
        getContentPane().setLayout(new java.awt.FlowLayout());

        lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/robocop.png"))); // NOI18N

        btConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settings.png"))); // NOI18N
        btConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfigActionPerformed(evt);
            }
        });

        lbStatus.setText("...");

        lbSinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sat-on.png"))); // NOI18N

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbImagem)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lbSinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(btConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbSinal)
                            .addComponent(lbStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(lbImagem)))
                .addContainerGap())
        );

        getContentPane().add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfigActionPerformed

        /**
         * Bacalhau para dar auto-hide/show em Panel de Funcoes
         */
        if (!configAtiva) {
            //btConfig.setText("<--");
            this.add(funcoes);
            funcoes.setVisible(true);
            this.setSize(750, 350);
            this.repaint();
            configAtiva = true;
        } else {
            //btConfig.setText("-->");
            funcoes.setVisible(false);   
            this.setSize(300, 350);
            this.repaint();
            configAtiva = false;
        }
    }//GEN-LAST:event_btConfigActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfig;
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbSinal;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}
