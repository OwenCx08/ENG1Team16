package com.mygdx.game;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Board.*;
import com.mygdx.game.GameObjects.Player;
import com.mygdx.game.GameObjects.Enemy;


public class Main extends ApplicationAdapter {
	OrthographicCamera camera;
	Map gameMap;
	int[] player;
	SpriteBatch sb;
	Texture texture;
	Sprite highlightedSprite;
	Sprite playerSprite;
	int counter = 0;
	BitmapFont font;
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,1024,576);
		camera.update();
		gameMap = new Map();
		sb = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("highlighted.png"));
		highlightedSprite = new Sprite(texture);
		this.SetupGraphics();
		int[] playerPosition = {896,128};
		this.playerOne = new Player(0, 100, 100, "VanbrughBoat.png", 100, playerPosition);//Player start data
		//							id, width, height, spriteName, health, position
		this.enemies = this.SetupEnemys();
		//this.gameMap = this.CreateMap();
		this.points = 0;
		playerSprite = new Sprite(new Texture(Gdx.files.internal(playerOne.getTexture())));
		System.out.println(playerOne.getX() +""+ playerOne.getY());
		font = new BitmapFont();
		font.setColor(Color.BLACK);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		Vector3 pos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(),0));
		int X =(int) (pos.x/ TileType.TileSize)*32;
		int Y =(int) (pos.y/TileType.TileSize)*32;
		int gameX =  (X/TileType.TileSize);
		int gameY =  (Y/TileType.TileSize);
		sb.setProjectionMatrix(camera.combined);
		camera.update();
		TileType type = gameMap.getTileTypebyLoc(1,X,Y);
		if(Gdx.input.justTouched()){
			if (type != null && type.isClickable()){
				System.out.println(gameX+"X,"+gameY+"Y");
				System.out.println(X+","+Y);
				int[] newPos = {X,Y};
				playerOne.relocate(newPos);

				//player move
			}else{
				System.out.println("Player cannot move there");
			}
		}
		int upperX = playerOne.getX()+ playerOne.getRange()*32;
		int lowerX = playerOne.getX()- playerOne.getRange()*32;
		int upperY = playerOne.getY()+ playerOne.getRange()*32;
		int lowerY = playerOne.getY()- playerOne.getRange()*32;



		gameMap.render(camera);
		sb.begin();
		font.draw(sb,"HP:100",10,570);
		font.draw(sb,"Destroy those two colleges!",10,550);
		playerSprite.draw(sb);
		playerSprite.setPosition(playerOne.getX(),playerOne.getY());
		counter += 1;
		if(counter == 100){
			for(int i=0;i<this.enemies.length;i++){
				//this.enemies[i].moveShips();
			
			}
		}
		highlightedSprite.setPosition(X, Y);
		if (X <= upperX && X >= lowerX) {
			if (Y <= upperY && Y >= lowerY) {
				if(type.isClickable()) {
					highlightedSprite.setColor(255, 255, 255, 255);
				}else {
					highlightedSprite.setColor(255,0,0,255);
				}
			}else {
				highlightedSprite.setColor(255,0,0,255);
			}
		}else {
			highlightedSprite.setColor(255,0,0,255);
		}
		highlightedSprite.draw(sb);
		for(int index=0;index<this.enemies.length;index++){

			this.enemies[index].draw(sb);

		};
		sb.end();
		}




	//protected Tasks[] tasks;
	protected Player playerOne;
	protected Enemy[] enemies;
	protected Map Map;
	protected int points;
	protected int[] screenDimentions = {-1,-1};
	    public Main(){
			this.enemies = this.SetupEnemys();
	        this.SetupGraphics();
			int[] playerPosition = {1012,890};
	        this.playerOne = new Player(0, 100, 100, "Player", 100, playerPosition);//Player start data
	        //							id, width, height, spriteName, health, position
			
	        //this.gameMap = this.CreateMap();
	        this.points = 0;
			this.screenDimentions[0] = 1024;//?
			this.screenDimentions[1] = 900;//?

			//this.playerOne.SetupMouse(this.screenDimentions,this.gameMap);
	    }

	    private void SetupGraphics(){
	        //Set up LIBGDX
	    }
	/*
	    private Tasks[] SetupTasks(){
	        Tasks[] data = {new Tasks()};
	        // Setup the Tasks
	        return(data);
	    }
	*/

	    private Enemy[] SetupEnemys(){
			int[] coord1 = {980,890};//To randomise in area
			int[] coord2 = {890, 980};//To randomise in area
	        Enemy[] data = {new Enemy(5,"Derwent",coord1,1,gameMap),new Enemy(30,"James",coord2,1,gameMap)};
	        // Setup the Enemys
	        return(data);
	    }

	    public void draw(){
	        float[] data;
	        
	        //data = 
			this.gameMap.draw();
	        //this.draw(data);

	        //for(int index=0;index<this.tasks.length;index++){
	        //    data = this.tasks[index].draw();
	        //    this.draw(data);
	        //};




	        //this.draw(data);

	    }

	
}
