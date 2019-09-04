package com.trello.api.services;


import com.trello.api.models.Card;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;


public interface CardsService {

    @POST("cards")
    Call<Card> createCard(@Query("idList") String idList, @Body Card card);

    @GET("cards/{id}")
    Call<Card> getCard(@Path("id") String id);

    @DELETE("cards/{id}")
    Call<ResponseBody> deleteCard(@Path("id") String id);

    @GET("user")
    Call<Card> getUserDetails(@Header("Authorization") String credentials);

    @POST("/cards/{id}/checklists")
    Call<Card> createChecklists(@Path("id") String id, @Query("name") String name);

}
