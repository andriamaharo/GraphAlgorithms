package com.algo.breadfirstsearch.example.webcrawler;

public class Main {

	public static void main(String[] args) {
		WebCrawler crawler = new WebCrawler();
		String root = "http://www.bbc.com";
        crawler.discoverWeb(root);
	}

}
