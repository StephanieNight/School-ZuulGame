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
public class CharacterBasic 
{
    private String characterName = "";
    private String description = "";
    private int healthPoints = 100;
    private int attackBaseDamage = 10;
    private int attackBaseHitModifier = 0;
    private int defenseBaseEvation = 5;
    private int defenseArmor = 0;
    private int level =1;
    private int expWorth = 1;
    private int totalExp = 0;

     
    // the next is work in progress
    // private Item weapon;
    // private Item armor;
    // private Item shield;
    
    
    /**
     * constructor for player character
     * @param characterName 
     */
    CharacterBasic(String characterName)
    {
        this.characterName = characterName;
    }
    
    /**
     * constructor for monsters
     * @param characterName
     * @param description
     * @param healthPoints
     * @param attackBaseDamage
     * @param attackBaseHitModifier
     * @param defenseArmor
     * @param defenseBaseEvation
     * @param level
     * @param expWorth 
     */
    CharacterBasic(String characterName, String description, int healthPoints, 
            int attackBaseDamage, int attackBaseHitModifier, int defenseArmor, 
            int defenseBaseEvation, int level, int expWorth)
    {   
        this.characterName = characterName;
        this.description = description;
        this.healthPoints = healthPoints; 
        this.attackBaseDamage = attackBaseDamage;
        this.attackBaseHitModifier = attackBaseHitModifier;
        this.defenseArmor = defenseArmor;
        this.defenseBaseEvation = defenseBaseEvation;
        this.level = level;
        this.expWorth = expWorth;
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
     * @param
     * @return Character.characterName
     */
    public String getCharacterName()
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
    public String getDiscription ()
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
     * @return 
     */
    public int getHealthPoints ()
    {
        return this.healthPoints;
    }
    
    /**
     * gets actual attack damage
     * @return
     */
    public int getAttackDamage()
    {
        return this.attackBaseDamage * this.level; // + this.weapon.damage
    }
    
    /**
     * getter for attackHitModifier
     * @return 
     */
    public int getAttackHitModifier()
    {
        return this.attackBaseHitModifier * this.level; 
    }
    
    /**
     * getter for defenseEvation
     * @return 
     */
    public int getDefenseEvation() 
    {
        return this.defenseBaseEvation * this.level;
    }
    
    /**
     * getter for defenseArmor
     * @return 
     */
    public int getDefenseArmor()
    {
        return this.defenseArmor;
    }
    
    /**
     * setter for attackBaseDamage
     * @param attackBaseDamage 
     */
    public void setAttackDamage(int attackBaseDamage)
    {
        this.attackBaseDamage = attackBaseDamage;
    }
    
    /**
     * setter for attackHitModifier
     * @param attackBaseHitModifier 
     */
    public void setAttackHitModifier(int attackBaseHitModifier)
    {
        this.attackBaseHitModifier = attackBaseHitModifier;
    }
    
    /**
     * setter for defenseEvation
     * @param defenseBaseEvation 
     */
    public void setDefenseEvation(int defenseBaseEvation)
    {
        this.defenseBaseEvation = defenseBaseEvation;
    }
    
    /**
     * setter for defenseArmor
     * @param defenseArmor 
     */
    public void setDefenseArmor(int defenseArmor)
    {
        this.defenseArmor = defenseArmor;
    }
    
    public int getExpWorth()
    {
        return this.expWorth;
    }
    public void setTotalExp(int expWorth)
    {
        this.totalExp = this.totalExp + expWorth;
    }
    
    public void updateLevel()
    {
        this.level = 1 + (totalExp / 3);
    }
    
    public void setExpWorth(int expWorth)
    {
        this.expWorth = expWorth;
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
