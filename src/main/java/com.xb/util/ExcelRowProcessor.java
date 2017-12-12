package com.xb.util;

/**
 * 每行处理
 */
public interface ExcelRowProcessor {
	/**
	 * excel每读一行就调用一次
	 * @param rowData 
	 * @param rowIndex
	 */
	void process(Object[] rowData, int rowIndex);
	/**
	 * 读excel之前调用一次
	 * @param fileName
	 */
	void beforeProcess(String fileName);
	/**
	 * 读完所有行之后被调用一次
	 */
	void afterProcess();
}
