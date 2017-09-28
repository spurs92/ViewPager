package com.spurs.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    MyAdpater adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        pager=(ViewPager)findViewById(R.id.pager);
        adpater=new MyAdpater(getLayoutInflater());
        pager.setAdapter(adpater);

        //Page를 조금이라도 움직이면 발동하는 메소드를 보유한 리스너 추가
        pager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                page.setAlpha(1-Math.abs(position));//명암효과
                page.setRotationY(position*90);//애니메이션효과

                page.setScaleX((1-Math.abs(position))/2+0.5f);//이미지 사이즈 점점 작게
                page.setScaleY((1-Math.abs(position))/2+0.5f);
            }
        });

    }

    public void clickPre(View v){
        int index=pager.getCurrentItem();
        pager.setCurrentItem(index-1,true);

    }

    public void clickNext(View v){
        int index=pager.getCurrentItem();
        pager.setCurrentItem(index+1,true);
    }
}
