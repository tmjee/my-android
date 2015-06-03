package com.tmjee.android1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by tmjee on 30/05/15.
 */
public class HelloDialogFragment extends DialogFragment {
    public static interface HelloDialogFragmentListener {
        void onDateChange(Date date);
    }

    private List<HelloDialogFragmentListener> listeners = new ArrayList<>();

    public static HelloDialogFragment newInstance() {
        Bundle bundle = new Bundle();
        HelloDialogFragment fragment = new HelloDialogFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public void addListener(HelloDialogFragmentListener listener) {
        listeners.add(listener);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DatePicker datePicker = (DatePicker) getActivity().getLayoutInflater().inflate(R.layout.date_picker, null, false);
        Calendar calendar = Calendar.getInstance();
        datePicker.init(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.YEAR, year);
                        final Date date = calendar.getTime();
                        for (HelloDialogFragmentListener listener : listeners) {
                            listener.onDateChange(date);
                        }

                        //listeners.forEach((l)->l.onDateChange(date));
                    }
                });


        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.alertDialogTitle)
                .setView(datePicker)
                //.setMessage(R.string.alertDialogMessage)
                .setPositiveButton(R.string.alertDialogPositiveButton,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("tmjee", "Dialog positive button clicked");
                            }
                        })
                .setNeutralButton(R.string.alertDialogNeutralButton,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("tmjee", "Dialog neutral button clicked");
                            }
                        })
                .setNegativeButton(R.string.alertDialogNegativeButton,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("tmjee", "Dialog negative button clicked");
                            }
                        }
                )
                .setCancelable(true)
                .create();
    }
}
