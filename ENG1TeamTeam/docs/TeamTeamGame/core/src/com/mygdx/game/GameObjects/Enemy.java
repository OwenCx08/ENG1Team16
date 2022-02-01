package com.mygdx.game.GameObjects;
import java.util.Random;
import com.mygdx.game.GameObjects.Ships.EnemyShip;
import com.mygdx.game.GameObjects.Colleges.EnemyCollege;
import com.mygdx.game.Board.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public class Enemy{
    /**
     * Stores the unique identifier for the enemy
     */
    private int enemyID;
    /**
     * Stores the starting location of an enemy's ships
     */
    protected int[] coord;
    /**
     * Stores the list of all the ships owned by this enemy
     */
    public EnemyShip[] ships;
    /**
     * Stores the college owned by this enemy
     */
    public EnemyCollege college;
    /**
     * Stores the current state of the map
     */
    public Map gameMap;

    Random randomGen = new Random();
    
    /**
     * Constructs a new enemy with the given parameters
     * @param enemyID the unique identifier for the enemy
     * @param collegeName the name of the college, used to find the sprites for the ships
     * @param coord the starting location of an enemy's ships
     * @param production the starting number of ships owned by the enemy
     * @param gameMap the current state of the map
     */
    public Enemy(int enemyID, String collegeName, int[] coord,int production, Map gameMap){
        this.gameMap = gameMap;
        this.enemyID = enemyID;
        this.college = new EnemyCollege(enemyID+1, collegeName ,1.0f,1.0f, collegeName, 100, coord, 3, enemyID);//
        this.ships = this.CreateShips(production);//number of ships
        //int[] coord = {50, 50};
        this.coord = coord;
        
        
    }
    /**
     * Creates and Initialises all the ships owned by an enemy
     * @param numberOfShips the number of ships owned by the enemy
     * @return The list of all the ships owned by this enemy
     */
    public EnemyShip[] CreateShips(int numberOfShips){
        EnemyShip[] returnData = new EnemyShip[numberOfShips];
        int[] boatPos = {randomGen.nextInt(4)*32+672,randomGen.nextInt(3)*32+384};
        for(int i=0;i<numberOfShips;i++){

            returnData[i] = new EnemyShip(enemyID+1, 1.0f,1.0f, (this.college.spriteName+"Boat.png"), 3, boatPos, 5, 3,this.enemyID,this.gameMap);
        }
        return(returnData);
    }
    /**
     * Moves all the ships owned by this enemy
     */
    public void moveShips(){
        for(int i=0; i<this.ships.length;i++){
            if(this.ships[i].checkForPlayer() == null){
                int[] data = {this.ships[i].getX()+(randomGen.nextInt(2)-1)*32,this.ships[i].getY()+(randomGen.nextInt(2)-1)*32};
                this.ships[i].relocate(data);
            } else{
                int[] playerPos = this.ships[i].checkForPlayer();
                this.ships[i].relocate(playerPos);
            }
        }

    }
    /**
     * Update the currently stored model of the map
     * @param globalMap the current map
     */
    public void updateMap(Map globalMap){
        this.gameMap = globalMap;
    }
    /**
     * Checks if this enemy is still alive by checking if it still has its college
     * @return Whether or not this enemy is alive
     */
    public Boolean checkIfAlive(){
        return(this.college.checkIfAlive());
    }
    /**
     * Draws all the ships onto the map
     * @param sb
     * @param shipsSprites The list of sprites used for the ships
     */
    public void draw(SpriteBatch sb,Sprite[] shipsSprites){
        for(int i=0;i<ships.length;i++){
            shipsSprites[i] = new Sprite(new Texture(Gdx.files.internal(ships[i].getSpriteName())));
            shipsSprites[i].setPosition(this.ships[i].getX(),this.ships[i].getY());
            shipsSprites[i].draw(sb);
        }
        
    }
}