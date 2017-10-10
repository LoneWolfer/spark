package com.luner;

import java.util.HashMap;
import java.util.List;

import static com.luner.sparkZL.analyzeHtml;

public class Main {

    public static void main(String[] args) {
	// write your code here
        for (int i = 1; ; i++) {
            List<HashMap<String, String>> resultList = analyzeHtml("http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E6%9D%AD%E5%B7%9E&kw=java%E5%AE%9E%E4%B9%A0%E7%94%9F&sm=0&isadv=0&sg=8125b58d7cb046daa72f67bc08b5819f&p=" + i, "UTF-8");
            if (resultList.size() == 1){
                break;
            }else {
                System.out.println(resultList);
            }
        }
    }
}
