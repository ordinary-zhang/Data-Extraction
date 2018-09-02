package cn.zhangyu.DTO;

/**
 * Created by grace on 2018/9/2.
 */
public class ZResponseDTO<T> {
    //返回总条数
    private Long total;

    //返回结果
    private T data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

