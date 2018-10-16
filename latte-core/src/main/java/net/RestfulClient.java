package net;

import net.callback.IError;
import net.callback.IFailer;
import net.callback.IRequest;
import net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.http.Url;

/**
 * 网络请求的
 */
public class RestfulClient {
     private final String URL;
     private final IError ERROR;
     private final ISuccess SUCCESS;
     private final IRequest REQUEST;
     private final IFailer FAILER;
     private final RequestBody REQUEST_BODY;
     private static WeakHashMap<String,Object> PARAMS;

    public RestfulClient(String url,
                         IError error,
                         ISuccess success,
                         IRequest request,
                         IFailer failer,
                         RequestBody request_body,
                         WeakHashMap<String,Object> params) {
        this.URL = url;
        this.ERROR = error;
        this.SUCCESS = success;
        this.REQUEST = request;
        this.FAILER = failer;
        this.REQUEST_BODY = request_body;
        PARAMS = params;
    }

    public static  RestfulClientBuilder builder(){
        return new RestfulClientBuilder();
    }

}
