package com.example.jazielsma.naivedatepicker.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jazielsma.naivedatepicker.R;

/**
 * //todo add javadoc and clean code
 * //todo convert the class into a singleton or interface
 * Created by eddy.velazquez@wocom-labs.com on 4/8/17.
 */

public class PoorDateCalculator {
	String _separator;
	ViewGroup _parent;
	TextView _sibling;
	private int flag;
	
	/**
	 * Set value.
	 *
	 * @param view
	 * 		the view
	 */
	public void set_flag(TextView view) {
		
		_separator = view.getContext()
		                 .getString(R.string.slash);
		String[] _valueStr = view.getText()
		                         .toString()
		                         .split(_separator);
		flag = Integer.valueOf(_valueStr[0]);
		
	}
	
	private void updateSiblingNext(View view, int id, int topLimit) {
		_parent = (ViewGroup) view.getParent();
		_sibling = (TextView) _parent.findViewById(id);
		next(_sibling,
		     topLimit
		);
		
	}
	
	private void updateSiblingPrev(View view, int id, int topLimit) {
		_parent = (ViewGroup) view.getParent();
		_sibling = (TextView) _parent.findViewById(id);
		prev(_sibling,
		     topLimit
		);
		
	}
	
	/**
	 * Next. this method adds 1 until it reaches the top limit
	 *
	 * @param view
	 * 		the view
	 * @param topLimit
	 * 		the top limit either here months have 31 days XP
	 */
	public void next(TextView view, int topLimit) {
		set_flag(view);
		
		if (flag <= 8 && flag >= 1) {
			view.setText("0" + String.valueOf(flag += 1) + _separator);
			
		}
		else if (flag < topLimit) {
			view.setText(String.valueOf(flag += 1) + _separator);
			
		}
		else {
			view.setText("0" + String.valueOf(flag = 1) + _separator);
			
			if (view.getTag() == "month") {
				
				_parent = (ViewGroup) view.getParent();
				_sibling = (TextView) _parent.findViewById(R.id.tv_year);
				_sibling.setText(String.valueOf(Integer.valueOf(_sibling.getText()
				                                                        .toString()) + 1));
				
				
			}
			else if (view.getTag() == "day") {
				updateSiblingNext(view, R.id.tv_month, 12);
			}
		}
		
	}
	
	/**
	 * Prev. this method substract 1 until it reaches 0 and starts again from top limit
	 *
	 * @param view
	 * 		the view
	 * @param topLimit
	 * 		the top limit
	 */
	public void prev(TextView view, int topLimit) {
		set_flag(view);
		
		if (flag <= 8 && flag >= 2) {
			view.setText("0" + String.valueOf(flag -= 1) + _separator);
			
		}
		else if (flag <= topLimit && flag >= 2) {
			view.setText(String.valueOf(flag -= 1) + _separator);
			
		}
		else {
			view.setText(String.valueOf(flag = topLimit) + _separator);
			
			if (view.getTag() == "month") {
				_parent = (ViewGroup) view.getParent();
				_sibling = (TextView) _parent.findViewById(R.id.tv_year);
				_sibling.setText(String.valueOf(Integer.valueOf(_sibling.getText()
				                                                        .toString()) - 1));
				
			}
			else if (view.getTag() == "day") {
				updateSiblingPrev(view, R.id.tv_month, 12);
				
			}
		}
	}
	
}
