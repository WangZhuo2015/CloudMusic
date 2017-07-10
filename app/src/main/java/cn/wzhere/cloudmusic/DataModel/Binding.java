//package cn.wzhere.cloudmusic.DataModel
//
////
////	Binding.java
////	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport
//
//import org.json.*;
//import java.util.*;
//import com.google.gson.annotations.SerializedName;
//
//
//public class Binding{
//
//	@SerializedName("expired")
//	private boolean expired;
//	@SerializedName("expiresIn")
//	private int expiresIn;
//	@SerializedName("id")
//	private int id;
//	@SerializedName("refreshTime")
//	private int refreshTime;
//	@SerializedName("tokenJsonStr")
//	private String tokenJsonStr;
//	@SerializedName("type")
//	private int type;
//	@SerializedName("url")
//	private String url;
//	@SerializedName("userId")
//	private int userId;
//
//	public void setExpired(boolean expired){
//		this.expired = expired;
//	}
//	public boolean isExpired()
//	{
//		return this.expired;
//	}
//	public void setExpiresIn(int expiresIn){
//		this.expiresIn = expiresIn;
//	}
//	public int getExpiresIn(){
//		return this.expiresIn;
//	}
//	public void setId(int id){
//		this.id = id;
//	}
//	public int getId(){
//		return this.id;
//	}
//	public void setRefreshTime(int refreshTime){
//		this.refreshTime = refreshTime;
//	}
//	public int getRefreshTime(){
//		return this.refreshTime;
//	}
//	public void setTokenJsonStr(String tokenJsonStr){
//		this.tokenJsonStr = tokenJsonStr;
//	}
//	public String getTokenJsonStr(){
//		return this.tokenJsonStr;
//	}
//	public void setType(int type){
//		this.type = type;
//	}
//	public int getType(){
//		return this.type;
//	}
//	public void setUrl(String url){
//		this.url = url;
//	}
//	public String getUrl(){
//		return this.url;
//	}
//	public void setUserId(int userId){
//		this.userId = userId;
//	}
//	public int getUserId(){
//		return this.userId;
//	}
//
//	/**
//	 * Instantiate the instance using the passed jsonObject to set the properties values
//	 */
//	public Binding(JSONObject jsonObject){
//		if(jsonObject == null){
//			return;
//		}
//		expired = jsonObject.optBoolean("expired");
//		expiresIn = jsonObject.optInt("expiresIn");
//		id = jsonObject.optInt("id");
//		refreshTime = jsonObject.optInt("refreshTime");
//		tokenJsonStr = jsonObject.opt("tokenJsonStr");
//		type = jsonObject.optInt("type");
//		url = jsonObject.opt("url");
//		userId = jsonObject.optInt("userId");
//	}
//
//	/**
//	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
//	 */
//	public JSONObject toJsonObject()
//	{
//		JSONObject jsonObject = new JSONObject();
//		try {
//			jsonObject.put("expired", expired);
//			jsonObject.put("expiresIn", expiresIn);
//			jsonObject.put("id", id);
//			jsonObject.put("refreshTime", refreshTime);
//			jsonObject.put("tokenJsonStr", tokenJsonStr);
//			jsonObject.put("type", type);
//			jsonObject.put("url", url);
//			jsonObject.put("userId", userId);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jsonObject;
//	}
//
//}