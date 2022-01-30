package com.mygdx.game.Board;



import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameFont implements ApplicationListener {
    SpriteBatch spriteBatch;
    BitmapFont bitmapFont;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        bitmapFont = new BitmapFont(Gdx.files.internal("words.fnt"),
                Gdx.files.internal("words1.png"), false);

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        bitmapFont.dispose();
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render() {
        //清屏
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
//		bitmapFont.draw(spriteBatch, "FPS" + Gdx.graphics.getFramesPerSecond(),
//                 5, 475);
        bitmapFont.draw(spriteBatch, "hello world！", 255, 255);
        spriteBatch.end();
    }

    @Override
    public void resize(int arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

}
