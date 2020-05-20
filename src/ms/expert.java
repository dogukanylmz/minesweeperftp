
package ms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;


public class expert extends javax.swing.JFrame {
    int wid=25, hei=25;
    int bombs=50;
    
    JToggleButton[][]blok =new JToggleButton[hei][wid];
    int[][] blox=new int[hei][wid];
    boolean ilk , oynar;
    private void ac(int y , int x){
        if(y<0 || x<0 || x > wid-1 || y > hei-1 || blox[y][x] != 0)return ;
        int bombs =0;
        for(int i =y-1;i<=y+1;i++){
            for(int j = x-1;j<=x+1;j++){
                if(!(j < 0 || i < 0 || j > wid-1 || i > hei-1)&& blox[i][j] == -1)
                    bombs++;
                
            }
        }
        
        if(bombs == 0){  
            blox[y][x]= -2;
            for(int i =y-1;i<=y+1;i++){                
            for(int j = x-1;j<=x+1;j++){
                 if(!(j < 0 || i < 0 || j > wid-1 || i > hei-1))
                if(i != y ||  j != x ) ac(i,j);
               }
            }
        }else blox[y][x]= bombs;
    }
    private void ref(){
        for(int i =0;i<hei;i++){
            for(int j= 0;j<wid;j++){
                if(blox[i][j]== 0){
                     blok[i][j].setText("");
                    blok[i][j].setSelected(false);
                }
                if(blox[i][j]== -2){
                    blok[i][j].setText("");
                    blok[i][j].setSelected(true);
                }
                if(blox[i][j]> 0){
                    blok[i][j].setText(""+blox[i][j]);
                    blok[i][j].setSelected(true);
                }
                if(blox[i][j] == -1 && !oynar){
                    blok[i][j].setSelected(true);
                }
            }
        }
    }
     private void spawn(int y , int x){
        for(int k =1;k<=bombs;k++){
           int i , j;
            do{
             i =(int)(Math.random()*(wid-.01));
             j =(int)(Math.random()*(hei-.01));
            }
            while(blox[i][j] == -1 || (i ==y && j == x));
            blox[i][j]=-1;
            
        }
    }
      ActionListener action =new ActionListener(){
    public void actionPerformed(ActionEvent e){
        int i = 0 , j =0;
        boolean found=false;
        for (i = 0;i<hei;i++){
            for(j =0;j<wid;j++){
                if(e.getSource()==blok[i][j]){
                found=true;
                break;
                }           
            }
             if(found) break;             
        }
        if(oynar){
        blok[i][j].setSelected(true);
        if(!ilk){
            spawn(i,j);
            ilk=true;
        }
        
        if(blox[i][j]!= -1){
        ac(i,j);
        ref();
        }else lose();
        win();
    }else ref();
    };
    private void win(){
        boolean win=true;
        for(int i =0;i<hei;i++){                    
            for(int j =0;j<wid;j++){
                if(blox[i][j] == 0){
                    win=false;
                    break;
                }                    
            }
            if(!win)break;
        }
        if(win){
            javax.swing.JOptionPane.showMessageDialog(null, "Kazandınız!!");
            oynar=false;
        }
    }
    private void lose(){
        oynar=false;
        for(int i =0;i<hei;i++){
            for(int j =0;j<wid;j++){
                if(blox[i][j] == -1){
                    blok[i][j].setText("BANG");
                    blok[i][j].setSelected(true);
                }
            }
        }
    }
    };
      

   
    public expert() {
        initComponents();
            for(int i =0;i<hei;i++){
            for(int j =0;j<wid;j++){
                
                blok[i][j]=new JToggleButton();
                blok[i][j].setSize(jPanel1.getWidth()/wid,jPanel1.getHeight()/hei);
                jPanel1.add(blok[i][j]);
                blok[i][j].setLocation(j*jPanel1.getWidth()/wid,i*jPanel1.getHeight()/hei);
                blok[i][j].addActionListener(action);
            }
        }
            ilk =false;
            oynar=true;
    }
        private void resiz(){
          for(int i =0;i<hei;i++){
            for(int j =0;j<wid;j++){
                blok[i][j].setSize(jPanel1.getWidth()/wid,jPanel1.getHeight()/hei);
                jPanel1.add(blok[i][j]);
                 blok[i][j].setLocation(j*jPanel1.getWidth()/wid,i*jPanel1.getHeight()/hei);
            }
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMenu1.setText("Options");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem1.setText("New game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Noob");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Pro");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
          resiz();
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
            blox=new int[hei][wid];
            ref();
            oynar=true;
            ilk=false;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        pro p =new pro();
        p.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        p.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        tarla T=new tarla();
        T.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        T.show();
        this.hide();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(expert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(expert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(expert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(expert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new expert().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
