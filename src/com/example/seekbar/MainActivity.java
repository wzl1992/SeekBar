package com.example.seekbar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private SeekBar sb;
	private TextView tv;
	private Context mContext;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        
        sb = (SeekBar) findViewById(R.id.sb);
        tv = (TextView) findViewById(R.id.tv);
        sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				int index = arg0.getProgress();
				Toast.makeText(mContext, "结束位置：" + index, Toast.LENGTH_SHORT).show();
				tv.setText("");
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				int index = arg0.getProgress();
				Toast.makeText(mContext, "开始位置：" + index, Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				tv.setText("当前位置：" + arg1 + "/100");
			}
		});
    }
    
}
