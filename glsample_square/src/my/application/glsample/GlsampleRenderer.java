package my.application.glsample;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;

public class GlsampleRenderer extends GLSurfaceView implements Renderer {

	private Line lineVertical;
	private Line lineHorizontal;
	private Square square;
	private int mHeight;
	private int mWidth;
	private int mWidthOffset;
	private int mHeightOffset;
	
	private float mLeftX;
	private float mRightX;
	private float mBottomY;
	private float mTopY;
	
	private float transX, transY;
	
	private float angle, rotateX, rotateY, rotateZ;
	
	private Handler mHandler = new Handler();
	private UpdateTextInfo textInfo;
	private String msg1;
	
	public GlsampleRenderer(Context context) {
		super(context);
		lineVertical = new Line(0.0f, 1.5f, 0.0f, 0.0f, -1.5f, 0.0f);
		lineHorizontal = new Line(-1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f);
		
		square = new Square();
		mLeftX = -1.0f;
		mRightX = 1.0f;
		mBottomY = -1.5f;
		mTopY = 1.5f;
		
		transX = transY = 0.0f;
		
		textInfo = new UpdateTextInfo();
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		StringBuilder sb = new StringBuilder();
		sb.append(msg1);
		sb.append(String.format("\nglOrthof(%3.1f, %3.1f, %3.1f, %3.1f)", mLeftX, mRightX, mBottomY, mTopY));
		textInfo.setMessage(sb.toString());
		mHandler.post(textInfo);

		setViewport(gl);
		gl.glClear(
				GL10.GL_COLOR_BUFFER_BIT|
				GL10.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		
		lineHorizontal.draw(gl);
		lineVertical.draw(gl);
		
		gl.glTranslatef(transX, transY, 0.0f);
		gl.glRotatef(angle, rotateX, rotateY, rotateZ);
		square.draw(gl);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, final int width, final int height) {
		while (mWidth < width && mHeight < height) {
			mWidth += 2;
			mHeight += 3;
		}
		mWidthOffset = (width - mWidth)/2;
		mHeightOffset = (height - mHeight)/2;
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("画面サイズ[witdh:%d,height:%d]\n", width, height));
		sb.append(String.format("glViewProt(%d, %d, %d, %d)", mWidthOffset, mHeightOffset, mWidth, mHeight));
		msg1 = sb.toString();
		
		textInfo.setMessage(msg1);
		mHandler.post(textInfo);
	}
	private void setViewport(GL10 gl) {
		gl.glViewport(mWidthOffset, mHeightOffset, mWidth, mHeight);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrthof(mLeftX, mRightX, mBottomY, mTopY, 0.5f, -0.5f);

		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
	}

	public void setOrthofParam(float leftX, float rightX, float bottomY, float topY) {
		mLeftX = leftX;
		mRightX = rightX;
		mBottomY = bottomY;
		mTopY = topY;
	}
	
	public void setColorParam(float r, float g, float b, float alpha) {
		//lineHorizontal.setColor(r, g, b, alpha);
		//lineVertical.setColor(r, g, b, alpha);
		square.setColor(r, g, b, alpha);
	}
	
	public void setSquareParam(float height, float width) {
		square.setHeightWidth(height, width);
	}
	
	public void setTransParam(float x, float y) {
		transX = x;
		transY = y;
	}
	
	public void setRotateParam(float a, float x, float y, float z) {
		angle = a;
		rotateX = x;
		rotateY = y;
		rotateZ = z;
	}
	public float getLeftX() {
		return mLeftX;
	}

	public void setLeftX(float mLeftX) {
		this.mLeftX = mLeftX;
	}

	public float getRightX() {
		return mRightX;
	}

	public void setRightX(float mRightX) {
		this.mRightX = mRightX;
	}

	public float getBottomY() {
		return mBottomY;
	}

	public void setBottomY(float mBottomY) {
		this.mBottomY = mBottomY;
	}

	public float getTopY() {
		return mTopY;
	}

	public void setTopY(float mTopY) {
		this.mTopY = mTopY;
	}
}
