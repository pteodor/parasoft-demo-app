package com.parasoft.demoapp.util;

import java.util.Date;

import com.parasoft.demoapp.model.industry.ItemEntity;
import com.parasoft.demoapp.model.industry.RegionType;

public class ItemEntityFactory {
	public static ItemEntity createItemEntity() {
		return new ItemEntity("item", "description", 1l, 14,
                "image", RegionType.AUSTRALIA, new Date());
	}

}

