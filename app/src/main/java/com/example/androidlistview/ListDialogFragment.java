package com.example.androidlistview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ListDialogFragment extends android.app.DialogFragment {

    static ListDialogFragment newInstance(String title, String message, String from) {
        ListDialogFragment listDialogFragment = new ListDialogFragment();

        Bundle args = new Bundle();

        args.putString("title", title);
        args.putString("message", message);
        args.putString("from", from);

        listDialogFragment.setArguments(args);

        return listDialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String title = getArguments().getString("title");
        String message = getArguments().getString("message");
        String from = getArguments().getString("from");

        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.dialoglist_layout, null);

        if (from.equals("item_add")) {
            return new AlertDialog.Builder(getActivity())
                    .setView(dialogView)
                    .setIcon(R.mipmap.ic_launcher)
                    .setTitle(title)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            EditText valueView = (EditText) dialogView.findViewById(R.id.list_view_item);
                            String valueText = valueView.getText().toString();
                            ((MainActivity)getActivity()).doPositiveClick(valueText);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ((MainActivity)getActivity()).doNegativeClick();
                        }
                    }).create();
        } else {
            return new AlertDialog.Builder(getActivity())
                    .setIcon(R.mipmap.ic_launcher)
                    .setTitle(title)
                    .setMessage(message)
                    .setNeutralButton("OK", null).create();
        }
    }
}
