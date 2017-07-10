//package cn.wzhere.cloudmusic.DataModel
//
////
////	Profile.java
////	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport
//
//import org.json.*;
//import java.util.*;
//import com.google.gson.annotations.SerializedName;
//
//
//public class Profile{
//
//	@SerializedName("accountStatus")
//	private int accountStatus;
//	@SerializedName("authStatus")
//	private int authStatus;
//	@SerializedName("authority")
//	private int authority;
//	@SerializedName("avatarImgId")
//	private int avatarImgId;
//	@SerializedName("avatarImgIdStr")
//	private String avatarImgIdStr;
//	@SerializedName("avatarUrl")
//	private String avatarUrl;
//	@SerializedName("backgroundImgId")
//	private int backgroundImgId;
//	@SerializedName("backgroundImgIdStr")
//	private String backgroundImgIdStr;
//	@SerializedName("backgroundUrl")
//	private String backgroundUrl;
//	@SerializedName("birthday")
//	private int birthday;
//	@SerializedName("city")
//	private int city;
//	@SerializedName("defaultAvatar")
//	private boolean defaultAvatar;
//	@SerializedName("description")
//	private String description;
//	@SerializedName("detailDescription")
//	private String detailDescription;
//	@SerializedName("djStatus")
//	private int djStatus;
//	@SerializedName("expertTags")
//	private Object expertTags;
//	@SerializedName("followed")
//	private boolean followed;
//	@SerializedName("gender")
//	private int gender;
//	@SerializedName("mutual")
//	private boolean mutual;
//	@SerializedName("nickname")
//	private String nickname;
//	@SerializedName("province")
//	private int province;
//	@SerializedName("remarkName")
//	private Object remarkName;
//	@SerializedName("signature")
//	private String signature;
//	@SerializedName("userId")
//	private int userId;
//	@SerializedName("userType")
//	private int userType;
//	@SerializedName("vipType")
//	private int vipType;
//
//	public void setAccountStatus(int accountStatus){
//		this.accountStatus = accountStatus;
//	}
//	public int getAccountStatus(){
//		return this.accountStatus;
//	}
//	public void setAuthStatus(int authStatus){
//		this.authStatus = authStatus;
//	}
//	public int getAuthStatus(){
//		return this.authStatus;
//	}
//	public void setAuthority(int authority){
//		this.authority = authority;
//	}
//	public int getAuthority(){
//		return this.authority;
//	}
//	public void setAvatarImgId(int avatarImgId){
//		this.avatarImgId = avatarImgId;
//	}
//	public int getAvatarImgId(){
//		return this.avatarImgId;
//	}
//	public void setAvatarImgIdStr(String avatarImgIdStr){
//		this.avatarImgIdStr = avatarImgIdStr;
//	}
//	public String getAvatarImgIdStr(){
//		return this.avatarImgIdStr;
//	}
//	public void setAvatarUrl(String avatarUrl){
//		this.avatarUrl = avatarUrl;
//	}
//	public String getAvatarUrl(){
//		return this.avatarUrl;
//	}
//	public void setBackgroundImgId(int backgroundImgId){
//		this.backgroundImgId = backgroundImgId;
//	}
//	public int getBackgroundImgId(){
//		return this.backgroundImgId;
//	}
//	public void setBackgroundImgIdStr(String backgroundImgIdStr){
//		this.backgroundImgIdStr = backgroundImgIdStr;
//	}
//	public String getBackgroundImgIdStr(){
//		return this.backgroundImgIdStr;
//	}
//	public void setBackgroundUrl(String backgroundUrl){
//		this.backgroundUrl = backgroundUrl;
//	}
//	public String getBackgroundUrl(){
//		return this.backgroundUrl;
//	}
//	public void setBirthday(int birthday){
//		this.birthday = birthday;
//	}
//	public int getBirthday(){
//		return this.birthday;
//	}
//	public void setCity(int city){
//		this.city = city;
//	}
//	public int getCity(){
//		return this.city;
//	}
//	public void setDefaultAvatar(boolean defaultAvatar){
//		this.defaultAvatar = defaultAvatar;
//	}
//	public boolean isDefaultAvatar()
//	{
//		return this.defaultAvatar;
//	}
//	public void setDescription(String description){
//		this.description = description;
//	}
//	public String getDescription(){
//		return this.description;
//	}
//	public void setDetailDescription(String detailDescription){
//		this.detailDescription = detailDescription;
//	}
//	public String getDetailDescription(){
//		return this.detailDescription;
//	}
//	public void setDjStatus(int djStatus){
//		this.djStatus = djStatus;
//	}
//	public int getDjStatus(){
//		return this.djStatus;
//	}
//	public void setExpertTags(Object expertTags){
//		this.expertTags = expertTags;
//	}
//	public Object getExpertTags(){
//		return this.expertTags;
//	}
//	public void setFollowed(boolean followed){
//		this.followed = followed;
//	}
//	public boolean isFollowed()
//	{
//		return this.followed;
//	}
//	public void setGender(int gender){
//		this.gender = gender;
//	}
//	public int getGender(){
//		return this.gender;
//	}
//	public void setMutual(boolean mutual){
//		this.mutual = mutual;
//	}
//	public boolean isMutual()
//	{
//		return this.mutual;
//	}
//	public void setNickname(String nickname){
//		this.nickname = nickname;
//	}
//	public String getNickname(){
//		return this.nickname;
//	}
//	public void setProvince(int province){
//		this.province = province;
//	}
//	public int getProvince(){
//		return this.province;
//	}
//	public void setRemarkName(Object remarkName){
//		this.remarkName = remarkName;
//	}
//	public Object getRemarkName(){
//		return this.remarkName;
//	}
//	public void setSignature(String signature){
//		this.signature = signature;
//	}
//	public String getSignature(){
//		return this.signature;
//	}
//	public void setUserId(int userId){
//		this.userId = userId;
//	}
//	public int getUserId(){
//		return this.userId;
//	}
//	public void setUserType(int userType){
//		this.userType = userType;
//	}
//	public int getUserType(){
//		return this.userType;
//	}
//	public void setVipType(int vipType){
//		this.vipType = vipType;
//	}
//	public int getVipType(){
//		return this.vipType;
//	}
//
//	/**
//	 * Instantiate the instance using the passed jsonObject to set the properties values
//	 */
//	public Profile(JSONObject jsonObject){
//		if(jsonObject == null){
//			return;
//		}
//		accountStatus = jsonObject.optInt("accountStatus");
//		authStatus = jsonObject.optInt("authStatus");
//		authority = jsonObject.optInt("authority");
//		avatarImgId = jsonObject.optInt("avatarImgId");
//		avatarImgIdStr = jsonObject.opt("avatarImgIdStr");
//		avatarUrl = jsonObject.opt("avatarUrl");
//		backgroundImgId = jsonObject.optInt("backgroundImgId");
//		backgroundImgIdStr = jsonObject.opt("backgroundImgIdStr");
//		backgroundUrl = jsonObject.opt("backgroundUrl");
//		birthday = jsonObject.optInt("birthday");
//		city = jsonObject.optInt("city");
//		defaultAvatar = jsonObject.optBoolean("defaultAvatar");
//		description = jsonObject.opt("description");
//		detailDescription = jsonObject.opt("detailDescription");
//		djStatus = jsonObject.optInt("djStatus");
//		expertTags = jsonObject.opt("expertTags");
//		followed = jsonObject.optBoolean("followed");
//		gender = jsonObject.optInt("gender");
//		mutual = jsonObject.optBoolean("mutual");
//		nickname = jsonObject.opt("nickname");
//		province = jsonObject.optInt("province");
//		remarkName = jsonObject.opt("remarkName");
//		signature = jsonObject.opt("signature");
//		userId = jsonObject.optInt("userId");
//		userType = jsonObject.optInt("userType");
//		vipType = jsonObject.optInt("vipType");
//	}
//
//	/**
//	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
//	 */
//	public JSONObject toJsonObject()
//	{
//		JSONObject jsonObject = new JSONObject();
//		try {
//			jsonObject.put("accountStatus", accountStatus);
//			jsonObject.put("authStatus", authStatus);
//			jsonObject.put("authority", authority);
//			jsonObject.put("avatarImgId", avatarImgId);
//			jsonObject.put("avatarImgIdStr", avatarImgIdStr);
//			jsonObject.put("avatarUrl", avatarUrl);
//			jsonObject.put("backgroundImgId", backgroundImgId);
//			jsonObject.put("backgroundImgIdStr", backgroundImgIdStr);
//			jsonObject.put("backgroundUrl", backgroundUrl);
//			jsonObject.put("birthday", birthday);
//			jsonObject.put("city", city);
//			jsonObject.put("defaultAvatar", defaultAvatar);
//			jsonObject.put("description", description);
//			jsonObject.put("detailDescription", detailDescription);
//			jsonObject.put("djStatus", djStatus);
//			jsonObject.put("expertTags", expertTags);
//			jsonObject.put("followed", followed);
//			jsonObject.put("gender", gender);
//			jsonObject.put("mutual", mutual);
//			jsonObject.put("nickname", nickname);
//			jsonObject.put("province", province);
//			jsonObject.put("remarkName", remarkName);
//			jsonObject.put("signature", signature);
//			jsonObject.put("userId", userId);
//			jsonObject.put("userType", userType);
//			jsonObject.put("vipType", vipType);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jsonObject;
//	}
//
//}