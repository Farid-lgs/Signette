package com.signette.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CENTER database table.
 * 
 */
@Entity
@Table(name="CENTER")
public class Center implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CENTER_SEQ")
	@SequenceGenerator(name = "CENTER_SEQ", sequenceName = "CENTER_SEQ", allocationSize = 1, initialValue = 1)
	@Column(name="CENTER_ID", unique=true, nullable=false, precision=38)
	private long centerId;

	@Lob
	@Column(name="CENTER_COMMENT")
	private String centerComment;

	@Column(name="CENTER_MAIL", nullable=false, length=20)
	private String centerMail;

	@Column(name="CENTER_NAME", nullable=false, length=20)
	private String centerName;

	@Column(name="CENTER_PHONE", length=14)
	private String centerPhone;

	@Column(name="CENTER_PICTURE", length=100)
	private String centerPicture;

	//bi-directional one-to-one association to Address
	@OneToOne
	@JoinColumn(name="ADDRESS_ID", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Trip
	@OneToMany(mappedBy="center")
	private List<Trip> trips;

	public Center() {
	}

	public long getCenterId() {
		return this.centerId;
	}

	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}

	public String getCenterComment() {
		return this.centerComment;
	}

	public void setCenterComment(String centerComment) {
		this.centerComment = centerComment;
	}

	public String getCenterMail() {
		return this.centerMail;
	}

	public void setCenterMail(String centerMail) {
		this.centerMail = centerMail;
	}

	public String getCenterName() {
		return this.centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterPhone() {
		return this.centerPhone;
	}

	public void setCenterPhone(String centerPhone) {
		this.centerPhone = centerPhone;
	}

	public String getCenterPicture() {
		return this.centerPicture;
	}

	public void setCenterPicture(String centerPicture) {
		this.centerPicture = centerPicture;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public Trip addTrip(Trip trip) {
		getTrips().add(trip);
		trip.setCenter(this);

		return trip;
	}

	public Trip removeTrip(Trip trip) {
		getTrips().remove(trip);
		trip.setCenter(null);

		return trip;
	}

}