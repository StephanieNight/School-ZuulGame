<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameframework;

/**
 *
 * @author Stephanie
 */
public class Start {
    public static void main(String[] args) {
        Game g = new Game();
        long time = System.currentTimeMillis();
        g.playTEST();
        time = System.currentTimeMillis()-time;
        System.out.println("Execution in ms: " +time);
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameframework;

/**
 *
 * @author Stephanie
 */
public class Start {
    public static void main(String[] args) {
        Game g = new Game();
        g.playTEST();
    }
}
>>>>>>> aa70eead8673139b2dbc53771c027b24985376c8
