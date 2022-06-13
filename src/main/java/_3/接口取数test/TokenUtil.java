package _3.接口取数test;

import java.util.HashMap;
import java.util.Map;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;

public class TokenUtil {
	public static final String EXCH_SERVER = "http://dsly.95306.cn/crl-mt-outer/channel1";
//	public static final String APPID = "87KDMX0ZX25K";
//	public static final String APPSECRET = "AIXESJM6WP107XZWBXXN";

	public static final String APPID = "IEBVUPFB29U8";//邯黄

	public static final String APPSECRET = "9KKAVAYQ131CN6TB6W6V";//邯黄
	
	public static String createToken() {
		
		Map<String, String> map = new HashMap(2);
		map.put("appid",APPID);
		map.put("appsecret",APPSECRET);
		String data = JSONUtil.toJsonStr(map);
	
		Map<String, String> param = new HashMap(3);
		param.put("Grant_Type", "appid");
		param.put("Authorization", "2");
		param.put("data", data);
		data = JSONUtil.toJsonStr(param);
		
		Map<String, Object> params = new HashMap();
		params.put("url", "/auth/createToken");
		params.put("data", data);
		
		return getToken(params, 0);
	}


	private static String getToken(Map<String, Object> params, Integer count) {
		String jsonResult = HttpUtil.post(EXCH_SERVER, params);
		Map<String, Object> result = JSONUtil.toBean(jsonResult, Map.class);
		if (!result.get("returnCode").equals("00200")) {
			if (count > 3) {
				return null;
			}
			count++;
			getToken(params, count);
		}
		String data = result.get("data").toString();
		if (StrUtil.isNotEmpty(data) && JSONUtil.isJson(data)) {
			Map<String, String> tokenMap = JSONUtil.toBean(result.get("data").toString(), Map.class);
			String token = tokenMap.get("accessToken").toString();
			return token;
		}
		return null;
	}
	
	public static String getData(String token,String url){
		Map<String, String> map = new HashMap(2);
		map.put("Grant_Type", "appid");
		map.put("Authorization",token);
		String paramData = JSONUtil.toJsonStr(map);
		Map<String, Object> params = new HashMap();
		params.put("url",url);
		params.put("data", paramData);
		String resultStr = toGetData(params,0);
		if (resultStr != null) {
			Map<String, Object> result = JSONUtil.toBean(resultStr, Map.class);
			String data = result.get("data").toString();
			if (!"[]".equals(data) && StrUtil.isNotEmpty(data) && JSONUtil.isJson(data)) {
				return data;
			}
		}
		return null;
	}
	
	public static String  toGetData(Map<String, Object> params,int count){
		String resultStr = HttpUtil.post(EXCH_SERVER, params);
		if(!resultStr.startsWith("\r\n{")){
			if (count > 100) {
				return null;
			}
			return toGetData(params,count);
		}
		Map<String, Object> result = JSONUtil.toBean(resultStr, Map.class);
		if (!result.get("returnCode").equals("00200")) {
			if (count > 100) {
				return null;
			}
			return toGetData(params,count);
		}
		return resultStr;
	}
}
