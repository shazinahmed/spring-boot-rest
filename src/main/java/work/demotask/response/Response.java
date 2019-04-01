package work.demotask.response;

/**
 * Enum to represent different types of response from the DB
 * @author shazinahmed
 *
 */
public enum Response {

	SUCCESS_ADD("Item was addes successfully"),
	ITEM_NOT_FOUND("We could not find an item with the given name"),
	FAILURE("Oops! Something went wrong");

	private String message;

	Response(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
