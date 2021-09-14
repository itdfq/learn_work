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
    @Alias("门店名称")
    private String storeName;
    @Alias("一级类目")
    private String category;
    @Alias("二级类目")
    private String sonCategory;
    @Alias("规格")
    private String specifications;
    @Alias("商品价格")
    private BigDecimal price;
}
