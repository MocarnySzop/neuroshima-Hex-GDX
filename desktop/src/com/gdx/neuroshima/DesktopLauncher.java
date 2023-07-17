package com.gdx.neuroshima;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.gdx.neuroshima.client.NeuroshimaGame;
import com.gdx.neuroshima.client.ScreenParams;
import com.gdx.neuroshima.practice.MyGame;
import com.gdx.neuroshima.practice.MyGame2;
import com.gdx.neuroshima.practice.MyGame3;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Neuroshima");
		config.setWindowedMode(ScreenParams.WIDTH, ScreenParams.HEIGHT);
//		config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
		new Lwjgl3Application(new NeuroshimaGame(), config);
//		new Lwjgl3Application(new MyGame3(), config);
	}
}
