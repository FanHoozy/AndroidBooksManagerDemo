package com.example.booksmanagerdemo11.service;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkService {

    private static Bitmap bitmap;

    /**
     * 获取网络图片
     *
     * @param imgUrlStr
     * @return
     */
    public static Bitmap getBitmap(String imgUrlStr) {
        try {
            // 访问网络
//            String imgUrlStr = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605593660437&di=cf1be37d68ca063ebe4515416c39453b&imgtype=0&src=http%3A%2F%2Fimg.yzcdn.cn%2Fupload_files%2F2017%2F07%2F17%2FFs2OZ0ygEeaDMIaD_m4d_GYuu2E0.jpg%2521730x0.jpg";
            URL url = new URL(imgUrlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(3000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.connect();
            // 判断连接的状态
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
//                                StringBuffer sb = new StringBuffer();
                InputStream inputStream = conn.getInputStream();

                bitmap = BitmapFactory.decodeStream(inputStream);
//                                byte[] bs = new byte[1024 * 1024 * 10];
//                                int len = 0;
//                                while ((len = inputStream.read(bs)) != -1) {
//                                    sb.append()
//                                }
            }
            conn.disconnect(); // 关闭连接

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private static final String TAG = "NetworkService";
    /**
     * 获取网络上的数据
     * @param urlStr
     * @return
     */
    public static String getJsonString(String urlStr) {
//        urlStr = "https://api.douban.com/v2/music/search?q=%E5%91%A8%E6%9D%B0%E4%BC%A6&count=20";
        Log.e(TAG, "getString: urlStr" + urlStr);
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(3000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.connect();
            // 判断连接的状态
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream in = conn.getInputStream();
                byte[] bs = new byte[1024 * 1024 * 10];
                int len = 0;
                while ((len = in.read(bs)) != -1) {
                    sb.append(new String(bs, 0, len));
                }
            }
            conn.disconnect(); // 关闭连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
