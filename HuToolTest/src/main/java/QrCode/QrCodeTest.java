package QrCode;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 11:16
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 二维码生成
 */
public class QrCodeTest {
    public static void main(String[] args) {
        // 生成指定url对应的二维码到文件，宽和高都是300像素
        QrCodeUtil.generate("https://itdfq.com/", 300, 300, FileUtil.file("E:/qrcode.jpg"));
    }
}
