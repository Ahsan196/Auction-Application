package com.aafs.hybrid.biddingapplication;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class ThirdWin extends AppCompatActivity {
    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView=findViewById(R.id.exp_listview);
        List<String> Headings=new ArrayList<String>();
        List<String> L1=new ArrayList<String>();
        List<String> L2=new ArrayList<String>();
        List<String> L3=new ArrayList<String>();
        List<String> L4=new ArrayList<String>();
        HashMap<String,List<String>> ChildList=new HashMap<String,List<String>>();
        String options[]=getResources().getStringArray(R.array.Options);
        String fisrt_sub_options[]=getResources().getStringArray(R.array.First_Sub_Options);
        String second_sub_options[]=getResources().getStringArray(R.array.Second_Sub_Options);
        String third_sub_options[]=getResources().getStringArray(R.array.Third_Sub_Options);
        String fourth_sub_options[]=getResources().getStringArray(R.array.Fourth_Sub_Options);
        for(String title:options)
    {
            Headings.add(title);
    }
        for(String title:fisrt_sub_options)
        {
            L1.add(title);
        }
        for(String title:second_sub_options)
        {
            L2.add(title);
        }
        for(String title:third_sub_options)
        {
            L3.add(title);
        }
        for(String title:fourth_sub_options)
        {
            L4.add(title);
        }
        ChildList.put(Headings.get(0),L1);
        ChildList.put(Headings.get(0),L2);
        ChildList.put(Headings.get(0),L3);
        ChildList.put(Headings.get(0),L4);
        Adapter adapter=new Adapter(this,Headings,ChildList);
        expandableListView.setAdapter(adapter);
    }
}
