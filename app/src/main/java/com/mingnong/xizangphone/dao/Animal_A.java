package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * 动物A证 离线使用
 * @author pc1
 *
 */
@SuppressWarnings("serial")
@Entity(nameInDb = "AnimalA")
public class Animal_A implements Serializable {
    private static final long serialVersionUID = -2798317154871234563L;
    @org.greenrobot.greendao.annotation.Id(autoincrement = true)
    private Long tId;
    private String zt;
    @Property(nameInDb = "id")
    private String Id;			//动物A证编号
    private int glid;			//票证打印
    private String Shipper;		//货主
    private String Shipper_phone;		//货主手机
    private String animal_species;		//动物种类
    private String animal_species1;		//动物种类1
    private String animal_species2;		//动物种类2
    private String PQuantity;			//数量
    private String input_PDanWei;		//单位
    private String Province;			//启运省
    private String City;				//启运市
    private String County;				//启运县
    private String Town;				//启运乡
    private String Village;				//村
    private String Input_market;		//启运种类
    private String Province1;			//到达省
    private String City1;			//到达市
    private String County1;			//到达县
    private String Town1;			//到达镇
    private String Village1;		//村
    private String Input_market1;		//到达种类
    private String Usage;			//用途
    private String Carrier;			//承运人
    private String Carrier_phone;			//承运人电话
    public String QDWYunZai; // / 运载方式
    private String Highway;			// 公路
    private String Railway;			 //铁路
    private String Waterway;		//水路
    private String Aviation; 		//航空
    private String Vehicle_mark;		//运载工具牌号
    private String Disinfect;			//消毒
    private String ETA;			//有效日
    private String Year;		//年
    private String Month;		 //月
    private String Date;		//日
    private String DateQF;		//签发日期
    private String Beast_id;		 //耳标号
    private String gfsy;
    private String Remark;			//备注
    private String Supervise_Telephone;			//动物卫生电话
    private String IsPrant;		//状态
    private String FSmemo1;
    private String FSmemo2;		//出厂编号
    private String FSmemo3;		//机器码
    private String AVeterinary;		//官方兽医签字
    private String FSm5;        //图片
    public Animal_A() {
        super();
    }


    @Generated(hash = 1058089058)
    public Animal_A(Long tId, String zt, String Id, int glid, String Shipper,
            String Shipper_phone, String animal_species, String animal_species1,
            String animal_species2, String PQuantity, String input_PDanWei,
            String Province, String City, String County, String Town,
            String Village, String Input_market, String Province1, String City1,
            String County1, String Town1, String Village1, String Input_market1,
            String Usage, String Carrier, String Carrier_phone, String QDWYunZai,
            String Highway, String Railway, String Waterway, String Aviation,
            String Vehicle_mark, String Disinfect, String ETA, String Year,
            String Month, String Date, String DateQF, String Beast_id, String gfsy,
            String Remark, String Supervise_Telephone, String IsPrant,
            String FSmemo1, String FSmemo2, String FSmemo3, String AVeterinary,
            String FSm5) {
        this.tId = tId;
        this.zt = zt;
        this.Id = Id;
        this.glid = glid;
        this.Shipper = Shipper;
        this.Shipper_phone = Shipper_phone;
        this.animal_species = animal_species;
        this.animal_species1 = animal_species1;
        this.animal_species2 = animal_species2;
        this.PQuantity = PQuantity;
        this.input_PDanWei = input_PDanWei;
        this.Province = Province;
        this.City = City;
        this.County = County;
        this.Town = Town;
        this.Village = Village;
        this.Input_market = Input_market;
        this.Province1 = Province1;
        this.City1 = City1;
        this.County1 = County1;
        this.Town1 = Town1;
        this.Village1 = Village1;
        this.Input_market1 = Input_market1;
        this.Usage = Usage;
        this.Carrier = Carrier;
        this.Carrier_phone = Carrier_phone;
        this.QDWYunZai = QDWYunZai;
        this.Highway = Highway;
        this.Railway = Railway;
        this.Waterway = Waterway;
        this.Aviation = Aviation;
        this.Vehicle_mark = Vehicle_mark;
        this.Disinfect = Disinfect;
        this.ETA = ETA;
        this.Year = Year;
        this.Month = Month;
        this.Date = Date;
        this.DateQF = DateQF;
        this.Beast_id = Beast_id;
        this.gfsy = gfsy;
        this.Remark = Remark;
        this.Supervise_Telephone = Supervise_Telephone;
        this.IsPrant = IsPrant;
        this.FSmemo1 = FSmemo1;
        this.FSmemo2 = FSmemo2;
        this.FSmemo3 = FSmemo3;
        this.AVeterinary = AVeterinary;
        this.FSm5 = FSm5;
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

    public String getAnimal_species() {
        return animal_species;
    }

    public void setAnimal_species(String animal_species) {
        this.animal_species = animal_species;
    }

    public String getAnimal_species1() {
        return animal_species1;
    }

    public void setAnimal_species1(String animal_species1) {
        this.animal_species1 = animal_species1;
    }

    public String getAnimal_species2() {
        return animal_species2;
    }

    public void setAnimal_species2(String animal_species2) {
        this.animal_species2 = animal_species2;
    }

    public String getPQuantity() {
        return PQuantity;
    }

    public void setPQuantity(String PQuantity) {
        this.PQuantity = PQuantity;
    }

    public String getInput_PDanWei() {
        return input_PDanWei;
    }

    public void setInput_PDanWei(String input_PDanWei) {
        this.input_PDanWei = input_PDanWei;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
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

    public String getVillage() {
        return Village;
    }

    public void setVillage(String village) {
        Village = village;
    }

    public String getInput_market() {
        return Input_market;
    }

    public void setInput_market(String input_market) {
        Input_market = input_market;
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

    public String getTown1() {
        return Town1;
    }

    public void setTown1(String town1) {
        Town1 = town1;
    }

    public String getVillage1() {
        return Village1;
    }

    public void setVillage1(String village1) {
        Village1 = village1;
    }

    public String getInput_market1() {
        return Input_market1;
    }

    public void setInput_market1(String input_market1) {
        Input_market1 = input_market1;
    }

    public String getUsage() {
        return Usage;
    }

    public void setUsage(String usage) {
        Usage = usage;
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

    public String getQDWYunZai() {
        return QDWYunZai;
    }

    public void setQDWYunZai(String QDWYunZai) {
        this.QDWYunZai = QDWYunZai;
    }

    public String getHighway() {
        return Highway;
    }

    public void setHighway(String highway) {
        Highway = highway;
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

    public void setETA(String ETA) {
        this.ETA = ETA;
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

    public String getBeast_id() {
        return Beast_id;
    }

    public void setBeast_id(String beast_id) {
        Beast_id = beast_id;
    }

    public String getGfsy() {
        return gfsy;
    }

    public void setGfsy(String gfsy) {
        this.gfsy = gfsy;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getSupervise_Telephone() {
        return Supervise_Telephone;
    }

    public void setSupervise_Telephone(String supervise_Telephone) {
        Supervise_Telephone = supervise_Telephone;
    }

    public String getIsPrant() {
        return IsPrant;
    }

    public void setIsPrant(String isPrant) {
        IsPrant = isPrant;
    }

    public String getFSmemo1() {
        return FSmemo1;
    }

    public void setFSmemo1(String FSmemo1) {
        this.FSmemo1 = FSmemo1;
    }

    public String getFSmemo2() {
        return FSmemo2;
    }

    public void setFSmemo2(String FSmemo2) {
        this.FSmemo2 = FSmemo2;
    }

    public String getFSmemo3() {
        return FSmemo3;
    }

    public void setFSmemo3(String FSmemo3) {
        this.FSmemo3 = FSmemo3;
    }

    public String getAVeterinary() {
        return AVeterinary;
    }

    public void setAVeterinary(String AVeterinary) {
        this.AVeterinary = AVeterinary;
    }

    public String getFSm5() {
        return FSm5;
    }

    public void setFSm5(String FSm5) {
        this.FSm5 = FSm5;
    }




    public Long getTId() {
        return this.tId;
    }


    public void setTId(Long tId) {
        this.tId = tId;
    }
}