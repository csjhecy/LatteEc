package app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * ┏┛ ┻━━━━━┛ ┻┓
 * ┃　　　　　　 ┃
 * ┃　　　━　　　┃
 * ┃　┳┛　  ┗┳　┃
 * ┃　　　　　　 ┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　 ┃
 * ┗━┓　　　┏━━━┛
 * ┃　　　┃   神兽保佑
 * ┃　　　┃   代码无BUG！
 * ┃　　　┗━━━━━━━━━┓
 * ┃　　　　　　　    ┣┓
 * ┃　　　　         ┏┛
 * ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
 * ┃ ┫ ┫   ┃ ┫ ┫
 * ┗━┻━┛   ┗━┻━┛
 *
 * @Description:  一些全局配置项
 * @author: ChenYuan by 10/12.
 */
public final class Latte {

    /**
     * 当调用 latte init方法时，就直接转到配置项里了
     * @param context
     * @return
     */
    public static Configuration init(Context context){
        getConfigurations().put(ConfigType.APP_CONTEXT.name(),context.getApplicationContext());
        return Configuration.getInstace();
    }

    public static final WeakHashMap getConfigurations(){
        return Configuration.getInstace().getLatteConfigs();
    }
}
