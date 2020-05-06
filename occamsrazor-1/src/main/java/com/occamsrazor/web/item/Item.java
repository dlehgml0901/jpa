package com.occamsrazor.web.item;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Component
public class Item {
	private String itemId, itemName, takerDate, category, takenPostion;
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", itemId,itemName,takerDate,category,takenPostion);
	}
}
