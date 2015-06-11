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
public class ActionBarAnotherFragment  extends Fragment {

    public static ActionBarAnotherFragment newInstance() {
        Bundle bundle = new Bundle();
        ActionBarAnotherFragment actionBarAnotherFragment = new ActionBarAnotherFragment();
        actionBarAnotherFragment.setArguments(bundle);
        return actionBarAnotherFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        setHasOptionsMenu(true);
        inflater.inflate(R.menu.action_bar_another_fragment_menu, menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_item_delete:
                Log.i("tag", "Delete menu options item clicked");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
