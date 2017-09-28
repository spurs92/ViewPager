package com.spurs.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by alfo06-11 on 2017-06-05.
 */

public class MyAdpater extends PagerAdapter {

    LayoutInflater inflater;

    public MyAdpater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 10;
    }

    //특정위치(position)에 해당하는 View객체르 생성 메소드
    //Viewpager가 보여줘야할 position번재 객제가 필요할때 자동 호출
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View page= inflater.inflate(R.layout.page, container,false); //xml을 객체로
        ImageView img=(ImageView) page.findViewById(R.id.img);
        img.setImageResource(R.drawable.gametitle_01+position);

        //만들어낸 뷰객체(pager)를 viewPager(container)에 추가
        container.addView(page);

        //만들어낸 page객체가 viewPager에 보여줄 View객체가 맞는가? 검증
        return page;
    }

    //더이상 필요없다고 판단되는 View 객체를 제거하는 메소드
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
