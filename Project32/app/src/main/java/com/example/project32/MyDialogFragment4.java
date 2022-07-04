package com.example.project32;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class MyDialogFragment4 extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] catNamesArray = {"Васька", "Рыжик", "Мурзик"};
        final boolean[] checkedItemsArray = {false, false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.person, null);
        builder.setView(view);
        EditText editText1 = view.findViewById(R.id.nameEdit);
        EditText editText2 = view.findViewById(R.id.ageEdit);
        Spinner spinner1 = view.findViewById(R.id.spinsex);
        Spinner spinner2 = view.findViewById(R.id.spinstatus);
        ArrayAdapter adapter1 = new ArrayAdapter<>(getActivity(), R.layout.spisok);
        adapter1.addAll(Sex.values());
        ArrayAdapter adapter2 = new ArrayAdapter<>(getActivity(), R.layout.spisok);
        adapter2.addAll(Status.values());
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner1.setSelection(0);
        spinner2.setSelection(0);
        builder.setTitle("Введите данные")
                .setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                ((Main)getActivity()).personokclicked(
                                        new Person(editText1.getText().toString(),
                                                Integer.valueOf(editText2.getText().toString()),
                                                Sex.valueOf(spinner1.getSelectedItemPosition()),
                                                Status.valueOf(spinner2.getSelectedItemPosition()))
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
