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
	Sprite sprite;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,1024,576);
		camera.update();
		gameMap = new Map();
		sb = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("highlighted.png"));
		sprite = new Sprite(texture);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		ScreenUtils.clear(1, 0, 0, 1);

		camera.update();
		Vector3 pos = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(),0));
		int x =(int) (pos.x/TileType.TileSize)*32;
		int y =(int) (pos.y/TileType.TileSize)*32;
		sb.setProjectionMatrix(camera.combined);
		TileType type = gameMap.getTileTypebyLoc(1,pos.x,pos.y);
		if(Gdx.input.justTouched()){

			if (type != null && type.isClickable()){
				System.out.println("Player has moved to "+(int) (pos.x/TileType.TileSize)+"X"+(int) (pos.y/TileType.TileSize)+"Y"+type.getName());
				//player move
			}else{
				System.out.println("Player cannot move there");
			}
		}
		gameMap.render(camera);
		sb.begin();
		sprite.draw(sb);
		sprite.setPosition(x, y);
		sb.end();
	}


	//protected Tasks[] tasks;
	protected Player playerOne;
	protected Enemy[] enemies;
	protected Map Map;
	protected int points;
	protected int[] screenDimentions = {-1,-1};
	    public Main(){
	        this.SetupGraphics();
			int[] playerPosition = {1012,890};
	        this.playerOne = new Player(0, 100, 100, "Player", 100, playerPosition);//Player start data
	        //							id, width, height, spriteName, health, position
			this.enemies = this.SetupEnemys();
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
			int[] coord1 = {800, 0};//To randomise in area
			int[] coord2 = {0, 800};//To randomise in area
	        Enemy[] data = {new Enemy(5,"Derwent",coord1,10,gameMap),new Enemy(30,"James",coord2,25,gameMap)};
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

	        for(int index=0;index<this.enemies.length;index++){
	            //data = 
				this.enemies[index].draw();
	            //this.draw(data);
	        };

	        data = this.playerOne.draw();
	        //this.draw(data);

	    }

	
}
