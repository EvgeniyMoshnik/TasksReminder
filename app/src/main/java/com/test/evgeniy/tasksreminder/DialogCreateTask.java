package com.test.evgeniy.tasksreminder;


import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;


public class DialogCreateTask extends DialogFragment {
    String task;
    String timeBefore;
    String time;
    View v;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        dialog.setTitle(R.string.tittle_dialog)
                .setView(v = inflater.inflate(R.layout.fragment_dialog, null))
                .setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        task = ((EditText) v.findViewById(R.id.editText_dialogTask)).getText().toString();
                        timeBefore = ((EditText) v.findViewById(R.id.editText_dialogTime)).getText().toString();
                        time = ((EditText) v.findViewById(R.id.editText_dialogDate)).getText().toString();



                    }
                })
                .setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return dialog.create();
    }
}
