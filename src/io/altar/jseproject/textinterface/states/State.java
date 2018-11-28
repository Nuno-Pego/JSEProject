package io.altar.jseproject.textinterface.states;

import io.altar.jseproject.textinterface.utils.ScannerUtils;

public interface State {

	static final ScannerUtils SCANNERUTILS = new ScannerUtils();
	
	public int execute();
}
