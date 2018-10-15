package www.csj.festec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import delegates.LatteDeletate;

public class ExampleDelegate extends LatteDeletate {

    public static ExampleDelegate newInstance() {
        ExampleDelegate f = new ExampleDelegate();
        Bundle args = new Bundle();
        f.setArguments(args);
        return f;
    }

    @Override
    public Object getLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBinder(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    }
}
