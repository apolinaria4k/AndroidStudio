package com.example.project32;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragment2 extends AppCompatDialogFragment {
    TextView textView;
    int choose;
    public MyDialogFragment2(TextView _textView){
        textView = _textView;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите любимое имя кота")
                .setSingleChoiceItems(catNamesArray, -1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item) {
                                choose = item;
                            }
                        })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        textView.setText("Любимое имя кота: " + catNamesArray[choose]);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }
}
