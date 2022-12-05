package cn.itrip.dao;

import cn.itrip.pojo.ItripHotelVO;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.List;

public class BaseDao {
    public static String url="http://localhost:8080/solr/HoteCore";
    HttpSolrClient httpSolrClient;
    public BaseDao(){
        httpSolrClient = new HttpSolrClient(url);
        httpSolrClient.setParser(new XMLResponseParser()); // 设置响应解析器
        httpSolrClient.setConnectionTimeout(500); // 建立连接的最长时间
    }

    //分页获取酒店
    public Page<ItripHotelVO> getlist1(SolrQuery query,int index,int psize) throws SolrServerException, IOException {
        query.setStart((index-1)*10);
            //一页显示多少条
        query.setRows(10);
        QueryResponse queryResponse = null;
        queryResponse = httpSolrClient.query(query);
        List<ItripHotelVO> list=queryResponse.getBeans(ItripHotelVO.class);
        SolrDocumentList solrDocuments=((QueryResponse)queryResponse).getResults();

        Page page = new Page(index,psize,new Long(solrDocuments.getNumFound()).intValue());
        page.setRows(list);
        return page;
    }


    public List<ItripHotelVO> getlist(SolrQuery query) throws SolrServerException, IOException {
        QueryResponse queryResponse=null;
        queryResponse=httpSolrClient.query(query);
        List<ItripHotelVO> list=queryResponse.getBeans(ItripHotelVO.class);
        return list;
    }
}
