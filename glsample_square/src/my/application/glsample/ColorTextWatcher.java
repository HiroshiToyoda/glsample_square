package my.application.glsample;
import my.application.glsample.R;
import android.text.Editable;
import android.text.TextWatcher;


public class ColorTextWatcher implements TextWatcher {
	private int mId;
	private GlsampleRenderer mRenderer;
	
	public ColorTextWatcher(int id, GlsampleRenderer renderer) {
		this.mId = id;
		this.mRenderer = renderer;
	}
	@Override
	public void afterTextChanged(Editable arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			int arg3) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		
		float tempFloat;
		try {
			tempFloat = Float.valueOf(s.toString());
		} catch (NumberFormatException e) {
			tempFloat = 0.0f;
		}
		
		switch (mId) {
		case R.id.editR:
			mRenderer.setLeftX(tempFloat);
			break;
		case R.id.editRightX:
			mRenderer.setRightX(tempFloat);
			break;
		case R.id.editBottomY:
			mRenderer.setBottomY(tempFloat);
			break;
		case R.id.editTopY:
			mRenderer.setTopY(tempFloat);
			break;
		}
	}

}
