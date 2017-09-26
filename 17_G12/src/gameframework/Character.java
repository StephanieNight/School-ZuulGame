/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameframework;

/**
 *Sketch for character and monster objects
 * @author Malte
 */
public class Character 
{
    Character(String name, String description, int health)
    {   
        this.characterName = name;
        this.description = description;
        this.healthPoints = health;                
    }
    
    private String characterName;
    private String description;
    private int healthPoints;
    //private imageFile image;
    /**
     * Setter for characterName
     * @param characterName 
     */
    public void setCharacterName (String characterName)
    {
        this.characterName = characterName;
    }
    
    /**
     * getter for characterName
     * @param character
     * @return Character.characterName
     */
    public String getCharacterName(Character character)
    {
        return this.characterName;
    }
    
    /**
     * setter for description
     * @param discription 
     */
    public void setDiscription (String discription)
    {
        this.description = discription;
    }
    
    /**
     * getter for description
     * @param character
     * @return 
     */
    public String getDiscription (Character character)
    {
        return this.description;
    }
    
    /**
     * setter for healthPoints
     * @param healthPoints 
     */
    public void setHealthPoints (int healthPoints)
    {
        this.healthPoints = healthPoints;
    }
    
    /**
     * getter for healthPoints
     * @param character
     * @return 
     */
    public int getHealthPoints (Character character)
    {
        return this.healthPoints;
    }
    
    /*
    soudo kode fordi jeg ikke helt ved hvordan det skal gøres
    
    public void setImageFile (flie path)
    {
    imageFile = file path;
    }
    
    public ?? getImageFile (Character character)
    {
    return this.imageFile;
    }
    */
    


    
}
