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
 * This delegate is called by the parser to notify when a token has been found.
 * It is also used to configure the parser so that the config file can be
 * validated.
 * 
 * @author Massimiliano Ziccardi
 */
public interface IYasminConfigParserDelegate {

	/**
	 * @return The state machine that validates the config file.
	 */
	public IStateMachine getStateMachine();

	/**
	 * Called automatically by the config parser when a token has been found.
	 * 
	 * @param token
	 *            The token that has been found
	 */
	public void receive(IYasminConfigToken token);

	/**
	 * Called automatically by the parser when the configuration file has ended.
	 */
	public void validate();
}
