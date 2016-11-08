package view;

public class Programa extends javax.swing.JFrame {

    private PaneFuncoes funcoes = new PaneFuncoes();
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
        lbStatus = new javax.swing.JLabel();
        lbSinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EMSoft bot");
        setBackground(new java.awt.Color(255, 0, 0));
        setExtendedState(6);

        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/robocop.png"))); // NOI18N

        lbStatus.setText("...");

        lbSinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sat-on.png"))); // NOI18N

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbImagem)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbSinal)
                    .addComponent(lbStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(lbImagem))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbSinal;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

}
