package com.ebay.assignment.model;

import java.util.Arrays;

public enum FileTypeEnum {
	CSV("CSV"), PRN("PRN") , DEFAULT("Default");

	private final String value;

	FileTypeEnum(String value) {
		this.value = value;
	}

	/**
	 * @return the Enum representation for the given string.
	 */
	public static FileTypeEnum getValue(String s)  {
		return Arrays.stream(FileTypeEnum.values())
				.filter(v -> v.value.equals(s))
				.findFirst()
				.orElse(DEFAULT);
	}
}
