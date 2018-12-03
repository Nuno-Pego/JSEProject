package io.altar.jseproject.textInterface.states;

import io.altar.jseproject.textInterface.utils.ScannerUtils;

public interface State {
	static final ScannerUtils SCANNER_UTILS = new ScannerUtils();
	
	public int execute();
}
