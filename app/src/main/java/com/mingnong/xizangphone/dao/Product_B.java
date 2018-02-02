package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * 产品B 离线使用
 */
@SuppressWarnings("serial")
@Entity(nameInDb = "ProductB")
public class Product_B implements Serializable {
	private static final long serialVersionUID = -2798317112345634593L;
	@org.greenrobot.greendao.annotation.Id(autoincrement = true)
	private Long tId;
	public int glid; //票证打印
	@Property(nameInDb = "id")
	public String Id; // 检疫证号
	public String Shipper; // 货主
	public String Product_name; // / 产品名称
	public String Product_name1;
	public String Product_name2;
	public String Product_name3; // / 产品名称
	public String PQuantity; // / 数量单位
	public String PQuantityDW; // / 单位
	public String CD; // / 产地
	public String SCDWMC; // 生产单位名称
	public String DZ; // / 地址
	public String MDD; // 目的地
	public String JYBZH; // 检疫标志号
	public String Remark; // / 备注
	public String DateQF; // / 签发日期
	public String TZGFSYQZ; // / 官方兽医签字
	public String zt; // 状态
	public String FSmemo1;
	private String FSmemo2;		//出厂编号
	private String FSmemo3;		//机器码
	public Product_B() {
		super();
	}
	@Generated(hash = 1139592683)
	public Product_B(Long tId, int glid, String Id, String Shipper,
									String Product_name, String Product_name1, String Product_name2,
									String Product_name3, String PQuantity, String PQuantityDW, String CD,
									String SCDWMC, String DZ, String MDD, String JYBZH, String Remark,
									String DateQF, String TZGFSYQZ, String zt, String FSmemo1,
									String FSmemo2, String FSmemo3) {
					this.tId = tId;
					this.glid = glid;
					this.Id = Id;
					this.Shipper = Shipper;
					this.Product_name = Product_name;
					this.Product_name1 = Product_name1;
					this.Product_name2 = Product_name2;
					this.Product_name3 = Product_name3;
					this.PQuantity = PQuantity;
					this.PQuantityDW = PQuantityDW;
					this.CD = CD;
					this.SCDWMC = SCDWMC;
					this.DZ = DZ;
					this.MDD = MDD;
					this.JYBZH = JYBZH;
					this.Remark = Remark;
					this.DateQF = DateQF;
					this.TZGFSYQZ = TZGFSYQZ;
					this.zt = zt;
					this.FSmemo1 = FSmemo1;
					this.FSmemo2 = FSmemo2;
					this.FSmemo3 = FSmemo3;
	}
	public int getGlid() {
		return glid;
	}
	public void setGlid(int glid) {
		this.glid = glid;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getShipper() {
		return Shipper;
	}
	public void setShipper(String shipper) {
		Shipper = shipper;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getProduct_name1() {
		return Product_name1;
	}
	public void setProduct_name1(String product_name1) {
		Product_name1 = product_name1;
	}
	public String getProduct_name2() {
		return Product_name2;
	}
	public void setProduct_name2(String product_name2) {
		Product_name2 = product_name2;
	}
	public String getProduct_name3() {
		return Product_name3;
	}
	public void setProduct_name3(String product_name3) {
		Product_name3 = product_name3;
	}
	public String getPQuantity() {
		return PQuantity;
	}
	public void setPQuantity(String pQuantity) {
		PQuantity = pQuantity;
	}
	public String getPQuantityDW() {
		return PQuantityDW;
	}
	public void setPQuantityDW(String pQuantityDW) {
		PQuantityDW = pQuantityDW;
	}
	public String getCD() {
		return CD;
	}
	public void setCD(String cD) {
		CD = cD;
	}
	public String getSCDWMC() {
		return SCDWMC;
	}
	public void setSCDWMC(String sCDWMC) {
		SCDWMC = sCDWMC;
	}
	public String getDZ() {
		return DZ;
	}
	public void setDZ(String dZ) {
		DZ = dZ;
	}
	public String getMDD() {
		return MDD;
	}
	public void setMDD(String mDD) {
		MDD = mDD;
	}
	public String getJYBZH() {
		return JYBZH;
	}
	public void setJYBZH(String jYBZH) {
		JYBZH = jYBZH;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getDateQF() {
		return DateQF;
	}
	public void setDateQF(String dateQF) {
		DateQF = dateQF;
	}
	public String getTZGFSYQZ() {
		return TZGFSYQZ;
	}
	public void setTZGFSYQZ(String tZGFSYQZ) {
		TZGFSYQZ = tZGFSYQZ;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getFSmemo1() {
		return FSmemo1;
	}
	public void setFSmemo1(String fSmemo1) {
		FSmemo1 = fSmemo1;
	}
	public String getFSmemo2() {
		return FSmemo2;
	}
	public void setFSmemo2(String fSmemo2) {
		FSmemo2 = fSmemo2;
	}
	public String getFSmemo3() {
		return FSmemo3;
	}
	public void setFSmemo3(String fSmemo3) {
		FSmemo3 = fSmemo3;
	}
	public Long getTId() {
					return this.tId;
	}
	public void setTId(Long tId) {
					this.tId = tId;
	}
	
	
}
