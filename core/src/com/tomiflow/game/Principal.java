package com.tomiflow.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Principal extends ApplicationAdapter {
	private static final int velocidad = 100;
	private SpriteBatch batch;
	 private Texture img;
	 private Sprite miCoche;
	
	 
	 
	 private void ProcesarEntradaTeclado(){
		 //Comprobamos las teclas pulsadas
		 boolean right=Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D);
		 boolean left=Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A);
		 boolean up=Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W);
		 boolean down=Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S);
		 boolean girod=Gdx.input.isKeyPressed(Input.Keys.Q);
		 boolean giroi=Gdx.input.isKeyPressed(Input.Keys.E);
		 float x=miCoche.getX(),y=miCoche.getY();
		 float delta=Gdx.graphics.getDeltaTime();
		 miCoche.setOriginCenter();
		 if (up && !down) {
			 y=y+velocidad*delta;
		 }
		 if (down && !up) {
			 y=y-velocidad*delta;
		 }
		 if (right&& !left) {				//Aquí movemos el sprite en función del la tecla pulsada
			 x=x+velocidad*delta;
		 }
		 if (left && !right) {
			 x=x-velocidad*delta;
		 }
		 if (girod&&!giroi) {
			  //Situamos el centro en el centro del Sprite
			 miCoche.rotate(1); //Rotamos 1 grado el sprite
		 }
		 if (giroi&&!girod) {
		miCoche.rotate(-1);
		 }
		
		 
		 miCoche.setPosition(x, y);
		 
		 
		 
		 
		 
		 
		 
	 }
	 private void ProcesarEntradaRaton() {
		 float ratX=Gdx.graphics.getHeight()-Gdx.input.getX();
		 float ratY=Gdx.graphics.getHeight()-Gdx.input.getY();
		// float angle = MathUtils.radiansToDegrees * MathUtils.atan2(ratY,ratX);
		 //Intento de girar con el ratón
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
	@Override
	public void create () {
		 batch = new SpriteBatch();
		 img = new Texture("coche.png");
		 miCoche= new Sprite(img);
		 miCoche.setPosition(0,20);
		 miCoche.setSize(200,100);
		 
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(15, 8, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		miCoche.draw(batch);
		batch.end();
		ProcesarEntradaTeclado();
		ProcesarEntradaRaton();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
