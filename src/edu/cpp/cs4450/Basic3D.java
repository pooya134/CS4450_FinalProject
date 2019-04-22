package edu.cpp.cs4450;

/***************************************************************
* file: Basic3D.java
* author: Jong Yoon, Youngjun Woo, Brian Rivera
* class: CS 4450 Computer Graphics
*
* assignment: Final Project (Check Point 1)
* date last modified: 3/12/2019
*
* purpose: This program will display a cube (which is at least 2 in width)
* 			in 3D space with each face colored differently.
*
*
*
****************************************************************/

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;

public class Basic3D {

	private DisplayMode displayMode;

	public void start() {
		try {
			createWindow();
			initGL();
			FPCameraController fp = new FPCameraController(0f,0f,0f);
			fp.gameLoop();//render();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createWindow() throws Exception{
		Display.setFullscreen(false);
		DisplayMode d[] = Display.getAvailableDisplayModes();
		for (int i = 0; i < d.length; i++) {
			if (d[i].getWidth() == 640&& d[i].getHeight() == 480 && d[i].getBitsPerPixel() == 32) {
				displayMode = d[i];
				break;
			}
		}

		Display.setDisplayMode(displayMode);
		Display.setTitle("Final Project");
		Display.create();
		}

	private void initGL() {
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluPerspective(100.0f, (float)displayMode.getWidth()/(float)
		displayMode.getHeight(), 0.1f, 300.0f);
		glMatrixMode(GL_MODELVIEW);
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
		glEnableClientState(GL_VERTEX_ARRAY);
		glEnableClientState(GL_COLOR_ARRAY);
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		glEnableClientState (GL_TEXTURE_COORD_ARRAY);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Basic3D basic = new Basic3D();
		basic.start();
	}

}
