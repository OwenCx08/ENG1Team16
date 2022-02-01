package com.mygdx.game.GameObjects; 
public class Entity{
    /**
     * Stores the Unique idendifier for each entity
     */
    protected int ID;
    protected float width;
    protected float height;
    /**
     * Stores the file name of the entity's sprite
     */
    protected String spriteName;
    /**
     * Stores the entity's hitpoints. If it reaches 0 is dies.
     */
    protected int health;
    /**
     * Stores the coordinates of the entity
     */
    protected int[] position;
    
    /**
     * Constructs a new entity with the given parameters
     * @param id the Unique idendifier for the entity
     * @param spriteName the file name of the entity's sprite
     * @param health the entity's hitpoints
     * @param position the coordinates of the entity
     */
    public Entity(int id, float width,float height, String spriteName, int health, int[] position){
        this.ID = id;
        this.width = width;
        this.height = height;
        this.spriteName = spriteName;
        this.health = health;
        this.position = position;
    }
/**
 * Gets the current health of the entity
 * @return The current health of the entity
 */
    public int getHealth(){
        return(this.health);
    }
/**
 * Attacks another entity at the specified position
 * @param position the position of the entity being attacked
 */
    public void attack(int[] position){
        //attach method
        //  -damage anything at position
        
    }


}