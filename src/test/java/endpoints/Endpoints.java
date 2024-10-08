package endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class Endpoints {

	public static Response getAllUsers() {
		Response res = given().when().get(Routes.users);
		return res;
	}

	public static Response getAllTodos() {

		Response res = given().when().get(Routes.todos);
		return res;
	}

	public static Response getSpecificUserTodos(int id) {

		Response res = given().queryParam("userId", id).when().get(Routes.todos);
		return res;
	}

	public static Response getComments() {

		Response res = given().when().get(Routes.comments);
		return res;
	}

	public static Response getPosts() {
		Response res = given().when().get(Routes.posts);
		return res;
	}

	public static Response getAlbums() {

		Response res = given().when().get(Routes.albums);
		return res;
	}
}
