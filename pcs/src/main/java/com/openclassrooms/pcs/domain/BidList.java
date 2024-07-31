package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "bid_list")
public class BidList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid_list_id")
	Integer BidListId;
	@NotBlank(message = "Account is mandatory")
	String account;
	@NotBlank(message = "Type is mandatory")
	String type;
	@NotNull(message = "Bid quantity is mandatory")
	Double bidQuantity;
	Double askQuantity;
	Double bid;
	Double ask;
	String benchmark;
	Timestamp bidListDate;
	String commentary;
	String security;
	String status;
	String trader;
	String book;
	String creationName;
	Timestamp creationDate;
	String revisionName;
	Timestamp revisionDate;
	String dealName;
	String dealType;
	String sourceListId;
	String side;
}
