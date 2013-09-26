package com.pps.netnew.activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.pps.netnew.adapter.MainPagerAdapter;
import com.pps.netnew.fragment.LeftCategoryFragment;
import com.pps.netnew.fragment.RightPerMsgCenterFragment;

public class MainActivity extends SlidingFragmentActivity {

	private ImageButton main_left_imgbtn;
	private ImageButton main_right_imgbtn;
	private ViewPager myViewPager;
	private PagerTitleStrip pagertitle;
	private PagerAdapter mAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		initSlidingMenu();
		initView();
		initValidata();
		bindData();
		initListener();
	}
	/**
	 * ��ʼ��SlidingMenu��ͼ
	 */
	private void initSlidingMenu(){
		// ���û����˵�������ֵ
	    getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		getSlidingMenu().setShadowWidthRes(R.dimen.shadow_width);	
		getSlidingMenu().setShadowDrawable(R.drawable.shadow);
		getSlidingMenu().setBehindOffsetRes(R.dimen.slidingmenu_offset);
		getSlidingMenu().setFadeDegree(0.35f);
		//�������������ͼ		
		setContentView(R.layout.main);
		// ������߲˵��򿪺����ͼ����
	    setBehindContentView(R.layout.left_content);	
	    getSupportFragmentManager().beginTransaction().replace(R.id.left_content_id, new LeftCategoryFragment()).commit();
	    // �����ұ߲˵��򿪺����ͼ����
		getSlidingMenu().setSecondaryMenu(R.layout.right_content);
		getSupportFragmentManager().beginTransaction().replace(R.id.right_content_id, new RightPerMsgCenterFragment()).commit();
	}
	
	private void initView()
	{
		main_left_imgbtn=(ImageButton)this.findViewById(R.id.main_left_imgbtn);
		main_right_imgbtn=(ImageButton)this.findViewById(R.id.main_right_imgbtn);
		myViewPager=(ViewPager)this.findViewById(R.id.myviewpager);
		pagertitle=(PagerTitleStrip)this.findViewById(R.id.pagertitle);
		
		
	}
	
	/**
	 * ��ʼ������
	 */
	private void initValidata()
	{
		pagertitle.setTextSize(0, 25);
		mAdapter=new MainPagerAdapter(getSupportFragmentManager());
		
	}
	
	/**
	 * ������
	 */
	private void bindData()
	{
		myViewPager.setAdapter(mAdapter);
		myViewPager.setCurrentItem(0);
	}
	private void initListener()
	{
		main_left_imgbtn.setOnClickListener(new MySetOnClickListener());
		main_right_imgbtn.setOnClickListener(new MySetOnClickListener());
		myViewPager.setOnPageChangeListener(new MySetOnPageChangeListener());
	}
	
	/**
	 * ViewPagerҳ��ѡ��л�������
	 */
	class MySetOnPageChangeListener implements OnPageChangeListener
	{
		public void onPageScrollStateChanged(int arg0) {				
		}
		public void onPageScrolled(int arg0, float arg1, int arg2) {		
		}
		public void onPageSelected(int arg0) {		
		}	
	}
	/**
	 * ���в໬�������ر�
	 * @author jiangqq
	 *
	 */
	class MySetOnClickListener implements OnClickListener
	{

		public void onClick(View v) {
		  toggle();
		}
	}
}
