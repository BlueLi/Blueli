package com.example.visitupd.adapter;

import java.util.List;

import cache.loader.ImageWorker;

import com.example.visitupd.R;
import com.example.visitupd.Dao.task;
import com.example.visitupd.Json.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StuAdapter extends BaseAdapter {
	List<Student> list;
	Context context;

	public StuAdapter(List<Student> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.adapter_stu, null);
			vh = new ViewHolder();
			vh.text_name = (TextView) convertView.findViewById(R.id.text_name);
			vh.text_title = (TextView) convertView
					.findViewById(R.id.text_title);
			vh.text_wifi = (TextView) convertView.findViewById(R.id.text_wifi);
			vh.text_address = (TextView) convertView
					.findViewById(R.id.text_address);
			vh.text_price = (TextView) convertView
					.findViewById(R.id.text_price);
			vh.imageview = (ImageView) convertView
					.findViewById(R.id.imageView1);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

//		ImageWorker.getImage(context,
//				"http://192.168.1.248:8080" + list.get(position).getCateurl(),
//				vh.imageview, R.drawable.ic_launcher);
		new task(vh.imageview).execute("http://192.168.1.248:8080" + list.get(position).getCateurl());

		vh.text_name.setText(list.get(position).getHotelname());
		vh.text_title.setText(list.get(position).getCatetitle());
		vh.text_price.setText(list.get(position).getCateprice());
		vh.text_address.setText(list.get(position).getAddress());
		vh.text_wifi.setText(list.get(position).getCatecontent());
		
		new task(vh.imageview).execute("http://192.172.10.252/rss.php" + list.get(position).getCateurl());

		return convertView;
	}

	class ViewHolder {
		TextView text_name, text_title, text_wifi, text_price, text_address;
		ImageView imageview;
	}
}
