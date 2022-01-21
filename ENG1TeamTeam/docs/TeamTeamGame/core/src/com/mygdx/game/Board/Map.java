package com.mygdx.game.Board;
public class Map{
    public void Map(){
        int[][] mapGrid
        // 0 is empty tile
        // 1 is a land tile
        // 2 is friendly college
        // 3 is friendly ship
        // 4+ is an enemy entity

    }
    //Coordinates are stored in the format (y,x)

    public int getAt(int x, int y){
        return mapGrid[y][x];
    }
}