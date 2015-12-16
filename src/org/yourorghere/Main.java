
package org.yourorghere;

import java.awt.BorderLayout;
import com.jogamp.opengl.GLCapabilities;
import javax.swing.JFrame;

public class Main {

    public Main(){
        GLCapabilities capabilities = null;
        double[][] m = new double[257][257];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                m[i][j] =0;
            }
        }
        m = new DiamondSquare().diamondSquare(m,100.0);
        
        Ocean o = new Ocean(m);
        m = o.makeOcean(30);
        
        Camera camera = new Camera(-50,50,200);
        GodAlgorythm canvas = new GodAlgorythm(capabilities, 800, 500, m, camera, o.getLevel());
        JFrame frame = new JFrame("YEAHHH!!!");
        frame.getContentPane().add(canvas, BorderLayout.CENTER);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        canvas.addKeyListener(new KeyHandler(camera));
        canvas.requestFocus();
    }
    
    /*
    private static GLCapabilities createGLCapabilities() {
        GLCapabilities capabilities = new GLCapabilities();
        capabilities.setRedBits(8);
        capabilities.setBlueBits(8);
        capabilities.setGreenBits(8);
        capabilities.setAlphaBits(8);
        return capabilities;
    }
    */
    
    public static void main(String[] args){
        new Main();
    }
}
