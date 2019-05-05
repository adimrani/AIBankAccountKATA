package com.bankaccount.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface DateUtils {

	default String format(Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

}
