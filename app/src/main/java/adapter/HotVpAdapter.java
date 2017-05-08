package adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.second.WeekF;

/**
 * Created by lenovo on 2017/4/25.
 */

public class HotVpAdapter extends FragmentPagerAdapter {
    public HotVpAdapter(FragmentManager fm) {
        super(fm);
    }

    String[]  TITLE={"周一","周二","周三","周四","周五","周六","周天"};

    @Override
    public Fragment getItem(int position) {

        WeekF  we=new WeekF();

       /* Bundle  bun=new Bundle();
        bun.putString("title",TITLE[position]);
        we.setArguments(bun);*/
        return we;
    }

    @Override
    public int getCount() {
        return TITLE.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLE[position];
    }
}
