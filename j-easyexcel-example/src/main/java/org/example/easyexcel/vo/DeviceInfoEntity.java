package org.example.easyexcel.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: DeviceInfoEntity
 * Description:
 *
 * @author Yuliang Lau
 * @date 2024/8/7 15:58
 */
@Getter
@Setter
public class DeviceInfoEntity {
    //总用电量
    private Double total;
    //    IT设备用电量
    private Double it;
    //    空气调节设备用电量
    private Double air;
//    配电及附属设备用电量

    private Double distribution;


    //总用电量
    private String totalName = "总用电量";
    //    IT设备用电量
    private String itName = "IT设备用电量";
    //    空气调节设备用电量
    private String airName = "空气调节设备用电量";
    //    配电及附属设备用电量
    private String distributionName = "配电及附属设备用电量";
}
