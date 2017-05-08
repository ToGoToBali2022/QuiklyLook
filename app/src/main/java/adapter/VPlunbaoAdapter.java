package adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bean.lunbaoB;

/**
 * Created by lenovo on 2017/5/2.
 */

public class VPlunbaoAdapter extends PagerAdapter {

    private Context context;
    private List<ImageView>   list;

    public VPlunbaoAdapter(Context context, List<ImageView> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position%list.size()));


        return list.get(position%list.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {


        container.removeView((View) object);
    }
}
