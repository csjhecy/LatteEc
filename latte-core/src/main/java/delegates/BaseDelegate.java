package delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public abstract class BaseDelegate extends SwipeBackFragment {

    private Unbinder bind;

    public abstract Object getLayout();

    public abstract void onBinder(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        if (getLayout() instanceof Integer){
            view = inflater.inflate((Integer) getLayout(), container, false);
        } else if (getLayout() instanceof View){
            view = (View) getLayout();
        }

        if (view!=null){
            bind = ButterKnife.bind(this, view);
            onBinder(inflater,container,savedInstanceState);
            return view;
        }
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onDestroy() {
        if (bind!=null){
            bind.unbind();
        }
        super.onDestroy();
    }
}
