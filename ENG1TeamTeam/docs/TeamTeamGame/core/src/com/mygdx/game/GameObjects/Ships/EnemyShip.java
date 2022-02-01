package com.mygdx.game.GameObjects.Ships;
import com.mygdx.game.Board.Map;
public class EnemyShip extends Ship{
    /**
     * Stores whether or not the ship is alive
     */
    private Boolean alive;
    /**
     * Stores the ID of the enemy that the ship belongs to
     */
    protected int enemyID;
    /**
     * Stores the current layout of the map
     */
    private Map gameMap;
    /**
     * 
     * @param id the Unique idendifier for the entity
     * @param spriteName the file name of the entity's sprite
     * @param health the entity's hitpoints
     * @param position the coordinates of the entity
     * @param range the attack range of the ship
     * @param moveRange how far the ship can move in a single move
     * @param enemyID the ID of the enemy that the ship belongs to
     * @param gameMap the current layout of the map
     */
    public EnemyShip(int id, float width,float height, String spriteName, int health, int[] position, int range, int moveRange,int enemyID, Map gameMap){
        super(id, width, height, spriteName, health, position,range,moveRange,gameMap);
        this.enemyID = enemyID;
        this.alive=true;
        this.position = position;
    }
    /**
     * Searches around a radius of 2 around the ship to see if the player is there
     * @return The position of the player if it is in range otherwise returns null
     */
    public int[] checkForPlayer(){
        if(true){
            return null;
        }
        int[] data = {-1,-1};
        for(int i=-2;i<3;i++){
            for(int j=-2;j<3;i++){
                /*if(this.gameMap.getAt(this.position[0]+i,this.position[1]+j)==3){
                    data[0] = this.position[0]+i;
                    data[1] = this.position[1]+j;
                    return (data);
                }*/
            }
        }

        return(null);
    }
/**
 * Checks if the ship is still alive by checking if its health has reached 0
 * @return whether or not the ship is alive
 */
    public Boolean checkIfAlive(){
        if(this.health<=0){
            this.alive=false;
        }
        return(this.alive);
    }
    /**
     * gets the name of the Sprite used by the ship
     * @return the file name of the entity's sprite
     */
    public String getSpriteName(){
        return this.spriteName;
    }
    /**
     * gets the X coordinate of the ship's position
     * @return the X coordinate of the ship's positione
     */
    public int getX(){
        return this.position[0];
    }
        /**
     * gets the Y coordinate of the ship's position
     * @return the Y coordinate of the ship's positione
     */
    public int getY(){
        return this.position[1];
    }
}