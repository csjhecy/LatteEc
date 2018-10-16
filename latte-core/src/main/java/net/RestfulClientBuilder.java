package net;

import net.callback.IError;
import net.callback.IFailer;
import net.callback.IRequest;
import net.callback.ISuccess;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestfulClientBuilder {
    private String mUrl;
    private IError mError;
    private ISuccess mSuccess;
    private IRequest mRequest;
    private IFailer mFailer;
    private RequestBody mRequestBody;
    private static WeakHashMap<String,Object> PARAMS = RestCreator.getParams() ;

    RestfulClientBuilder(){}

    public final RestfulClientBuilder url(String url){
        mUrl = url;
        return this;
    }

    public final RestfulClientBuilder params(Map<String,Object> params){
        PARAMS.putAll(params);
        return this;
    }

     public final RestfulClientBuilder params(String key,Object value){
         PARAMS.put(key,value);
        return this;
    }

    public final RestfulClientBuilder raw(String raw){
        mRequestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return  this;
    }

    public RestfulClientBuilder error(IError mError) {
        this.mError = mError;
        return  this;
    }

    public RestfulClientBuilder success(ISuccess mSuccess) {
        this.mSuccess = mSuccess;
        return  this;
    }

    public RestfulClientBuilder request(IRequest mRequest) {
        this.mRequest = mRequest;
        return  this;
    }

    public RestfulClientBuilder failer(IFailer mFailer) {
        this.mFailer = mFailer;
        return  this;
    }

    public final RestfulClient build(){
        return  new RestfulClient(this.mUrl,
                this.mError,
                this.mSuccess,
                this.mRequest,
                this.mFailer,
                this.mRequestBody,
                PARAMS);
    }
}
