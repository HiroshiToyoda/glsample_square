package my.application.glsample;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Line extends Shape {
	private float[] vertices = null;
	private float[] colors = null;
	private FloatBuffer polygonVertices;
	private FloatBuffer polygonColors;
	
	public Line(
			float x1, float y1, float z1,
			float x2, float y2, float z2) {
		vertices = new float[3 * 2];
		colors = new float[4 * 2];
		
		vertices[0] = x1; vertices[1] = y1; vertices[2] = z1;
		vertices[3] = x2; vertices[4] = y2; vertices[5] = z2;
		
		colors[0] = 1.0f; colors[1] = 1.0f; colors[2] = 1.0f; colors[3] = 1.0f;
		colors[4] = 1.0f; colors[5] = 1.0f; colors[6] = 1.0f; colors[7] = 1.0f;
		
		polygonVertices = makeFloatBuffer(vertices);
		polygonColors = makeFloatBuffer(colors);
	}
	
	public void draw(GL10 gl) {
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, polygonVertices);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, polygonColors);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		gl.glDrawArrays(GL10.GL_LINES, 0, 2);
	}
	
	public void setColor(float r, float g, float b, float alpha) {
		colors[0] = r; colors[1] = g; colors[2] = b; colors[3] = alpha;
		colors[4] = r; colors[5] = g; colors[6] = b; colors[7] = alpha;
		polygonColors = makeFloatBuffer(colors);
	}
	
	public float getColorR() {
		return colors[0];
	}
	public float getColorG() {
		return colors[1];
	}
	public float getColorB() {
		return colors[2];
	}
	public float getAlpha() {
		return colors[3];
	}
	public void setColorR(float v) {
		colors[0] = v;
		colors[4] = v;
	}
	public void setColorG(float v) {
		colors[1] = v;
		colors[5] = v;
	}
	public void setColorB(float v) {
		colors[2] = v;
		colors[6] = v;
	}
	public void setColorAlpha(float v) {
		colors[3] = v;
		colors[7] = v;
	}
}
