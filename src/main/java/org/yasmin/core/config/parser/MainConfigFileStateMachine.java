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

/**
 * This class represent the state machine to be used to validate the main
 * configuration file.
 * 
 * @author Massimiliano Ziccardi
 */
class MainConfigFileStateMachine implements IStateMachine {
	private State currentState;

	/**
	 * Builds the state machine.
	 */
	MainConfigFileStateMachine() {
		currentState = initStateMachine();
	}

	/**
	 * Initializes the state machine.
	 * 
	 * @return the start state
	 */
	private State initStateMachine() {
		State keyState = new State("KVPAIR");
		keyState.addTransition(ConfigTokenType.kvpair, keyState);
		keyState.addTransition(ConfigTokenType.emptyLine, keyState);
		keyState.addTransition(ConfigTokenType.comment, keyState);
		keyState.addTransition(ConfigTokenType.end, State.END_STATE);
		return keyState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.yasmin.core.config.parser.IStateMachine#getCurrentState()
	 */
	@Override
	public State getCurrentState() {
		return currentState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.yasmin.core.config.parser.IStateMachine#moveTo(org.yasmin.core.config
	 * .parser.ConfigTokenType)
	 */
	@Override
	public State moveTo(ConfigTokenType transition) {
		currentState = currentState.getTransition(transition);
		return currentState;
	}
}
