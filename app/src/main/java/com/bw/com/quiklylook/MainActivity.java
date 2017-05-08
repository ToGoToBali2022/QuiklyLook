package com.bw.com.quiklylook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import fragment.FeedF;
import fragment.FindF;
import fragment.HomeF;
import fragment.MyF;

public class MainActivity extends FragmentActivity {


    private RadioGroup group;
  private    int  selectindex;
    private List<Fragment> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         group = (RadioGroup)findViewById(R.id.main_rg_group);


         createaAdFragment();



        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case  R.id.main_bt_home:
                          selectindex=0;
                        break;

                    case  R.id.main_bt_find:
                        selectindex=1;
                        break;
                    case  R.id.main_bt_feed:
                        selectindex=2;
                        break;
                    case  R.id.main_bt_my:
                        selectindex=3;
                        break;
                }

                showFragment(selectindex);
            }
        });




    }

    private void showFragment(int  index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (!list.get(index).isAdded()){

            transaction.add(R.id.main_frame,list.get(index));
        }

        for (int  i=0;i<list.size();i++){
            if (index==i){

               transaction.show(list.get(i));
            }else{

                transaction.hide(list.get(i));
            }

        }
        transaction.commit();
    }

    private void createaAdFragment() {
        HomeF  hnme=new HomeF();
        FindF  find=new FindF();
        FeedF feed=new FeedF();
        MyF  my=new MyF();

        list.add(hnme);
        list.add(find);
        list.add(feed);
        list.add(my);

    }


}
