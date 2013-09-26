package com.pps.netnew.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pps.netnew.fragment.EconomicsFragment;
import com.pps.netnew.fragment.EntertainFragment;
import com.pps.netnew.fragment.HeadlinesFragment;
import com.pps.netnew.fragment.ScienceFragment;
import com.pps.netnew.fragment.SportFragment;
/**
 * �Զ���ViewPagerҳ��ѡ�������
 * @author jiangqq
 *
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> mFragments;
	private String[] mViewpager_title;
	
	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
		mFragments=new ArrayList<Fragment>();
		//������Ҫ��ʾ��Fragmentѡ����뵽������
		mFragments.add(new HeadlinesFragment());
		mFragments.add(new EntertainFragment());
		mFragments.add(new SportFragment());
		mFragments.add(new EconomicsFragment());
		mFragments.add(new ScienceFragment());
		mViewpager_title=new String[]{"ͷ��","����","����","�ƾ�","�Ƽ�"};
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return mViewpager_title[position];
	}

	@Override
	public Fragment getItem(int arg0) {
		return mFragments.get(arg0);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mFragments!=null?mFragments.size():0;
	}
}
