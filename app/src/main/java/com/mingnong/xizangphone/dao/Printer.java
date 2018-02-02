package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by wyw on 2016/10/31.
 * 打印机保存的数据
 */
//@Keep
//@Entity
public class Printer {

//    @Id(autoincrement = true)
//    private Long id;
    @Property(nameInDb = "PrinterNo")
    private String printerNo;
    @Property(nameInDb = "PrinterHao")
    private String printerHao;
    @Generated(hash = 791511843)
    public Printer(String printerNo, String printerHao) {
        this.printerNo = printerNo;
        this.printerHao = printerHao;
    }
    @Generated(hash = 206512902)
    public Printer() {
    }
    public String getPrinterNo() {
        return this.printerNo;
    }
    public void setPrinterNo(String printerNo) {
        this.printerNo = printerNo;
    }
    public String getPrinterHao() {
        return this.printerHao;
    }
    public void setPrinterHao(String printerHao) {
        this.printerHao = printerHao;
    }
}
