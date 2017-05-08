package fragment.second;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bw.com.quiklylook.MainActivity;
import com.bw.com.quiklylook.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adapter.WeekItemAdapter;
import bean.ManHua;
import listener.Respon;

/**
 * Created by lenovo on 2017/4/25.
 */

public class WeekF extends Fragment implements SwipeRefreshLayout.OnRefreshListener, Respon {
    String title;
    private SwipeRefreshLayout swipe;
    private   List<ManHua.DataBean.ComicsBean> all=new ArrayList<>();
    private ListView lv;
    private WeekItemAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.week_fragment, container, false);
        if (getArguments() != null) {

           // title = getArguments().getString("title");
        }

        swipe = (SwipeRefreshLayout) view.findViewById(R.id.week_swipe);
        lv = (ListView) view.findViewById(R.id.week_lv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
        swipe.setOnRefreshListener(this);

        adapter = new WeekItemAdapter(getActivity(),all);

        lv.setAdapter(adapter);




    }

     private void getData() {
     String path="http://api.kuaikanmanhua.com/v1/daily/comic_lists/1489334400?since=0&gender=0";

        new asTask.AT(this).execute(path);

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void success(String str) {

        swipe.setRefreshing(false);
        Gson gson=new Gson();

        ManHua hua = gson.fromJson(str, ManHua.class);

        List<ManHua.DataBean.ComicsBean> list = hua.getData().getComics();

        all.addAll(list);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void fail() {
        swipe.setRefreshing(false);
    }
}
