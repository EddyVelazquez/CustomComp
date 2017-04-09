package com.example.jazielsma.naivedatepicker;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by eddy.velazquez@wocom-labs.com on 4/8/17.
 */

public class DatePicker extends LinearLayout {
	
	
	public Button btnPrevMonth, btnPrevDay, btnNextDay, btnNextMonth;
	public TextView tvDay, tvMonth, tvYear;
	
	
	public DatePicker(Context context) {
		super(context);
		initializeView(context);
	}
	
	public DatePicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		initializeView(context);
	}
	
	public DatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initializeView(context);
		
	}
	
	@RequiresApi (api = Build.VERSION_CODES.LOLLIPOP)
	public DatePicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		initializeView(context);
	}
	
	private void initializeView(Context context) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.date_picker, this);
		
	}
	
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		
		
		btnPrevMonth = (Button) this.findViewById(R.id.btn_prev_month);
		btnPrevDay = (Button) this.findViewById(R.id.btn_prev_day);
		btnNextDay = (Button) this.findViewById(R.id.btn_next_day);
		btnNextMonth = (Button) this.findViewById(R.id.btn_next_month);
		
		tvDay = (TextView) this.findViewById(R.id.tv_day);
		tvMonth = (TextView) this.findViewById(R.id.tv_month);
		tvYear = (TextView) this.findViewById(R.id.tv_year);
		
	}
}
