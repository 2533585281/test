package com.wzb.douyin;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.*;


/**
 * 获取抖音数据
 *
 * @author
 */
public class CrawlerDouYin {


    public static void main(String[] args) throws IOException {

        long maxCousor=0;
        boolean hasMore=true;
        //String url="https://www.iesdouyin.com/web/api/v2/aweme/post/?sec_uid=MS4wLjABAAAAiCzlnajEt9aDiXNtxAXxVSd6FCgZiwiV_pYXjt2VWX1qk_-HuP6lfxtKaJqYqYXK&type_flag=p";
        //String url="https://www.iesdouyin.com/web/api/v2/aweme/post/?user_id=&sec_uid=MS4wLjABAAAA_yq-vLM3V2wpPsp4dHvq3F_fw-Z_KwTbiyAsCqK6bQI&count=21&max_cursor=0&aid=1128&uid=85441903025&_signature=ZJ8uSAAABenF9gn7Y2PYdGSfLl&dytk=";
        // 只需更改 sec_uid     可用的sec_uid   MS4wLjABAAAAshzXgVS8HqF8PomFlCATZjkjC48Az0d8tk28RXRgrbA  MS4wLjABAAAA_yq-vLM3V2wpPsp4dHvq3F_fw-Z_KwTbiyAsCqK6bQI
        List<Map<String,Object>> douYinVideos=new ArrayList<>();
        while (hasMore){
            //分页获取用户作品列表
            String url="https://www.iesdouyin.com/web/api/v2/aweme/post/?user_id=&sec_uid=MS4wLjABAAAAshzXgVS8HqF8PomFlCATZjkjC48Az0d8tk28RXRgrbA&count=36&max_cursor="+maxCousor+"&aid=1128&uid=85441903025&_signature=ZJ8uSAAABenF9gn7Y2PYdGSfLl&dytk=";
            String json = HttpUtil.get(url);
            JSONObject jsonObject = JSONObject.parseObject(json);

            JSONObject res = JSONObject.parseObject(String.valueOf(jsonObject));
            //获取max_cursor最大值
            maxCousor =Long.parseLong(res.getString("max_cursor"));
            hasMore = (boolean) res.get("has_more");
            System.out.println(hasMore);
            String aweme_list =res.getString("aweme_list");
            List<String> list = Arrays.asList(aweme_list.split(","));
            List<String>  title=new ArrayList<>();
            List<String>  vid=new ArrayList<>();
            for (int i=0;i<list.size();i++){

                String a = list.get(i);

                //获取标题
                if(a.contains("\"desc\":\"\"")){
                    //标题为空
                    title.add(String.valueOf(i));
                }else if(a.contains("desc")){
                    String substring = a.substring(8, a.lastIndexOf("\""));
                    title.add(substring);
                }

                //获取无水印视频地址
                if(a.contains("play_addr\":{\"url_list\":")){
                    String substring = a.substring(26,a.lastIndexOf("\""));
                    if(substring!=null && substring!=""){
                        vid.add(substring);
                    }
                }
            }


            if(title.size()==vid.size()){
                Map<String,Object> map=new HashMap<>(16);
                int size = title.size();
                List slist=new ArrayList();
                for (int i = 0; i < size; i++) {
                    map.put(title.get(i),vid.get(i));
                }
                slist.add(map);
                douYinVideos.addAll(slist);
            }

        }
        System.out.println("视频集合------------"+douYinVideos);
        System.out.println("视频共有"+douYinVideos.size()+"页");

        System.out.println("开始下载--------------------");
        for(int i=0;i<douYinVideos.size();i++){
            System.out.println("正在下载第"+(i+1)+"页视频");
            Map<String,String> m=(Map)douYinVideos.get(i);
            m.forEach((key, value) -> {
                try {
                    IoUtil.download(value,"E://douyinvid/"+key+".mp4");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("下载完成");

    }

}
