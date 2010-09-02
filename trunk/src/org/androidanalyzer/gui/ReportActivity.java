package org.androidanalyzer.gui;

import java.net.URL;

import org.androidanalyzer.Constants;
import org.androidanalyzer.R;
import org.androidanalyzer.core.AnalyzerCore;
import org.androidanalyzer.core.Data;
import org.apache.http.client.HttpResponseException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class is used to create form for processing (save to file or/and send to the
 * back-end) collected data.
 */
public class ReportActivity extends Activity {

	private static final int SEND_REPORT_PROGRESS = 0;
	private static final int SAVE_REPORT_PROGRESS = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		Intent intent = getIntent();
		Bundle data = intent.getExtras();
		final Data analysisResult = (Data) data.get(Constants.GUI_HANDLER_SEND);
		final AnalyzerCore core = AnalyzerCore.getInstance();
		final String host = (String) data.get(Constants.HOST);
		Button sendB = (Button) findViewById(R.id.first_button);
		sendB.setText(R.string.send_report_button);
		sendB.setOnClickListener(new View.OnClickListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see android.view.View.OnClickListener#onClick(android.view.View)
			 */
			@Override
			public void onClick(View v) {
				EditText mUserText = (EditText) findViewById(R.id.edittext1);
				String comment = mUserText.getText().toString();
				analysisResult.setComment(comment);
				Bundle bundle = new Bundle();
				bundle.putParcelable(Constants.GUI_HANDLER_SEND, analysisResult);
				bundle.putString(Constants.HOST, host);
				showDialog(SEND_REPORT_PROGRESS);
				new ProgressThread(SEND_REPORT_PROGRESS, bundle, handler).start();
			}
		});
		Button saveB = (Button) findViewById(R.id.second_button);
		saveB.setText(R.string.save_report_button);
		saveB.setOnClickListener(new View.OnClickListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see android.view.View.OnClickListener#onClick(android.view.View)
			 */
			@Override
			public void onClick(View v) {
				Bundle bundle = new Bundle();
				bundle.putParcelable(Constants.GUI_HANDLER_SEND, analysisResult);
				showDialog(SAVE_REPORT_PROGRESS);
				new ProgressThread(SAVE_REPORT_PROGRESS, bundle, handler).start();
			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateDialog(int)
	 */
	@Override
	protected Dialog onCreateDialog(int id) {
		ProgressDialog progress = new ProgressDialog(this);
		switch (id) {
		case SAVE_REPORT_PROGRESS:
			progress.setMessage(getString(R.string.save_progress_message));
			break;
		case SEND_REPORT_PROGRESS:
			progress.setMessage(getString(R.string.send_progress_message));
		}
		return progress;
	}

	void showResultDialog(String message, int action, boolean negative) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		switch (action) {
		case SAVE_REPORT_PROGRESS:
			dialog.setTitle(message != null ? R.string.alert_dialog_pos_title : R.string.alert_dialog_warning_title);
			dialog.setIcon(message != null ? R.drawable.ok_icon : R.drawable.warning_icon_yellow);
			dialog.setMessage(message != null ? getString(R.string.alert_dialog_pos_ssd) + " "
					+ getString(R.string.alert_dialog_pos_file_loc) + message : getString(R.string.alert_dialog_warning_msg));
			break;
		case SEND_REPORT_PROGRESS:
			dialog.setTitle(negative ? R.string.alert_dialog_warning_title : R.string.alert_dialog_pos_title);
			dialog.setIcon(negative ? R.drawable.warning_icon_yellow : R.drawable.ok_icon);
			message = message == null || message.length() == 0 ? getString(R.string.alert_dialog_warning_msg) : message;
			dialog.setMessage(negative ? message : getString(R.string.alert_dialog_pos_ss) + message);
			break;
		}
		dialog.setCancelable(false);
		dialog.setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * android.content.DialogInterface.OnClickListener#onClick(android.content
			 * .DialogInterface, int)
			 */
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		dialog.show();
	}

	final Handler handler = new Handler() {

		public void handleMessage(Message msg) {
			if (msg.getData().getBoolean(Constants.REPORT_DONE)) {
				int id = msg.getData().getInt(Constants.REPORT_ID);
				boolean negative = msg.getData().getBoolean(Constants.REPORT_RESULT_NEGATIVE);
				dismissDialog(id);
				String response = msg.getData().getString(Constants.REPORT_RESULT);
				showResultDialog(response, id, negative);
			}
		}

	};

	private class ProgressThread extends Thread {

		int action;
		Bundle data;
		Handler handler;
		AnalyzerCore core;

		public ProgressThread(int action, Bundle data, Handler handler) {
			this.action = action;
			this.data = data;
			this.handler = handler;
			core = AnalyzerCore.getInstance();
		}

		public void run() {
			Message msg = new Message();
			Bundle bundle = new Bundle();
			bundle.putBoolean(Constants.REPORT_DONE, true);
			bundle.putInt(Constants.REPORT_ID, action);
			String response = null;
			boolean negative = false;
			Data result = (Data) data.get(Constants.GUI_HANDLER_SEND);
			switch (action) {
			case SAVE_REPORT_PROGRESS:
				response = core.writeToFile(result);
				if (response != null)
					bundle.putString(Constants.REPORT_RESULT, response);
				break;
			case SEND_REPORT_PROGRESS:
				try {
					String host = (String) data.get(Constants.HOST);
					URL lHost = new URL(host);
					response = (String) core.sendReport(result, lHost);
				} catch (Exception ex) {
					negative = true;
					if (ex instanceof HttpResponseException) {
						int code = ((HttpResponseException) ex).getStatusCode();
						response = getString(R.string.alert_dialog_warning_msg) + System.getProperty("line.separator") + "Status - " + code;
					}
				}
				if (response != null)
					bundle.putString(Constants.REPORT_RESULT, response);
				break;
			}
			bundle.putBoolean(Constants.REPORT_RESULT_NEGATIVE, negative);
			msg.setData(bundle);
			handler.sendMessage(msg);
		}
	}

}