package com.example.project32;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragment extends AppCompatDialogFragment {
    TextView textView;
    public MyDialogFragment(TextView _textView){
        textView = _textView;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выберите кота")
                .setItems(catNamesArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("Выбранный кот: " + catNamesArray[which]);
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }
}
