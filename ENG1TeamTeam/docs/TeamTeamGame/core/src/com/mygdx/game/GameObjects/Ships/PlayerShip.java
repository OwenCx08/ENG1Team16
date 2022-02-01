package com.mygdx.game.GameObjects.Ships;

import com.mygdx.game.Board.Map;

public class PlayerShip extends Ship{
    /**
     * 
     * @param id the Unique idendifier for the entity
     * @param spriteName the file name of the entity's sprite
     * @param health the entity's hitpoints
     * @param position the coordinates of the entity
     * @param range the attack range of the ship
     * @param moveRange how far the ship can move in a single move
     * @param gameMap the current layout of the map
     */
    public PlayerShip(int id, float width,float height, String spriteName, int health, int[] position, int range, int moveRange,Map gameMap){
            super(id, width, height, spriteName, health, position,range,moveRange,gameMap);
    }

    public int[] mouseListener(){
        int[] data = {-1,-1};
        //Get mouse location
        //LIBGDX interface required
        return(data);
    }
}