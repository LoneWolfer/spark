package com.luner;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class sparkZL {
    public static String getHtmlCode(String url, String encoding) {
        URL uri;
        URLConnection urlConnection;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bReader =null;
        StringBuffer sBuffer= new StringBuffer();

        try {
            // 建立网络连接
            uri = new URL(url);
            // 打开连接
            urlConnection = uri.openConnection();
            //输入流
            inputStream = urlConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, encoding);
            bReader = new BufferedReader(inputStreamReader);
            String temp;
            while ((temp = bReader.readLine()) != null) {
                sBuffer.append(temp + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            //关闭资源
            if(bReader!=null){
                try {
                    bReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sBuffer.toString();
    }
    public static List<HashMap<String, String>> analyzeHtml(String url, String encoding){
        String htmlCode = getHtmlCode(url, encoding);
        Document document = Jsoup.parse(htmlCode);
        Elements elements = document.getElementsByClass("newlist");
        List<HashMap<String, String>> list=new ArrayList<>();
        for (Element e : elements) {
            HashMap<String, String> map = new HashMap<>();
            String zwmc = e.getElementsByClass("zwmc").text();
            String gsmc = e.getElementsByClass("gsmc").text();
            String zwyx = e.getElementsByClass("zwyx").text();
            String gzdd = e.getElementsByClass("gzdd").text();
            String gxsj = e.getElementsByClass("gxsj").text();
            map.put("职位名称:", zwmc);
            map.put("公司名称", gsmc);
            map.put("职位月薪", zwyx);
            map.put("工作地点", gzdd);
            map.put("发布日期", gxsj);
            list.add(map);
        }
        return list;
    }
}
