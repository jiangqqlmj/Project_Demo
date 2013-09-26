package com.pps.netnew.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.pps.netnew.activity.R;
import com.pps.netnew.adapter.LeftCateGoryAdapter;
import com.pps.netnew.model.ItemCategoryModel;

/**
 * ��ߵײ�����������ʾFragment
 * 
 * @author jiangqingqing
 * 
 */
public class LeftCategoryFragment extends Fragment {
	private View mView;
	private Context mContext;
	private ListView listview_right_category;
	private LeftCateGoryAdapter mAdapter;
	private String[] category_name;
	private String[] category_title;
	private Integer[] category_img;
	private List<ItemCategoryModel> mLists;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (null == mView) {
			mView = inflater.inflate(R.layout.left_category, container, false);
			initView();
			initValidata();
			bindData();
			initListener();
		}
		return mView;
	}

	/**
	 * ��ʼ������Ԫ��
	 */
	private void initView() {
		listview_right_category = (ListView) mView
				.findViewById(R.id.listview_left_category);

	}

	/**
	 * ��ʼ������
	 */
	private void initValidata() {
		mContext = mView.getContext();
		// ����ģ��ͳ�ʼ����Ҫ���з���������õ�����
		category_name = mContext.getResources().getStringArray(
				R.array.category_name);
		category_title = mContext.getResources().getStringArray(
				R.array.category_title);
		category_img = new Integer[] { R.drawable.biz_navigation_tab_news,
				R.drawable.biz_navigation_tab_local_news,
				R.drawable.biz_navigation_tab_ties,
				R.drawable.biz_navigation_tab_pics,
				R.drawable.biz_navigation_tab_ugc,
				R.drawable.biz_navigation_tab_voted,
				R.drawable.biz_navigation_tab_micro,
				R.drawable.biz_pc_list_polymetric_icon };

		mLists = new ArrayList<ItemCategoryModel>();
		// ����Ҫ��ʾ�ķ��������󼯺�
		for (int i = 0; i < category_img.length; i++) {
			mLists.add(new ItemCategoryModel(category_img[i], category_name[i],
					category_title[i]));
		}
		// ��ʼ��������
		mAdapter = new LeftCateGoryAdapter(mContext, mLists);
	}

	/**
	 * ������
	 */
	private void bindData() {
		listview_right_category.setAdapter(mAdapter);
	}

	/**
	 * ��ʼ��������
	 */
	private void initListener() {
		listview_right_category
				.setOnItemClickListener(new MyOnItemClickListener());
	}

	/**
	 * listview�б��item�ĵ������
	 * 
	 * @author jiangqingqing
	 * 
	 */
	class MyOnItemClickListener implements OnItemClickListener {
		
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
            Toast.makeText(mContext, "��ѡ����"+category_name[arg2], Toast.LENGTH_SHORT).show();
		}
	}
}
