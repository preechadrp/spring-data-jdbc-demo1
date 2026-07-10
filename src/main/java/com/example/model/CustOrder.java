package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table("cust_order") // ระบุชื่อ Table ให้ตรงกับใน DB
public class CustOrder implements Persistable<String> {

	@Transient
	private boolean isNewRecord = true;

	@Override
	public @Nullable String getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return isNewRecord;
	}

	@Id
	private String id;
	private String orderId;
	private String customerName;
	private BigDecimal totalAmount;
	private LocalDateTime insertDateTime;

}
