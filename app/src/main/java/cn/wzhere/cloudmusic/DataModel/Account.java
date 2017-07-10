//package cn.wzhere.cloudmusic.DataModel
//
////
////	Account.java
////	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport
//
//import org.json.*;
//import java.util.*;
//import com.google.gson.annotations.SerializedName;
//
//
//public class Account{
//
//	@SerializedName("anonimousUser")
//	private boolean anonimousUser;
//	@SerializedName("ban")
//	private int ban;
//	@SerializedName("baoyueVersion")
//	private int baoyueVersion;
//	@SerializedName("createTime")
//	private int createTime;
//	@SerializedName("donateVersion")
//	private int donateVersion;
//	@SerializedName("id")
//	private int id;
//	@SerializedName("salt")
//	private String salt;
//	@SerializedName("status")
//	private int status;
//	@SerializedName("tokenVersion")
//	private int tokenVersion;
//	@SerializedName("type")
//	private int type;
//	@SerializedName("userName")
//	private String userName;
//	@SerializedName("vipType")
//	private int vipType;
//	@SerializedName("viptypeVersion")
//	private int viptypeVersion;
//	@SerializedName("whitelistAuthority")
//	private int whitelistAuthority;
//
//	public void setAnonimousUser(boolean anonimousUser){
//		this.anonimousUser = anonimousUser;
//	}
//	public boolean isAnonimousUser()
//	{
//		return this.anonimousUser;
//	}
//	public void setBan(int ban){
//		this.ban = ban;
//	}
//	public int getBan(){
//		return this.ban;
//	}
//	public void setBaoyueVersion(int baoyueVersion){
//		this.baoyueVersion = baoyueVersion;
//	}
//	public int getBaoyueVersion(){
//		return this.baoyueVersion;
//	}
//	public void setCreateTime(int createTime){
//		this.createTime = createTime;
//	}
//	public int getCreateTime(){
//		return this.createTime;
//	}
//	public void setDonateVersion(int donateVersion){
//		this.donateVersion = donateVersion;
//	}
//	public int getDonateVersion(){
//		return this.donateVersion;
//	}
//	public void setId(int id){
//		this.id = id;
//	}
//	public int getId(){
//		return this.id;
//	}
//	public void setSalt(String salt){
//		this.salt = salt;
//	}
//	public String getSalt(){
//		return this.salt;
//	}
//	public void setStatus(int status){
//		this.status = status;
//	}
//	public int getStatus(){
//		return this.status;
//	}
//	public void setTokenVersion(int tokenVersion){
//		this.tokenVersion = tokenVersion;
//	}
//	public int getTokenVersion(){
//		return this.tokenVersion;
//	}
//	public void setType(int type){
//		this.type = type;
//	}
//	public int getType(){
//		return this.type;
//	}
//	public void setUserName(String userName){
//		this.userName = userName;
//	}
//	public String getUserName(){
//		return this.userName;
//	}
//	public void setVipType(int vipType){
//		this.vipType = vipType;
//	}
//	public int getVipType(){
//		return this.vipType;
//	}
//	public void setViptypeVersion(int viptypeVersion){
//		this.viptypeVersion = viptypeVersion;
//	}
//	public int getViptypeVersion(){
//		return this.viptypeVersion;
//	}
//	public void setWhitelistAuthority(int whitelistAuthority){
//		this.whitelistAuthority = whitelistAuthority;
//	}
//	public int getWhitelistAuthority(){
//		return this.whitelistAuthority;
//	}
//
//	/**
//	 * Instantiate the instance using the passed jsonObject to set the properties values
//	 */
//	public Account(JSONObject jsonObject){
//		if(jsonObject == null){
//			return;
//		}
//		anonimousUser = jsonObject.optBoolean("anonimousUser");
//		ban = jsonObject.optInt("ban");
//		baoyueVersion = jsonObject.optInt("baoyueVersion");
//		createTime = jsonObject.optInt("createTime");
//		donateVersion = jsonObject.optInt("donateVersion");
//		id = jsonObject.optInt("id");
//		salt = jsonObject.opt("salt");
//		status = jsonObject.optInt("status");
//		tokenVersion = jsonObject.optInt("tokenVersion");
//		type = jsonObject.optInt("type");
//		userName = jsonObject.opt("userName");
//		vipType = jsonObject.optInt("vipType");
//		viptypeVersion = jsonObject.optInt("viptypeVersion");
//		whitelistAuthority = jsonObject.optInt("whitelistAuthority");
//	}
//
//	/**
//	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
//	 */
//	public JSONObject toJsonObject()
//	{
//		JSONObject jsonObject = new JSONObject();
//		try {
//			jsonObject.put("anonimousUser", anonimousUser);
//			jsonObject.put("ban", ban);
//			jsonObject.put("baoyueVersion", baoyueVersion);
//			jsonObject.put("createTime", createTime);
//			jsonObject.put("donateVersion", donateVersion);
//			jsonObject.put("id", id);
//			jsonObject.put("salt", salt);
//			jsonObject.put("status", status);
//			jsonObject.put("tokenVersion", tokenVersion);
//			jsonObject.put("type", type);
//			jsonObject.put("userName", userName);
//			jsonObject.put("vipType", vipType);
//			jsonObject.put("viptypeVersion", viptypeVersion);
//			jsonObject.put("whitelistAuthority", whitelistAuthority);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jsonObject;
//	}
//
//}