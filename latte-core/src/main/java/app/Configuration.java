package app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 *  配置项  单例
 */
public class Configuration {
    private static final WeakHashMap<String,Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configuration(){
        LATTE_CONFIGS.put(ConfigType.APP_CONFIG_READY.name(),false);
    }

    private static class Holder{
        private static final Configuration INSTANCE = new Configuration();
    }

    public static Configuration getInstace(){
        return Holder.INSTANCE;
    }

    /**
     * 这个告诉我们 配置好了
     */
    public final void config(){
        LATTE_CONFIGS.put(ConfigType.APP_CONFIG_READY.name(),true);
    }

    public final WeakHashMap getLatteConfigs(){
        return  LATTE_CONFIGS;
    }

    //设置apiHost
    public final Configuration withApiHost(String apiHost){
        LATTE_CONFIGS.put(ConfigType.APP_HOST.name(),apiHost);
        return this;
    }

    /**
     * 什么时候检测呢，当然是拿配置项的时候检测一下，
     * 如果没有调用  config（）方法就会报错
     */
    public final void checkReadyConfig(){
        boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.APP_CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Don't set config");
        }
    }

    /**
     * 获取配置项
     * @param key
     * @param <T>
     * @return
     */
    public final <T> T getConfig(Enum<ConfigType> key){
        checkReadyConfig();  //这个是检查是否调用 config 关键字
        return (T) getLatteConfigs().get(key);
    }
}
