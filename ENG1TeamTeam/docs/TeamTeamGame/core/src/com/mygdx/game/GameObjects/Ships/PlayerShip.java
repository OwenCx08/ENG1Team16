package com.mygdx.game.GameObjects.Ships;

import com.mygdx.game.Board.Map;

public class PlayerShip extends Ship{
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