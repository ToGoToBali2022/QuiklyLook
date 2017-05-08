package fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bw.com.quiklylook.R;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import adapter.VPlunbaoAdapter;
import bean.lunbaoB;
import utils.StringRead;

/**
 * Created by lenovo on 2017/4/24.
 */

public class FindF extends Fragment {

    private ViewPager vp;
    private List<ImageView> all;

    Handler han = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                vp.setCurrentItem(vp.getCurrentItem() + 1);


            }
            sendEmptyMessageDelayed(1,2000);

        }
    };
    private LinearLayout linear;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment, container, false);
        vp = (ViewPager) view.findViewById(R.id.find_vp_huadong);
        linear = (LinearLayout)view.findViewById(R.id.linear);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        all = new ArrayList<>();
        ImageView iv1 = new ImageView(getActivity());
        iv1.setImageResource(R.drawable.one);
        iv1.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView iv2 = new ImageView(getActivity());
        iv2.setImageResource(R.drawable.two);
        iv2.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView iv3 = new ImageView(getActivity());
        iv3.setImageResource(R.drawable.three);
        iv3.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView iv4 = new ImageView(getActivity());
        iv4.setImageResource(R.drawable.four);
        iv4.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView iv5 = new ImageView(getActivity());
        iv5.setImageResource(R.drawable.five);
        iv5.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView iv6 = new ImageView(getActivity());
        iv6.setImageResource(R.drawable.six);
        iv6.setScaleType(ImageView.ScaleType.FIT_XY);

        all.add(iv1);
        all.add(iv2);
        all.add(iv3);
        all.add(iv4);
        all.add(iv5);
        all.add(iv6);


        VPlunbaoAdapter adapter = new VPlunbaoAdapter(getActivity(), all);

        vp.setAdapter(adapter);

        vp.setCurrentItem(all.size()+1000);

        final List<ImageView>  imageViews=new ArrayList<>();

        linear.removeAllViews();
        imageViews.clear();

        for (int i=0;i<all.size();i++){

          ImageView  imageView=new ImageView(getActivity());
            if (i==0){
             imageView.setImageResource(R.drawable.shape);

            }else{

                imageView.setImageResource(R.drawable.shapemoren);}

            LinearLayout.LayoutParams  params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            params.setMargins(5,0,5,0);
            linear.addView(imageView,params);
            imageViews.add(imageView);
        }



vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int  i=0;i<all.size();i++){

            if (i==position%imageViews.size()){

                imageViews.get(i).setImageResource(R.drawable.shape);
            }else
            {

                imageViews.get(i).setImageResource(R.drawable.shapemoren);

            }

        }
    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }
});




        han.sendEmptyMessageDelayed(1, 2000);


    }


}
