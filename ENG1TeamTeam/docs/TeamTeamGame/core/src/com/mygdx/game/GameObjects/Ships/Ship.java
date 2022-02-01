package com.mygdx.game.GameObjects.Ships;
import com.mygdx.game.GameObjects.Entity;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.mygdx.game.Board.Map;
import com.mygdx.game.Board.TileType;
public class Ship extends Entity{
    protected Map gameMap;
    /**
     * Stores the attack range of the ship
     */
    protected int range;
    /**
     * Stores how far the ship can move in a single move
     */
    protected int moveRange;

    /**
     * Contructs a new ship with the given parameters
     * @param id the Unique idendifier for the entity
     * @param spriteName the file name of the entity's sprite
     * @param health the entity's hitpoints
     * @param position the coordinates of the entity
     * @param range the attack range of the ship
     * @param moveRange how far the ship can move in a single move
     */
    public Ship(int id, float width,float height, String spriteName, int health, int[] position, int range, int moveRange,Map gameMap){
        super(id, width, height, spriteName, health, position);
        this.range = range;
        this.moveRange = moveRange;
        this.gameMap = gameMap;
    }
/**
 * moves the ship x,y "steps"
 * @param x the change in x position
 * @param y the change in y position
 * @return the new position of the ship
 */
    public int[]  move(int x,int y){
        this.position[0]+=x;
        this.position[1]+=y;
        return(this.position);
    }


/**
 * Sets location of the ship to x,y
 * @param position The new position of the ship
 */
    public void relocate(int[] position){//Sets location to x,y
        float[] floatPos = new float[2];
        floatPos[0] = position[0];
        floatPos[1] = position[1];
        TileType type = this.gameMap.getTileTypebyLoc(1,floatPos[0],floatPos[1]);
        if(type != null && type.isClickable()){
            this.position = position;
        }
        
    }
/**
 * Gets the movement range of the ship
 * @return how far the ship can move in a single move
 */
    public int getRange(){
        return this.moveRange;
    }
}