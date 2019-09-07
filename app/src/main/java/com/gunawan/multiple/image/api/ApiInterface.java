package com.gunawan.multiple.image.api;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {
    @Multipart
    @POST("Image_controller/addImage")
    Call<ResponseBody> addImage(@Part ArrayList<MultipartBody.Part> photo);
}
