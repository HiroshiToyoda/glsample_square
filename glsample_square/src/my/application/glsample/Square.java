package my.application.glsample;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Square extends Shape {
	private float vertices[] = {
			-1.0f,  1.0f, 0.0f,	// 0, Top Left
			-1.0f, -1.0f, 0.0f,	// 1, Bottom Left
			 1.0f, -1.0f, 0.0f,	// 2, Bottom Right
			 1.0f,  1.0f, 0.0f,	// 3, Top Right
	};
	private float colors[] = {
			1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 1.0f, 1.0f, 1.0f,
			1.0f, 1.0f, 1.0f, 1.0f,
	};
	
	private short indices[] = {0, 1, 2, 3, 0, 2, 3};
	
	private FloatBuffer vertexBuffer;
	private ShortBuffer indexBuffer;
	private FloatBuffer colorBuffer;
	
	public Square() {
		vertexBuffer = makeFloatBuffer(vertices);
		indexBuffer = makeShortBuffer(indices);
		colorBuffer = makeFloatBuffer(colors);
	}

	public void draw(GL10 gl) {
		gl.glFrontFace(GL10.GL_CCW);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_BACK);
		
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
		
		gl.glDrawElements(
				GL10.GL_TRIANGLES, indices.length, 
				GL10.GL_UNSIGNED_SHORT, indexBuffer);
		
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisable(GL10.GL_CULL_FACE);
	}
	
	public void setHeightWidth(float height, float width) {
		vertices[0] = (width/2.0f)*(-1.0f);		// 0, Left(x) 
		vertices[1] = (height/2.0f)*(1.0f);		// 0, Top(y)
		vertices[2] = 0.0f;						// 0, Z
		vertices[3] = (width/2.0f)*(-1.0f);		// 1, Left(x)
		vertices[4] = (height/2.0f)*(-1.0f);	// 1, Bottom(y)
		vertices[5] = 0.0f;						// 1, Z
		vertices[6] = (width/2.0f)*(1.0f);		// 2, Right(x)
		vertices[7] = (height/2.0f)*(-1.0f);	// 2, Bottom(y)
		vertices[8] = 0.0f;						// 2, Z
		vertices[9] = (width/2.0f)*(1.0f);		// 3, Right(x)
		vertices[10] = (height/2.0f)*(1.0f);	// 3, Top(y)
		vertices[11] = 0.0f;					// 3, Z
		vertexBuffer = makeFloatBuffer(vertices);
	}
	
	public void setColor(float r, float g, float b, float alpha) {
		for (int i = 0; i < 4; ++i) {
			colors[(i*4)] = r; colors[(i*4)+1] = g; colors[(i*4)+2] = b; colors[(i*4)+3] = alpha;
		}
		colorBuffer = makeFloatBuffer(colors);
	}
}
