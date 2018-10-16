package net;

import java.nio.file.StandardWatchEventKinds;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import app.ConfigType;
import app.Latte;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestCreator {

    private RestCreator(){

    }

    private static final class WeakHashMapHolder{
        private static final WeakHashMap<String,Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String,Object> getParams(){
        return WeakHashMapHolder.PARAMS;
    }

    //创建 retrofit
    private static final class RetrofitHolder{
        private static final String BASE_URL = (String) Latte.getConfigurations().get(ConfigType.APP_HOST.name());
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkhttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }
    //ok_http
    private static final class OkhttpHolder{
        private static final int CONNECT_TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT,TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder{
        private static final RestfulService RESTFUL_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestfulService.class);
    }

    public static RestfulService getRestFulService(){
        return RestServiceHolder.RESTFUL_SERVICE;
    }

}
