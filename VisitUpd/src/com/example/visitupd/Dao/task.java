package com.example.visitupd.Dao;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class task extends AsyncTask<String, Integer, Bitmap>{
	private ImageView imageView;
	
	public task(ImageView imageView) {
		super();
		this.imageView = imageView;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		Bitmap bitmap = BitmapFactory.decodeStream(NetUtils.getInputStream(params[0]));
		return bitmap;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		imageView.setImageBitmap(result);
	}
	
}
