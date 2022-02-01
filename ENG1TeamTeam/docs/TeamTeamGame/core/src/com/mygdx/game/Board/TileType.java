package com.mygdx.game.Board;

import java.util.HashMap;

public enum TileType {
    /**
    *This sets up the different types of tiles that are going to be used by the map
     */

    darkWater(1,true,"DarkWater"),
    darkBeach(2,false,"darkBeach"),
    darkRocks(3,false,"darkRocks"),
    darkCorner(4,false,"darkCorner"),
    water(5,true,"water"),
    beach(6,false,"beach"),
    rocks(7,false,"rocks"),
    grass(8,false,"grass"),
    corner(9,false,"corner"),
    darkInvertedCorner(10,false,"darkInvertedCorner"),
    invertedCorner(11,false,"invertedCorner"),
    DerwentTL(12,true,"DerwentTL"),
    DerwentTR(13,true,"DerwentTR"),
    VanbrughTL(14,true,"VanbrughTL"),
    VanbrughTR(15,true,"VanbrughTR"),
    JamesTL(16,true,"JamesTL"),
    JamesTR(17,true,"JamesTR"),
    JamesBL(18,true,"JamesBL"),
    JamesBR(19,true,"JamesBR"),
    VanbrughBR(20,true,"VanbrughBR"),
    DerwentBL(21,true,"DerwentBL"),
    DerwentBR(22,true,"DerwentBR"),
    VanbrughBL(23,true,"VanbrughBL"),
    Highlighted(24,false,"highlighted");


    private int id;
    private  boolean clickable;
    private String name;
    public static final int TileSize = 32;

    /***
     * Constructor for the tile types
     * @param id uid for the type of tile
     * @param clickable Bool of whether the type can be clicked
     * @param name Name of the tile
     *
     */

    private  TileType(int id, boolean clickable, String name){
        this.id = id;
        this.clickable = clickable;
        this.name = name;
    }

    /***
     * getter for tile id
     * @return id
     */
    public int getId() {
        return id;
    }

    /***
     * getter for tile clickablitiy
     * @return clickable
     */
    public boolean isClickable(){
        return clickable;
    }

    /***
     * getter for tile name
     * @return name
     */
    public String getName() {
        return name;
    }

    /***
     * Hash map of all the tile types
     */
    private static HashMap<Integer,TileType> tileMap;

    /**
     * Puts all tile types into above hashmap
     */
    static {
        tileMap = new HashMap<Integer,TileType>();
        System.out.println(tileMap);
        for(TileType TileType: TileType.values()){
            tileMap.put(TileType.getId(),TileType);
        }
    }

    /**
     * Get the tile type given an id
     * @param id id of tile given
     * @return All information about a tile with that id
     */
    public static TileType getTileTypebyid(int id){
        return tileMap.get(id);
    }
}
