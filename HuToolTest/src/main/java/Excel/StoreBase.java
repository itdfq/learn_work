package Excel;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: QianMo
 * @Date: 2021/9/14 17:13
 * @Description:
 */
@Data
public class StoreBase {
    @Alias("�ŵ�����")
    private String storeName;
    @Alias("һ����Ŀ")
    private String category;
    @Alias("������Ŀ")
    private String sonCategory;
    @Alias("���")
    private String specifications;
    @Alias("��Ʒ�۸�")
    private BigDecimal price;
}
