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
 * This interface represent a Yasmin Config Token
 * 
 * @author Massimiliano Ziccardi
 */
public interface IYasminConfigToken {

	/**
	 * @return the type of token represented by this object
	 */
	public ConfigTokenType getType();

	/**
	 * Parse the given configuration line.
	 * 
	 * @param line
	 *            The line to be parsed
	 * @return An instance of IYasminConfigToken configured with the given line
	 */
	public IYasminConfigToken parse(String line);

	/**
	 * @return The unparsed configuration line
	 */
	public String getRawLine();
}
