package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndpoints {
	
	public static Response CreateUser(User payload){
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.post_url);	
		
		return response;
		
	}
	
	public static Response readUser(String userName){
		
		Response response = given()
				.pathParams("username", userName)
		
		.when()
		.get(Routes.get_url);	
		
		return response;
		
	}
	
	public static Response UpdateUser(String userName, User payload){
		
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParams("username", userName)
		.body(payload)
		
		.when()
		.put(Routes.put_url);	
		
		return response;
		
	}
	public static Response deleteUser(String userName){
		
		Response response = given()
				.pathParams("username", userName)
		
		.when()
		.delete(Routes.delete_url);	
		
		return response;
		
	}

}
