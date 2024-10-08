package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;
import endpoints.Endpoints;
import io.cucumber.java.en.*;

public class TodosCompletionSteps {
	Response allUser;
//  List to hold filtered users
	List<Map<String, Object>> filteredUsers = new ArrayList<Map<String, Object>>();

	@Given("User has the todo tasks")
	public void user_has_the_todo_tasks() {
		allUser = Endpoints.getAllUsers();
	}

	@And("User belongs to the city FanCode")
	public void user_belongs_to_the_city_fan_code() {
		List<Map<String, Object>> users = allUser.jsonPath().getList("$");
		double latMin = -40.0;
		double latMax = 5.0;
		double lngMin = 5.0;
		double lngMax = 100.0;
//		Iterate over each user
		for (Map<String, Object> user : users) {
//			Get the geo information
			Map<String, Object> address = (Map<String, Object>) user.get("address");
			if (address != null) {
				Map<String, Object> geo = (Map<String, Object>) address.get("geo");
				double lat = Double.parseDouble(geo.get("lat").toString());
				double lng = Double.parseDouble(geo.get("lng").toString());

//				Check if the user's lat and lng are within the specified ranges
				if (lat > latMin && lat < latMax && lng > lngMin && lng < lngMax) {
					// Add the user to the filtered list
					filteredUsers.add(user);
				}
			}
		}

	}

	@Then("User Completed task percentage should be greater than {int}%")
	public void user_completed_task_percentage_should_be_greater_than(Integer int1) {
		Response todos = Endpoints.getAllTodos();
		List<Map<String, Object>> tasks = todos.jsonPath().getList("$");

        System.out.println("User Completion Percentages:");
        System.out.printf("%-25s %s%n", "User Name", "Completion Percentage");
        System.out.println("---------------------------------------");
        
        for (Map<String, Object> user : filteredUsers) {
            int userId = (Integer) user.get("id");
            int totalTasks = 0;
            int completedTasks = 0;

            for (Map<String, Object> task : tasks) {
                if ((Integer) task.get("userId") == userId) {
                    totalTasks++;
                    if ((Boolean) task.get("completed")) {
                        completedTasks++;
                    }
                }
            }

            double completionPercentage =((double) completedTasks / totalTasks) * 100;
            // Print formatted output
            System.out.printf("%-25s %.2f%%%n", user.get("name"), completionPercentage);
	}
}
}
