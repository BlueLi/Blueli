package com.example.visitupd;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.visitupd.Dao.NetUtils;
import com.example.visitupd.Json.Student;
import com.example.visitupd.adapter.StuAdapter;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private List<Student> mList;
	private StuAdapter adapter;
	private Context context;
	private ListView list_view;
						
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 1:
				adapter = new StuAdapter(mList, context);
				list_view.setAdapter(adapter);
				break;
			case 0:
				Toast.makeText(getApplicationContext(), "º”‘ÿ ß∞‹", 0).show();
				break;
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		list_view = (ListView) findViewById(R.id.listView1);
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String string = NetUtils.getStr();
				string = string.substring(1);
				if (string != "") {
					mList = parseJson(string);
					Log.d("mlist", mList.toString());
					handler.sendEmptyMessage(1);
					} else {
					handler.sendEmptyMessage(0);
				}
			}
		}).start();
	}
	public List<Student> parseJson(String str) {

		List<Student> list = new ArrayList<Student>();
		try {
			JSONArray array = new JSONArray(str);
			
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				String hotelname = obj.getString("hotelname");
				String address = obj.getString("address");
				JSONArray arr = obj.getJSONArray("menu");
				for (int j = 0; j < arr.length(); j++) {
					Log.d("jiexi", "dfghjkrtyuiodfghjkdfghjk");
					JSONObject objec = arr.getJSONObject(j);
					int cateid = objec.getInt("cateid");
					String cateurl = objec.getString("cateurl");
					String catetitle = objec.getString("catetitle");
					String catecontent = objec.getString("catecontent");
					String cateprice = objec.getString("cateprice");
					Student stu = new Student(cateid, hotelname, address,
							cateprice, catetitle, catecontent, cateurl);
					list.add(stu);
					System.out.println(list.toString() + "------------list->>");

				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
