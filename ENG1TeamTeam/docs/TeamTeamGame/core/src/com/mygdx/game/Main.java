package com.mygdx.game;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Board.*;
import com.mygdx.game.GameObjects.Player;
import com.mygdx.game.GameObjects.Enemy;
import com.mygdx.game.GameObjects.Ships.EnemyShip;


public class Main extends ApplicationAdapter {

	OrthographicCamera camera;
	Map gameMap;
	int[] player;
	/**
	 * Stores SpriteBatch which will be used to display graphics and text
	 */
	SpriteBatch sb;
	Texture texture;
	Sprite highlightedSprite;
	Sprite playerSprite;
	Sprite capturedFlag;
	int counter = 0;
	/**
	 * Stores the text format for UI
	 */
	BitmapFont UIfont;
	/**
	 * Stores the text format for normal text
	 */
	BitmapFont font;
	Sprite[] EnemyShipSprites;
	float gameTime;
	int seconds;
	int[] playerVectorMovement={0,0};
	int[] playerPosMovement;
	Sprite[] vitoryPlayerSprite;
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
		int[] playerPosition = {896,64};
		this.playerOne = new Player(0, 100, 100, "VanbrughBoat.png", 100, playerPosition);//Player start data
		//							id, width, height, spriteName, health, position
		int[] playerPos = {playerOne.getX(),playerOne.getY()};
		playerPosMovement = playerPos;

		this.enemies = this.SetupEnemys();
		//this.gameMap = this.CreateMap();
		this.points = 0;
		playerSprite = new Sprite(new Texture(Gdx.files.internal(playerOne.getTexture())));
		capturedFlag = new Sprite(new Texture(Gdx.files.internal("CapturedFlag.png")));
		Sprite[] s = {capturedFlag,capturedFlag};
		vitoryPlayerSprite = s;
		UIfont = new BitmapFont(Gdx.files.internal("UI.fnt"));
		font = new BitmapFont(Gdx.files.internal("normal.fnt"));
		EnemyShipSprites = new Sprite[enemies.length];
		float gameTime = 0;
		int seconds= 0;
	}
	/**
	 * Set up the game
	 */
	@Override
	public void render () {
		gameTime = gameTime + Gdx.graphics.getDeltaTime();
		seconds = ((int)gameTime);
		ScreenUtils.clear(1, 0, 0, 1);
		Vector3 pos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(),0));
		int X =(int) (pos.x/ TileType.TileSize)*32;
		int Y =(int) (pos.y/TileType.TileSize)*32;
		int gameX =  (X/TileType.TileSize);
		int gameY =  (Y/TileType.TileSize);
		sb.setProjectionMatrix(camera.combined);
		camera.update();
		TileType type = gameMap.getTileTypebyLoc(1,X,Y);
		int[] playerPos = {playerOne.getX(),playerOne.getY()};
		int upperX = playerOne.getX()+ playerOne.getRange()*32;
		int lowerX = playerOne.getX()- playerOne.getRange()*32;
		int upperY = playerOne.getY()+ playerOne.getRange()*32;
		int lowerY = playerOne.getY()- playerOne.getRange()*32;
		if(Gdx.input.justTouched()){
			if (type != null && type.isClickable()){
				//System.out.println(gameX*TileType.TileSize/32*TileType.TileSize+"X,"+gameY*TileType.TileSize/32*TileType.TileSize+"Y");
				System.out.println(X+":"+Y);
				System.out.println(upperX+","+lowerX+">"+upperY+","+lowerY);
				if (X <= upperX && X >= lowerX) {
					if (Y <= upperY && Y >= lowerY) {
				//System.out.println(gameX+"X,"+gameY+"Y");
				//System.out.println(X+","+Y);
				int[] newPos = {X,Y};
				playerPosMovement = newPos;

				
				//System.out.println("NVPP:"+playerPos[0]+":"+playerPos[1]);
				//System.out.println("NVPPM:"+playerPosMovement[0]+":"+playerPosMovement[1]);
				//System.out.println(playerPosMovement[0]-playerPos[0]);
				
				int[] newVect = {playerVectorMovement[0]+(int) Math.ceil(((playerPosMovement[0]-playerPos[0]))),playerVectorMovement[1]+(int) Math.ceil(((playerPosMovement[1]-playerPos[1])))};
				//System.out.println("NV:"+newVect[0]+":"+newVect[1]);
				
				playerVectorMovement = newVect;
				//System.out.println("PP:"+playerPos[0]+":"+playerPos[1]);
				//System.out.println("PPM:"+playerPosMovement[0]+":"+playerPosMovement[1]);
				//System.out.println("PVM:"+playerVectorMovement[0]+":"+playerVectorMovement[1]);
				//playerOne.relocate(newPos);
					}};
					System.out.println(X+":"+Y);
					if((X==960 || X==992) && (Y==512 || Y==544) && (X-playerOne.getX())<=96 && (Y-playerOne.getY())<=96){
						this.enemies[0].college.damage(20);
						System.out.println("Damage");
						System.out.println(this.enemies[0].college.getHealth());
					}else if((X==32 || X==0) && (Y==32) && (playerOne.getX()-X)<=96 && (playerOne.getY()-Y)<=96){
						System.out.println("Damage2");
						this.enemies[1].college.damage(20);
					}
				
				//player move
			}else{
				System.out.println("Player cannot move there");
				//int[] newpos = playerPos;
				//playerPosMovement = newpos;
				//int[] newVect = {0,0};
				//playerVectorMovement = newVect;
			}
		}
		
		if(playerPosMovement!=playerPos){
			int[] step = {playerPos[0]+Math.round(playerVectorMovement[0]/28),playerPos[1]+Math.round(playerVectorMovement[1]/28)};
			//System.out.println("PP2:"+playerPos[0]+":"+playerPos[1]);
			//System.out.println("PPM2:"+playerPosMovement[0]+":"+playerPosMovement[1]);
			//System.out.println("PVM2:"+playerVectorMovement[0]+":"+playerVectorMovement[1]);
			playerOne.relocate(step);
			if(playerVectorMovement[0]!=0 || playerVectorMovement[1]!=0){
				points+=1;
			}
			int[] voidPos = {playerOne.getX(),playerOne.getY()};
			playerPos = voidPos;
			if((playerPos[0]<=playerPosMovement[0]) && playerVectorMovement[0]<=0){//|| (playerPos[0]>=playerPosMovement[0] && playerPos[1]<=playerPosMovement[1])){
				int[] newVect = {0,playerVectorMovement[1]};
				playerVectorMovement = newVect;
			}else if((playerPos[0]>=playerPosMovement[0]) && playerVectorMovement[0]>0){//|| (playerPos[0]>=playerPosMovement[0] && playerPos[1]<=playerPosMovement[1])){
				int[] newVect = {0,playerVectorMovement[1]};
				playerVectorMovement = newVect;
			}//&&
			if((playerPos[1]<=playerPosMovement[1]) && playerVectorMovement[1]<=0){
				int[] newVect = {playerVectorMovement[0],0};
				playerVectorMovement = newVect;
			}else if(playerPos[1]>=playerPosMovement[1] && playerVectorMovement[1]>=0){
				int[] newVect = {playerVectorMovement[0],0};
				playerVectorMovement = newVect;
			}
			
		}else{
			int[] newVect = {0,0};
			playerVectorMovement = newVect;
			//System.out.println("Q:"+playerVectorMovement[0]+":"+playerVectorMovement[1]+"\n"+playerPos[0]+":"+playerPos[1]);
		}
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameMap.render(camera);
		sb.begin();
		UIfont.draw(sb,"HP:"+playerOne.getHealth(),10,570);
		UIfont.draw(sb,"Points:",10,530);
		UIfont.draw(sb,"   "+this.points,10,510);
		UIfont.draw(sb,"Mission:",100,570);
		//Referencing Tasks?
		font.draw(sb,"Destroy the",100,550);
		font.draw(sb,"other two",100,530);
		font.draw(sb,"colleges!",100,510);
		playerSprite.draw(sb);
		playerSprite.setPosition(playerOne.getX(),playerOne.getY());
		//try{

			if(this.enemies[0].checkIfAlive()==false){
				vitoryPlayerSprite[0].draw(sb);
				vitoryPlayerSprite[0].setPosition(960, 512);
			}
			if(this.enemies[1].checkIfAlive()==false){
				vitoryPlayerSprite[1].draw(sb);
				vitoryPlayerSprite[1].setPosition(32, 32);
			}
		//}finally{
			//
		//}

		//Enemies move every 100 frames
		counter += 1;
		if(counter == 100){
			for(int i=0;i<this.enemies.length;i++){
				this.enemies[i].moveShips();
				counter =0;
			
			}
		}
		highlightedSprite.setPosition(X, Y);
		if (X <= upperX && X >= lowerX) {
			if (Y <= upperY && Y >= lowerY) {
				if(type!=null && type.isClickable()) {
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
		for(int index=0;index<this.enemies.length;index++) {
			this.enemies[index].draw(sb, EnemyShipSprites);
		};
		sb.end();
		if (seconds >= 1){
			//Runs every second
			//enemies.moveShips();

		}
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
			//int[] playerPosition = {1012,890};
	        //this.playerOne = new Player(0, 100, 100, "Player", 100, playerPosition);//Player start data
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
	/**
	 	* Set up the enemy on the map
	 	*/
	    private Enemy[] SetupEnemys(){
			int[] coord1 = {980,890};//To randomise in area
			int[] coord2 = {890, 800};//To randomise in area
	        Enemy[] data = {new Enemy(5,"Derwent",coord1,1,gameMap),new Enemy(30,"James",coord2,1,gameMap)};
	        // Setup the Enemys
	        return(data);
	    }

	    public void draw(){
	        float[] data;
	        
	        //data = 
	        //this.draw(data);

	        //for(int index=0;index<this.tasks.length;index++){
	        //    data = this.tasks[index].draw();
	        //    this.draw(data);
	        //};




	        //this.draw(data);

	    }

	
}

