package com.fashion.webCrawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * @author zhaoht
 * @date 2016/11/11 22:24
 */
public class Controller {

    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "/data/crawl/root";
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();

        config.setCrawlStorageFolder(crawlStorageFolder);

        PageFetcher pageFetcher = new PageFetcher(config);

        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();

        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig,pageFetcher);

        CrawlController controller = new CrawlController(config,pageFetcher,robotstxtServer);

        controller.addSeed("http://www.baidu.com");

        controller.start(MyCrawler.class,numberOfCrawlers);

    }
}
