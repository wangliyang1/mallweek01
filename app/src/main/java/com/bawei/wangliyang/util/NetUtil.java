package com.bawei.wangliyang.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtil {
    private static NetUtil netUtil = new NetUtil();

    private NetUtil() {
    }

    public static NetUtil getInstance() {
        return netUtil;
    }
    @SuppressLint("StaticFieldLeak")
    public void getJson(final String dizhi, final Callback callback){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                if (TextUtils.isEmpty(s)){
                    callback.onError(new Exception("接受失败"));
                }else {
                    callback.onGetJson(s);
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                InputStream inputStream = null;
                String s = "";
                try {
                    URL url = new URL(dizhi);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(5000);
                    urlConnection.connect();
                    if (urlConnection.getResponseCode()==200){
                        inputStream = urlConnection.getInputStream();
                        s = io2String(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return s;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }
    @SuppressLint("StaticFieldLeak")
    public void getPhono(final String dizhi, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                InputStream inputStream = null;
                Bitmap s = null;
                try {
                    URL url = new URL(dizhi);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(5000);
                    urlConnection.connect();
                    if (urlConnection.getResponseCode()==200){
                        inputStream = urlConnection.getInputStream();
                        s = io2Bitmap(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if (inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return s;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }
    public Bitmap io2Bitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }
    public String io2String(InputStream inputStream) throws IOException {
        int len = -1;
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String s = new String(bytes1);
        return s;
    }
    public interface Callback{
        void onGetJson(String s);
        void onError(Throwable throwable);
    }
    public boolean isWang(Context context){
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            return true;
        }else {
            return false;
        }
    }
}
