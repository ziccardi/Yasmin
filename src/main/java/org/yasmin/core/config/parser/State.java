/*
 * Copyright (c) 2014 Frederico Campos & Massimiliano Ziccardi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.yasmin.core.config.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represent a state of the {@link IStateMachine} object.
 * 
 * @author Massimiliano Ziccardi
 * 
 */
public class State {
	/**
	 * End state...
	 */
	public final static State END_STATE = new State("END");

	/**
	 * State name
	 */
	private final String name;

	/**
	 * Available transitions
	 */
	private Map<ConfigTokenType, State> transitionsMap = new HashMap<ConfigTokenType, State>();

	/**
	 * Builds the state and initializes it with the given name.
	 * 
	 * @param name
	 *            The state name
	 */
	public State(String name) {
		this.name = name;
	}

	/**
	 * Adds a transition to this state.
	 * 
	 * @param tokenType
	 *            The token type that triggers the transition
	 * @param newState
	 *            The token state to be reached
	 */
	void addTransition(ConfigTokenType tokenType, State newState) {
		transitionsMap.put(tokenType, newState);
	}

	/**
	 * Returns the transition triggered by the given toke type.
	 * 
	 * @param tokenType
	 *            The token type that triggers the transition
	 * @return The new state
	 */
	State getTransition(ConfigTokenType tokenType) {
		return transitionsMap.get(tokenType);
	}

	/**
	 * @return the state name
	 */
	public String getStateName() {
		return name;
	}
}
