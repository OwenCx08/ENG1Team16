package com.mygdx.game.GameObjects.Ships;

import com.mygdx.game.Board.Map;

public class FriendShip extends Ship{
    public FriendShip(int id, float width,float height, String spriteName, int health, int[] position, int range, int moveRange,Map gameMap){
        super(id, width, height, spriteName, health, position,range,moveRange,gameMap);
    }
}