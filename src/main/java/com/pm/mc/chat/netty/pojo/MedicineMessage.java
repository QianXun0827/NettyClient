package com.pm.mc.chat.netty.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author derekhehe@yahoo.com
 * @date Created in 2018/11/6 09:19
 * @description 医药箱信息类
 * @Modified By:
 */
@Getter
@Builder(toBuilder = true)
@ToString
public class MedicineMessage {
    public String state;
    public int status;
}
