package com.example.goddragonfish.customdialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.goddragonfish.customdialogdemo.Adapter.MyAdapter;
import com.example.goddragonfish.customdialogdemo.Entity.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonTop;
    private Button buttonLeft;
    private Button buttonRight;
    private Button buttonBottom;
    private Button buttonCenter;
    private Button buttonFullScreen;
    private View view;
    private CustomDialog.Builder builder;
    private List<Item> il=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTop=findViewById(R.id.btnTop);
        buttonLeft=findViewById(R.id.btnLeft);
        buttonRight=findViewById(R.id.btnRight);
        buttonCenter=findViewById(R.id.btnCenter);
        buttonBottom=findViewById(R.id.btnBottom);
        buttonFullScreen=findViewById(R.id.btnFullScreen);
        view=getLayoutInflater().inflate(R.layout.dialog,null);
        Button btnDelete=view.findViewById(R.id.delete);
        RecyclerView recyclerView=view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        for (int i = 0; i < 6; i++) {
            Item it=new Item();
            it.setTextView(Integer.toString(i));
            il.add(it);
        }
        final MyAdapter adapter=new MyAdapter(il);
        recyclerView.setAdapter(adapter);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator<Item> itemIterator=il.iterator();
                if (itemIterator.hasNext()){
                    Item item=itemIterator.next();
                    itemIterator.remove();
                }
                adapter.notifyDataSetChanged();
            }
        });

        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(builder==null){
                    builder=new CustomDialog.Builder(MainActivity.this);
                    builder.setStyle(R.style.myDialogStyle)
                            .setAnim(R.style.myDialogTopAnim)
                            .setPosition(Gravity.TOP)
                            .setWidthOrHeight(WindowManager.LayoutParams.MATCH_PARENT, 300)
                            .setCustomView(view);
                }
                builder.create();

            }
        });

//        buttonLeft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View view=getLayoutInflater().inflate(R.layout.dialog,null);
//                RecyclerView recyclerView=view.findViewById(R.id.recycler);
//                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
//                recyclerView.setLayoutManager(linearLayoutManager);
//                for (int i = 0; i < 6; i++) {
//                    Item it=new Item();
//                    it.setTextView(Integer.toString(i));
//                    il.add(it);
//                }
//                MyAdapter adapter=new MyAdapter(il);
//                recyclerView.setAdapter(adapter);
//                CustomDialog.Builder builder=new CustomDialog.Builder(MainActivity.this);
//                builder.setStyle(R.style.myDialogStyle)
//                        .setAnim(R.style.myDialogLeftAnim)
//                        .setPosition(Gravity.LEFT)
//                        .setWidthOrHeight(300, WindowManager.LayoutParams.MATCH_PARENT)
//                        .setCustomView(view).create();
//
//            }
//        });
//
//        buttonRight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View view=getLayoutInflater().inflate(R.layout.dialog,null);
//                RecyclerView recyclerView=view.findViewById(R.id.recycler);
//                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
//                recyclerView.setLayoutManager(linearLayoutManager);
//                for (int i = 0; i < 6; i++) {
//                    Item it=new Item();
//                    it.setTextView(Integer.toString(i));
//                    il.add(it);
//                }
//                MyAdapter adapter=new MyAdapter(il);
//                recyclerView.setAdapter(adapter);
//                CustomDialog.Builder builder=new CustomDialog.Builder(MainActivity.this);
//                builder.setStyle(R.style.myDialogStyle)
//                        .setAnim(R.style.myDialogRightAnim)
//                        .setPosition(Gravity.RIGHT)
//                        .setWidthOrHeight(300, WindowManager.LayoutParams.MATCH_PARENT)
//                        .setCustomView(view).create();
//
//            }
//        });
//
//        buttonBottom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View view=getLayoutInflater().inflate(R.layout.dialog,null);
//                RecyclerView recyclerView=view.findViewById(R.id.recycler);
//                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
//                recyclerView.setLayoutManager(linearLayoutManager);
//                for (int i = 0; i < 6; i++) {
//                    Item it=new Item();
//                    it.setTextView(Integer.toString(i));
//                    il.add(it);
//                }
//                MyAdapter adapter=new MyAdapter(il);
//                recyclerView.setAdapter(adapter);
//                CustomDialog.Builder builder=new CustomDialog.Builder(MainActivity.this);
//                builder.setStyle(R.style.myDialogStyle)
//                        .setAnim(R.style.myDialogBottomAnim)
//                        .setPosition(Gravity.TOP)
//                        .setWidthOrHeight(WindowManager.LayoutParams.MATCH_PARENT, 300)
//                        .setCustomView(view).create();
//
//            }
//        });
//
//        buttonCenter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View view=getLayoutInflater().inflate(R.layout.dialog,null);
//                RecyclerView recyclerView=view.findViewById(R.id.recycler);
//                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
//                recyclerView.setLayoutManager(linearLayoutManager);
//                for (int i = 0; i < 6; i++) {
//                    Item it=new Item();
//                    it.setTextView(Integer.toString(i));
//                    il.add(it);
//                }
//                MyAdapter adapter=new MyAdapter(il);
//                recyclerView.setAdapter(adapter);
//                CustomDialog.Builder builder=new CustomDialog.Builder(MainActivity.this);
//                builder.setStyle(R.style.myDialogStyle)
//                        //.setAnim(R.style.myDialogAnim)
//                        .setPosition(Gravity.CENTER)
//                        .setWidthOrHeight(300, 300)
//                        .setCustomView(view).create();
//
//            }
//        });
//
//        buttonFullScreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View view=getLayoutInflater().inflate(R.layout.dialog,null);
//                RecyclerView recyclerView=view.findViewById(R.id.recycler);
//                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
//                recyclerView.setLayoutManager(linearLayoutManager);
//                for (int i = 0; i < 6; i++) {
//                    Item it=new Item();
//                    it.setTextView(Integer.toString(i));
//                    il.add(it);
//                }
//                MyAdapter adapter=new MyAdapter(il);
//                recyclerView.setAdapter(adapter);
//                CustomDialog.Builder builder=new CustomDialog.Builder(MainActivity.this);
//                builder.setStyle(R.style.myDialogStyle)
//                        //.setAnim(R.style.myDialogAnim)
//                        //.setPosition(Gravity.TOP)
//                        .setWidthOrHeight(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
//                        .setCustomView(view).create();
//
//            }
//        });


    }


}
