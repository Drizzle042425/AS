package com.example.mychat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment2 extends Fragment {
    //获取recyclerView对象并且实例化适配器
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fra_lx, container, false);
        View view;
        //存所有控件的视图
        view=inflater.inflate(R.layout.tab02, container, false);
        //调用recycleview控件
        recyclerView=view.findViewById(R.id.recycleview);
        //创建数据
        String[] names={"Felicity","Novocaine 2","rainy road","风（wind）","Windy Hill","至少还有你","The rain ＆ lovers","How Long"};
        int[] images={R.drawable.no1, R.drawable.no2, R.drawable.no3, R.drawable.no4,R.drawable.no5,
                R.drawable.no6,R.drawable.no7,R.drawable.no8};
        String[] composer={"Isaac Shepard","Cloke/Shiloh Dynasty","CHINESE","陈越龙","羽肿",
                "林忆莲","The rain ＆ lovers","Charlie Puth"};
        String[] album={"Deep Joy","Novocaine 2","Rainy road","Apr.四月","Windy Hill","爱的主题曲 十七岁的天空","rainy days",
                "Voicenotes"};
        String[] tags={"纯音乐","静谧","独白","治愈","轻音乐",
                "华语","小众","欧美"};
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> item=new HashMap<String, Object>();
            item.put("i_name",names[i]);
            item.put("i_image",images[i]);
            item.put("i_songer",composer[i]);
            item.put("i_song",album[i]);
            item.put("i_tag",tags[i]);
            items.add(item);
        }
        //创建RecycleView实例和设置Adapter
        Context context=getContext();
        myAdapter=new MyAdapter(items,context);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        manager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(myAdapter);

        //实现拖拽和左滑删除效果
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                int swiped=ItemTouchHelper.LEFT;
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                return makeMovementFlags(dragFlags,swiped);
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int oldPosition = viewHolder.getAdapterPosition();
                int newPosition = target.getAdapterPosition();
                if (oldPosition < newPosition) {
                    for (int i = oldPosition; i < newPosition; i++) {
                        // 改变数据集
                        Collections.swap(items, i, i +1);
                    }
                } else {
                    for (int i = oldPosition; i > newPosition; i--) {
                        // 改变数据集
                        Collections.swap(items, i, i - 1);
                    }
                }
                myAdapter.notifyItemMoved(oldPosition, newPosition);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                items.remove(position);
                myAdapter.notifyItemRemoved(position);
            }
            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                if (actionState!=ItemTouchHelper.ACTION_STATE_IDLE){
                    viewHolder.itemView.setBackgroundColor(Color.parseColor("#04BE02"));
                }
            }
            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        //关联recycleView
        itemTouchHelper.attachToRecyclerView(recyclerView);
        return view;
    }
}