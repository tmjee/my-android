package com.tmjee.android1;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by tmjee on 8/06/15.
 */
public class ActionBarFragment  extends Fragment {

    public static ActionBarFragment newInstance() {
        Bundle bundle = new Bundle();
        ActionBarFragment fragment = new ActionBarFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.action_bar_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_item_create: {
                Log.i("tag", "options item (create) clicked");
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
