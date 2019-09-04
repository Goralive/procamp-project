package com.trello.ui.core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trello.api.CookieStorage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import okhttp3.Cookie;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Map;

import static com.trello.ui.core.Constants.URL;

public class BrowserFactory {

    private static WebDriver driver;
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    CookieStorage cookieStorage = new CookieStorage();
    OkHttpClient client = new OkHttpClient.Builder().cookieJar(cookieStorage).build();
    Gson gson = new Gson();


    @BeforeTest
    public void setUp() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
        driver().manage().window().maximize();
        log.info("Browser Start");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        log.info("Browser Closed");

    }

    public static WebDriver driver() {
        return driver;
    }

    public static void get(String url) {
        driver().get(url);
    }

    public static WebDriverWait getWebDriverWait(long timeout) {
        return new WebDriverWait(driver(), timeout);
    }

    protected void trelloApiLogin () throws IOException {

        //trello.com
        client.newCall(new Request.Builder().url(URL).build()).execute().body().string();
        //auth
        FormBody formData = new FormBody.Builder()
                .add("method","password")
                .add("factors[user]","l3438@yandex.ru")
                .add("factors[password]","QAZxsw123")
                .build();
        Request request = new Request.Builder().url(URL + "1/authentication").post(formData).build();
        String response = client.newCall(request).execute().body().string();
        log.info("Response after send authentication request {}" , response);
        Map<String, String> map = gson.fromJson(response, new TypeToken<Map<String, String>>(){}.getType());
        String code = map.get("code");
        log.info("Get a Code {}" , code);

        //session
        String dsc = cookieStorage.cookies.stream().filter(cookie -> cookie.name().equals("dsc")).findFirst().get().value();
        FormBody sessionFormData = new FormBody.Builder()
                .add("authentication", code)
                .add("dsc", dsc)
                .build();
        Request requestSession = new Request.Builder().url(URL + "1/authorization/session").post(sessionFormData).build();
        response = client.newCall(requestSession).execute().body().string();
        log.info("Response after adding to request authentication code and dsc: {}", response);

        //Selenium
        driver().get("https://trello.com");

        for (Cookie cookie : cookieStorage.cookies) {
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie(cookie.name(),cookie.value());
            driver().manage().addCookie(seleniumCookie);
            log.info("Add cookie: {}:{}" , cookie.name(),cookie.value());
        }

        driver().navigate().refresh();
    }
}
