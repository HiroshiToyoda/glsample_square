package my.application.glsample;

import android.widget.TextView;

public class UpdateTextInfo implements Runnable {
	private String message;

	@Override
	public void run() {
		TextView tempText;
		tempText = (TextView)Global.mActivity.findViewById(R.id.TextInfo);
		tempText.setText(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
