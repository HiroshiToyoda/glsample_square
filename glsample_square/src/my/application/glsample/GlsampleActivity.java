package my.application.glsample;

import my.application.glsample.Global;
import my.application.glsample.GlsampleRenderer;
import my.application.glsample.R;
import my.application.glsample.TouchSurfaceView;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

public class GlsampleActivity extends Activity {
	private GlsampleRenderer renderer;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        Global.mActivity = this;
        
        TouchSurfaceView surfaceView = new TouchSurfaceView(this);
        renderer = new GlsampleRenderer(this);
        //renderer.setColorParam(1.0f, 1.0f, 1.0f, 1.0f);
        surfaceView.setRenderer(renderer);
        setContentView(surfaceView);
        
        LinearLayout buttons = 
        		(LinearLayout)View.inflate(this, R.layout.viewmain, null);
        buttons.setGravity(Gravity.TOP|Gravity.LEFT);
        addContentView(
        		buttons,
        		new LayoutParams(
        				LayoutParams.FILL_PARENT,
        				LayoutParams.FILL_PARENT));
        // イベントハンドラの設定
        setOrthofTextWatcher();
        setColorTextWatcher();
        setSquareTextWatcher();
        setTransTextWatcher();
        setRotateTextWatcher();
        setButtonClickHandler();
        
        setOrthofParam("-1.0", "1.0", "-1.5", "1.5");
        updateOrthofParam();
        setColorParam("1.0", "1.0", "1.0", "1.0");
        updateColorParam();
        setSquareParam("1.0", "1.0");
        updateSquarefParam();
        setTransParam("0.0", "0.0");
        updateTransParam();
        setRotateParam("0.0", "0.0", "0.0", "0.0");
        updateRotateParam();
    }
    private void setButtonClickHandler() {
    	Button b;
    	View.OnClickListener h = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
		    	ViewFlipper f = (ViewFlipper)findViewById(R.id.viewFlipper);
		    	switch (v.getId()) {
		    	case R.id.button1:
		    		f.setDisplayedChild(0);
		    		break;
		    	case R.id.button2:
		    		f.setDisplayedChild(1);
		    		break;
		    	case R.id.button3:
		    		f.setDisplayedChild(2);
		    		break;
		    	case R.id.button4:
		    		f.setDisplayedChild(3);
		    		break;
		    	case R.id.button5:
		    		f.setDisplayedChild(4);
		    		break;
		    	}
			}
		};
    	b = (Button)findViewById(R.id.button1);
    	b.setOnClickListener(h);
    	b = (Button)findViewById(R.id.button2);
    	b.setOnClickListener(h);
    	b = (Button)findViewById(R.id.button3);
    	b.setOnClickListener(h);
    	b = (Button)findViewById(R.id.button4);
    	b.setOnClickListener(h);
    	b = (Button)findViewById(R.id.button5);
    	b.setOnClickListener(h);
    }
    private float getFloatValue(String s) {
		float tempFloat;
		try {
			tempFloat = Float.valueOf(s.toString());
		} catch (NumberFormatException e) {
			tempFloat = 0.0f;
		}
		return tempFloat;
    }
    private void setOrthofTextWatcher() {
    	TextWatcher w;
    	w = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable arg0) {}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Global.mActivity.updateOrthofParam();
			}
    	};
    	
        ((EditText)findViewById(R.id.editLeftX)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editRightX)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editTopY)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editBottomY)).addTextChangedListener(w);
    }
    private void setColorTextWatcher() {
    	TextWatcher w;
    	w = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable arg0) {}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Global.mActivity.updateColorParam();
			}
    	};
    	
        ((EditText)findViewById(R.id.editR)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editG)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editB)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editAlpha)).addTextChangedListener(w);
    }
    private void setSquareTextWatcher() {
    	TextWatcher w;
    	w = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable arg0) {}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Global.mActivity.updateSquarefParam();
			}
    	};
    	
        ((EditText)findViewById(R.id.editHeight)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editWidth)).addTextChangedListener(w);
    }
    private void setTransTextWatcher() {
    	TextWatcher w;
    	w = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable arg0) {}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Global.mActivity.updateTransParam();
			}
    	};
    	
        ((EditText)findViewById(R.id.editTransX)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editTransY)).addTextChangedListener(w);
    }
    private void setRotateTextWatcher() {
    	TextWatcher w;
    	w = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable arg0) {}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,	int after) {}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Global.mActivity.updateRotateParam();
			}
    	};
    	
        ((EditText)findViewById(R.id.editAngle)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editRotateX)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editRotateY)).addTextChangedListener(w);
        ((EditText)findViewById(R.id.editRotateZ)).addTextChangedListener(w);
    }
    private void setRotateParam(String angle, String x, String y, String z) {
    	EditText editAngle, editRotateX, editRotateY, editRotateZ;
    	editAngle = (EditText)findViewById(R.id.editAngle);
    	editRotateX = (EditText)findViewById(R.id.editRotateX);
    	editRotateY = (EditText)findViewById(R.id.editRotateY);
    	editRotateZ = (EditText)findViewById(R.id.editRotateZ);
    	
    	editAngle.setText(angle);
    	editRotateX.setText(x);
    	editRotateY.setText(y);
    	editRotateZ.setText(z);
    }
    private void setTransParam(String x, String y) {
    	EditText editTransX, editTransY;
    	editTransX = (EditText)findViewById(R.id.editTransX);
    	editTransY = (EditText)findViewById(R.id.editTransY);
    	
    	editTransX.setText(x);
    	editTransY.setText(y);
    }
    private void setSquareParam(String height, String width) {
    	EditText editHeight, editWidth;
    	editHeight = (EditText)findViewById(R.id.editHeight);
    	editWidth = (EditText)findViewById(R.id.editWidth);
    	
    	editHeight.setText(height);
    	editWidth.setText(width);
    }
    private void setColorParam(String r, String g, String b, String alpha) {
    	EditText editR, editG, editB, editAlpha;
    	editR = (EditText)findViewById(R.id.editR);
    	editG = (EditText)findViewById(R.id.editG);
    	editB = (EditText)findViewById(R.id.editB);
    	editAlpha = (EditText)findViewById(R.id.editAlpha);
    	
    	editR.setText(r);
    	editG.setText(g);
    	editB.setText(b);
    	editAlpha.setText(alpha);
    }
    private void setOrthofParam(String leftX, String rightX, String bottomY, String topY) {
        EditText editRightX, editLeftX, editBottomY, editTopY;
        editRightX = (EditText)findViewById(R.id.editRightX);
        editLeftX = (EditText)findViewById(R.id.editLeftX);
        editBottomY = (EditText)findViewById(R.id.editBottomY);
        editTopY = (EditText)findViewById(R.id.editTopY);
        
        editRightX.setText(rightX);
        editLeftX.setText(leftX);
        editBottomY.setText(bottomY);
        editTopY.setText(topY);
    }
    public void updateOrthofParam() {
        EditText editRightX, editLeftX, editBottomY, editTopY;
        editRightX = (EditText)findViewById(R.id.editRightX);
        editLeftX = (EditText)findViewById(R.id.editLeftX);
        editBottomY = (EditText)findViewById(R.id.editBottomY);
        editTopY = (EditText)findViewById(R.id.editTopY);
        renderer.setOrthofParam(
        		getFloatValue(editLeftX.getText().toString()), 
        		getFloatValue(editRightX.getText().toString()), 
        		getFloatValue(editBottomY.getText().toString()), 
        		getFloatValue(editTopY.getText().toString()));
    }
    public void updateColorParam() {
        EditText editR, editG, editB, editAlpha;
        editR = (EditText)findViewById(R.id.editR);
        editG = (EditText)findViewById(R.id.editG);
        editB = (EditText)findViewById(R.id.editB);
        editAlpha = (EditText)findViewById(R.id.editAlpha);
        renderer.setColorParam(
        		getFloatValue(editR.getText().toString()), 
        		getFloatValue(editG.getText().toString()), 
        		getFloatValue(editB.getText().toString()), 
        		getFloatValue(editAlpha.getText().toString()));
    }
    public void updateSquarefParam() {
        EditText editHeight, editWidth;
        editHeight = (EditText)findViewById(R.id.editHeight);
        editWidth = (EditText)findViewById(R.id.editWidth);
        renderer.setSquareParam(
        		getFloatValue(editHeight.getText().toString()), 
        		getFloatValue(editWidth.getText().toString())); 
    }
    public void updateTransParam() {
        EditText editTransX, editTransY;
        editTransX = (EditText)findViewById(R.id.editTransX);
        editTransY = (EditText)findViewById(R.id.editTransY);
        renderer.setTransParam(
        		getFloatValue(editTransX.getText().toString()), 
        		getFloatValue(editTransY.getText().toString())); 
    }
    public void updateRotateParam() {
        EditText editAngle, editRotateX, editRotateY, editRotateZ;
        editAngle = (EditText)findViewById(R.id.editAngle);
        editRotateX = (EditText)findViewById(R.id.editRotateX);
        editRotateY = (EditText)findViewById(R.id.editRotateY);
        editRotateZ = (EditText)findViewById(R.id.editRotateZ);
        renderer.setRotateParam(
        		getFloatValue(editAngle.getText().toString()), 
        		getFloatValue(editRotateX.getText().toString()), 
        		getFloatValue(editRotateY.getText().toString()),
        		getFloatValue(editRotateZ.getText().toString())); 
    }
/*    private void setTextWatcher(int id) {
        EditText editText;
        float tempFloat = 0;

        editText = (EditText)findViewById(id);
        
        switch (id) {
        case R.id.editLeftX:
        	tempFloat = renderer.getLeftX();
        	break;
        case R.id.editRightX:
        	tempFloat = renderer.getRightX();
        	break;
        case R.id.editBottomY:
        	tempFloat = renderer.getBottomY();
        	break;
        case R.id.editTopY:
        	tempFloat = renderer.getTopY();
        	break;
        }
        editText.setText(Float.toString(tempFloat));
        editText.addTextChangedListener(new OrthofTextWatcher(id, renderer));
    }
*/
}