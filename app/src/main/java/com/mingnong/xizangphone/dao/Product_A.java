package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * 产品A  离线使用
 */
@SuppressWarnings("serial")
@Entity(nameInDb = "ProductA")
public class Product_A implements Serializable {
	private static final long serialVersionUID = -2798311234568934593L;
	@org.greenrobot.greendao.annotation.Id(autoincrement = true)
	private Long tId;
	private String zt;//状态
	@Property(nameInDb = "id")
	private String Id;//编号
	public int glid;		//票证打印
	private String Shipper;  	//货主
	private String Shipper_phone;		//货主手机
	private String Product_name;		//产品种类
	private String Product_name1;		//产品种类1
	private String Product_name2;		//产品种类2
	private String Product_name3;	//产品种类3
	private String PQuantity;			//数量
	private String input_PDanWei;	//单位
	private String TZGFSYQZ;		// 生产单位名称地址
	private String Province;
	private String PUnitName;
	private String City;
	private String County;
	private String Town;
	private String Town1;
	private String Province1;		//到达省
	private String City1;			//到达市
	private String County1;			//到达县
	private String Carrier;			//承运人
	private String Carrier_phone; 		//承运人电话
	private String Highway;		// 公路
	private String FSmemo1;
	private String Railway;
	private String Waterway;
	private String Aviation;			//航空
	private String QCPYunZai;			//运载方式
	private String Vehicle_mark;			//运载工具牌号
	private String Disinfect;			//消毒
	private String ETA;			//有效日
	private String Year;
	private String Month;
	private String Date;
	private String DateQF;			//签发日期
	private String Remark;			//备注
	private String PVeterinary; 	//官方兽医
	private String Supervise_Telephone;			//动物卫生电话
	private String NameDZ;
	private String IsPrant;
	private String FSmemo2;		//出厂编号
	private String FSmemo3;		//机器码
	public Product_A() {
		super();
	}
	@Generated(hash = 2012065764)
	public Product_A(Long tId, String zt, String Id, int glid, String Shipper,
									String Shipper_phone, String Product_name, String Product_name1,
									String Product_name2, String Product_name3, String PQuantity,
									String input_PDanWei, String TZGFSYQZ, String Province,
									String PUnitName, String City, String County, String Town, String Town1,
									String Province1, String City1, String County1, String Carrier,
									String Carrier_phone, String Highway, String FSmemo1, String Railway,
									String Waterway, String Aviation, String QCPYunZai, String Vehicle_mark,
									String Disinfect, String ETA, String Year, String Month, String Date,
									String DateQF, String Remark, String PVeterinary,
									String Supervise_Telephone, String NameDZ, String IsPrant,
									String FSmemo2, String FSmemo3) {
					this.tId = tId;
					this.zt = zt;
					this.Id = Id;
					this.glid = glid;
					this.Shipper = Shipper;
					this.Shipper_phone = Shipper_phone;
					this.Product_name = Product_name;
					this.Product_name1 = Product_name1;
					this.Product_name2 = Product_name2;
					this.Product_name3 = Product_name3;
					this.PQuantity = PQuantity;
					this.input_PDanWei = input_PDanWei;
					this.TZGFSYQZ = TZGFSYQZ;
					this.Province = Province;
					this.PUnitName = PUnitName;
					this.City = City;
					this.County = County;
					this.Town = Town;
					this.Town1 = Town1;
					this.Province1 = Province1;
					this.City1 = City1;
					this.County1 = County1;
					this.Carrier = Carrier;
					this.Carrier_phone = Carrier_phone;
					this.Highway = Highway;
					this.FSmemo1 = FSmemo1;
					this.Railway = Railway;
					this.Waterway = Waterway;
					this.Aviation = Aviation;
					this.QCPYunZai = QCPYunZai;
					this.Vehicle_mark = Vehicle_mark;
					this.Disinfect = Disinfect;
					this.ETA = ETA;
					this.Year = Year;
					this.Month = Month;
					this.Date = Date;
					this.DateQF = DateQF;
					this.Remark = Remark;
					this.PVeterinary = PVeterinary;
					this.Supervise_Telephone = Supervise_Telephone;
					this.NameDZ = NameDZ;
					this.IsPrant = IsPrant;
					this.FSmemo2 = FSmemo2;
					this.FSmemo3 = FSmemo3;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public int getGlid() {
		return glid;
	}
	public void setGlid(int glid) {
		this.glid = glid;
	}
	public String getShipper() {
		return Shipper;
	}
	public void setShipper(String shipper) {
		Shipper = shipper;
	}
	public String getShipper_phone() {
		return Shipper_phone;
	}
	public void setShipper_phone(String shipper_phone) {
		Shipper_phone = shipper_phone;
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
	public String getInput_PDanWei() {
		return input_PDanWei;
	}
	public void setInput_PDanWei(String input_PDanWei) {
		this.input_PDanWei = input_PDanWei;
	}
	public String getTZGFSYQZ() {
		return TZGFSYQZ;
	}
	public void setTZGFSYQZ(String tZGFSYQZ) {
		TZGFSYQZ = tZGFSYQZ;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getPUnitName() {
		return PUnitName;
	}
	public void setPUnitName(String pUnitName) {
		PUnitName = pUnitName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCounty() {
		return County;
	}
	public void setCounty(String county) {
		County = county;
	}
	public String getTown() {
		return Town;
	}
	public void setTown(String town) {
		Town = town;
	}
	public String getTown1() {
		return Town1;
	}
	public void setTown1(String town1) {
		Town1 = town1;
	}
	public String getProvince1() {
		return Province1;
	}
	public void setProvince1(String province1) {
		Province1 = province1;
	}
	public String getCity1() {
		return City1;
	}
	public void setCity1(String city1) {
		City1 = city1;
	}
	public String getCounty1() {
		return County1;
	}
	public void setCounty1(String county1) {
		County1 = county1;
	}
	public String getCarrier() {
		return Carrier;
	}
	public void setCarrier(String carrier) {
		Carrier = carrier;
	}
	public String getCarrier_phone() {
		return Carrier_phone;
	}
	public void setCarrier_phone(String carrier_phone) {
		Carrier_phone = carrier_phone;
	}
	public String getHighway() {
		return Highway;
	}
	public void setHighway(String highway) {
		Highway = highway;
	}
	public String getFSmemo1() {
		return FSmemo1;
	}
	public void setFSmemo1(String fSmemo1) {
		FSmemo1 = fSmemo1;
	}
	public String getRailway() {
		return Railway;
	}
	public void setRailway(String railway) {
		Railway = railway;
	}
	public String getWaterway() {
		return Waterway;
	}
	public void setWaterway(String waterway) {
		Waterway = waterway;
	}
	public String getAviation() {
		return Aviation;
	}
	public void setAviation(String aviation) {
		Aviation = aviation;
	}
	public String getQCPYunZai() {
		return QCPYunZai;
	}
	public void setQCPYunZai(String qCPYunZai) {
		QCPYunZai = qCPYunZai;
	}
	public String getVehicle_mark() {
		return Vehicle_mark;
	}
	public void setVehicle_mark(String vehicle_mark) {
		Vehicle_mark = vehicle_mark;
	}
	public String getDisinfect() {
		return Disinfect;
	}
	public void setDisinfect(String disinfect) {
		Disinfect = disinfect;
	}
	public String getETA() {
		return ETA;
	}
	public void setETA(String eTA) {
		ETA = eTA;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getDateQF() {
		return DateQF;
	}
	public void setDateQF(String dateQF) {
		DateQF = dateQF;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getPVeterinary() {
		return PVeterinary;
	}
	public void setPVeterinary(String pVeterinary) {
		PVeterinary = pVeterinary;
	}
	public String getSupervise_Telephone() {
		return Supervise_Telephone;
	}
	public void setSupervise_Telephone(String supervise_Telephone) {
		Supervise_Telephone = supervise_Telephone;
	}
	public String getNameDZ() {
		return NameDZ;
	}
	public void setNameDZ(String nameDZ) {
		NameDZ = nameDZ;
	}
	public String getIsPrant() {
		return IsPrant;
	}
	public void setIsPrant(String isPrant) {
		IsPrant = isPrant;
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
	
	

