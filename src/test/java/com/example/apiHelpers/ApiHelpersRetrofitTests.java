package com.example.apiHelpers;

import com.example.apiHelpers.pojo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;
import java.io.IOException;

@SpringBootTest
class ApiHelpersRetrofitTests {

	APIInterface service = APIClientHelper.getClient().create(APIInterface.class);
	APIInterface serviceResource = APIClientHelper.getClientResource().create(APIInterface.class);

	@Test
	@DisplayName("GET - GET USER BY ID")
	void retrofitTest() {
		Response<User> response;

		try {
			response = service.getUser().execute();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		assert response.isSuccessful();

		if(response.isSuccessful()) {
			System.out.println("Response SUCCESS");

			User user = response.body();
			assert user != null;
			System.out.println(user.getData().getId());
			assert user.getData().getId() == 2;

			System.out.println(user.getData().getEmail());
			assert user.getData().getEmail().equals("janet.weaver@reqres.in");

			System.out.println(user);
			System.out.println(user.getData());
			System.out.println(user.getSupport());
			System.out.println(user.getData().getFirstName());
			System.out.println(user.getData().getLastName());
		} else {
			System.out.println("Response ERROR");
		}
	}

	@Test
	@DisplayName("POST - CREATE USER")
	void checkUserCreation() throws IOException {
		Response<CreateUserResponse> responseCreateUser;
		CreateUserResponse userResponse;

		System.out.println(getRequestBody());
		responseCreateUser = service.createUser(getRequestBody()).execute();

		userResponse = responseCreateUser.body();
		System.out.println(userResponse.getId());
		System.out.println(userResponse.getCreatedAt());

		if(responseCreateUser.isSuccessful()){
			System.out.println("Response SUCCESS");
		}else{
			System.out.println("Response ERROR");
		}
		System.out.println(responseCreateUser.body());
		Assertions.assertEquals(201, responseCreateUser.code());
	}

	public CreateUserRequest getRequestBody() {
		CreateUserRequest requestNewUserData = new CreateUserRequest();
		requestNewUserData.setJob("morpheus");
		requestNewUserData.setName("leader");

		return requestNewUserData;
	}

	public UpdateUserRequest getRequestBodyForUpdate() {
		UpdateUserRequest requestNewUserData = new UpdateUserRequest();
		requestNewUserData.setJob("morpheus");
		requestNewUserData.setName("leader");

		return requestNewUserData;
	}

	@Test
	@DisplayName("PUT - UPDATE USER")
	void checkUserUpdating() throws IOException {
		Response<UpdateUserResponse> responseUpdateUser;
		UpdateUserResponse userResponse;

		System.out.println(getRequestBody());
		responseUpdateUser = service.updateUser(getRequestBodyForUpdate()).execute();

		userResponse = responseUpdateUser.body();
		System.out.println(userResponse.getName());
		System.out.println(userResponse.getJob());
		System.out.println(userResponse.getUpdatedAt());

		if(responseUpdateUser.isSuccessful()){
			System.out.println("Response SUCCESS");
		}else{
			System.out.println("Response ERROR");
		}
		System.out.println(responseUpdateUser.body());
		Assertions.assertEquals(200, responseUpdateUser.code());
	}

	@Test
	@DisplayName("PATCH - UPDATE USER")
	void checkUserUpdatingByPatch() throws IOException {
		Response<UpdateUserResponse> responseUpdateUser;
		UpdateUserResponse userResponse;

		System.out.println(getRequestBody());
		responseUpdateUser = service.updateUserByPatch(getRequestBodyForUpdate()).execute();

		userResponse = responseUpdateUser.body();
		System.out.println(userResponse.getName());
		System.out.println(userResponse.getJob());
		System.out.println(userResponse.getUpdatedAt());

		if(responseUpdateUser.isSuccessful()){
			System.out.println("Response SUCCESS");
		}else{
			System.out.println("Response ERROR");
		}
		System.out.println(responseUpdateUser.body());
		Assertions.assertEquals(200, responseUpdateUser.code());
	}

	@Test
	@DisplayName("GET - GET RESOURCE BY ID")
	void retrofitTestResource() {
		Response<Resource> response;

		try {
			response = serviceResource.getResource().execute();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		assert response.isSuccessful();

		if(response.isSuccessful()) {
			System.out.println("Response SUCCESS");

			Resource resource = response.body();
			assert resource != null;
			System.out.println(resource.getData().getId());
			assert resource.getData().getId() == 2;

			System.out.println(resource.getData().getName());
			assert resource.getData().getName().equals("fuchsia rose");

			System.out.println(resource);
			System.out.println(resource.getData());
			System.out.println(resource.getSupport());
			System.out.println(resource.getData().getColor());
			System.out.println(resource.getData().getPantoneValue());
		} else {
			System.out.println("Response ERROR");
		}
	}
}
