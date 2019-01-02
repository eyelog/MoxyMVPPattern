package ru.eyelog.moxymvppattern;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class FragmentDown extends MvpAppCompatFragment implements FragmentView {

    @InjectPresenter
    FragmentPresenter fragmentPresenter;

    Button btAdd, btUpdate, btDelete;
    EditText editText;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_up, null);
        btAdd = view.findViewById(R.id.id_btAdd);
        btUpdate = view.findViewById(R.id.id_btUpdate);
        btDelete = view.findViewById(R.id.id_btDelete);
        editText = view.findViewById(R.id.id_editText);
        textView = view.findViewById(R.id.id_textView);

        btAdd.setOnClickListener(v -> fragmentPresenter.createData(editText.getText().toString()));

        btUpdate.setOnClickListener(v -> fragmentPresenter.updateData());

        btDelete.setOnClickListener(v -> fragmentPresenter.deleteData());

        return view;
    }

    @Override
    public void setData(String data) {
        textView.setText(data);
    }
}
