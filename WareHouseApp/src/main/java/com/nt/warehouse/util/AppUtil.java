package com.nt.warehouse.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface AppUtil {
	
	public static String getCurrentDateTime() {
		return new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());
	}

}
