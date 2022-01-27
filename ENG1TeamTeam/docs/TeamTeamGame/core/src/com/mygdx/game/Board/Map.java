package com.mygdx.game.Board;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import java.util.HashMap;

public class Map{
        // 0 is empty tile
        // 1 is a land tile
        // 2 is friendly college
        // 3 is friendly ship
        // 4+ is an enemy entity
        // Map is initialised with no objects on it, the land on the map is the same everytime
    
    public int[][] mapGrid;
    TiledMap tiledMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;



    public int getAt(int x, int y){
        return mapGrid[y][x];
    }

    public void draw(){
        //Fill in
    }


    public Map(){
        tiledMap = new TmxMapLoader().load("Eng1Map.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        //Coordinates are stored in the format (y,x)
        int[][] data = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,1,1},
                            {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1},
                            {1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1},
                            {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1},
                            {1,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1},
                            {1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
        this.mapGrid = data;
    }

    public void render(OrthographicCamera camera){
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    public void dispose(){
        tiledMap.dispose();
    }

    public TileType getTileTypebyCoordinate(int layer, int col, int row){
        TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getCell(col,row);
        if (cell!=null){
            TiledMapTile tile = cell.getTile();
            if (tile!= null){
                int id = tile.getId();
                return TileType.getTileTypebyid(id);
            }
        }
        return null;
    }
    public int getWidth(){
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
    }
    public int getHeight(){
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
    }
    public int getLayers(){
        return tiledMap.getLayers().getCount();
    }

    public TileType getTileTypebyLoc(int layer, float x, float y) {
        return this.getTileTypebyCoordinate(layer,(int) (x / TileType.TileSize), (int) (y / TileType.TileSize));
    }
}

