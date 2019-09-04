package com.trello.api;

import com.trello.api.interceptors.TrelloAuthInterceptor;
import com.trello.api.services.BoardService;
import com.trello.api.services.ListServices;
import com.trello.api.services.CardsService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class TrelloRestClient {
    public static final String HOME_TO_BASE_URL = "https://api.trello.com/1/";

    public BoardService boardService;
    public ListServices listServices;
    public CardsService cardsService;

    public TrelloRestClient() {

        //init OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new TrelloAuthInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(HOME_TO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        boardService = retrofit.create(BoardService.class);
        listServices = retrofit.create(ListServices.class);
        cardsService = retrofit.create(CardsService.class);

    }
}