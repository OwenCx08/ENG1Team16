package com.mygdx.game.Board;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.GameObjects.Player;
import com.mygdx.game.GameObjects.Ships.EnemyShip;

public class Tasks implements ApplicationListener {
	private SpriteBatch batch;
	private BitmapFont font;
	public int taskState=0;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	public void Tasks(){
		//First task--MOVE!
		while(taskState==0){
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			font.draw(batch, "Try to click somewhere to move", 200, 200);
			batch.end();
			int[] position = checkmove();

			int[] loc = {29,15};
			if(position!=loc){
				taskState = 1;
			}
		}


		//Second task--destory an EnemyShip
		while(taskState == 1){
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			font.draw(batch, "Time to destory some ships,try to click that enemy ship to attack it.", 200, 200);
			batch.end();
			//if enemyship hp == 0 then state2
			Boolean enemystate = EnemyShip.checkIfAlive();
			if(enemystate==false){
				taskState =2;

			}
		}

		//Third task--destory the first EnemyCollege
		while(taskState == 2){
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			font.draw(batch, "At North-east of the lake, there is a college with great wealth. Conquer that college can help you to upgrade your ship.", 200, 200);
			batch.end();
			//if ship VanbrughHp=0 then state3

		}
		//Last task--destoryanother college(a stranger one?)
		while(taskState == 3){
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			batch.begin();
			font.draw(batch, "Now, sail to the south-west and conquer the last college.", 200, 200);
			batch.end();
			//if ship DerwentHp=0 then state4
		}
		if(taskState == 4){
			//wining page
		}
	}

	private int[] checkmove() {
		//Gets player location?
		return null;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}
}
