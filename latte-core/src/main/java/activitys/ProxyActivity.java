package activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import delegates.LatteDeletate;
import me.yokeyword.fragmentation.SupportActivity;
import www.csj.latte_core.R;

/**
 * 这个仅仅做为一个容器
 */
public abstract class ProxyActivity extends SupportActivity {
     public abstract LatteDeletate setRootDelegate();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContanner(savedInstanceState);
    }

    @SuppressLint("RestrictedApi")
    public void initContanner(@Nullable Bundle savedInstanceState){
        ContentFrameLayout contentLayout = new ContentFrameLayout(this);
        contentLayout.setId(R.id.delegate_containner);
        setContentView(contentLayout);
        if (savedInstanceState == null){
           loadRootFragment(R.id.delegate_containner,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
