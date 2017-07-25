package com.test.evgeniy.tasksreminder.Dialogs;


import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.test.evgeniy.tasksreminder.R;

import java.util.Calendar;


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
        View container = inflater.inflate(R.layout.fragment_dialog, null);

        TextInputLayout tilTitle = (TextInputLayout) container.findViewById(R.id.dialogTaskTitle);
        EditText etTitle = tilTitle.getEditText();

        TextInputLayout tilDate = (TextInputLayout) container.findViewById(R.id.dialogTaskDate);
        final EditText etDate = tilTitle.getEditText();

        TextInputLayout tilTime = (TextInputLayout) container.findViewById(R.id.dialogTaskTime);
        EditText etTime = tilTitle.getEditText();

        tilTitle.setHint(getResources().getString(R.string.task_title));
        tilDate.setHint(getResources().getString(R.string.task_date));
        tilTime.setHint(getResources().getString(R.string.task_time));


        dialog.setTitle(R.string.tittle_dialog)
                .setView(container)
                .setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                      //  task = ((EditText) v.findViewById(R.id.editText_dialogTask)).getText().toString();
                    //    timeBefore = ((EditText) v.findViewById(R.id.editText_dialogTime)).getText().toString();
                      //  time = ((EditText) v.findViewById(R.id.editText_dialogDate)).getText().toString();




                    }
                })
                .setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePickerFragment = new DatePickerFragment() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar dateCalendar = Calendar.getInstance();
                        dateCalendar.set(year, month, dayOfMonth);
                        etDate.setText();
                    }
                };
            }
        });
        return dialog.create();
    }
}
