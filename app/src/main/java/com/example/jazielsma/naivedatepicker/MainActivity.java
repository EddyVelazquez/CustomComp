package com.example.jazielsma.naivedatepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jazielsma.naivedatepicker.utils.PoorDateCalculator;

//todo add javadoc and clean code

public class MainActivity extends AppCompatActivity {
	
	private Button btnPrevMonth, btnPrevDay, btnNextDay, btnNextMonth;
	public TextView tvDay, tvMonth, tvYear;
	private String dayStr = "01", monthStr = "01", yearStr = "2017";
	
	private PoorDateCalculator util;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnPrevMonth = (Button) findViewById(R.id.btn_prev_month);
		btnPrevDay = (Button) findViewById(R.id.btn_prev_day);
		btnNextDay = (Button) findViewById(R.id.btn_next_day);
		btnNextMonth = (Button) findViewById(R.id.btn_next_month);
		
		
		tvDay = (TextView) findViewById(R.id.tv_day);
		tvMonth = (TextView) findViewById(R.id.tv_month);
		tvYear = (TextView) findViewById(R.id.tv_year);
		
		tvDay.setTag("day");
		tvMonth.setTag("month");
		tvYear.setTag("year");
		
		tvDay.setText(dayStr + getString(R.string.slash));
		tvMonth.setText(monthStr + getString(R.string.slash));
		tvYear.setText(yearStr);
		
		util = new PoorDateCalculator();
		
		btnNextDay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				util.next(tvDay, 31);
			}
		});
		btnNextMonth.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				util.next(tvMonth, 12);
			}
		});
		btnPrevDay.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				util.prev(tvDay,31);
			}
		});
		btnPrevMonth.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				util.prev(tvMonth, 12);
			}
		});
	}
	
}
