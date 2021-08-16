package Http;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 13:23
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class DownTest {
    public static void main(String[] args) {
        String fileUrl="http://mirrors.sohu.com/centos/8.4.2105/isos/x86_64/CentOS-8.4.2105-x86_64-dvd1.iso";
        //带进度显示的文件下载
//        HttpUtil.downloadFile(fileUrl, FileUtil.file("e:/"), new StreamProgress(){
//            @Override
//            public void start() {
//                Console.log("开始下载。。。。");
//            }
//
//            @Override
//            public void progress(long progressSize) {
//                Console.log("已下载：{},总大小：{}", FileUtil.readableFileSize(progressSize));
//            }
//
//            @Override
//            public void finish() {
//                Console.log("下载完成！");
//            }
//        });
        try {
            OutputStream outputStream = new FileOutputStream(FileUtil.file("e:/test.zip"));
            long download = HttpUtil.download(fileUrl, outputStream, true);
            System.out.println(download);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
