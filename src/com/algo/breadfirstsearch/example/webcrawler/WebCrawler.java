package com.algo.breadfirstsearch.example.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	Queue<String> queue = new LinkedList<>();
	List<String> discoverdWebsiteList = new ArrayList<String>();
	
	public void discoverWeb(String root){
		queue.add(root);
		discoverdWebsiteList.add(root);
		while(!queue.isEmpty()){
			String v = queue.remove();
			String rawHtml = readUrl(v);
			String regexp = "http://(\\w+\\.)*(\\w+)*";
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(rawHtml);
			while(matcher.find()){
				String actualUrl = matcher.group();
				if(!discoverdWebsiteList.contains(actualUrl)){
					discoverdWebsiteList.add(actualUrl);
					System.out.println("Website find " + actualUrl);
					queue.add(actualUrl);
				}
				
			}
		}
	}

	private String readUrl(String v) {
		String rawHtml = "";
		try {
			URL url = new URL(v);
		  BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line;
		    while ((line = in.readLine()) != null) {
		      rawHtml += line;
		    }
		    in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rawHtml;
	}	
}
