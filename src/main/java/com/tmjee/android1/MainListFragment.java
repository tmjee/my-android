package com.tmjee.android1;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 */
public class MainListFragment extends ListFragment {

    private static final MyItem[] MY_ITEMS = new MyItem[] {
            new MyItem("Activity with Fragment"),
            new MyItem("ViewPager"),
            new MyItem("DialogFragment"),
            new MyItem("Fragment2FragmentComm"),
            new MyItem("ActionBar")
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("dd", "Fragment on create");
    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }*/

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(R.string.listTitle);
        setListAdapter(new MyListAdapter(getActivity(), MY_ITEMS));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.e("dd", "***** id="+id+"  position="+position);
        if (0 == id) { // fragment example
            Intent intent = new Intent(getActivity(), HelloAndroidActivity.class);
            startActivity(intent);
        } else if (1 == id) { // view pager example
            Intent intent = new Intent(getActivity(), ViewPagerActivity.class);
            startActivity(intent);
        } else if (2 == id) { // dialog fragment
            Intent intent = new Intent(getActivity(), HelloDialogActivity.class);
            startActivity(intent);
        } else if (3 == id) { // fragment 2 fragment comm
            Intent intent = new Intent(getActivity(), FragmentToFragmentCommActivity.class);
            startActivity(intent);
        } else if (4 == id) { // action menu
            Intent intent = new Intent(getActivity(), ActionBarActivity.class);
            startActivity(intent);
        }
    }

    /////////// MyListAdapter

    private class MyListAdapter extends ArrayAdapter<MyItem> {
        public MyListAdapter(Context context, MyItem[] myItems) {
            super(context, android.R.layout.simple_list_item_1, myItems);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return super.getView(position, convertView, parent);
        }
    }




   //////////// MyItem

    private static class MyItem {
        public String name;

        private MyItem(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
