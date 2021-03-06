package com.filmland.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.filmland.constants.Constants;
import com.filmland.dto.ResponseStatus;

/**
 * Class to handle all the custom application exceptions.
 * 
 * @author ashis
 *
 */
@ControllerAdvice
public class FilmlandExceptionHandler {

	/**
	 * In case requested user is not available with filmland.
	 * 
	 * @param exception {@link UserNotFoundException}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		ResponseStatus status = new ResponseStatus(new Date(), Constants.LOGIN_SUCCESSFULL,
				"Requested User is not registered with filmland.");
		return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
	}

	/**
	 * In case requested category is not available with filmland.
	 * 
	 * @param exception {@link UserNotFoundException}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler(value = CategoryNotFoundException.class)
	public ResponseEntity<Object> exception(CategoryNotFoundException exception) {
		ResponseStatus status = new ResponseStatus(new Date(), Constants.LOGIN_SUCCESSFULL,
				"Requested category is not found with filmland.");
		return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
	}

	/**
	 * In case requested requested category is already subscribed by the user.
	 * 
	 * @param exception {@link UserNotFoundException}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler(value = SubscriptionAlreadyAvailableException.class)
	public ResponseEntity<Object> exception(SubscriptionAlreadyAvailableException exception) {
		ResponseStatus status = new ResponseStatus(new Date(), Constants.LOGIN_SUCCESSFULL,
				"Your Subscription to requested category is already avaialble.");
		return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
	}

	/**
	 * In case requested user is not available with filmland.
	 * 
	 * @param exception {@link UserNotFoundException}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler(value = LoginUserNotFoundException.class)
	public ResponseEntity<Object> exception(LoginUserNotFoundException exception) {
		ResponseStatus status = new ResponseStatus(new Date(), Constants.LOGIN_FAILED,
				"User trying to login is not registered with filmland.");
		return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
	}

	/**
	 * In case requested user is not available with filmland.
	 * 
	 * @param exception {@link UserNotFoundException}
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler(value = SubscriptionNotAvailableException.class)
	public ResponseEntity<Object> exception(SubscriptionNotAvailableException exception) {
		ResponseStatus status = new ResponseStatus(new Date(), Constants.LOGIN_FAILED,
				"Logged in User is not subscribed to requested subscription.");
		return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
	}

}
