package www.csj.festec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.RestCreator;
import net.RestfulClient;
import net.callback.IError;
import net.callback.IFailer;
import net.callback.ISuccess;

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

    public void test() {
        RestfulClient.builder()
                .url("www.http.com")
                .params(null)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess() {

                    }
                })
                .failer(new IFailer() {
                    @Override
                    public void onFailer() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError() {

                    }
                }).build();

    }
}
