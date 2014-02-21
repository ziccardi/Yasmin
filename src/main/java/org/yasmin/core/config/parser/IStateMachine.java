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
 * The interface that all the state machines must implement. It is used by the
 * parser to validate the configuration file.
 * 
 * @author Massimiliano Ziccardi
 */
public interface IStateMachine {
	/**
	 * @return The current state machine state
	 */
	public State getCurrentState();

	/**
	 * If possible, moves to the requested machine state. If the state can't be
	 * reached, the machine state enters an invalid state.
	 * 
	 * @param transition
	 *            the transition we want to move to
	 * @return The new state or <code>null</code> if the requested state can't
	 *         be reached
	 */
	public State moveTo(ConfigTokenType transition);
}
