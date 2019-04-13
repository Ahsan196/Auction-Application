package com.aafs.hybrid.biddingapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Adapter extends BaseExpandableListAdapter {
    private List<String> options;
    private HashMap<String,List<String>> suboptions;
    private Context context;
    Adapter(Context context,List<String> options,HashMap<String,List<String>> suboptions)
    {
      this.context=context;
      this.options=options;
        this.suboptions=suboptions;
    }
    @Override
    public int getGroupCount() {
        return options.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return suboptions.get(options.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return options.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return suboptions.get(options.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
       String title=(String)this.getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.activity_third_win1,null);
        }
        TextView textView=(TextView)convertView.findViewById(R.id.headline_item);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title=(String)this.getChild(groupPosition,childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.child_layout,null);
        }
        TextView textView=(TextView)convertView.findViewById(R.id.child_item);

        textView.setText(title);
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
