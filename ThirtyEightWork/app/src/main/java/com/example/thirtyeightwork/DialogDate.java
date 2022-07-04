package com.example.thirtyeightwork;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogDate extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};
        final boolean[] checkedItemsArray = {false, false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.date, null);
        DatePicker datePicker = view.findViewById(R.id.mydatePicker);
        builder.setView(view);
        builder.setTitle("Выберите дату")
                .setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                ((Main)getActivity()).dateokclicked(
                                        datePicker.getYear(),
                                        datePicker.getMonth(),
                                        datePicker.getDayOfMonth()
                                );
                                dialog.dismiss();
                            }
                        })
                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        return builder.create();
    }
}
