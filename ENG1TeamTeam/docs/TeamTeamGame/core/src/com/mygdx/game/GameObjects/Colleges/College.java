package com.mygdx.game.GameObjects.Colleges;
import com.mygdx.game.GameObjects.Entity;
public class College extends Entity{
    /**
     * Stores the attack range of the college
     */
    protected int range;
    /**
     * Stores the name of the college
     */
    protected String name;
    /**
     * Contructs a new college with the given parameters
     * @param id the Unique idendifier for the entity
     * @param name the name of the college
     * @param spriteName the file name of the entity's sprite
     * @param health the entity's hitpoints
     * @param position the coordinates of the entity
     * @param range the attack range of the college
     */
    public College(int id, String name,float width,float height, String spriteName, int health, int[] position, int range){
        super(id, width, height, spriteName, health, position);
        this.range = range;
        this.name = name;
    }
    /**
     * gets the name of the college
     * @return the name of the college
     */
    public String getName(){
        return this.spriteName;
    }
}