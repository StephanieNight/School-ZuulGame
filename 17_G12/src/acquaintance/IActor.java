
package acquaintance;

/**
 *
 * @author nicol
 */
public interface IActor {
    
   
    public void setLevel(int level);
    
    public void setXp(int xp);
    
    public void setTotalXp(int totalXp);
    
    public void setCurrentRoom(Room currentRoom);
    
    public void setCurrentHealth(int currentHealth);
    
    public int getDefaultHealthPoint();
    
    public int getModufiedHealthPoint();
    
    public int getDefaultDefense();
    
    public int getModifiedDefense(); 
    
    public String getName();
    
    public int getDefaultDamgeOutput();
    
    public int getModifiedDamgeOutput();
    
    public int getLevel();
    
    public int getXp();
    
    public int getTotalXp();
    
    public char getMapCode();
    
    public IRoom getCurrentRoom();
    
    public int getCurrentHealth();
    
    public void updateLevel();
    
    public IInventory getInventory();
    
    public void setWeapon(int weapon);
    
    public void setArmor(int armor);
    
    public void setShield(int shield);

     
}
