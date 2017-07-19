package com.slokam.rest.util;

import com.slokam.rest.pojo.State_M;

public interface IStateFileGenerater {
	public abstract void generateFile(State_M state, String fileName);
}
