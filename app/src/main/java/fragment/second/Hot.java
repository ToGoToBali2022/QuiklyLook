package fragment.second;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bw.com.quiklylook.R;

import adapter.HotVpAdapter;

/**
 * Created by lenovo on 2017/4/24.
 */

public class Hot extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      

        View view = inflater.inflate(R.layout.hot_fragment, container, false);

        tabLayout= (TabLayout) view.findViewById(R.id.hot_tab);

        viewPager = (ViewPager) view.findViewById(R.id.hot_vp);


        return   view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HotVpAdapter  adapter=new HotVpAdapter(getChildFragmentManager());

       viewPager.setAdapter(adapter);

            //tablayout与viewpager关联
        tabLayout.setupWithViewPager(viewPager);
            //设置选中和未选中字体颜色
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorHui),getResources().getColor(R.color.colorCoffer));
            //设置指示器颜色，即下划线
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorJu));
    //设置模式有常规和滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
