package com.mygdx.game.GameObjects.Colleges;
public class EnemyCollege extends College{
    /**
     * Stores the ID of the enemy the college belongs to
     */
    protected int enemyID;
    /**
     * Constructs a new Enemy College with the given parameters
     * @param id the Unique idendifier for the entity
     * @param name the name of the college
     * @param spriteName the file name of the entity's sprite
     * @param health the entity's hitpoints
     * @param position the coordinates of the entity
     * @param range the attack range of the college
     * @param enemyID the ID of the enemy the college belongs to
     */
    public EnemyCollege(int id, String name,float width,float height, String spriteName, int health, int[] position, int range,int enemyID){
        super(id, name,width, height,spriteName,health,position,range);
        this.enemyID = enemyID;
    }
    /**
     * Searches around a radius of 2 around the college to see if the player is there
     * @return The position of the player if it is in range otherwise returns null
     */
    public int[] checkForPlayer(){
        int[] data = {-1,-1};
        //Get player pos
        //  - if in range return location/head to location
        return(data);
    }
 /**
 * Checks if the college is still alive by checking if its health has reached 0
 * @return whether or not the college is alive
 */
    public Boolean checkIfAlive(){
        return(health<=0);
    }
}