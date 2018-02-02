package com.mingnong.xizangphone.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * 动物申报单 动物申报 实体类 处理实体类  离线使用
 * @author pc1
 *
 */
@Entity(nameInDb = "AnimalApplyBean")
public class AnimalApplyBean implements Serializable {
	private static final long serialVersionUID = -2798317154878934593L;
	@Id(autoincrement = true)
	private Long id;
	public String FStId = "-2";	//FSTId
	public String QDWType; // / 区分（省内动物申报/出省动物申报）
	public String QDWNumber; // / 申报单编号
	public String QDWCargoOwner; // / 货主
	public String QDWPhone; // / 电话
	public String QDWXuZhong; // / 畜种
	public String QDWXuZhongOne; // / 畜种【1】
	public String QDWXuZhongTwo; // / 畜种【2】
	public int QDWQuantity; // / 数量
	public String FSmemo1;
	public String QDWDanWei; // / 单位
	public String QDWYongTu; // / 用途
	public String QDWLaiYuan; // / 来源
	public String QDWShengQy; // / 省【起运地】
	public String QDWShiQy; // / 市【起运地】
	public String QDWXianQy; // / 县【起运地】
	public String QDWXiangQy; // 乡镇【起运地】
	public String QDWCunQy; // / 村【起运地】
	public String QDWTypeQy; // / 养殖场、交易市场、散养户【起运地】
	public String QDAddQy; // / 起运地
	public String QDWShengDd; // 省【到达地】
	public String QDWShiDd; // / 市【到达地】
	public String QDWXianDd; // / 县【到达地】
	public String QDWXsqDd; // / 县/市/区【到达地】
	public String QDWXiangDd; // / 乡镇【到达地】
	public String QDWCunDd; // / 村【到达地】
	public String QDWTypeDd; // / 养殖场、屠宰场、交易市场、散养户【到达地】
	public String QDWAddDd; // / 到达地
	public String QDWChengYunRen; // / 承运人
	public String QDWCyrDianHua; // / 承运人联系电话
	public String QDWYunZai; // / 运载方式
	public String QDWTrademark; // / 运载工具牌号
	public String QDWDisinfection; // / 装运前经XX消毒
	public String QDWErBiaoHao; // / 牲畜耳标号
	public String DateQF;		//申报时间
	public String DateQy;	//启运时间
	public String FSm5;		//来源的人工，和合法捕获
	
	public String Highway;		//公路
	public String Railway; //铁路
	public String Waterway; 	//水路
	public String Aviation; //航空
	
	public String QDWAccepted;	// 申报处理结果
	public String QDWAddress;	/// 检疫地点
	public String QDWLiYou;		/// 不受理理由
	public String QDWAttn;		// 官方兽医
	public String QDWJBRDianHua;	// 官方兽医联系电话
	public String DateNpy;		// 检疫时间
	public String DateJL;			/// 记录日期
	public String QResults;		// 检疫结果
	public String QRemarks;		// 备注
	public int QLMSNumber;	// 头数【瘦肉精抽检情况】
	public int QCHYin;	// 盐酸克伦特罗-阴性数【瘦肉精抽检情况】
	public int QCHYang;		// 盐酸克伦特罗-阳性数【瘦肉精抽检情况】
	public int QPayleanYin;			// 莱克多巴胺-阴性数【瘦肉精抽检情况】
	public int QPayleanYang;		// 莱克多巴胺-阳性数【瘦肉精抽检情况】
	public int QsalbutamolYin;		// 沙丁胺醇-阴性数【瘦肉精抽检情况】
	public int QsalbutamolYang;		// 沙丁胺醇-阳性数【瘦肉精抽检情况】
	public Double FLongitude;		//经度
	public Double FLatitude;		//纬度
	public String FLName;			//动物监督所的名称
	public String GPSunitUstrId;    //动物监督所的ＩＤ
	public String IsPrant;			//状态
	public String FSuserName;       //申报人姓名

	public String getFSuserName() {
		return FSuserName;
	}

	public void setFSuserName(String FSuserName) {
		this.FSuserName = FSuserName;
	}

	public AnimalApplyBean() {
		super();
	}

	@Generated(hash = 26304983)
	public AnimalApplyBean(Long id, String FStId, String QDWType, String QDWNumber,
									String QDWCargoOwner, String QDWPhone, String QDWXuZhong,
									String QDWXuZhongOne, String QDWXuZhongTwo, int QDWQuantity,
									String FSmemo1, String QDWDanWei, String QDWYongTu, String QDWLaiYuan,
									String QDWShengQy, String QDWShiQy, String QDWXianQy, String QDWXiangQy,
									String QDWCunQy, String QDWTypeQy, String QDAddQy, String QDWShengDd,
									String QDWShiDd, String QDWXianDd, String QDWXsqDd, String QDWXiangDd,
									String QDWCunDd, String QDWTypeDd, String QDWAddDd,
									String QDWChengYunRen, String QDWCyrDianHua, String QDWYunZai,
									String QDWTrademark, String QDWDisinfection, String QDWErBiaoHao,
									String DateQF, String DateQy, String FSm5, String Highway,
									String Railway, String Waterway, String Aviation, String QDWAccepted,
									String QDWAddress, String QDWLiYou, String QDWAttn,
									String QDWJBRDianHua, String DateNpy, String DateJL, String QResults,
									String QRemarks, int QLMSNumber, int QCHYin, int QCHYang,
									int QPayleanYin, int QPayleanYang, int QsalbutamolYin,
									int QsalbutamolYang, Double FLongitude, Double FLatitude, String FLName,
									String GPSunitUstrId, String IsPrant, String FSuserName) {
					this.id = id;
					this.FStId = FStId;
					this.QDWType = QDWType;
					this.QDWNumber = QDWNumber;
					this.QDWCargoOwner = QDWCargoOwner;
					this.QDWPhone = QDWPhone;
					this.QDWXuZhong = QDWXuZhong;
					this.QDWXuZhongOne = QDWXuZhongOne;
					this.QDWXuZhongTwo = QDWXuZhongTwo;
					this.QDWQuantity = QDWQuantity;
					this.FSmemo1 = FSmemo1;
					this.QDWDanWei = QDWDanWei;
					this.QDWYongTu = QDWYongTu;
					this.QDWLaiYuan = QDWLaiYuan;
					this.QDWShengQy = QDWShengQy;
					this.QDWShiQy = QDWShiQy;
					this.QDWXianQy = QDWXianQy;
					this.QDWXiangQy = QDWXiangQy;
					this.QDWCunQy = QDWCunQy;
					this.QDWTypeQy = QDWTypeQy;
					this.QDAddQy = QDAddQy;
					this.QDWShengDd = QDWShengDd;
					this.QDWShiDd = QDWShiDd;
					this.QDWXianDd = QDWXianDd;
					this.QDWXsqDd = QDWXsqDd;
					this.QDWXiangDd = QDWXiangDd;
					this.QDWCunDd = QDWCunDd;
					this.QDWTypeDd = QDWTypeDd;
					this.QDWAddDd = QDWAddDd;
					this.QDWChengYunRen = QDWChengYunRen;
					this.QDWCyrDianHua = QDWCyrDianHua;
					this.QDWYunZai = QDWYunZai;
					this.QDWTrademark = QDWTrademark;
					this.QDWDisinfection = QDWDisinfection;
					this.QDWErBiaoHao = QDWErBiaoHao;
					this.DateQF = DateQF;
					this.DateQy = DateQy;
					this.FSm5 = FSm5;
					this.Highway = Highway;
					this.Railway = Railway;
					this.Waterway = Waterway;
					this.Aviation = Aviation;
					this.QDWAccepted = QDWAccepted;
					this.QDWAddress = QDWAddress;
					this.QDWLiYou = QDWLiYou;
					this.QDWAttn = QDWAttn;
					this.QDWJBRDianHua = QDWJBRDianHua;
					this.DateNpy = DateNpy;
					this.DateJL = DateJL;
					this.QResults = QResults;
					this.QRemarks = QRemarks;
					this.QLMSNumber = QLMSNumber;
					this.QCHYin = QCHYin;
					this.QCHYang = QCHYang;
					this.QPayleanYin = QPayleanYin;
					this.QPayleanYang = QPayleanYang;
					this.QsalbutamolYin = QsalbutamolYin;
					this.QsalbutamolYang = QsalbutamolYang;
					this.FLongitude = FLongitude;
					this.FLatitude = FLatitude;
					this.FLName = FLName;
					this.GPSunitUstrId = GPSunitUstrId;
					this.IsPrant = IsPrant;
					this.FSuserName = FSuserName;
	}



	public String getFStId() {
		return FStId;
	}

	public void setFStId(String FStId) {
		this.FStId = FStId;
	}

	public String getQDWType() {
		return QDWType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setQDWType(String QDWType) {
		this.QDWType = QDWType;
	}

	public String getQDWNumber() {
		return QDWNumber;
	}

	public void setQDWNumber(String QDWNumber) {
		this.QDWNumber = QDWNumber;
	}

	public String getQDWCargoOwner() {
		return QDWCargoOwner;
	}

	public void setQDWCargoOwner(String QDWCargoOwner) {
		this.QDWCargoOwner = QDWCargoOwner;
	}

	public String getQDWPhone() {
		return QDWPhone;
	}

	public void setQDWPhone(String QDWPhone) {
		this.QDWPhone = QDWPhone;
	}

	public String getQDWXuZhong() {
		return QDWXuZhong;
	}

	public void setQDWXuZhong(String QDWXuZhong) {
		this.QDWXuZhong = QDWXuZhong;
	}

	public String getQDWXuZhongOne() {
		return QDWXuZhongOne;
	}

	public void setQDWXuZhongOne(String QDWXuZhongOne) {
		this.QDWXuZhongOne = QDWXuZhongOne;
	}

	public String getQDWXuZhongTwo() {
		return QDWXuZhongTwo;
	}

	public void setQDWXuZhongTwo(String QDWXuZhongTwo) {
		this.QDWXuZhongTwo = QDWXuZhongTwo;
	}

	public int getQDWQuantity() {
		return QDWQuantity;
	}

	public void setQDWQuantity(int QDWQuantity) {
		this.QDWQuantity = QDWQuantity;
	}

	public String getFSmemo1() {
		return FSmemo1;
	}

	public void setFSmemo1(String FSmemo1) {
		this.FSmemo1 = FSmemo1;
	}

	public String getQDWDanWei() {
		return QDWDanWei;
	}

	public void setQDWDanWei(String QDWDanWei) {
		this.QDWDanWei = QDWDanWei;
	}

	public String getQDWYongTu() {
		return QDWYongTu;
	}

	public void setQDWYongTu(String QDWYongTu) {
		this.QDWYongTu = QDWYongTu;
	}

	public String getQDWLaiYuan() {
		return QDWLaiYuan;
	}

	public void setQDWLaiYuan(String QDWLaiYuan) {
		this.QDWLaiYuan = QDWLaiYuan;
	}

	public String getQDWShengQy() {
		return QDWShengQy;
	}

	public void setQDWShengQy(String QDWShengQy) {
		this.QDWShengQy = QDWShengQy;
	}

	public String getQDWShiQy() {
		return QDWShiQy;
	}

	public void setQDWShiQy(String QDWShiQy) {
		this.QDWShiQy = QDWShiQy;
	}

	public String getQDWXianQy() {
		return QDWXianQy;
	}

	public void setQDWXianQy(String QDWXianQy) {
		this.QDWXianQy = QDWXianQy;
	}

	public String getQDWXiangQy() {
		return QDWXiangQy;
	}

	public void setQDWXiangQy(String QDWXiangQy) {
		this.QDWXiangQy = QDWXiangQy;
	}

	public String getQDWCunQy() {
		return QDWCunQy;
	}

	public void setQDWCunQy(String QDWCunQy) {
		this.QDWCunQy = QDWCunQy;
	}

	public String getQDWTypeQy() {
		return QDWTypeQy;
	}

	public void setQDWTypeQy(String QDWTypeQy) {
		this.QDWTypeQy = QDWTypeQy;
	}

	public String getQDAddQy() {
		return QDAddQy;
	}

	public void setQDAddQy(String QDAddQy) {
		this.QDAddQy = QDAddQy;
	}

	public String getQDWShengDd() {
		return QDWShengDd;
	}

	public void setQDWShengDd(String QDWShengDd) {
		this.QDWShengDd = QDWShengDd;
	}

	public String getQDWShiDd() {
		return QDWShiDd;
	}

	public void setQDWShiDd(String QDWShiDd) {
		this.QDWShiDd = QDWShiDd;
	}

	public String getQDWXianDd() {
		return QDWXianDd;
	}

	public void setQDWXianDd(String QDWXianDd) {
		this.QDWXianDd = QDWXianDd;
	}

	public String getQDWXsqDd() {
		return QDWXsqDd;
	}

	public void setQDWXsqDd(String QDWXsqDd) {
		this.QDWXsqDd = QDWXsqDd;
	}

	public String getQDWXiangDd() {
		return QDWXiangDd;
	}

	public void setQDWXiangDd(String QDWXiangDd) {
		this.QDWXiangDd = QDWXiangDd;
	}

	public String getQDWCunDd() {
		return QDWCunDd;
	}

	public void setQDWCunDd(String QDWCunDd) {
		this.QDWCunDd = QDWCunDd;
	}

	public String getQDWTypeDd() {
		return QDWTypeDd;
	}

	public void setQDWTypeDd(String QDWTypeDd) {
		this.QDWTypeDd = QDWTypeDd;
	}

	public String getQDWAddDd() {
		return QDWAddDd;
	}

	public void setQDWAddDd(String QDWAddDd) {
		this.QDWAddDd = QDWAddDd;
	}

	public String getQDWChengYunRen() {
		return QDWChengYunRen;
	}

	public void setQDWChengYunRen(String QDWChengYunRen) {
		this.QDWChengYunRen = QDWChengYunRen;
	}

	public String getQDWCyrDianHua() {
		return QDWCyrDianHua;
	}

	public void setQDWCyrDianHua(String QDWCyrDianHua) {
		this.QDWCyrDianHua = QDWCyrDianHua;
	}

	public String getQDWYunZai() {
		return QDWYunZai;
	}

	public void setQDWYunZai(String QDWYunZai) {
		this.QDWYunZai = QDWYunZai;
	}

	public String getQDWTrademark() {
		return QDWTrademark;
	}

	public void setQDWTrademark(String QDWTrademark) {
		this.QDWTrademark = QDWTrademark;
	}

	public String getQDWDisinfection() {
		return QDWDisinfection;
	}

	public void setQDWDisinfection(String QDWDisinfection) {
		this.QDWDisinfection = QDWDisinfection;
	}

	public String getQDWErBiaoHao() {
		return QDWErBiaoHao;
	}

	public void setQDWErBiaoHao(String QDWErBiaoHao) {
		this.QDWErBiaoHao = QDWErBiaoHao;
	}

	public String getDateQF() {
		return DateQF;
	}

	public void setDateQF(String dateQF) {
		DateQF = dateQF;
	}

	public String getDateQy() {
		return DateQy;
	}

	public void setDateQy(String dateQy) {
		DateQy = dateQy;
	}

	public String getFSm5() {
		return FSm5;
	}

	public void setFSm5(String FSm5) {
		this.FSm5 = FSm5;
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

	public String getQDWAccepted() {
		return QDWAccepted;
	}

	public void setQDWAccepted(String QDWAccepted) {
		this.QDWAccepted = QDWAccepted;
	}

	public String getQDWAddress() {
		return QDWAddress;
	}

	public void setQDWAddress(String QDWAddress) {
		this.QDWAddress = QDWAddress;
	}

	public String getQDWLiYou() {
		return QDWLiYou;
	}

	public void setQDWLiYou(String QDWLiYou) {
		this.QDWLiYou = QDWLiYou;
	}

	public String getQDWAttn() {
		return QDWAttn;
	}

	public void setQDWAttn(String QDWAttn) {
		this.QDWAttn = QDWAttn;
	}

	public String getQDWJBRDianHua() {
		return QDWJBRDianHua;
	}

	public void setQDWJBRDianHua(String QDWJBRDianHua) {
		this.QDWJBRDianHua = QDWJBRDianHua;
	}

	public String getDateNpy() {
		return DateNpy;
	}

	public void setDateNpy(String dateNpy) {
		DateNpy = dateNpy;
	}

	public String getDateJL() {
		return DateJL;
	}

	public void setDateJL(String dateJL) {
		DateJL = dateJL;
	}

	public String getQResults() {
		return QResults;
	}

	public void setQResults(String QResults) {
		this.QResults = QResults;
	}

	public String getQRemarks() {
		return QRemarks;
	}

	public void setQRemarks(String QRemarks) {
		this.QRemarks = QRemarks;
	}

	public int getQLMSNumber() {
		return QLMSNumber;
	}

	public void setQLMSNumber(int QLMSNumber) {
		this.QLMSNumber = QLMSNumber;
	}

	public int getQCHYin() {
		return QCHYin;
	}

	public void setQCHYin(int QCHYin) {
		this.QCHYin = QCHYin;
	}

	public int getQCHYang() {
		return QCHYang;
	}

	public void setQCHYang(int QCHYang) {
		this.QCHYang = QCHYang;
	}

	public int getQPayleanYin() {
		return QPayleanYin;
	}

	public void setQPayleanYin(int QPayleanYin) {
		this.QPayleanYin = QPayleanYin;
	}

	public int getQPayleanYang() {
		return QPayleanYang;
	}

	public void setQPayleanYang(int QPayleanYang) {
		this.QPayleanYang = QPayleanYang;
	}

	public int getQsalbutamolYin() {
		return QsalbutamolYin;
	}

	public void setQsalbutamolYin(int qsalbutamolYin) {
		QsalbutamolYin = qsalbutamolYin;
	}

	public int getQsalbutamolYang() {
		return QsalbutamolYang;
	}

	public void setQsalbutamolYang(int qsalbutamolYang) {
		QsalbutamolYang = qsalbutamolYang;
	}

	public Double getFLongitude() {
		return FLongitude;
	}

	public void setFLongitude(Double FLongitude) {
		this.FLongitude = FLongitude;
	}

	public Double getFLatitude() {
		return FLatitude;
	}

	public void setFLatitude(Double FLatitude) {
		this.FLatitude = FLatitude;
	}

	public String getFLName() {
		return FLName;
	}

	public void setFLName(String FLName) {
		this.FLName = FLName;
	}

	public String getGPSunitUstrId() {
		return GPSunitUstrId;
	}

	public void setGPSunitUstrId(String GPSunitUstrId) {
		this.GPSunitUstrId = GPSunitUstrId;
	}

	public String getIsPrant() {
		return IsPrant;
	}

	public void setIsPrant(String isPrant) {
		IsPrant = isPrant;
	}


}
