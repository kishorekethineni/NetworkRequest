package com.kishore.resusablenetworkcall;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingDialog {

	private final Activity activity;
	private AlertDialog dialog;
	private ImageView imageView;
	private ProgressBar progressBar;
	private TextView message;
	LoadingDialog(Activity myActivity) {
		activity = myActivity;
	}

	@SuppressLint("InflateParams")
	void startLoadingDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity,R.style.Style_Dialog_Rounded_Corner);
		LayoutInflater inflater = activity.getLayoutInflater();
		View view = inflater.inflate(R.layout.loading_alert, null);
		builder.setView(view);
		builder.setCancelable(false);

		imageView = view.findViewById(R.id.doneImage);
		progressBar = view.findViewById(R.id.progressBar);
		message = view.findViewById(R.id.message);

		dialog = builder.create();
		dialog.show();
	}

	void dismissDialog(int imageRes,String msg) {
		imageView.setImageResource(imageRes);
		imageView.setVisibility(View.VISIBLE);
		progressBar.setVisibility(View.GONE);
		message.setText(msg);
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				dialog.dismiss();
			}
		}, 2000);
	}
}
