package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//
public class UserEndpoints2 { 
	
	//method created to get URL from property file
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	
	public static Response CreateUser(User payload){
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(getURL().getString("post_url"));	
		
		return response;
		
	}
	
	public static Response readUser(String userName){
		
		Response response = given()
				.pathParams("username", userName)
		
		.when()
		.get(getURL().getString("get_url"));	
		
		return response;
		
	}
	
	public static Response UpdateUser(String userName, User payload){
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParams("username", userName)
		.body(payload)
		
		.when()
		.put(getURL().getString("put_url"));	
		
		return response;
		
	}
	public static Response deleteUser(String userName){
		
		Response response = given()
				.pathParams("username", userName)
		
		.when()
		.delete(getURL().getString("delete_url"));	
		
		return response;
		
	}

}
