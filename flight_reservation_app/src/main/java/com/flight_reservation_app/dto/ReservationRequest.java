package com.flight_reservation_app.dto;

public class ReservationRequest {

	private long flightId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String phone;
	private String cardNumber;
	private String NameOnTheCard;
	private String expiryDate;
	private String cvv;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String NameOnTheCard() {
		return NameOnTheCard;
	}

	public void setCardHolderName(String NameOnTheCard) {
		this.NameOnTheCard = NameOnTheCard;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvvCode() {
		return cvv;
	}

	public void setCvvCode(String cvvCode) {
		this.cvv = cvvCode;
	}

}
