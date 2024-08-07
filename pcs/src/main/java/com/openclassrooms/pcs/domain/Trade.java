package com.openclassrooms.pcs.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

/**
 * A representation class for a trade object in the database.
 */
@Data
@Entity
@Table(name = "trade")
public class Trade
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trade_id")
	Integer tradeId;
	@NotBlank(message = "Account is mandatory")
	String account;
	@NotBlank(message = "Type is mandatory")
	String type;
	@NotNull(message = "Buy quantity is mandatory")
	@Min(value = 0, message = "Must be over 0")
	Double buyQuantity;
	Double sellQuantity;
	Double buyPrice;
	Double sellPrice;
	String benchmark;
	Timestamp tradeDate;
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
