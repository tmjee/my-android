package com.tmjee.android1;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 */
public class MainFragment extends ListFragment {

    private static final MyItem[] MY_ITEMS = new MyItem[] {
            new MyItem("Fragment")
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.listTitle);
        setListAdapter(new MyListAdapter(getActivity(), MY_ITEMS));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (1 == id) { // fragment example
            Intent intent = new Intent(getActivity(), HelloAndroidActivity.class);
            startActivity(intent);
        }
    }

    /////////// MyListAdapter

    private class MyListAdapter extends ArrayAdapter<MyItem> {
        public MyListAdapter(Context context, MyItem[] myItems) {
            super(context, android.R.layout.simple_list_item_1, myItems);
        }
    }




   //////////// MyItem

    private static class MyItem {
        public String name;

        private MyItem(String name) {
            this.name = name;
        }
    }
}
