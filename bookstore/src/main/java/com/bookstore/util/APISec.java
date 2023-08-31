package com.bookstore.util;



	import javax.crypto.Mac;
	import javax.crypto.spec.SecretKeySpec;
	import java.security.InvalidKeyException;
	import java.security.NoSuchAlgorithmException;
	import java.time.Clock;
	
	
	
	public class APISec {
	    /**
	     * Signs the request payload using the api key secret
	     *
	     * @param apiKeySecret - the api key secret
	     * @param timestamp    - the unix timestamp of this request e.g. Clock.systemUTC().millis()
	     * @param verb         - Http verb - GET, POST, PUT or DELETE
	     * @param path         - path excluding host name, e.g. '/v1/withdraw
	     * @param body         - http request body as a string, optional
	     * @return the signature of the request
	     */
		
		
		public static String getSecurityKey() {
		
		
		//public static void main(String args[]) {
			
		//System.out.println(signRequest("4961b74efac86b25cce8fbe4c9811c4c7a787b7a5996660afcc2e287ad864363","1558017528946","POST","/v1/orders/market","{\"customerOrderId\":\"ORDER-000001\",\"pair\":\"BTCZAR\",\"side\":\"BUY\",\"quoteAmount\":\"80000\"}"));
			
			
			//return signRequest("4961b74efac86b25cce8fbe4c9811c4c7a787b7a5996660afcc2e287ad864300",""+TimeStampUtil.getTimeStamp(),"POST","/v1/orders/market","{\"customerOrderId\":\"ORDER-000001\",\"pair\":\"BTCZAR\",\"side\":\"BUY\",\"quoteAmount\":\"80000\"}");
			
		return signRequest("4961b74efac86b25cce8fbe4c9811c4c7a787b7a5996660afcc2e287ad864300",""+TimeStampUtil.getTimeStamp(),"POST","/v1/orders","{"
					+ "    \"Asks\": ["
					+ "        {"
					+ "            \"side\": \"sell\","
					+ "            \"quantity\": \"0.03000000\","
					+ "            \"price\": \"100000\","
					+ "            \"currencyPair\": \"BTCZAR\","
					+ "            \"id\": \"3212dcbe-c25f-4402-9139-199e0e014a0e\","
					+"              \"positionAtPrice\": 1"
					+ "        }"
					+ "    ],"
					+ "    \"Bids\": ["
					+ "        {"
					+ "            \"side\": \"buy\","
					+ "            \"quantity\": \"0.05000000\","
					+ "            \"price\": \"7015620\","
					+ "            \"currencyPair\": \"BTCZAR\","
					+ "            \"id\": \"3212dcbe-c25f-4402-9139-199e0e014a0f\","
					+"              \"positionAtPrice\": 1"
					+ "        }"
					+ "    ],"
					+ "     \"LastChange\":"+ TimeStampUtil.getDateFormat()+","
					+ "    \"SequenceNumber\": 31147500"
					+ "}");	
			
		}
		
	    public static String signRequest(String apiKeySecret, String timestamp, String verb, String path, String body) {
	        try {
	            Mac hmacSHA512 = Mac.getInstance("HmacSHA512");
	            SecretKeySpec secretKeySpec = new SecretKeySpec(apiKeySecret.getBytes(), "HmacSHA512");
	            hmacSHA512.init(secretKeySpec);
	            hmacSHA512.update(timestamp.getBytes());
	            hmacSHA512.update(verb.toUpperCase().getBytes());
	            hmacSHA512.update(path.getBytes());
	            hmacSHA512.update(body.getBytes());
	            byte[] digest = hmacSHA512.doFinal();
	            return toHexString(digest);
	        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
	            throw new RuntimeException("Unable to sign request", e);
	        }
	    }
	    public static String toHexString(byte[] a) {
	        StringBuilder sb = new StringBuilder(a.length * 2);
	        for (byte b : a)
	        	sb.append(String.format("%02x", b));
	           // sb.append(String.format("x", b));
	        return sb.toString();
	    }
	    

}
