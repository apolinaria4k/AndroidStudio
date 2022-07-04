package com.example.project32;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragment3 extends AppCompatDialogFragment {
    TextView textView;
    public MyDialogFragment3(TextView _textView){
        textView = _textView;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};
        final boolean[] checkedItemsArray = {false, false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите котов")
                .setMultiChoiceItems(catNamesArray, checkedItemsArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkedItemsArray[which] = isChecked;
                            }
                        })
                .setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                StringBuilder state = new StringBuilder();
                                for (int i = 0; i < catNamesArray.length; i++) {
                                    state.append(catNamesArray[i]);
                                    if (checkedItemsArray[i])
                                        state.append(" выбран\n");
                                    else
                                        state.append(" не выбран\n");
                                }
                                textView.setText(state.toString());
                                dialog.dismiss();
                            }
                        })

                .setNegativeButton("Отмена",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.cancel();
                            }
                        });

        return builder.create();
    }
}
