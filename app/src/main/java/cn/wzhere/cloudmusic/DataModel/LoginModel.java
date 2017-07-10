//package cn.wzhere.cloudmusic.DataModel
//
////
////	LoginModel.java
////	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport
//
//import org.json.*;
//import java.util.*;
//import com.google.gson.annotations.SerializedName;
//
//
//public class LoginModel{
//
//	@SerializedName("account")
//	private Account account;
//	@SerializedName("bindings")
//	private Binding[] bindings;
//	@SerializedName("code")
//	private int code;
//	@SerializedName("loginType")
//	private int loginType;
//	@SerializedName("profile")
//	private Profile profile;
//
//	public void setAccount(Account account){
//		this.account = account;
//	}
//	public Account getAccount(){
//		return this.account;
//	}
//	public void setBindings(Binding[] bindings){
//		this.bindings = bindings;
//	}
//	public Binding[] getBindings(){
//		return this.bindings;
//	}
//	public void setCode(int code){
//		this.code = code;
//	}
//	public int getCode(){
//		return this.code;
//	}
//	public void setLoginType(int loginType){
//		this.loginType = loginType;
//	}
//	public int getLoginType(){
//		return this.loginType;
//	}
//	public void setProfile(Profile profile){
//		this.profile = profile;
//	}
//	public Profile getProfile(){
//		return this.profile;
//	}
//
//	/**
//	 * Instantiate the instance using the passed jsonObject to set the properties values
//	 */
//	public LoginModel(JSONObject jsonObject){
//		if(jsonObject == null){
//			return;
//		}
//		account = new Account(jsonObject.optJSONObject("account"));
//		JSONArray bindingsJsonArray = jsonObject.optJSONArray("bindings");
//		if(bindingsJsonArray != null){
//			ArrayList<Binding> bindingsArrayList = new ArrayList<>();
//			for (int i = 0; i < bindingsJsonArray.length(); i++) {
//				JSONObject bindingsObject = bindingsJsonArray.optJSONObject(i);
//				bindingsArrayList.add(new Binding(bindingsObject));
//			}
//			bindings = (Binding[]) bindingsArrayList.toArray();
//		}		code = jsonObject.optInt("code");
//		loginType = jsonObject.optInt("loginType");
//		profile = new Profile(jsonObject.optJSONObject("profile"));
//	}
//
//	/**
//	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
//	 */
//	public JSONObject toJsonObject()
//	{
//		JSONObject jsonObject = new JSONObject();
//		try {
//			jsonObject.put("account", account.toJsonObject());
//			if(bindings != null && bindings.length > 0){
//				JSONArray bindingsJsonArray = new JSONArray();
//				for(Binding bindingsElement : bindings){
//					bindingsJsonArray.put(bindingsElement.toJsonObject());
//				}
//				jsonObject.put("bindings", bindingsJsonArray);
//			}
//			jsonObject.put("code", code);
//			jsonObject.put("loginType", loginType);
//			jsonObject.put("profile", profile.toJsonObject());
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return jsonObject;
//	}
//
//}