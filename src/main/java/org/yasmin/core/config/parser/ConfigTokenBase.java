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
 * Main class for all the config token classes.
 * 
 * @author Massimiliano Ziccardi
 */
abstract class ConfigTokenBase implements IYasminConfigToken {
	private final String rawLine;

	/**
	 * Initializes the object with a null rawLine. Used only by the
	 * {@link TokenFactory}
	 */
	ConfigTokenBase() {
		rawLine = null;
	}

	/**
	 * Initializes the object with the given config line. Used only by the
	 * {@link #parse(String)} method.
	 * 
	 * @param line
	 *            The line to be parsed
	 */
	protected ConfigTokenBase(String line) {
		rawLine = line;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.yasmin.core.config.parser.IYasminConfigToken#getRawLine()
	 */
	@Override
	public String getRawLine() {
		return rawLine;
	}
}
