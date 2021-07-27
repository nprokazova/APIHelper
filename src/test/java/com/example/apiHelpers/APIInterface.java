package com.example.apiHelpers;

import com.example.apiHelpers.pojo.*;
import retrofit2.Call;
import retrofit2.http.*;

public interface APIInterface {
    @GET("2")
    Call<User> getUser();

    @POST("users")
    Call<CreateUserResponse> createUser(@Body CreateUserRequest body);

    @PUT("users")
    Call<UpdateUserResponse> updateUser(@Body UpdateUserRequest body);

    @PATCH("users")
    Call<UpdateUserResponse> updateUserByPatch(@Body UpdateUserRequest body);

    @GET("2")
    Call<Resource> getResource();
}
