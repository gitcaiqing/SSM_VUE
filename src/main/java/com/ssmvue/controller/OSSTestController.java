/**
 * auth:CQ
 * date:2018/7/30 10:27
 **/
package com.ssmvue.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by CQ on 2018/7/30.
 */

public class OSSTestController {

    public static void main(String[] args) {
//
/*      aliyun_access_id=NalmDIbbDQxAn79P
aliyun_access_key=0v1SXv19H6Ldi0aBd6z4x2oiEEWl9u
aliyun_bucket_name=jht-file-quitest
aliyun_domain=oss-cn-hangzhou.aliyuncs.com
aliyun_out_domain=oss-cn-hangzhou.aliyuncs.com*/
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAIdQimhNgw2Uy8";
        String accessKeySecret = "0Zmhth5DExrr62Q9Ap6gbpBBKcKdO0";
        String bucketName = "cq-oss-test";
        String KeyPrefix = "/test1/product.jpg";
// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(bucketName, KeyPrefix);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (OSSObjectSummary s : sums) {
            System.out.println("\t 最后更新时间" + df.format(s.getLastModified())+"---->"+ s.getKey());
        }
// 关闭OSSClient。
        ossClient.shutdown();



       // String objectName = "test1/product.jpg";
        String objectName = "test1/";
// 创建OSSClient实例。
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 删除文件。
        ossClient.deleteObject(bucketName, objectName);
// 关闭OSSClient。
        ossClient.shutdown();

//        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//        // 删除文件。
//        List<String> keys = new ArrayList<String>();
//        keys.add("test1/test1-1/test1-1-2");
//        DeleteObjectsRequest deleteObjectsRequest = new DeleteObjectsRequest(bucketName);
//        deleteObjectsRequest.setKeys(keys);
//        deleteObjectsRequest.setQuiet(true);
//        DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(deleteObjectsRequest);
//        List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
//



       /* String a = "https://cq-oss-test.oss-cn-beijing.aliyuncs.com/test1/pro1.jpg?Expires=1533007261&OSSAccessKeyId=TMP.AQE1dvnfqWT-A2lcSo8OFzFUYO899NW37RJQVZ_YHTXAhfxBoWwRudc3P1_zADAtAhUAtHeOQBYb7lwfF45JTKBLot19g9QCFBpZNON93P2g9QiOoc6N0G99ABKg&Signature=jFI3v1GCuF2Yw2K%2FEHcSQ4oYChg%3D";

        String bucketAndEpid = a.split("//")[1].split("/")[0]; //cq-oss-test.oss-cn-beijing.aliyuncs.com

        String aliyun_bucket_name = bucketAndEpid.split("\\.")[0];
        System.out.println(aliyun_bucket_name);
        String aliyun_out_domain = a.split("//")[0]+"//"+bucketAndEpid.replaceAll(aliyun_bucket_name+"\\.", "");
        System.out.println(aliyun_out_domain);

        String objectName = a.split("\\?")[0].split(a.split("//")[1].split("/")[0])[1];
        objectName = objectName.substring(1, objectName.length());

        System.out.println(objectName);*/
    }
}