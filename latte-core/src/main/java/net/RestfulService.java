package net;

import java.net.URLEncoder;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 各种请求的类型
 */
public interface RestfulService {
    /**
     * get
     */
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String,Object> params);

     /**
     * post
     */
     @FormUrlEncoded
     @POST
     Call<String> post(@Url String url, @FieldMap Map<String,Object> params);

     /**
     * put
     */
     @FormUrlEncoded
     @POST
     Call<String> put(@Url String url, @FieldMap Map<String,Object> params);

     /**
     * delete
     */
     @DELETE
     Call<String> delete(@Url String url, @QueryMap Map<String,Object> params);

     /**
     * download 下载
      *  默认情况下是一次性下载到内存里，这样很容易造成内存溢出。
      *  所有要加个 @streaming 注解，这样的话，边下载边加到内存里。 这样也要异步才行
     */
     @Streaming
     @GET
     Call<ResponseBody> download(@Url String url, @QueryMap Map<String,Object> params);

     /**
     * upload
      * 其实是post的一人变种
     */
     @Multipart
     @POST
     Call<String> upload(@Url String url, @Part MultipartBody.Part file);

}
