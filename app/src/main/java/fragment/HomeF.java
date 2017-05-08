package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.bw.com.quiklylook.R;

import adapter.HomeVpAdapter;
import listener.Respon;

/**
 * Created by lenovo on 2017/4/24.
 */

public class HomeF extends Fragment implements Respon{

    private ViewPager vp;
    private RadioGroup group;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        vp = (ViewPager)view.findViewById(R.id.home_vp);
        group = (RadioGroup)view.findViewById(R.id.home_group);


        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        HomeVpAdapter  hvpadapter=new HomeVpAdapter(getActivity().getSupportFragmentManager());

        vp.setAdapter(hvpadapter);


        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            group.check(group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
              for(int i=0;i<2;i++){
                  if (group.getChildAt(i).getId()==checkedId){
                        vp.setCurrentItem(i);
                  }


              }


            }
        });
    }

    @Override
    public void success(String str) {

    }

    @Override
    public void fail() {

    }
}
