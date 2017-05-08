package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.second.Fouces;
import fragment.second.Hot;

/**
 * Created by lenovo on 2017/4/24.
 */

public class HomeVpAdapter extends FragmentPagerAdapter {
    public HomeVpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment  frag=null;
        switch (position){
            case  0:

                frag=new Fouces();
                break;

            case  1:

                frag=new Hot();
                break;

        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
