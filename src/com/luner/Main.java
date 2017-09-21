package com.luner;

import java.util.HashMap;
import java.util.List;

import static com.luner.sparkZL.analyzeHtml;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<HashMap<String, String>> resultList = analyzeHtml("http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E4%B8%8A%E6%B5%B7&kw=java&sm=0&p=1", "UTF-8");
        System.out.println(resultList);
    }
}
