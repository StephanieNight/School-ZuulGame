/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

/**
 *
 * @author Malte
 */
class MiniMap extends Item{

    @Override
    public String getDescription() {
        return "A datailed map of the labyrinth!";
    }

    @Override
    public String getName() {
        return "Map";
    }

    
    /**
     * Updates the whole map as if you've been everywhere.
     */
    @Override
    public void useItem() {
        //prints the whole map including monsters and unvisited rooms
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getStat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
