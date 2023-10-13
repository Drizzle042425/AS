package com.example.mychat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class Fragment2 extends Fragment{   //继承自Fragment类的weixinFragment类。在该类中，重写了onCreateView方法用于创建视图
    private RecyclerView recyclerView;
    private List<String> list;
    private Context context;
    private Myadapter myadapter;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.tab02,container,false);
        context=view.getContext();
        recyclerView=view.findViewById(R.id.recycleview);
        list=new ArrayList();

        initial();
        myadapter = new Myadapter(context,list);
        recyclerView.setAdapter(myadapter);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        return view;

    }

    private void initial() {
        list.add("蔡徐坤");
        list.add("陈立农");
        list.add("范丞丞");
        list.add("黄明昊");
        list.add("林彦俊");
        list.add("朱正廷");
        list.add("王子异");
        list.add("王琳凯");
        list.add("尤长靖");
        list.add("nine percent(＾－＾)V");
    }

}

