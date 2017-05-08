package adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.com.quiklylook.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bean.ManHua;

/**
 * Created by lenovo on 2017/4/28.
 */

public class WeekItemAdapter extends BaseAdapter {
    private Context context;
    private List<ManHua.DataBean.ComicsBean> list;
    private VHolder vh;

    public WeekItemAdapter(Context context, List<ManHua.DataBean.ComicsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            vh = new VHolder();

            convertView = View.inflate(context, R.layout.week_lv_item, null);

            vh.ivflag = (TextView) convertView.findViewById(R.id.week_item_flag);
            vh.tvtitle = (TextView) convertView.findViewById(R.id.week_item_title);
            vh.bigphoto = (ImageView) convertView.findViewById(R.id.week_item_bigphoto);
            vh.zititle = (TextView) convertView.findViewById(R.id.zititle);
            vh.ivzan = (ImageView) convertView.findViewById(R.id.week_item_zan);
            vh.tvzan = (TextView) convertView.findViewById(R.id.zannum);
            // vh.ivping=(ImageView) convertView.findViewById(R.id.week_item_ping);
            vh.tvping = (TextView) convertView.findViewById(R.id.pingnum);


            convertView.setTag(vh);
        } else {

            vh = (VHolder) convertView.getTag();

        }

     /*   GradientDrawable myGrad = (GradientDrawable) vh.ivflag.getBackground();
        myGrad.setColor(Color.parseColor(list.get(position).getLabel_color()));*/

        vh.ivflag.setText(list.get(position).getLabel_text());


        vh.tvtitle.setText(list.get(position).getTopic().getTitle());
        ImageLoader.getInstance().displayImage(list.get(position).getCover_image_url(), vh.bigphoto);
        vh.zititle.setText(list.get(position).getTitle());

        vh.tvzan.setText(list.get(position).getLikes_count() + "");
        vh.tvzan.setText(list.get(position).getComments_count() + "");


        vh.ivzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // 点赞动画

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(
                        ObjectAnimator.ofFloat(v, "scaleY", 1, 1.4f, 1),
                        ObjectAnimator.ofFloat(v, "scaleX", 1, 1.4f, 1));
                animatorSet.setDuration(400);
                animatorSet.start();
            }
        });


        return convertView;
    }


    class VHolder {
        TextView ivflag;
        TextView tvtitle;


        ImageView bigphoto;


        TextView zititle;
        ImageView ivzan;
        TextView tvzan;
        //ImageView ivping;
        TextView tvping;

    }
}
