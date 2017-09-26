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
    private String characterName = "";
    private String description = "";
    private int healthPoints = 100;
    private int attackDamage = 0;
    private int attackHitModifier = 0;
    private int defenseEvation = 0;
    private int defenseArmor = 0;
    private int level =1;
    // private Item weapon;
    // private Item armor;
    // private Item shield;
    
    Character(String characterName, String description, int healthPoints, 
            int attackDamage, int attackHitModifier, int defenseArmor, 
            int defenseEvation, int level)
    {   
        this.characterName = characterName;
        this.description = description;
        this.healthPoints = healthPoints; 
        this.attackDamage = attackDamage;
        this.attackHitModifier = attackHitModifier;
        this.defenseArmor = defenseArmor;
        this.defenseEvation = defenseEvation;
        this.level = level;
    }
    
    
    
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
    /**
     * 
     * @param character
     * @return 
     */
    public int getAttackDamage(Character character)
    {
        return this.attackDamage;
    }
    public int getAttackHitModifier(Character character)
    {
        return this.attackHitModifier;
    }
    public int getDefenseEvation(Character character) 
    {
        return this.defenseEvation;
    }
    public int getDefenseArmor(Character character)
    {
        return this.defenseArmor;
    }
    
    public void setAttackDamage(int attackDamage)
    {
        this.attackDamage = attackDamage;
    }
    public void setAttackHitModifier(int attackHitModifier)
    {
        this.attackHitModifier = attackHitModifier;
    }
    public void setDefenseEvation(int defenseEvation)
    {
        this.defenseEvation = defenseEvation;
    }
    public void setDefenseArmor(int defenseArmor)
    {
        this.defenseArmor = defenseArmor;
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
