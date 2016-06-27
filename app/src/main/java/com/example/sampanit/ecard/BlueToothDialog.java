package com.example.sampanit.ecard;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by SampanIT on 21/06/2016.
 */
public class BlueToothDialog extends DialogFragment implements View.OnClickListener {
    Button yes, no;
    communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator = (communicator)activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blue_tooth_dialog, null);
        yes = (Button) view.findViewById(R.id.yes);
        no = (Button) view.findViewById(R.id.no);
        setCancelable(false);
        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.yes){
            dismiss();
        }
        else {
            dismiss();
        }
    }
    interface communicator{
        public void dialogActivity();
    }
}
